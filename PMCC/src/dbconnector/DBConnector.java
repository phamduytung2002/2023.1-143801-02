package dbconnector;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;

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
}
