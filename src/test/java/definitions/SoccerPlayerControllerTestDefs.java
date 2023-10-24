package definitions;

import com.example.capstone.SoccerFantasyTeamApiApplication;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SoccerFantasyTeamApiApplication.class)
public class SoccerPlayerControllerTestDefs {
    private static final String BASE_URL = "http://localhost:";

    @LocalServerPort
    String port;

    private static final Logger log = getLogger(SoccerPlayerControllerTestDefs.class.getName());

    private static Response response;

    @Given("A list of soccer players are available in the database")
    public void aListOfSoccerPlayersAreAvailableInTheDatabase() {
    }
}
