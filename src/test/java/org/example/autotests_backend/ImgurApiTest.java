package org.example.autotests_backend;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ImgurApiTest {

    private static int commentId;

    @Test
    @Order(1)
    @DisplayName("Получение инфо об аккаунте")
    void testGetAccountBase() {
        given()
                .header("Authorization", "Client-ID 245e10b28ddc002")
                .log()
                .all()
                .expect()
                .statusCode(200)
                .body("data.id", is("153514053"))
                .body("data.url", is("levinmk23"))
                .body("success", is(true))
                .log()
                .all()
                .when()
                .get("https://api.imgur.com/3/account/levinmk23");
    }

    @Test
    @Order(2)
    @DisplayName("Не валидный токен при создании комментария")
    void testPostComment() {
        int commentId = given().auth()
                .oauth2("token")
                .formParam("image_id", "4jZlZEJ")
                .formParam("comment", "My comment")
                .expect()
                .statusCode(403)
                .body("success", is(false))
                .log()
                .body()
                .when()
                .post("https://api.imgur.com/3/comment")
                .jsonPath()
                .getInt("data.id");

        System.out.println(commentId);

//        @Test
//        @Order(3)
//        void testGetComment() {
//            given()
//                    .header("Authorization", "Client-ID 245e10b28ddc002")
//                    .log()
//                    .all()
//                    .expect()
//                    .body("data.id", is(commentId))
//                    .body("data.image_id", is("4jZlZEJ"))
//                    .body("data.comment", is("My comment 3"))
//                    .statusCode(200)
//                    .log()
//                    .all()
//                    .when()
//                    .get("https://api.imgur.com/3/comment/" + commentId);
//        }

    }
    @Test
    @Order(4)
    void testDeleteComment() {
        given()
                .auth()
                .oauth2("76ee37117ac4d779519a9a287ef92c40e543334e")
                .expect()
                .statusCode(200)
                .log().all()
                .when()
                .delete("https://api.imgur.com/3/comment/" + commentId);
    }

//        аналогичная запись header
//        given().header(new Header("Authorization", "Client-ID 245e10b28ddc002"))
//                .expect()
//                .body("data.id", is("153514053"))
//                .when()
//                .get("https://api.imgur.com/3/account/levinmk23");
    }
