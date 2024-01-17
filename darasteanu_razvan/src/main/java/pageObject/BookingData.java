package pageObject;


public class BookingData {

    public static final String username = "BookingLoginTest@yahoo.com";

    public static final String password = "7hkSG7RERiZ2neK";
    public static final String hotelName = "Hotel Iasi";
    public static final String roomName = "tripla";
    public static final String contactPerson = "Me";
    public static final String checkinDate = "01/05/2024";
    public static final String checkoutDate = "01/06/2024";
    public static final int breakfastOption = 1;

    private String Username;
    private String Password;
    private String hotel;
    private String roomType;
    private int numberOfPeople;
    private String mainContactPerson;
    private String additionalPerson;
    private RoomOption roomOption;
    private String checkInDate;
    private String checkOutDate;
    private int breakfastsPerDay;
    private int numberOfPets;
    private String paymentOption;
    private int valueInTheField;
    private int valueInTheSecondField;

    public BookingData() {
        this.Username = username;
        this.Password = password;
        this.hotel = hotelName;
        this.roomType = roomName;
        this.roomOption = RoomOption.tripla;
        this.numberOfPeople = 1;
        this.mainContactPerson = contactPerson;
        this.additionalPerson = "";
        this.checkInDate = checkinDate;
        this.checkOutDate = checkoutDate;
        this.breakfastsPerDay = breakfastOption;
        this.numberOfPets = 0;
        this.paymentOption = "bank transfer";
    }


    // Getters and setters for the fields

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getMainContactPerson() {
        return mainContactPerson;
    }

    public void setMainContactPerson(String mainContactPerson) {
        this.mainContactPerson = mainContactPerson;
    }

    public String getAdditionalPerson() {
        return additionalPerson;
    }

    public void setAdditionalPerson(String additionalPerson) {
        this.additionalPerson = additionalPerson;
    }

    public RoomOption getRoomOption() {
        return roomOption;
    }

    public void setRoomOption(RoomOption roomOption) {
        this.roomOption = roomOption;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getBreakfastsPerDay() {
        return breakfastsPerDay;
    }

    public void setBreakfastsPerDay(int breakfastsPerDay) {
        this.breakfastsPerDay = breakfastsPerDay;
    }

    public int getNumberOfPets() {
        return numberOfPets;
    }

    public void setNumberOfPets(int numberOfPets) {
        this.numberOfPets = numberOfPets;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void enterValueInTheField(int i, String s) {
    }
}



