package services;

import models.Notification;
import utils.EmailSender;
import utils.InAppSender;
import utils.SMSSender;

public class NotificationService {

    public void sendNotification(Notification notification) {
        int maxRetries = 3;
        int attempt = 0;
        boolean success = false;

        while (attempt < maxRetries && !success) {
            try {
                switch (notification.getType().toLowerCase()) {
                    case "email":
                        EmailSender.send(notification);
                        break;
                    case "sms":
                        SMSSender.send(notification);
                        break;
                    case "inapp":
                        InAppSender.send(notification);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported type: " + notification.getType());
                }

                success = true;

            } catch (Exception e) {
                attempt++;
                System.out.println("Attempt " + attempt + " failed: " + e.getMessage());

                if (attempt < maxRetries) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {
                    }
                } else {
                    System.out.println("All retries failed for notification: " + notification.getMessage());
                }
            }
        }
    }
}
