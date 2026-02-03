package APIStepDefinitions;

import Utils.APIConstants;
import Utils.APIPayloadConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apiguardian.api.API;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class APIWorkflowSteps {

    RequestSpecification request;
    Response response;
    public static String employee_id;

    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
            //prepare the request
           request=given().
                    header(APIConstants.HEADER_KEY_CONTENT_TYPE,APIConstants.HEADER_VALUE_CONTENT_TYPE)
                    .header(APIConstants.HEADER_KEY_AUTHORIZATION, GenerateTokenSteps.token).body(APIPayloadConstants.createEmployeePayload());
        }

        //another request with json payload

    @Given("a request is prepared to create an employee using json payload")
    public void a_request_is_prepared_to_create_an_employee_using_json_payload() {
        request=given().
                header(APIConstants.HEADER_KEY_CONTENT_TYPE,APIConstants.HEADER_VALUE_CONTENT_TYPE)
                .header(APIConstants.HEADER_KEY_AUTHORIZATION, GenerateTokenSteps.token).body(APIPayloadConstants.createEmployeePayload())
                .body(APIPayloadConstants.createEmployeePayloadJson());
    }


    @When("a POST call is made to create a new employee")
    public void a_post_callis_made_to_create_a_new_employee() {
      response=request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
    }

    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(Integer int1) {
        //argument value is coming from feature file
        response.prettyPrint();
        response.then().assertThat().statusCode(int1);
    }

    @Then("the emplyee contains key {string} and value {string}")
    public void the_emplyee_contains_key_and_value(String message, String value) {
      response.then().assertThat().body(message, equalTo(value));

    }

    @Then("the {string} is stored as a global variable to be used for other calls")
    public void the_is_stored_as_a_global_variable_to_be_used_for_other_calls(String string) {
        employee_id=response.jsonPath().getString(string);
    }


}
