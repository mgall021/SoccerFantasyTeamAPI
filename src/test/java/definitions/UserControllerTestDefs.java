package definitions;

import com.example.capstone.SoccerFantasyTeamApiApplication;
import com.example.capstone.model.FantasyTeam;
import com.example.capstone.service.UserService;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
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
    public void iCreateAnAccount() {
    }
}
