package br.com.restassured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class OlaMundoTest {

    @Test
    public void testOlaMundo() {
        Response response = request(Method.GET, "https://restapi.wcaquino.me/ola");
        assertTrue(response.getBody().asString().equals("Ola Mundo!"));
        assertTrue(response.statusCode() == 200);
        assertTrue("O Status cod deveria ser 200 ", response.statusCode() == 200);
        assertEquals(200, response.statusCode());

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
    }

    @Test
    public void testConhecendoFormasGiven() {
        given()//Pré - condições
                .when() // Ação
                .get("https://restapi.wcaquino.me/ola")
                .then() // Assertions
                .statusCode(200);
    }

    @Test
    public void devoConhecerOsMatcherComHamcrest() {
          assertThat("Maria", Matchers.is("Maria"));
        //    assertThat(123, Matchers.is(123));
        //   assertThat(123, Matchers.isA(Integer.class));
        //   assertThat("Maria", Matchers.isA(String.class));


    }
}
