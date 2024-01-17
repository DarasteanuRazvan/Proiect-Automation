package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiTestingWithJunit {

    private static final String url = "https://us-central1-booking-wnts-01-backend.cloudfunctions.net/webApi";
    private static final String url2 = "https://us-central1-booking-wnts-01-backend.cloudfunctions.net/webApi/auth/login";


    @Test
    public void verifyGetHotelByIdReturns200() {
        given().contentType("application/json")
                .when().get(url + "/hotels/{id}", "4a47d1ea-ce18-4239-bdd8-a9eecfb1b26a")
                .then().log().body().statusCode(200);
    }

    @Test
    public void verifyGetHotelByIdReturns404ForUnexistingHotel() {
        given().contentType("application/json")
                .when().get(url + "/hotels/{id}", "non-existing-id")
                .then().log().body().statusCode(404);
    }

    @Test
    public void verifyGetHotelByIdHasCorrectName() {
        given().contentType("application/json")
                .when().get(url + "/hotels/{id}", "4a47d1ea-ce18-4239-bdd8-a9eecfb1b26a")
                .then().log().body()
                .and().body("name", equalTo("Hotel Iasi"));
    }
    @Test
    public void testPutRequest() {
        String baseURI = "https://us-central1-booking-wnts-01-backend.cloudfunctions.net/webApi";
        String endpoint = "/users/navigation-history";
        String requestBody = "{\"history\": []}";

        given()
                .baseUri(baseURI)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put(endpoint)
                .then()
                .log().all();
    }

    @Test
    public void bugPutRequest() {
        String baseURI = "https://us-central1-booking-wnts-01-backend.cloudfunctions.net/webApi";
        String endpoint = "/users/favorites";
        String requestBody = "{\"favorites\": []}";

        given()
                .baseUri(baseURI)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put(endpoint)
                .then()
                .statusCode(401)
                .log().all();
    }

    @Test
    public void verifyBookingProcess() {
        System.out.println("Login step");
        RestAssured.baseURI = "https://us-central1-booking-wnts-01-backend.cloudfunctions.net/webApi";

        // Login Step
        String loginUrl = RestAssured.baseURI + "/auth/login";
        String requestBody = "{ \"email\": \"BookingLoginTest@yahoo.com\", \"password\": \"7hkSG7RERiZ2neK\" }";

        String accessToken = given().contentType("application/json").body(requestBody)
                .when().post(loginUrl)
                .then().extract().jsonPath().getString("access_token");
        System.out.println("End of test: Login Step");
        System.out.println("----------------------------------------------------");

        // Click on Hotel Iasi Image Step
        System.out.println("Begin of test: Click on Hotel Iasi Image Step");
        RestAssured.baseURI = "https://us-central1-booking-wnts-01-backend.cloudfunctions.net/webApi";
        String hotelUrl = RestAssured.baseURI + "/hotels/4a47d1ea-ce18-4239-bdd8-a9eecfb1b26a";

        given().header("Authorization", "Bearer " + accessToken)
                .when().get(hotelUrl)
                .then().log().body()
                .statusCode(200)
                .body("id", equalTo("4a47d1ea-ce18-4239-bdd8-a9eecfb1b26a"));
        System.out.println("End of test: Click on Hotel Iasi Image Step");
        System.out.println("----------------------------------------------------");

        // Click on Room "tripla" Step
        System.out.println("Begin of test: Click on Room \"tripla\" Step");
        RestAssured.baseURI = "http://138.68.69.185";
        RestAssured.basePath = "/_next/data/vnIJtE9hmxKQH6ElLfLkx/reserve-room/4a47d1ea-ce18-4239-bdd8-a9eecfb1b26a.json";

        given()
                .param("id", "4a47d1ea-ce18-4239-bdd8-a9eecfb1b26a")
                .when().get()
                .then().log().body()
                .statusCode(200)
                .body("pageProps.id", equalTo("4a47d1ea-ce18-4239-bdd8-a9eecfb1b26a"));
        System.out.println("End of test: Click on Room \"tripla\" Step");
        System.out.println("----------------------------------------------------");

        // Logout Step
        System.out.println("Logout Step");
        RestAssured.baseURI = "https://us-central1-booking-wnts-01-backend.cloudfunctions.net/webApi";

        // Logout Step
        String logoutUrl = RestAssured.baseURI + "/auth/logout";

        given().contentType("application/json")
                .when().post(logoutUrl)
                .then().log().all()
                .statusCode(200);
        System.out.println("End of test: Logout Step");
    }
}




