import java.time.LocalDate;

public interface BookingFactory {
    Booking createBooking(Customer customer, Hotel hotel, Room room, LocalDate checkIn, LocalDate checkOut,
            int receptionistID);

}
