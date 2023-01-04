package producttestcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import product.ProductBody;
import prop.PropertyFileLoader;

public class ProductTests {

    PropertyFileLoader propertyFile;
    Response responceMessage;
    
    @Given("The base URL is invoked")
    public void invokeBaseURL() throws IOException{
        propertyFile = new PropertyFileLoader();
        RestAssured.baseURI
            = propertyFile.getBaseURL() + propertyFile.getProductURL();
    }

    @When("Request a GET method to return full product record")
    public void getAllProducts(){
        responceMessage = RestAssured.given().when()
            .get(propertyFile.readAllProduct());
    }

    @Then("I verify the status code is {int}")
    public void assertStatusCode(int statusCode){
        assertEquals(responceMessage.statusCode(), statusCode);
    }

    @When("Request a GET method to search for id number {int}")
    public void searchForProduct(int id){
        responceMessage = RestAssured.given().queryParam("id", id)
            .when().get(propertyFile.readOneProduct());
    }

    @Then("I verify the product name is {string}")
    public void verifyProductName(String productName){
        assertEquals(responceMessage.getBody().jsonPath().get("name"),
                     productName);
    }

    @When("Request a POST method to creat product with data")
    public void createNewProduct(DataTable productData){
       List<String> productBodyList = productData.row(1);
       double price = Double.valueOf(productBodyList.get(2));
       int category_id = Integer.valueOf(productBodyList.get(3));
       ProductBody productBody
           = new ProductBody(productBodyList.get(0), productBodyList.get(1),
                             price, category_id);
       responceMessage = RestAssured.given().body(productBody)
           .post(propertyFile.createNewProduct());
    }

    @Then("I verify the responce message is {string}")
    public void productIsCreated(String message){
        assertEquals(responceMessage.jsonPath().get("message"), message);
    }

    @When("Request a PUT method to update product with data")
    public void updateProduct(DataTable productData){
       List<String> productBodyList = productData.row(1);
       int id = Integer.valueOf(productBodyList.get(0));
       double price = Double.valueOf(productBodyList.get(3));
       int category_id = Integer.valueOf(productBodyList.get(4));
       ProductBody productBody
           = new ProductBody(id, productBodyList.get(1), productBodyList.get(2),
                             price, category_id);
       responceMessage = RestAssured.given().body(productBody)
           .put(propertyFile.updateProduct());
    }

    @Then("I verify the responce message of update is {string}")
    public void productIsUpdated(String message){
        assertEquals(responceMessage.jsonPath().get("message"), message);
    }

    @When("Request a DELETE method to delete product with id {int}")
    public void deleteProduct(int id){
        String body  = "{ \"id\" : "+id+" }";
       responceMessage = RestAssured.given().body(body)
           .delete(propertyFile.deleteProduct());
    }

    @Then("I verify the responce message of deletion is {string}")
    public void productIsDeleted(String message){
        assertEquals(responceMessage.jsonPath().get("message"), message);
    }
}
