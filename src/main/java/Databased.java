import java.sql.*;

public class Databased {

    public static void main(String[] args) throws SQLException
    {
        DatabaseConnector connector     = new DatabaseConnector();
        DatabaseCreator createDatabase  = new DatabaseCreator();
        DatabaseInsert insert           = new DatabaseInsert();
        DatabasePrint dbIO              = new DatabasePrint();
        DatabaseHandler DBHandler       = new DatabaseHandler();

        DBHandler.showPeople("2000");
        DBHandler.insertRows
                (10,"Ola","Kveli", "Sigurd Hoels Vei 106", 655, "95974022");
//        System.out.println("Please choose postNumber to print firstName from");
//        Scanner userInput = new Scanner(System.in);
//        String input = userInput.nextLine();
    }
}