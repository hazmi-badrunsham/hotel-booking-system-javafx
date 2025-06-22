import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getStyleClass().add("root");

        // Title
        Label title = new Label("Hotel Booking System");
        title.getStyleClass().add("label-title");

        // Customer Info
        TextField customerNameField = new TextField();
        customerNameField.setPromptText("Customer Name");
        customerNameField.getStyleClass().add("text-field");

        TextField customerEmailField = new TextField();
        customerEmailField.setPromptText("Customer Email");
        customerEmailField.getStyleClass().add("text-field");

        TextField customerPhoneField = new TextField();
        customerPhoneField.setPromptText("Customer Phone");
        customerPhoneField.getStyleClass().add("text-field");

        // Receptionist Info
        TextField receptionistNameField = new TextField();
        receptionistNameField.setPromptText("Receptionist Name");
        receptionistNameField.getStyleClass().add("text-field");

        TextField receptionistEmailField = new TextField();
        receptionistEmailField.setPromptText("Receptionist Email");
        receptionistEmailField.getStyleClass().add("text-field");

        TextField receptionistPhoneField = new TextField();
        receptionistPhoneField.setPromptText("Receptionist Phone");
        receptionistPhoneField.getStyleClass().add("text-field");

        // Booking Info
        TextField hotelNameField = new TextField();
        hotelNameField.setPromptText("Hotel Name");
        hotelNameField.getStyleClass().add("text-field");

        ComboBox<String> roomTypeCombo = new ComboBox<>();
        roomTypeCombo.getItems().addAll("Single", "Double", "Suite");
        roomTypeCombo.setPromptText("Room Type");
        roomTypeCombo.getStyleClass().add("combo-box");

        DatePicker checkInDate = new DatePicker();
        checkInDate.getStyleClass().add("date-picker");

        DatePicker checkOutDate = new DatePicker();
        checkOutDate.getStyleClass().add("date-picker");

        // Payment Info
        TextField paymentAmountField = new TextField();
        paymentAmountField.setPromptText("Amount");
        paymentAmountField.getStyleClass().add("text-field");

        ComboBox<String> paymentMethodCombo = new ComboBox<>();
        paymentMethodCombo.getItems().addAll("Credit Card", "Debit Card", "Cash");
        paymentMethodCombo.setPromptText("Payment Method");
        paymentMethodCombo.getStyleClass().add("combo-box");

        // Factories and Service Layer
        BookingFactory bookingFactory = new StandardBookingFactory();
        PaymentFactory paymentFactory = new SimplePaymentFactory();
        BookingService bookingService = new BookingService(bookingFactory, paymentFactory);

        // Submit Button
        Button submitBtn = new Button("Submit Booking");
        submitBtn.getStyleClass().add("button");
        submitBtn.setOnAction(e -> {
            try {
                // Collect input
                String custName = customerNameField.getText();
                String custEmail = customerEmailField.getText();
                String custPhone = customerPhoneField.getText();

                String recepName = receptionistNameField.getText();
                String recepEmail = receptionistEmailField.getText();
                String recepPhone = receptionistPhoneField.getText();

                String hotelName = hotelNameField.getText();
                String roomType = roomTypeCombo.getValue();
                LocalDate checkIn = checkInDate.getValue();
                LocalDate checkOut = checkOutDate.getValue();
                float amount = Float.parseFloat(paymentAmountField.getText());
                String paymentMethod = paymentMethodCombo.getValue();

                // Basic validation
                if (custName.isEmpty() || roomType == null || paymentMethod == null || checkIn == null
                        || checkOut == null || recepName.isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Please fill in all required fields.");
                    return;
                }

                // Model creation
                Customer customer = new Customer(1, custName, custEmail, custPhone);
                Receptionist receptionist = new Receptionist(1, recepName, recepEmail, recepPhone);
                Hotel hotel = new Hotel(1, hotelName, "Unknown");
                Room room = new Room(101, hotel.getHotelID(), roomType, amount, "Available");

                // Business logic
                Booking booking = bookingService.handleBooking(customer, hotel, room, checkIn, checkOut,
                        receptionist.getReceptionistID());
                Payment payment = bookingService.handlePayment(booking, amount, paymentMethod);

                // Confirmation
                showAlert(Alert.AlertType.INFORMATION,
                        "Booking Successful!\n\n" +
                                "Customer: " + customer.getName() + "\n" +
                                "Hotel: " + hotel.getName() + "\n" +
                                "Room: " + room.getType() + "\n" +
                                "Receptionist: " + receptionist.getName() + "\n" +
                                "Amount: RM" + payment.getAmount());

            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Invalid input: " + ex.getMessage());
            }
        });

        layout.getChildren().addAll(
                title,
                new Label("Customer Information"), customerNameField, customerEmailField, customerPhoneField,
                new Label("Receptionist Information"), receptionistNameField, receptionistEmailField,
                receptionistPhoneField,
                new Label("Booking Information"), hotelNameField, roomTypeCombo, checkInDate, checkOutDate,
                new Label("Payment"), paymentAmountField, paymentMethodCombo,
                submitBtn);

        Scene scene = new Scene(layout, 400, 650);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hotel Booking System");
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType type, String msg) {
        Alert alert = new Alert(type);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
