package api.Booking.UpdateBooking.Model;

import api.Booking.CreateBooking.Model.CreateBookingRequestModel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateBookingRequestResponseModel {

    public String firstname;
    public String lastname;
    public int totalprice;
    public boolean depositpaid;
    public CreateBookingRequestModel.Bookingdates bookingdates;
    public String additionalneeds;

    @Builder
    public static class Bookingdates{
        public String checkin;
        public String checkout;
    }

}
