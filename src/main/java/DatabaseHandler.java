import java.sql.*;

public class DatabaseHandler {

    private PreparedStatement preparedStatement;
    private CallableStatement callableStatement;

    public DatabaseHandler() {
    }

    public void insertData(String firstName, String lastName, String address, String postNumber, int phoneNumber) throws SQLException {
        int generatedKeys = -1;
        try (Connection con = new DatabaseConnector().getConnection();
             Statement statement = con.createStatement())
        {
            String SQL = "INSERT INTO Telefonliste (firstName, lastName, address, postNumber, phoneNumber) " +
                    "VALUES ('" + firstName + "', '" + lastName + "', '" + address + "', '" + postNumber + "', " + phoneNumber + ") ";

            statement.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                generatedKeys = resultSet.getInt(1);
            }else{
                System.out.println("Nothing to print");
        }
            System.out.println("Auto Increment is: " + generatedKeys);
//            statement.addBatch("INSERT INTO Telefonliste (firstName, lastName, address, postNumber, phoneNumber) " +
//                    "VALUES ('" + firstName + "', '" + lastName + "', '" + address + "', '" + postNumber + "', " + phoneNumber + ") ");
            statement.executeBatch();
        }
    }
    public void showPeople(String postNumber) throws SQLException{
        try(Connection con = new DatabaseConnector().getConnection())
        {
            preparedStatement = con.prepareStatement
                    ("SELECT firstName, lastName FROM telefonliste WHERE postNumber LIKE ? ORDER BY firstName");
            preparedStatement.setString(1, postNumber);
            preparedStatement.executeQuery();
            System.out.println(preparedStatement.toString());

            if (preparedStatement == null){
                preparedStatement.close();
            }
        }
    }
    public void insertRows
            (int id, String firstName, String lastName, String address, int postNumber, String phoneNumber) throws SQLException{
        try(Connection con = new DatabaseConnector().getConnection()){
//            String sql = "DELIMITER //\n" +
//                    "DROP PROCEDURE IF EXISTS `ny_oppfoering`;\n" +
//                    "CREATE PROCEDURE `ny_oppfoering`\n" +
//                    "  (IN nr SMALLINT(2),\n" +
//                    "    IN fornavn VARCHAR(10),\n" +
//                    "    IN etternavn VARCHAR(15),\n" +
//                    "    IN adresse VARCHAR(20),\n" +
//                    "    IN postnummer SMALLINT(4),\n" +
//                    "    IN telefon VARCHAR(8),\n" +
//                    "    OUT melding VARCHAR(12))\n" +
//                    "  BEGIN INSERT INTO telefonliste VALUES\n" +
//                    "    (nr, fornavn, etternavn, adresse, postnummer, telefon);\n" +
//                    "    COMMIT;\n" +
//                    "    SET melding = 'Vellykket';\n" +
//                    "  END\n" +
//                    "// DELIMITER ;";
//
//            Statement statement = con.createStatement();
//            statement.addBatch(sql);
//            statement.executeBatch();

            String calledStatement = "{CALL ny_oppfoering(?,?,?,?,?,?,?)}";
            callableStatement = con.prepareCall(calledStatement);
            callableStatement.setInt(1, id);
            callableStatement.setString(2, firstName);
            callableStatement.setString(3, lastName);
            callableStatement.setString(4, address);
            callableStatement.setInt(5, postNumber);
            callableStatement.setString(6, phoneNumber);
            callableStatement.registerOutParameter(7, Types.VARCHAR);
            callableStatement.execute();
        }
    }
}