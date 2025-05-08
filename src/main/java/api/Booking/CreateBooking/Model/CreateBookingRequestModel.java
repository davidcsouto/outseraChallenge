package api.Booking.CreateBooking.Model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateBookingRequestModel {

    public String firstname;
    public String lastname;
    public int totalprice;
    public boolean depositpaid;
    public Bookingdates bookingdates;
    public String additionalneeds;

    @Builder
    public static class Bookingdates{
        public String checkin;
        public String checkout;
    }

}
