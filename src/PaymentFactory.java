public interface PaymentFactory {
    Payment createPayment(int bookingID, float amount, String method);
}
