//package org.example.autotests_backend;
//
//import io.qameta.allure.restassured.AllureRestAssured;
//import io.restassured.RestAssured;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.lessThan;
//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.junit.Assert.assertThat;
//
//public class Imgur {
//    static Map<String, String> headers =new HashMap<>();
//    static Properties prop = new Properties();
//
//    @BeforeAll
//    static void setUp() throws IOException {
//        RestAssured.filters(new AllureRestAssured());
//
//        headers.put("Autorization", "Bearer 9d2306f677fa45ecbbe39df15c86f710fb9692fc");
//        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
//
//        FileInputStream fis;
//        fis = new FileInputStream("src/test/recourses/allure.properties");
//
//        prop.load(fis);
//    }
//
//    @Test
//    void getAccountInfoTest() {
//        given().log().method()
//                .headers(headers)
//                .when()
//                .get("https://api.imgur.com/3/account/<username>")
//                .prettyPeek()
//                .then()
//                .statusCode(404);
//    }
//
//    @Test
//    void getEasy() {
//        RestAssured.get("https://corona-virus-stats.herokuapp.com/api/v1/cases/general-stats")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    void getStatistics() {
//        given()
//                .when()
//                .request("GET", "https://corona-virus-stats.herokuapp.com/api/v1/cases/general-stats")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    void getStatistics2() {
//        String result = given()
//                .when()
//                .get("https://corona-virus-stats.herokuapp.com/api/v1/cases/general-stats", 2)
//                .then()
//                .statusCode(404)
//                .extract()
//                .response()
//                .jsonPath()
//                .getString("status");
//        assertThat(result, equalTo("success"));
//    }
//
//    @Test
//    void getStatistics3() {
//        String result = given()
//                .when()
//                .get("https://corona-virus-stats.herokuapp.com/api/v1/cases/countries-search?page={page}", 2)
//                .then()
//                .statusCode(200)
//                .contentType(MyProp.applicationJson)
//                .extract()
//                .response()
//                .jsonPath()
//                .getString("status");
//        assertThat(result, equalTo("success"));
//    }
//
//    @Test
//    void getStatistics4() {
//        given()
//                .when()
//                .request("https://corona-virus-stats.herokuapp.com/api/v1/cases/countries-search?page={page}", 2)
//                .then()
//                .statusCode(200).body("status", equalTo("success10"));
//
//    }
//
//    @Test
//    void getStatistics5() {
//        given()
//                .log().all()
//                .when()
//                .get((String) prop.get("geturl"))
//                .prettyPeek()
//                .then()
//                .statusCode(200)
//            .and()
//            .body("status", equalTo("success"))
//            .and()
//            .time(lessThan(5L), TimeUnit.DAYS);
//    }
//
//    @Test
//    void Imgur() {
//        MyProp myProp = new MyProp();
//        myProp.initProp();
//        myProp.refresh();
//        myProp.test();
//
//        MyProp myProp2 = new MyProp();
//
//        myProp2
//                .test()
//                .test()
//                .second()
//                .refresh();
//    }
//}