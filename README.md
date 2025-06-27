# 🏦 Itaú Transactional API

This project is a **RESTful API** developed as part of a **technical challenge for junior developers at Itaú Unibanco**. The goal of this application is to **manage financial transactions** and **compute real-time statistics** based on transactions made in the last 60 seconds.

The application was built with a focus on backend best practices, using the **Java** programming language and the **Spring Boot** framework, and is prepared for local execution.


## 🚀 Features

The API allows:

- ✅ Recording of new transactions based on amount, date and time.
- ✅ Deletion of all recorded transactions.
- ✅ Calculation of statistics (sum, average, minimum, maximum and count) of transactions in real time.
- ✅ Statistics query with customizable time interval (by default 60 seconds).


## 🛠️ Technologies Used

- **Java**
- **Spring Boot**
- **Gradle (Kotlin DSL)**
- **Swagger/OpenAPI 3** – for API documentation
- **Lombok**


## 📋 Prerequisites

To run this application you need:

- ✅ Java JDK 17+
- ✅ Gradle (Kotlin DSL)
- ✅ Git


## 📥 How to Configure the Project

### 1. Clone the Repository

```bash
git clone https://github.com/YuriErnani/itau-transactional-api.git
cd itau-transactional-api
```

### 2. Compile the Project

```bash
 ./gradlew build
```

### 3. Execute the Project

```bash
 ./gradlew bootRun
```


## 📖 API documentation

#### Receive Transactions

```http
 POST /transaction
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `value` | `BigDecimal` | **Mandatory**. The transaction amount 
| `dateTime` | `OffsetDateTime` | **Mandatory**. The time the transaction occurred

#### Clear Transactions

```http
  DELETE /transaction
```

#### Calculate Statistics

```http
  GET /statistics
```

| Parameter   | Type       | Description                                   |
| :---------- | :--------- | :------------------------------------------ |
| `searchRange` | `integer` | **Optional** The default value is 60s  |


## 🏁 Conclusion

This challenge was an excellent opportunity to apply modern development practices with Spring Boot, such as clean architecture, SOLID, automated documentation, exception control, among other features.
