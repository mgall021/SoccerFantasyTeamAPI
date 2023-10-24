package definitions;

import com.example.capstone.SoccerFantasyTeamApiApplication;
import com.example.capstone.model.FantasyTeam;
import com.example.capstone.service.UserService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.logging.Logger;

@CucumberContextConfiguration()
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SoccerFantasyTeamApiApplication.class)
public class UserControllerTestDefs {

//    private static final Logger logger = Logger.getLogger(FantasyTeamControllerTestDefs.class.getName());
    private static Response response;
    private String message;

    @LocalServerPort
    String port;

    @Autowired
    private UserService userService;

    private final static String BASE_URL = "http://localhost:";

    private static RequestSpecification request = RestAssured.given();


    public String getJWTKey() throws JSONException {
        // Set the base URI and create a request
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        // Set the content-type header to indicate JSON data
        request.header("Content-Type", "application/json");

        String endpoint = BASE_URL + port + "/auth/users/login/";

        // Create a JSON request body with user email and password
        JSONObject requestBody = new JSONObject();
        requestBody.put("emailAddress", "suresh@g.com");
        requestBody.put("password", "suresh123");

        // Send a POST request to the authentication endpoint
        Response response = request.body(requestBody.toString()).post(endpoint);

        // Extract and return the JWT key from the authentication response
        return response.jsonPath().getString("jwt");
    }


    @When("I create an account")
    public void iCreateAnAccount() throws JSONException {
        String endpoint = BASE_URL + port + "/auth/users/register/";
        JSONObject requestBody = new JSONObject()
                .put("firstName", "Suresh")
                .put("lastName", "Sigera")
                .put("emailAddress", "suresh@g.com")
                .put("password", "suresh123");

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post(endpoint);

        Assert.assertEquals(201, response.getStatusCode());
    }

    @Then("I get a user account")
    public void iGetAUserAccount() throws JSONException {
        System.out.println(response.getBody().prettyPrint());
        System.out.println(getJWTKey());
    }

//
    @When("I update the user account")
    public void iUpdateTheUserAccount() throws JSONException{
        int userId = response.jsonPath().getInt("data.id");
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        JSONObject requestBody = new JSONObject();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + getJWTKey());
        requestBody.put("name", "Updated Name");
        response = request.body(requestBody.toString()).put(BASE_URL + port + "/auth/users/" + userId + "/");
    }
//
//    @Then("The user account is updated")
//    public void theUserAccountIsUpdated() {
//
//    }
//
//    @When("I delete the user")
//    public void iDeleteTheUser() {
//
//    }
//
//    @Then("The user gets deleted")
//    public void theUserGetsDeleted() {
//    }
}
