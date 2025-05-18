# 📬 Notification Service - Java + Spark API

A simple Java-based backend to send notifications via Email, SMS, and In-App messages using RESTful API.

---

## ✅ Requirements

- Java 8 or above installed
- These `.jar` dependencies placed in the `lib/` folder:
  - spark-core-2.9.4.jar
  - gson-2.8.9.jar
  - slf4j-api-1.7.36.jar
  - slf4j-simple-1.7.36.jar
  - jetty-server-9.4.44.v20210927.jar
  - jetty-util-9.4.44.v20210927.jar
  - jetty-http-9.4.44.v20210927.jar
  - jetty-io-9.4.44.v20210927.jar
  - javax.servlet-api-3.1.0.jar

---

## 📦 Setup Instructions

1. **Extract the Project**  
   Unzip `pepsales-working.zip` into a folder like `C:\Users\YourName\Desktop\pepsales-working`.

2. **Place All JARs in `lib/`**  
   Ensure all required JARs listed above are inside the `lib/` folder.

3. **Open Terminal or CMD in Project Root**  
   Navigate to the `pepsales-working` folder.

4. **Compile the Code**

   ```bash
   javac -cp "lib/*" -d out src/models/*.java src/utils/*.java src/services/*.java src/controllers/*.java
   ```

5. **Run the Server**

   ```bash
   java -cp "lib/*;out" controllers.NotificationApi
   ```

   > Use `:` instead of `;` on macOS/Linux.

---

## 🌐 API Endpoints

### 🔹 POST `/notifications`
Send a notification.

**Request Body Example (JSON):**
```json
{
  "userId": "user123",
  "message": "Hello from API!",
  "type": "email"
}
```

### 🔹 GET `/users/{id}/notifications`
Retrieve notifications sent to a user.

---

## 🧠 Assumptions Made

- In-memory map used to store user notifications (no DB/file).
- Retry logic (3 attempts) added for failed sends.
- All sending operations are simulated via console prints.
- Spark Java used without Maven (manual JAR management).

---

## 🚀 Optional: Use run.bat

Double-click `run.bat` (on Windows) for auto-compile and run.

---