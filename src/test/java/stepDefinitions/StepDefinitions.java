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
    String email;
    int query_type;
    String message;

// ------------------QUERY01-SELECT-----------------------
    // Select sorgusunda bunu kullan; resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    // Diğer sorgularda Update, Insert, Delete bunu kullan;  preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

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
    // ------------------QUERY04-Insert and Update------------------------
    @Given("Insert values to the contacts table")
    public void insert_values_to_the_contacts_table() throws SQLException {
        query = queryManage.getQuery04Insert();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
         id = faker.number().numberBetween(1000,2000);
        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        int query_type = faker.number().randomDigit();
        message = faker.lorem().sentence();
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,email);
        preparedStatement.setInt(4,query_type);
        preparedStatement.setString(5,message);
        preparedStatement.executeUpdate();
        System.out.println(id +" "+name+" "+email+ " "+" "+ query_type+" "+message);
    }
    @Given("Update the message content")
    public void update_the_message_content() throws SQLException {
        query = queryManage.getQuery04Update();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        String updatedMessage = faker.lorem().sentence();
        preparedStatement.setString(1,updatedMessage);
        preparedStatement.setString(2,name);
        rowCount = preparedStatement.executeUpdate();
        System.out.println(updatedMessage);

    }
    @Given("ResultSet is processed")
    public void result_set_is_processed() {
        assertEquals(1,rowCount);
    }
    // ------------------QUERY05-Insert and Delete------------------------
    @Given("Delete the added data by entering the email information in the contacts table.")
    public void delete_the_added_data_by_entering_the_email_information_in_the_contacts_table() throws SQLException {
        query = queryManage.getQuery05();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1,email);
        rowCount = preparedStatement.executeUpdate();
    }
    // ------------------QUERY06-Group By------------------------
    @Given("Query06 is prepared and executed.")
    public void query06_is_prepared_and_executed() throws SQLException {
        query =queryManage.getQuery06();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
        // Bu adım, queryManage nesnesinden query06 sorgusunu alır ve bu sorguyu çalıştırır. Sonuçlar resultSet nesnesine atanır.
    }
    @Given("ResultSet06 is processed.")
    public void result_set06_is_processed() throws SQLException {
        while (resultSet. next()) {
            int couponId = resultSet.getInt("coupon_id");
            int productCount = resultSet.getInt("product_count");
            //Her satır için coupon_id ve product_count değerlerini alır ve ekrana yazdırır.
            System.out.println("Coupon ID: " + couponId + ", Product Count: " + productCount);
        }
    }
    // ------------------QUERY07-Limit------------------------
    @Given("Query07 is prepared and executed.")
    public void query07_is_prepared_and_executed() throws SQLException {
        query = queryManage.getQuery07();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet07 is processed.")
    public void result_set07_is_processed() throws SQLException {
        boolean containsDigit = false;
        while (resultSet.next())
        {
            String phoneNumber = resultSet.getString("phone");
            if (phoneNumber.contains("5")) {
                containsDigit = true;
            }
            System.out.println("phone: "+ phoneNumber);
    }
    }
    }


