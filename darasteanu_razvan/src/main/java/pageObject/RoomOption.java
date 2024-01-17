package pageObject;

public enum RoomOption {
    tripla("tripla"),
    dubla("dubla");

    private String value;

    RoomOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
