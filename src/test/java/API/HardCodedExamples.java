package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {

    String baseURI = RestAssured.baseURI="https://opensource-demo.orangehrmlive.com/web/index.php/api/v2";
    String token = "Bearer <valid-token>";// Mock token used for illustration since the OrangeHRM demo site does not provide authentication tokens.
    static String empNumber;

    public void addEmplyee(){
        RequestSpecification preparedRequest=given().
                header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "  \"firstName\": \"Iuliia\",\n" +
                        "  \"lastName\": \"Cherviakova\",\n" +
                        "  \"middleName\": \"A\",\n" +
                        "  \"employeeId\": \"E" + empNumber + "\"\n" +
                        "}");

        //hitting the endpoint/send the request
        Response response=preparedRequest.when().post("/pim/employees");

        //verifying the assertion
        response.then().assertThat().statusCode(201);

        response.then().assertThat().
                body("data.firstName", equalTo("Iuliia"));
        response.then().assertThat().
                body("data.lastName", equalTo("Cherviakova"));
    }

    public void updateEmplyee(){
        //prepare the request
        RequestSpecification perparedRequest=given().
                header("Content-Type","application/json").
                header("Authorization", token).body("{\n" +
                        "  \"firstName\": \"Yulia\",\n" +
                        "  \"lastName\": \"Cherviakova\",\n" +
                        "  \"middleName\": \"A\",\n" +
                        "  \"employeeId\": \"E" + empNumber + "\"\n" +
                        "}");

        Response response=perparedRequest.when().put("\"/pim/employees\"");
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message", equalTo("Employee record updated"));

    }

    public void getEmployee(){
        RequestSpecification perparedRequest=given().
                header("Content-Type","application/json").
                header("Authorization", token).
                queryParam("employeeId",empNumber);

        Response response=perparedRequest.when().get("\"/pim/employees\"");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        String temEmpId=response.jsonPath().getString("data[0].empNumber");
        Assert.assertEquals(empNumber, temEmpId);
        response.then().assertThat().header("Content-Type", containsString("application/json"));
    }

    @Test
 public void getCreatedEmployeeId() {
     //prepare the request
     RequestSpecification perparedRequest=given().
             header("Content-Type","application/json")
             .header("Authorization", token);

     //hitting the endpoint/send request
     Response response= perparedRequest.when().
             get("/pim/employee/7/contact-details");

     // verify assertions
     response.then().assertThat().statusCode(200);

     //verify the value in the response body
     response.then().assertThat().body("data.empNumber", equalTo("7"));

     //capturing emplyee number from responce
     empNumber=response.jsonPath().getString("get.empNumber");

     //verify header
     response.then().assertThat().header("Content-Type", "application/json");

     // print response for debugging
     System.out.println("Response Body:");
     response.prettyPrint();

 }

}
