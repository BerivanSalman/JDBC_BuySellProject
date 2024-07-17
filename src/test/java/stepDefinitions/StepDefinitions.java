package stepDefinitions;

import manage.QueryManage;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.JDBCReusableMethods;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StepDefinitions {
    QueryManage queryManage = new QueryManage(); //obje olusturduk
    String query;
    ResultSet resultSet;

// ------------------QUERY01------------------------
    @Given("The database connection is created.")
    public void the_database_connection_is_created() {
        JDBCReusableMethods.getConnection();
        //ConfigProperties'ten istediği bilgileri alır database e gider bağlantı kurar ve bağlantıyı dönmüş olur
    }
    @Given("Query01 is prepared and executed.")
    public void query01_is_prepared_and_executed() throws SQLException {
        query = queryManage.getQuery01();
        resultSet =JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet01 is processed.")
    public void result_set01_is_processed() throws SQLException {
        resultSet.next();
        String actualName = resultSet.getString("name");
        String expectedName = "Fashion";
        Assert.assertEquals(expectedName,actualName);

    }
    @Given("The database connection is closed.")
    public void the_database_connection_is_closed() {
        JDBCReusableMethods.closeConnection();
    }
}
