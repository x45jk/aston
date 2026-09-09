package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoApiTest {
    private final String requestBody = "This is expected to be sent back as part of response body.";
    private final String responseBody = "This is expected to be sent back as part of response body.";

    @BeforeEach
    public void configureRestAssured() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGETRequest() {
        given()
            .log().ifValidationFails()
        .when()
            .get("/get?foo1=bar1&foo2=bar2")
        .then()
            .log().ifValidationFails()
            .statusCode(HttpStatus.SC_OK)
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPOSTRawText() {
        given()
            .log().ifValidationFails()
            .contentType(ContentType.TEXT)
            .body(requestBody)
        .when()
            .post("/post")
        .then()
            .log().ifValidationFails()
            .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(responseBody));
    }

    @Test
    public void testPOSTFormData() {
        given()
            .log().ifValidationFails()
            .multiPart("foo1", "bar1")
            .multiPart("foo2", "bar2")
        .when()
            .post("/post")
        .then()
            .log().ifValidationFails()
            .statusCode(HttpStatus.SC_OK)
                .and().body("form.foo1", equalTo("bar1"))
                .and().body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void testPUTRequest() {
        given()
            .log().ifValidationFails()
            .contentType(ContentType.TEXT)
            .body(requestBody)
        .when()
            .put("/put")
        .then()
            .log().ifValidationFails()
            .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(responseBody));
    }

    @Test
    public void testPATCHRequest() {
        given()
            .log().ifValidationFails()
            .contentType(ContentType.TEXT)
            .body(requestBody)
        .when()
            .patch("/patch")
        .then()
            .log().ifValidationFails()
            .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(responseBody));
    }

    @Test
    public void testDELETERequest() {
        given()
            .log().ifValidationFails()
            .contentType(ContentType.TEXT)
            .body(requestBody)
        .when()
            .delete("/delete")
        .then()
            .log().ifValidationFails()
            .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(responseBody));
    }
}