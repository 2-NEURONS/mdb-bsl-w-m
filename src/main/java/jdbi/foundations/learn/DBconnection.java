package jdbi.foundations.learn;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.util.Properties;

public class DBconnection
{
    //1. to use Jdbi , you must connect to a databse....
    //2. to connect to a database , you must specify the database connection parameters.....
    //3. parameters...
    //  syntax "jdbc:"
    //jdbc:postgresql://localhost:5432/testdb

    //Jdbi connect = Jdbi.create("Url",properties);

    // the above process saves database connection parameters for later use...

    //working with handles...
    // instances of the handle class are used to handle database connections,and queries.
    // handle establishes connection to the database.

     //Jdbi connection = Jdbi.create();

    Properties  properties; // for setting up user name and password
    String DBurl; // database url
    Jdbi setupDB;

    public DBconnection(Properties properties)
    {

        this.properties = properties;
        DBurl = "jdbc:postgresql://localhost:5432/postgres";

    }
    public void connectDb()
    {
        setupDB = Jdbi.create(DBurl,properties);
    }
    public Jdbi getSetupDB()
    {
        return setupDB;
    }
     public static void main(String[] args)
     {
          Properties properties = new Properties();
          properties.setProperty("username","admin");
          properties.setProperty("password","");


         DBconnection connection = new DBconnection(properties);
         connection.connectDb();
         connection.getSetupDB().useHandle(handle -> {

             handle.execute("create table play ( id integer);");
             System.out.println("success!");
         });



     }
}
