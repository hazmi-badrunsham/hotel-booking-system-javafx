public class SimplePaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment(int bookingID, float amount, String method) {
        return new Payment(1, bookingID, amount, method, "Paid");
    }
}
