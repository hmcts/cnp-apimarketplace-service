package uk.gov.hmcts.apimarketplace.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SampleSmokeTest {
    @Value("${TEST_URL:http://localhost:4550}")
    private String testUrl;

    @BeforeEach
    public void setUp() {
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    void smokeTest() {
        log.info("SmokeTest hitting endpoint {}", testUrl);
        try {
            Response response = given()
                .baseUri(testUrl)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract().response();
            log.info("SmokeTest response:{}", response.asString());
            Assertions.assertEquals(200, response.statusCode());
            Assertions.assertTrue(response.asString().startsWith("Welcome"));
        } catch (Exception e) {
            log.info("SmokeTest exception ", e);
        }
    }
}
