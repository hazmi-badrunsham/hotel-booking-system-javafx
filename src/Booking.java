import java.time.LocalDate;

public class Booking {
    private int bookingID;
    private int customerID;
    private int roomID;
    private int hotelID;
    private int receptionistID;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Booking(int bookingID, int customerID, int roomID, int hotelID, int receptionistID,
            LocalDate checkInDate, LocalDate checkOutDate) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.roomID = roomID;
        this.hotelID = hotelID;
        this.receptionistID = receptionistID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Getters only for now (you can add setters too)
    public int getBookingID() {
        return bookingID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getRoomID() {
        return roomID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public int getReceptionistID() {
        return receptionistID;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
}
