package utils;

import models.Notification;

public class EmailSender {

    public static void send(Notification notification) {
        if (Math.random() < 0.5) {
            throw new RuntimeException("Simulated email failure");
        }
        System.out.println("Email sent to " + notification.getUserId() + ": " + notification.getMessage());
    }
}
