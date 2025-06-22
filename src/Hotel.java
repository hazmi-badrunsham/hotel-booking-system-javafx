public class Hotel {
    private int hotelID;
    private String name;
    private String location;

    public Hotel(int hotelID, String name, String location) {
        this.hotelID = hotelID;
        this.name = name;
        this.location = location;
    }

    public int getHotelID() {
        return hotelID;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
