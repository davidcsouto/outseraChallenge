package api.Booking.UpdateBooking;

import api.Booking.CreateBooking.CreateBookingLogic;
import api.Booking.CreateBooking.Model.CreateBookingRequestModel;
import api.Support.ApiSupport;
import api.UrlsApi;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static support.Context.rest;

public class UpdateBookingLogic {

    Response response;
    CreateBookingLogic createBookingLogic;

    public String setupRequestBodyToUpdate(){
        CreateBookingRequestModel.Bookingdates bookingdates = CreateBookingRequestModel.Bookingdates.builder()
                .checkin("2025-07-03")
                .checkout("2025-12-03")
                .build();

        CreateBookingRequestModel createBookingRequestModel = CreateBookingRequestModel.builder()
                .firstname("Teste Update")
                .lastname("Outsera Update")
                .totalprice(9876)
                .depositpaid(false)
                .bookingdates(bookingdates)
                .additionalneeds("No needed")
                .build();

        return ApiSupport.convertJavaObjectToJson(createBookingRequestModel);
    }

    public void createRequestUpdateBooking(String endpoint){
        createBookingLogic = new CreateBookingLogic();
        String token = ApiSupport.createToken();

        rest().baseUri(UrlsApi.BASE_URL + endpoint + "/" + createBookingLogic.createBookingAndGetId());
        rest().header("Authorization", "Bearer " + token);
        rest().header("Content-Type", "application/json");
        rest().header("Accept", "application/json");
        rest().header("Cookie", "token=" + token);
        rest().body(setupRequestBodyToUpdate());

    }

    public void sendPut(){
        response = rest().put();
    }

    public void validateResponse(Integer expectedStatusCode){
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("jsonSchemas/updateBookingResponseSchema.json"));
    }

}
