package definitions;

import com.example.capstone.SoccerFantasyTeamApiApplication;
import io.cucumber.java.en.Given;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SoccerFantasyTeamApiApplication.class)
public class SoccerPlayerControllerTestDefs {
    private static final String BASE_URL = "http://localhost:";

    @Given("A list of soccer players are available in the database")
    public void aListOfSoccerPlayersAreAvailableInTheDatabase() {
    }
}
