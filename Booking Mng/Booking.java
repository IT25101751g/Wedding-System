
public class Booking {

    private int bookingId;
    private String bookingDate;

    public Booking(int bookingId, String bookingDate) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }
}