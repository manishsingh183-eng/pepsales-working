package controllers;

import static spark.Spark.*;
import com.google.gson.Gson;
import models.Notification;
import services.NotificationService;

import java.util.*;

public class NotificationApi {

    static Map<String, List<Notification>> userNotifications = new HashMap<>();

    public static void main(String[] args) {
        port(4567);
        Gson gson = new Gson();
        NotificationService service = new NotificationService();

        post("/notifications", (req, res) -> {
            Notification notification = gson.fromJson(req.body(), Notification.class);
            service.sendNotification(notification);
            userNotifications.computeIfAbsent(notification.getUserId(), k -> new ArrayList<>()).add(notification);
            res.status(201);
            return "Notification sent.";
        });

        get("/users/:id/notifications", (req, res) -> {
            String userId = req.params(":id");
            List<Notification> notifications = userNotifications.getOrDefault(userId, new ArrayList<>());
            res.type("application/json");
            return gson.toJson(notifications);
        });
    }
}
