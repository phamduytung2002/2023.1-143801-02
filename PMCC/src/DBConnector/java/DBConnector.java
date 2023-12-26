package DBConnector.java;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.function.Consumer;

public class DBConnector {
    private static final String connectionString = "mongodb+srv://ducdm200158:Uz9AIW3Wh5AjuSbL@dbhethongchamcong.b7msvmq.mongodb.net/?retryWrites=true&w=majority";
    private final String database_name;
    private final String collection_name;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public DBConnector(String database_name, String collection_name) {
        this.database_name = database_name;
        this.collection_name = collection_name;
        this.database = connectToDatabase();
        this.collection = database.getCollection(collection_name);
        System.out.println("You successfully connected to MongoDB!");
    }

    private MongoDatabase connectToDatabase() {
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        return mongoClient.getDatabase(database_name);
    }

    public void insertData(Document document) {
        try {
            this.collection.insertOne(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
    private static final Consumer<Document> printBlock = document -> {
        System.out.println(document.toJson());
    };
    public void getData() {
        try {
            this.collection.find().forEach(printBlock);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
