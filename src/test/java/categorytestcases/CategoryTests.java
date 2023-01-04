package categorytestcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.hamcrest.core.IsEqual;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import prop.PropertyFileLoader;

public class CategoryTests {

    PropertyFileLoader propertyFile;
    Response responce;

    @Given("The category base URL is invoked")
    public void invokeBaseURL() throws IOException{
        propertyFile = new PropertyFileLoader();
        RestAssured.baseURI
            = propertyFile.getBaseURL() + propertyFile.getCategroyURL();
    }

    @When("Request a GET method to return full category record")
    public void getAllCateory() {
        responce = RestAssured.given().when().get(propertyFile
            .readAllCategroy());
        responce.then().assertThat().log().all();
    }

    @Then("The status code should be {int} to read all ctegory")
    public void getAllCateory(int status) {
        assertEquals(responce.statusCode(), status);
        responce.then().assertThat().body("records.id[0]", IsEqual.equalTo("1"));
    }
}
