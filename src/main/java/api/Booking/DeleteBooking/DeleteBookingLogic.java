package api.Booking.DeleteBooking;

import api.Booking.CreateBooking.CreateBookingLogic;
import api.Support.ApiSupport;
import api.UrlsApi;
import io.restassured.response.Response;
import org.testng.Assert;

import static support.Context.rest;

public class DeleteBookingLogic {

    Response response;
    CreateBookingLogic createBookingLogic;

    public void createRequestDeleteBooking(String endpoint){
        createBookingLogic = new CreateBookingLogic();
        String token = ApiSupport.createToken();

        rest().baseUri(UrlsApi.BASE_URL + endpoint + "/" + createBookingLogic.createBookingAndGetId());
        rest().header("Content-Type", "application/json");
        rest().header("Cookie", "token=" + token);
    }

    public void sendDelete(){
        response = rest().delete();
    }

    public void validateResponse(Integer expectedStatusCode, String expectedMessage){
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
        String messageActual = response.getBody().asString();
        Assert.assertEquals(messageActual, expectedMessage);
    }

}
