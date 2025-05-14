package adapters;

import utils.PropertyReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class BaseAdapter {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()                       // Formats JSON output to be human-readable (indented)
            .excludeFieldsWithoutExposeAnnotation()    // Ignores fields that don't have @Expose annotation
            .create();                                 // Builds the Gson object

    static RequestSpecification headerRequest = given()
            .header("Token", System.getProperty("token", PropertyReader.getProperty("token")))
            .header("Content-Type", ContentType.JSON);

    public Response post(String uri, String body, int expectedStatusCode) {
        return
                given()
                        .filter(new AllureRestAssured())
                        .spec(headerRequest)
                        .log().all()
                        .body(body)
                        .when()
                        .post(baseURI + uri)
                        .then()
                        .log().all()
                        .statusCode(expectedStatusCode)
                        .extract().response();
    }

    public Response get(String uri, int expectedStatusCode) {
        return
                given()
                        .filter(new AllureRestAssured())
                        .spec(headerRequest)
                        .log().all()
                        .get(baseURI + uri)
                        .then()
                        .log().all()
                        .assertThat()
                        .statusCode(expectedStatusCode)
                        .extract().response();
    }

    public Response patch(String uri, String body, int expectedStatusCode) {
        return
                given()
                        .filter(new AllureRestAssured())
                        .spec(headerRequest)
                        .log().all()
                        .body(body)
                        .when()
                        .patch(baseURI + uri)
                        .then()
                        .log().all()
                        .statusCode(expectedStatusCode)
                        .extract().response();
    }

    public Response delete(String uri, int expectedStatusCode) {
        return
                given()
                        .filter(new AllureRestAssured())
                        .spec(headerRequest)
                        .log().all()
                        .when()
                        .delete(baseURI + uri)
                        .then()
                        .log().all()
                        .statusCode(expectedStatusCode)
                        .extract().response();
    }
}
