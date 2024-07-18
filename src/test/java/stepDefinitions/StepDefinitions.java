package stepDefinitions;

import com.github.javafaker.Faker;
import manage.QueryManage;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.JDBCReusableMethods;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    QueryManage queryManage = new QueryManage(); //obje olusturduk
    Faker faker = new Faker();
    String query;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    int rowCount;
    int id;
    String name;
    int state_id;
    int status;
    String created_at;

// ------------------QUERY01-SELECT-----------------------

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
        assertEquals(expectedName,actualName);
    }
    @Given("The database connection is closed.")
    public void the_database_connection_is_closed() {
        JDBCReusableMethods.closeConnection();
    }

    // ------------------QUERY02-INSERT------------------------

    @Given("Query02 is prepared and executed.")
    public void query02_is_prepared_and_executed() throws SQLException {
        query = queryManage.getQuery02();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        id = faker.number().randomDigit();
        name = faker.name().firstName();
        status = faker.number().randomDigitNotZero();
        state_id = faker.number().randomDigit();
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setInt(3,state_id);
        preparedStatement.setInt(4,status);
        preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));
        rowCount = preparedStatement.executeUpdate();
        System.out.println(id +" "+name+" "+state_id+" "+status+ " "+created_at);

    }
    @Given("PreparedResultSet02 is processed.")
    public void prepared_result_set02_is_processed() {
        assertEquals(1,rowCount);
    }
    // ------------------QUERY03-DELETE------------------------
    @Given("Query03 is prepared and executed.")
    public void query03_is_prepared_and_executed() throws SQLException {
        query = queryManage.getQuery03();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        rowCount = preparedStatement.executeUpdate();
        System.out.println("Silinen id: "+id+" Silinen name: "+name);
    }
    @Given("PreparedResultSet03 is processed.")
    public void prepared_result_set03_is_processed() {
     assertEquals(1,rowCount);

    }
}

