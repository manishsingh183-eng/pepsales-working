package models;

public class Notification {
    private String userId;
    private String message;
    private String type;

    public Notification(String userId, String message, String type) {
        this.userId = userId;
        this.message = message;
        this.type = type;
    }

    public String getUserId() { return userId; }
    public String getMessage() { return message; }
    public String getType() { return type; }
}