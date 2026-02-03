package APIStepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {

    String baseURI = RestAssured.baseURI="https://opensource-demo.orangehrmlive.com/web/index.php/api/v2";
    public static String token;

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        RequestSpecification generateTokenRequest=given().  header("Content-Type","application/json").
                body("{\n" +
                        "\"username\": \"Admin\",\n" +
                        "\"password\": \"admin123\"\n" +
                        "}");

        //hitting the endpoint
        // NOTE: OrangeHRM demo does NOT provide JWT-based authentication.
        // This is only for portfolio/demo purposes.

        Response response=generateTokenRequest.when().post("/auth/login");

        //storing the token in global variable
        token="Bearer "+response.jsonPath().getString("token");
    }
}
