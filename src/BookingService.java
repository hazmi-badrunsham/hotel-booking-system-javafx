import java.time.LocalDate;

public class BookingService {
    private final BookingFactory bookingFactory;
    private final PaymentFactory paymentFactory;

    public BookingService(BookingFactory bookingFactory, PaymentFactory paymentFactory) {
        this.bookingFactory = bookingFactory;
        this.paymentFactory = paymentFactory;
    }

    public Booking handleBooking(Customer customer, Hotel hotel, Room room, LocalDate checkIn, LocalDate checkOut,
            int receptionistID) {
        return bookingFactory.createBooking(customer, hotel, room, checkIn, checkOut, receptionistID);
    }

    public Payment handlePayment(Booking booking, float amount, String method) {
        return paymentFactory.createPayment(booking.getBookingID(), amount, method);
    }
}
