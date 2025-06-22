import java.time.LocalDate;

public class StandardBookingFactory implements BookingFactory {
    @Override
    public Booking createBooking(Customer customer, Hotel hotel, Room room, LocalDate checkIn, LocalDate checkOut,
            int receptionistID) {
        return new Booking(1, customer.getCustomerID(), room.getRoomID(), hotel.getHotelID(), receptionistID, checkIn,
                checkOut);
    }

}
