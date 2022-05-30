package com.word.counter.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;


public class Steps {
    private static final String BASE_URL = "http://localhost:8080";
    private static String TOKEN;
    private static Response response;
    private static Response unAuthorizedResponse;
    @Given("I am an authorized user {string}")
    public void iAmAnAuthorizedUser(String arg0) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.pathParam("userName", "user1");
        response = requestSpecification
                .get("/jwt-token/{userName}");
            TOKEN = response.asString();
        Assert.assertEquals(200, response.getStatusCode());

    }

    public RequestSpecification getRequestSpecification(){
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + TOKEN);
        request.header("Content-Type", "application/json");
        return request;
    }
    @When("I add word list")
    public void iAddWordList() {
        RestAssured.baseURI = BASE_URL;
        List<String> wordsList = Arrays.asList("123","abc","$abc");
        response = getRequestSpecification().body(wordsList)
                .post("/words/add");
    }

    @Then("word is added")
    public void wordIsAdded() {
        Assert.assertEquals(201, response.getStatusCode());
    }

    @Then("result contain more then one word count for alphabetic word {string}")
    public void resultContainMoreThenOneWordCountForAlphabeticWord(String arg0) {
        Assert.assertTrue(response.asString().contains("Word count for "+arg0+" :"));
    }

    @And("result don't contain any count for non alphabetic word {string}")
    public void resultDonTContainAnyCountForNonAlphabeticWord(String arg0) {
        Assert.assertEquals(response.asString(), "Word count for "+arg0+" : 0");

    }

    @When("I want to know count of word {string}")
    public void iWantToKnowCountOfWord(String arg0) {
        RestAssured.baseURI = BASE_URL;
        response = getRequestSpecification().pathParam("word",arg0.trim()).get("/words/count/{word}");
    }


    @When("I add word list without passing jwt")
    public void iAddWordListWithoutPassingJwt() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecificationNegative = RestAssured.given();
        requestSpecificationNegative.header("Content-Type", "application/json");
        List<String> wordsList = Arrays.asList("123","abc","$abc");
        unAuthorizedResponse = requestSpecificationNegative.body(wordsList)
                .post("/words/add");

    }

    @Then("Unauthorized exception will occur")
    public void unauthorizedExceptionWillOccur() {
        Assert.assertEquals(403,unAuthorizedResponse.getStatusCode() );

    }

    @When("I want to know count of any word without pass jwt")
    public void iWantToKnowCountOfAnyWordWithoutPassJwt() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecificationNegative = RestAssured.given();
        unAuthorizedResponse = requestSpecificationNegative.pathParam("word","abc").get("/words/count/{word}");

    }

}
