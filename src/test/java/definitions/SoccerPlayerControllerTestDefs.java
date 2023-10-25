package definitions;

import com.example.capstone.SoccerFantasyTeamApiApplication;
import com.example.capstone.model.SoccerPlayer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SoccerFantasyTeamApiApplication.class)
public class SoccerPlayerControllerTestDefs {
    private static final String BASE_URL = "http://localhost:";

    @LocalServerPort
    String port;

    private static final Logger log = getLogger(SoccerPlayerControllerTestDefs.class.getName());

    private static Response response;
    public static String getJWTKey(String port) throws JSONException {
        // Set the base URI and create a request

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        // Set the content-type header to indicate JSON data
        request.header("Content-Type", "application/json");

        // Create a JSON request body with user email and password
        JSONObject requestBody = new JSONObject();
        requestBody.put("emailAddress", "suresh@ga.com");
        requestBody.put("password", "suresh123");

        // Send a POST request to the authentication endpoint
        response = request.body(requestBody.toString()).post(BASE_URL + port + "/auth/users/login/");

        // Extract and return the JWT key from the authentication response
        return response.jsonPath().getString("jwt");
    }

    @Given("A list of soccer players are available in the database")
    public void aListOfSoccerPlayersAreAvailableInTheDatabase() {
        log.info("Calling aListOfSoccerPlayersAreAvailableInTheDatabase");
        try {
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();
            request.header("Authorization", "Bearer " + getJWTKey(port));
            request.header("Content-Type", "application/json");
            // Send a GET request to retrieve the list of soccer players
            response = request.get(BASE_URL + port + "/api/soccerplayers/");
            log.info(request.toString());
            List<SoccerPlayer> soccerPlayers = response.jsonPath().get("data");
            Assert.assertEquals(response.getStatusCode(), HttpStatus.OK.value()); //status is OK (200)
            Assert.assertTrue(soccerPlayers.size() > 0); //list of soccer players is not empty
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("The user requests to get a list of soccer players")
    public void theUserRequestsToGetAListOfSoccerPlayers() {
        try {
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given();
            request.header("Authorization", "Bearer " + getJWTKey(port));
            request.header("Content-Type", "application/json");

            log.info("Requesting the list of all soccer players");

            response = request.get(BASE_URL + port + "/api/soccerplayers/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("The system should respond with a list of soccer players")
    public void theSystemShouldRespondWithAListOfSoccerPlayers() {
        String responseList = null;
        assertNotNull(responseList);
        assertFalse(responseList.isEmpty());

    }
}
