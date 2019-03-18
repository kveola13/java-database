import java.sql.SQLException;

public class DatabaseInsert {

    public DatabaseInsert()throws SQLException{
        DatabaseHandler inserter = new DatabaseHandler();

<<<<<<< HEAD

        try(Connection con = DatabaseConnector.getConnection();
            Statement statement =  con.createStatement())
        {
            statement.executeUpdate("INSERT INTO Telefonliste (firstName, lastName, address, postNumber, phoneNumber) " +
                    "VALUES ('" + firstName +"', '"+ lastName + "', '"+ address +"', '"+ postNumber+"', " +phoneNumber+ ") ");


        try (Connection con = new DatabaseConnector().getConnection();
            Statement statement = con.createStatement())
        {
            statement.executeUpdate("INSERT INTO Telefonliste (firstName, lastName, address, postNumber, phoneNumber) " +
                    "VALUES ('" + firstName + "', '" + lastName + "', '" + address + "', '" + postNumber + "', " + phoneNumber + ") ");
        }
=======
        inserter.insertData("Petra", "Petrasen", "Aveien 1", "2000", 12345678);
        inserter.insertData("Tor", "Torsen", "Bveien 2", "2000", 23456781);
        inserter.insertData("Arne", "Arnesen", "Cveien 3", "2000", 34567812);
        inserter.insertData("Inger", "Ingersen", "Dveien 4", "2001", 45678123);
        inserter.insertData("Eva", "Evanger", "Cveien 3", "2000", 34567812);
        inserter.insertData("Siri", "Sirissen", "Fveien 6", "2002", 67812345);
        inserter.insertData("Petra", "Petrasen", "Aveien 1", "2000", 12345678);
        inserter.insertData("Knut", "Knutsen", "Hveien 7", "2002", 81234567);
        inserter.insertData("Henrik", "Henriksen", "Gveien 8", "2202", 88888888);
>>>>>>> 0a8dbe8d8abffd3bb5946ceae51b49038d60fa4f
    }
}
