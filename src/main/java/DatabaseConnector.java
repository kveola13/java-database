import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

<<<<<<< HEAD
public class DatabaseConnector {

    private String USERNAME    = "admin";
    private String PASSWORD    = "admin";
    private String database = "mydb";
    private String userServer      = "localhost";
//    private static final String CONNECTION  = "jdbc:mysql://" + SERVER + ":3306/" + database + "?autoReconnect=true&useSSL=false";

//    public static Connection getConnection() throws SQLException{
//        return DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
//    }
//    public Connection getConnection() throws SQLException {
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setDatabaseName(database);
//        dataSource.setServerName(SERVER);
//        dataSource.setUser(USERNAME);
//        dataSource.setPassword(PASSWORD);
//        Connection connection = dataSource.getConnection();
//        return connection;
////    }
//    private String username    = "admin";
//    private String password    = "admin";
//    private String database = "mydb";
//    private String server = "localhost";
=======
public class DatabaseConnector
{
    private String username    = "admin";
    private String password    = "admin";
    private String database    = "mydb";
    private String server      = "localhost";
>>>>>>> 0a8dbe8d8abffd3bb5946ceae51b49038d60fa4f
//    private static final String CONNECTION = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false";

//    public static Connection getConnection() throws SQLException{
//        return DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
//    }

    public DatabaseConnector(){

    }

    public DatabaseConnector(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public DatabaseConnector(String username, String password, String database, String server)
    {
        this.username = username;
        this.password = password;
        this.database = database;
        this.server = server;
    }

    public void setDatabase() throws SQLException
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the name of the database:");
        SERVER = userInput.nextLine();
        System.out.println("Enter the name of the server:");
        userServer = userInput.nextLine();
        System.out.println("Enter the username:");
        username = userInput.nextLine();
        System.out.println("Enter the password:");
        password = userInput.nextLine();
        System.out.println("Connected to: " + SERVER + "with servername: "+ userServer + " as " + username +  " using " + password);
    }

    public Connection getConnection() throws SQLException
    {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName(database);
        dataSource.setServerName(server);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection con = dataSource.getConnection();
        return con;
    }
}
