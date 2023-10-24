package definitions;

import com.example.capstone.SoccerFantasyTeamApiApplication;
import com.example.capstone.model.FantasyTeam;
import com.example.capstone.service.UserService;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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



    @When("I create an account")
    public void iCreateAnAccount() {
    }
}
