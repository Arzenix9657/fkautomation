package id.co.juaracoding.testng;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import id.co.juaracoding.util.TestConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScratchTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = TestConfig.BASE_URL;
    }

    @Test
    public void probeApi() {
        // Fetch captcha
        Response captchaResp = RestAssured.given()
                .header("X-API-KEY", TestConfig.X_API_KEY)
                .contentType("application/json")
                .get("/api/v1/captcha");
        String captchaValue = captchaResp.jsonPath().getString("data.captcha_value");
        String captchaHash = captchaResp.jsonPath().getString("data.captcha_hash");
        
        System.out.println("=== FORGOT PASSWORD (unregistered@example.com) ===");
        String forgotBody = String.format(
            "{\"email\":\"%s\",\"captcha_answer\":\"%s\",\"captcha_hash\":\"%s\"}",
            "unregistered@example.com",
            captchaValue,
            captchaHash
        );
        
        RestAssured.given()
                .header("X-API-KEY", TestConfig.X_API_KEY)
                .contentType("application/json")
                .body(forgotBody)
                .post("/api/v1/forgot-password")
                .prettyPrint();
    }
}
