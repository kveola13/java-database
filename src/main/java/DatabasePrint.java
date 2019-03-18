import java.sql.*;

public class DatabasePrint {

    public String postNumber;

//    public DatabasePrint(String postNumber)throws SQLException{
//        try(Connection con = new DatabaseConnector().getConnection();
//            Statement statement = con.createStatement())
//        {
//            ResultSet resultSet = statement.executeQuery("SELECT postNumber FROM telefonliste");
//            if (resultSet.next()){
//                postNumber = resultSet.getString("postNumber");
//                this.postNumber = postNumber;
//                System.out.println(postNumber);
//            }
//        }
//    }

    public DatabasePrint() throws SQLException{

        try(Connection con = new DatabaseConnector().getConnection();
            Statement statement =  con.createStatement())
        {
            ResultSet resultSet = statement.executeQuery
                    ("SELECT id, firstName, lastName, postNumber, phoneNumber FROM telefonliste ORDER BY id");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int j = 1; j <= columnCount; j++)
            {
                System.out.printf("%1$9s",metaData.getColumnName(j) + "\t ");
            }
            System.out.println();
            while (resultSet.next()) {
                for(int i = 1; i <= columnCount; i++)
                System.out.printf("%1$9s",resultSet.getString(i) + " \t ");
                System.out.println();
            }
        }
    }
}
