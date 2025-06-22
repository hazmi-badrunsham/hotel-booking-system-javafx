public class Room {
    private int roomID;
    private int hotelID;
    private String type;
    private float price;
    private String status;

    public Room(int roomID, int hotelID, String type, float price, String status) {
        this.roomID = roomID;
        this.hotelID = hotelID;
        this.type = type;
        this.price = price;
        this.status = status;
    }

    public int getRoomID() {
        return roomID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
