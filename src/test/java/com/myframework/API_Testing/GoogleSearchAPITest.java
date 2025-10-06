package com.myframework.API_Testing;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GoogleSearchAPITest {

        public static void main(String[] args) {
            String apiKey = "AIzaSyDZSA6-8wclNtD5p92vH-82NSmX9SE-RJQ";  // Replace with your API key
            String cx = "42720f855b9c14f12"; // Replace with your search engine ID
            String query = "OnlyDingle";

            RestAssured.baseURI = "https://www.googleapis.com";

            Response response = given()
                    .queryParam("key", apiKey)
                    .queryParam("cx", cx)
                    .queryParam("q", query)
                    .when()
                    .get("/customsearch/v1")
                    .then()
                    .statusCode(200)
                    .extract().response();

            // Print all result titles and links
            var items = response.jsonPath().getList("items");

            System.out.println("Search results for: " + query);
            for (int i = 0; i < items.size(); i++) {
                String title = response.jsonPath().getString("items[" + i + "].title");
                String link = response.jsonPath().getString("items[" + i + "].link");
                System.out.println((i + 1) + ". " + title + " → " + link);
            }
            // JSON Format
            //System.out.println(response.asPrettyString());

        }
    }
