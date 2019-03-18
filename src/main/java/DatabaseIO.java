<<<<<<< HEAD:DatabaseReal/src/main/java/DatabasePrint.java
import java.sql.*;

public class DatabasePrint {

    public void printDatabase() throws SQLException{


        try(Connection con = DatabaseConnector.getConnection();
            Statement statement =  con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT firstName, lastName FROM telefonliste WHERE postNumber = '0655'"))
        {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                for(int i = 1; i <= columnCount; i++)
                    System.out.print(resultSet.getString(i) + " ");
                System.out.println();
            }
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        }
    }
}
=======
import java.sql.*;

public class DatabaseIO {

    public String postNumber;

    public void inputDatabase(String postNumber){
        this.postNumber = postNumber;
    }

    public void printDatabase() throws SQLException{

        try(Connection con = new DatabaseConnector().getConnection();
            Statement statement =  con.createStatement())
        {
            ResultSet resultSet = statement.executeQuery
                    ("SELECT firstName, lastName FROM telefonliste WHERE postNumber LIKE '" + postNumber + "' ORDER BY firstName");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                for(int i = 1; i <= columnCount; i++)
                    System.out.print(resultSet.getString(i) + " ");
                System.out.println();
            }
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        }
    }
}
>>>>>>> 35eda982c8132c81579b7244e71333fa8c730a01:DatabaseReal/src/main/java/DatabaseIO.java
