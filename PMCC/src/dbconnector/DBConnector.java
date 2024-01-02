package dbconnector;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DBConnector {
    private static final String connectionString = "mongodb+srv://ducdm200158:Uz9AIW3Wh5AjuSbL@dbhethongchamcong.b7msvmq.mongodb.net/?retryWrites=true&w=majority";

    private static final Consumer<Document> printBlock = document -> {
        System.out.println(document.toJson());
    };
    final MongoCollection<Document> collection;
    private final String databaseName;
    private final MongoDatabase database;
    private MongoClient mongoClient;

    public DBConnector(String databaseName, String collectionName) {
        this.databaseName = databaseName;
        this.database = connectToDatabase();
        this.collection = database.getCollection(collectionName);

        System.out.println("You successfully connected to MongoDB!");
    }

    private MongoDatabase connectToDatabase() {
        ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();
        MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(new ConnectionString(connectionString)).serverApi(serverApi).build();
        this.mongoClient = MongoClients.create(settings);
        return mongoClient.getDatabase(databaseName);
    }

    public void insertData(List<Document> documentList) {
        try {
            for (Document document : documentList) {
                this.collection.insertOne(document);
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        this.mongoClient.close();
    }

    public List<Document> getData() {
        List<Document> documentList = new ArrayList<>();

        try {
            FindIterable<Document> documents = this.collection.find();
            documents.forEach(documentList::add);
        } catch (MongoException e) {
            e.printStackTrace();
        }

        return documentList;
    }
    public Document findData(String key, String value) {
        Document document = null;

        try {
            document = this.collection.find(new Document(key, value)).first();
        } catch (MongoException e) {
            e.printStackTrace();
        }

        return document;
    }
    public Document findDataWithCondition(String key, String value, String conditionField, String conditionValue) {
        Document document = null;

        try {
            // Build the query using the $ne operator to exclude documents with TrangThai equal to "Đã xử lý"
            Document query = new Document(key, value).append(conditionField, new Document("$ne", conditionValue));

            // Execute the find operation
            document = this.collection.find(query).first();
        } catch (MongoException e) {
            e.printStackTrace();
        }

        return document;
    }

    public Document updateData1(String key, ObjectId value, Document document) {
        Document document1 = null;

        try {
//            document1 = this.collection.findOneAndUpdate(new Document(key, value), document);
            // Use $set update operator to update the fields
            Document updateQuery = new Document(key, value);
            Document update = new Document("$set", document);

            document1 = this.collection.findOneAndUpdate(updateQuery, update);
        } catch (MongoException e) {
            e.printStackTrace();
        }

        return document1;
    }
    public Document updateData(String key, String value, Document document) {
        Document document1 = null;

        try {
            document1 = this.collection.findOneAndUpdate(new Document(key, value), document);
        } catch (MongoException e) {
            e.printStackTrace();
        }

        return document1;
    }

}