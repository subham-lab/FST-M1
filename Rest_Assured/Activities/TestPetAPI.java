import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPetAPI {

        String baseURI = "https://petstore.swagger.io/v2/pet";
        @Test
        public void GetPetDetails() {
                // Specify the base URL to the RESTful web service


                // Make a request to the server by specifying the method Type and
                // resource to send the request to.
                // Store the response received from the server for later use.
                Response response =
                        given().contentType(ContentType.JSON) // Set headers
                                .when().get(baseURI + "/findByStatus?status=sold"); // Run GET request

                // Now let us print the body of the message to see what response
                // we have received from the server
                String responseBody = response.getBody().asString();
                System.out.println("Response Body is =>  " + responseBody);

                // Assertions
                response.then().statusCode(200);
                response.then().body("[0].status", equalTo("sold"));
        }

        @Test
        public void AddNewPet() {
                String reqBody = "{\"id\": 77232,\"name\": \"Riley\",\"status\": \"alive\"}";

                Response response =
                        given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody).when().post(baseURI); // Send POST request

        // Print response of POST request
                String body = response.getBody().asPrettyString();
                System.out.println(body);
        }

        @Test

        public void UpdatePet() {
                // Write the request body
                String reqBody = "{\"id\": 77232,\"name\": \"Hansel\",\"status\": \"alive\"}";
                Response response =
                        given().contentType(ContentType.JSON) // Set headers
                                .body(reqBody).when().put(baseURI); // Send PUT request

                // Print the response
                String resBody = response.getBody().asPrettyString();
                System.out.println(resBody);
                // Assert the updates
                response.then().body("name", equalTo("Hansel"));
        }
}