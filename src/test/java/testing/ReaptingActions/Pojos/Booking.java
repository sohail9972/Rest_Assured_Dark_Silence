package testing.ReaptingActions.Pojos;

public class Booking {
    private String firstname;
    private String lastnaem;
    private String additionalneeds;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingDates;

    public Booking(){

    }
    public Booking(String fname,String lname,String aneeds,
                   int tprice,boolean dpaid,BookingDates dates){
        setFirstname(fname);
        setLastnaem(lname);
        setAdditionalneeds(aneeds);
        setTotalprice(tprice);
        setDepositpaid(dpaid);
        setBookingDates(dates);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastnaem() {
        return lastnaem;
    }

    public void setLastnaem(String lastnaem) {
        this.lastnaem = lastnaem;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }


}
