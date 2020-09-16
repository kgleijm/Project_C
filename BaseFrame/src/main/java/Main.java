import com.mongodb.MongoClient;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        DBManager.setup(new MongoClient( "localhost" , 27017 ));

    }



    public static class DBManager{

        private static MongoClient mongo;
        private static Logger mongoLogger;

         static void setup(MongoClient client){
            mongo = client;
            mongoLogger = Logger.getLogger( "org.mongodb.driver" );
            mongoLogger.setLevel(Level.SEVERE);
            try {
                if(mongo.getDatabaseNames().size() > 0){
                    System.out.println("SETUP: Succesfully initialized dataBase Connection");
                }else{
                    System.out.println("SETUP: DBManager failed to connect to database,\nAre there any existing mongo databases? \nIs mongod.exe running on specified name and port?");
                }
            }catch (Exception e){
                System.out.println("SETUP: DBManager failed to connect to database, is mongod.exe running on specified name and port?");
            }

        }





    }


}
