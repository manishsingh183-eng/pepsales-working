package utils;

import models.Notification;

public class InAppSender {
    public static void send(Notification notification) {
        System.out.println("Sending In-App Notification to " + notification.getUserId() + ": " + notification.getMessage());
    }
}