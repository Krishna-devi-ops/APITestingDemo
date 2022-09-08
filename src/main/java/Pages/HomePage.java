package Pages;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class HomePage {
    public static void main(String[] args) {
        RestAssured.baseURI="https://www.makemytrip.com/";
        given().queryParam("itinerary","DEL-BLR-07/09/2022&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&ccde=IN&lang=eng")
                .header("Content_Type","application/json").body(" {\n" +
                        "   \"firstName\": \"Krishna\",\n" +
                        "   \"lastName\": \"Chauhan\",\n" +
                        "   \"gender\": \"female\",\n" +
                        "   \"age\": 28,\n" +
                        "   \"address\": {\n" +
                        "       \"streetAddress\": \"101\",\n" +
                        "       \"city\": \"Bangalore\",\n" +
                        "       \"state\": \"KA\"\n" +"   },\n" +
                        "   \"phoneNumbers\": \"12345678\"\n" +"\n" +
                        "}")
                .when().post("flight/search").then().assertThat().statusCode(200);
    }
}
