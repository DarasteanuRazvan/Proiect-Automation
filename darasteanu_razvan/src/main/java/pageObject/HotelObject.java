package pageObject;


public class HotelObject {
    private String id;
    private String name;
    private String description;
    private int starRating;
    private double userRating;
    private String amenities;
    private int pricePerBreakfast;
    private boolean allowsPets;
    private boolean breakfastAsOption;
    private String location;

    @Override
    public String toString() {
        return "HotelObject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", starRating=" + starRating +
                ", userRating=" + userRating +
                ", amenities='" + amenities + '\'' +
                ", pricePerBreakfast=" + pricePerBreakfast +
                ", allowsPets=" + allowsPets +
                ", breakfastAsOption=" + breakfastAsOption +
                ", location='" + location + '\'' +
                '}';
    }
}