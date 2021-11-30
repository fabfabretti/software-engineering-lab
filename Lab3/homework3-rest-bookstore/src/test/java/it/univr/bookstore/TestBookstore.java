package it.univr.bookstore;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =
        SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestBookstore {
    @BeforeAll
    public static void setBaseUri() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void createBookTest(){
        final String title = "Titoletto";
        final String author = "Io";
        final float price = 13.50F; // Nota: F serve perché altrimenti lui lo casterebbe a double

        // create the book
        int id =
                given()
                        .queryParam("title",title)
                        .queryParam("author",author)
                        .queryParam("price",price)
                .when()
                        .post("/book")
                .then()
                        .statusCode(200)
                        .body("id", Matchers.greaterThan(0))
                        .body("title",Matchers.is(title))
                        .body("author",Matchers.is(author))
                        .body("price",Matchers.is(price))
                        .extract().path("id");

        // update the book
        final String title2 = "Software Engineering, Vol. 1";
        final String author2 = "Mariano Ceccato";
        final float price2 = 16.50F;
        given()
            .contentType("application/json").body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"title\": \"Software Engineering, Vol. 1\",\n" +
                        "  \"author\": \"Mariano Ceccato\",\n" +
                        "  \"price\": 16.5\n" +
                        "}")
        .when().put("/book")
        .then()
            .statusCode(200)
            .body("id", Matchers.greaterThan(0))
            .body("title",Matchers.is(title2))
            .body("author",Matchers.is(author2))
            .body("price",Matchers.is(price2));



    }

}