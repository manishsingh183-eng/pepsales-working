# Notification Service

## Setup Instructions

1. Make sure you have Java 8 or above installed.
2. Place `spark-core-2.9.4.jar` and `gson-2.8.9.jar` inside the `lib/` folder.
3. Compile the project:

```
javac -cp "lib/*" -d out src/models/*.java src/utils/*.java src/services/*.java src/controllers/*.java
```

4. Run the server:

```
java -cp "lib/*;out" controllers.NotificationApi
```

## API Endpoints

- `POST /notifications`
- `GET /users/{id}/notifications`