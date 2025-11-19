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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
class FunctionalTest {
    protected static final String CONTENT_TYPE_VALUE = "application/json";

    @Value("${TEST_URL:http://localhost:8080}")
    private String testUrl;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = testUrl;
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    void functionalTest() {
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
            Assertions.assertTrue(response.asString().equals("API Marketplace template"));
        } catch (Exception e) {
            log.info("SmokeTest exception ", e);
        }
    }
}
