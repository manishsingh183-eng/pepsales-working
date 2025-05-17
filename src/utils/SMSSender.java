package utils;

import models.Notification;

public class SMSSender {
    public static void send(Notification notification) {
        System.out.println("Sending SMS to " + notification.getUserId() + ": " + notification.getMessage());
    }
}