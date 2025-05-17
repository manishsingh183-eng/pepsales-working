package services;

import models.Notification;
import utils.EmailSender;
import utils.SMSSender;
import utils.InAppSender;

public class NotificationService {

    public void sendNotification(Notification notification) {
        int retries = 3;
        while (retries-- > 0) {
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
                        System.out.println("Unknown notification type: " + notification.getType());
                }
                break;
            } catch (Exception e) {
                System.out.println("Failed to send. Retries left: " + retries);
                if (retries == 0) {
                    System.out.println("Giving up on notification to " + notification.getUserId());
                }
            }
        }
    }
}