public class Payment {
    private int paymentID;
    private int bookingID;
    private float amount;
    private String paymentMethod;
    private String status;

    public Payment(int paymentID, int bookingID, float amount, String paymentMethod, String status) {
        this.paymentID = paymentID;
        this.bookingID = bookingID;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public float getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
