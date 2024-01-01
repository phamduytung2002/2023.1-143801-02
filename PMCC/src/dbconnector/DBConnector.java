package dbconnector;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DBConnector {
    private static final String connectionString = "mongodb+srv://ducdm200158:Uz9AIW3Wh5AjuSbL@dbhethongchamcong.b7msvmq.mongodb.net/?retryWrites=true&w=majority";
    private final String database_name;
    private final String collection_name;
    private final MongoDatabase database;
    final MongoCollection<Document> collection;
    private  MongoClient mongoClient;

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
        this.mongoClient = MongoClients.create(settings);
        return mongoClient.getDatabase(database_name);
    }

    public void insertData(List<Document> documentList) {
        try {
           for(Document document:documentList){
               this.collection.insertOne(document);
           }
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
public void close()
{
    this.mongoClient.close();
}
    private static final Consumer<Document> printBlock = document -> {
        System.out.println(document.toJson());
    };
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

    public static void main(String[] args) {
        // Example usage
//        DBConnector connector = new DBConnector("ChamCong", "Ban ghi cham cong");
//        connector.insertData(new Document("key", "value"));
//       List<Document>  result=connector.getData();
//         for(Document document:result){
//              System.out.println(document.toJson());
//         }
//    }
}}