package api.Booking.CreateBooking;

import api.Booking.CreateBooking.Model.CreateBookingRequestModel;
import api.Support.ApiSupport;
import api.UrlsApi;
import io.restassured.response.Response;
import lombok.extern.java.Log;
import org.testng.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static support.Context.rest;

@Log
public class CreateBookingLogic {

    Response response;

    public String setupBody(){
        CreateBookingRequestModel.Bookingdates bookingdates = CreateBookingRequestModel.Bookingdates.builder()
                .checkin("2025-06-01")
                .checkout("2025-07-01")
                .build();

        CreateBookingRequestModel createBookingRequestModel = CreateBookingRequestModel.builder()
                .firstname("Teste")
                .lastname("Outsera")
                .totalprice(1234)
                .depositpaid(true)
                .bookingdates(bookingdates)
                .additionalneeds("Breakfast")
                .build();

        return ApiSupport.convertJavaObjectToJson(createBookingRequestModel);
    }

    public void createRequestBodyCreateBooking(String endpoint){
        rest().baseUri(UrlsApi.BASE_URL + endpoint);
        rest().header("Authorization", "Bearer " + ApiSupport.createToken());
        rest().header("Content-Type", "application/json");
        rest().body(setupBody());

    }

    public void sendPost(){
        response = rest().post();
    }

    public void validateResponse(Integer expectedStatusCode){
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("jsonSchemas/createBookingResponseSchema.json"));
    }

    public String createBookingAndGetId(){
        createRequestBodyCreateBooking("/booking");
        sendPost();
        validateResponse(200);
        return response.getBody().jsonPath().get("bookingid").toString();
    }

}