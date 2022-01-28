package org.example.autotests_backend;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class ApiYandex {

    static ResponseSpecification responseSpecification;

    static RequestSpecification requestSpecification;


    @BeforeEach
    void setUp() {

        requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .build();


        responseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(2000L))
                .build();
        RestAssured.responseSpecification = responseSpecification;
    }

    @Test
    @DisplayName("Расписание полётов")
    @Order(1)
    void testFlightSchedule() {
        given()
                .when()
                .get("https://api.rasp.yandex.net/v3.0/search/?apikey=5419f50f-0f61-425f-b03f-2d8b4a153a79&format=json&from=c146&to=c213&lang=ru_RU&page=1&date=20220126")
                .then()
                .assertThat()
                .statusCode(200)
                .body(containsString("pagination"));
    }

    @Test
    @DisplayName("Расписание рейсов по станции")
    @Order(2)
    void testScheduleByStation() {
        given()
                .when()
                .get("https://api.rasp.yandex.net/v3.0/schedule/?apikey=5419f50f-0f61-425f-b03f-2d8b4a153a79&station=s9600213&transport_types=suburban&direction=на%20Москву")
                .then()
                .assertThat()
                .statusCode(200)
                .body(containsString("schedule"));
    }

    @Test
    @DisplayName("Список станций следования")
    @Order(3)
    void testStationList() {
        given()
                .when()
                .get("https://api.rasp.yandex.net/v3.0/thread/?apikey=5419f50f-0f61-425f-b03f-2d8b4a153a79&station=s9600213&format=json&uid=34&lang=ru_RU&show_systems=all")
                .then()
                .assertThat()
                .statusCode(404)
                .statusLine(containsString("Not Found"))
                .body(containsString("Рейса с uid 34 нет в базе"));
    }

    @Test
    @DisplayName("Список ближайших станций")
    @Order(4)
    void testNearestStationList() {
        given()
                .when()
                .get("https://api.rasp.yandex.net/v3.0/nearest_stations/?apikey=5419f50f-0f61-425f-b03f-2d8b4a153a79&format=json&lat=50.440046&lng=40.4882367&distance=50&lang=ru_RU")
                .then()
                .assertThat()
                .statusCode(200)
                .body(containsString("Верхний Мамон, трасса"));
    }

    @Test
    @DisplayName("Ближайший город")
    @Order(5)
    void testNearestCity() {
        given()
                .when()
                .get("https://api.rasp.yandex.net/v3.0/nearest_settlement/?apikey=5419f50f-0f61-425f-b03f-2d8b4a153a79&format=json&lat=50.440046&lng=40.4882367&distance=50&lang=ru_RU")
                .then()
                .assertThat()
                .statusCode(200)
                .body(containsString("Павловск"));
    }

    @Test
    @DisplayName("Информация о перевозчике")
    @Order(6)
    void testCarrierInformation() {
        given()
                .when()
                .get("https://api.rasp.yandex.net/v3.0/carrier/?format=json&apikey=5419f50f-0f61-425f-b03f-2d8b4a153a79&lang=ru_RU&code=c10680&system=iata")
                .then()
                .assertThat()
                .statusCode(404)
                .statusLine(containsString("Not Found"))
                .body(containsString("Не нашли компании по коду"));
    }

    @Test
    @DisplayName("Список всех доступных станций")
    @Order(7)
    void testAvailableStationList() {
        given()
                .when()
                .get("https://api.rasp.yandex.net/v3.0/stations_list/?apikey=5419f50f-0f61-425f-b03f-2d8b4a153a79&lang=ru_RU&format=json")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(60L), TimeUnit.SECONDS);
    }
}
