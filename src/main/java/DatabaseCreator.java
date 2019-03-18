import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {

<<<<<<< HEAD
    public void createDatabase()throws SQLException{

        try(Connection con = DatabaseConnector.getConnection();
            Statement statement =  con.createStatement())
        {
        statement.executeUpdate("DROP TABLE IF EXISTS Telefonliste;");
        statement.executeUpdate("CREATE TABLE Telefonliste(id INT NOT NULL AUTO_INCREMENT, " +

=======
    public DatabaseCreator()throws SQLException{
>>>>>>> 0a8dbe8d8abffd3bb5946ceae51b49038d60fa4f
        DatabaseConnector databaseConnector = new DatabaseConnector();
        try(Connection con = databaseConnector.getConnection();
            Statement statement =  con.createStatement())
        {
            statement.addBatch("DROP DATABASE IF EXISTS testBase");
            statement.addBatch("CREATE DATABASE IF NOT EXISTS testBase");
            statement.addBatch("USE testBase");
            statement.addBatch("CREATE DATABASE IF NOT EXISTS mydb;");
            statement.addBatch("USE mydb");
            statement.addBatch("DROP TABLE IF EXISTS Telefonliste;");
            statement.addBatch("CREATE TABLE Telefonliste(id INT NOT NULL AUTO_INCREMENT, " +
                "firstName VARCHAR(255), " +
                "lastName VARCHAR(255), " +
                "address VARCHAR(255) , " +
                "postNumber VARCHAR(10), " +
                "phoneNumber INT, " +
                "PRIMARY KEY (id));");

            statement.executeBatch();
        }
    }
}
