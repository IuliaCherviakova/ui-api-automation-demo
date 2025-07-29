package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.EmployeeSearchPage;
import Pages.LoginPage;

public class PageInitializer {
    public static LoginPage login;
    public static EmployeeSearchPage employeeSearch;
    public static AddEmployeePage addEmployee;
    public static void initializePageObjects(){
       login=new LoginPage();
       employeeSearch=new EmployeeSearchPage();
       addEmployee=new AddEmployeePage();

    }
}
