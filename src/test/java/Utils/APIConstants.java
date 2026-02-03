package Utils;

import io.restassured.RestAssured;

public class APIConstants {
    public static final String BaseURI= RestAssured.baseURI="https://opensource-demo.orangehrmlive.com/web/index.php/api/v2";
    public static final String GENERATE_TOKEN_URI=BaseURI+ "/auth/login";
    public static final String CREATE_EMPLOYEE_URI=BaseURI+"/pim/employees";
    public static final String GET_ONE_EMPLOYEE_URI=BaseURI+"/pim/employees/{empNumber}";
    public static final String UPDATE_EMPLOYEE_URI=BaseURI+"/pim/employees/{empNumber}/personal-details";

    public static final String HEADER_KEY_CONTENT_TYPE="Content-Type";
    public static final String HEADER_VALUE_CONTENT_TYPE="aplication/json";
    public static final String HEADER_KEY_AUTHORIZATION="Authorization";


}
