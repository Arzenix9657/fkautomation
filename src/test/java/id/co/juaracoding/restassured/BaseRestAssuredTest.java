package id.co.juaracoding.restassured;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import id.co.juaracoding.util.TestConfig;
import org.testng.annotations.BeforeClass;

public class BaseRestAssuredTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = TestConfig.BASE_API_URL;
    }

    protected RequestSpecification givenApiRequest() {
        return RestAssured.given()
                .header("X-API-KEY", TestConfig.X_API_KEY)
                .contentType("application/json");
    }
}
