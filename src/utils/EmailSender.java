package utils;

import models.Notification;

public class EmailSender {
    public static void send(Notification notification) {
        System.out.println("Sending EMAIL to " + notification.getUserId() + ": " + notification.getMessage());
    }
}