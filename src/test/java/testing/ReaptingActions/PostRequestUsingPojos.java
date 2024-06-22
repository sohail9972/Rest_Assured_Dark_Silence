package testing.ReaptingActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import testing.ReaptingActions.Pojos.Booking;
import testing.ReaptingActions.Pojos.BookingDates;

public class PostRequestUsingPojos {

    @Test
    public void postApiRequestPojo(){
        BookingDates bookingDates = new BookingDates("2024-07--20","2024-07-26");
        Booking booking = new Booking("sally","maid","breakfast",1000,true,bookingDates);

        ObjectMapper objectMapper = new ObjectMapper();
//        String requestBody = ObjectMapper.writeWithDefaultPrettyPrinter().writeValueAsString(booking);

    }
}
