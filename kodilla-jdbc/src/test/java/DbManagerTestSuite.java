import com.kodilla.jdbc.DbManager;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DbManagerTestSuite {

    @Test
    void testConnection() {
        DbManager dbManager = DbManager.getInstance();

        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        int conter = 0;
        while (rs.next())
            {
                System.out.println(rs.getInt("ID")+", " +
                        rs.getString("FIRSTNAME")+", "+
                        rs.getString("LASTNAME"));
                conter++;
            }
        rs.close();
        statement.close();
        assertEquals(5,conter);
    }

    @Test
    void testSelectUsersAndTasks() throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = """
                SELECT U.FIRSTNAME, U.LASTNAME, I.SUMMARY
                FROM USERS U
                JOIN ISSUES I ON U.ID = I.USER_ID_ASSIGNEDTO
                """;
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        int counter = 0;
        while (rs.next()){
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME")+", " +
                    rs.getString("SUMMARY"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(15,counter);
    }
}
