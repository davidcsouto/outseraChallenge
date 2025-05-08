package api.Booking.ReadBooking;

import api.Booking.CreateBooking.CreateBookingLogic;
import api.Support.ApiSupport;
import api.UrlsApi;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static support.Context.rest;

public class ReadBookingLogic {

    Response response;
    CreateBookingLogic createBookingLogic;

    public void createRequestReadBooking(String endpoint){
        createBookingLogic = new CreateBookingLogic();

        rest().baseUri( UrlsApi.BASE_URL + endpoint + "/" + createBookingLogic.createBookingAndGetId());
        rest().header("Authorization", "Bearer " + ApiSupport.createToken());
    }

    public void sendGet(){
        response = rest().get();
    }

    public void validateResponse(Integer expectedStatusCode){
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("jsonSchemas/readBookingResponseSchema.json"));
    }

}
