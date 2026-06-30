# 📚 Library Management System

A console-based Library Management System developed using **Java**, **JDBC**, and **Oracle SQL**. The application allows users to manage library books through a menu-driven interface with complete CRUD operations and book issue/return functionality.

---

## ✨ Features

- Add a new book
- View all books
- Search books by ID
- Update book details
- Delete books
- Issue books
- Return books
- Input validation
- Exception handling
- Menu-driven console interface

---

## 🛠 Technologies Used

- Java
- JDBC
- Oracle SQL
- IntelliJ IDEA
- Git
- GitHub

---

## 📂 Project Structure

```
LibraryManagementSystem
│
├── src
│   ├── dao
│   │     └── BookDAO.java
│   ├── database
│   │     └── DBConnection.java
│   ├── model
│   │     └── Book.java
│   ├── service
│   │     └── LibraryService.java
│   ├── util
│   │     └── InputValidator.java
│   └── Main.java
│
└── README.md
```

---

## 🗄 Database

This project uses **Oracle SQL**.

Example table:

| Column | Type |
|---------|------|
| BOOK_ID | NUMBER |
| TITLE | VARCHAR2 |
| AUTHOR | VARCHAR2 |
| CATEGORY | VARCHAR2 |
| PRICE | NUMBER |
| ISSUED | CHAR(1) |

---

## ▶️ How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Add the Oracle JDBC driver (`ojdbc11.jar`) to the project.
4. Create the `BOOKS` table in Oracle SQL.
5. Update the database credentials in `DBConnection.java`.
6. Run `Main.java`.

---

## 🚀 Future Improvements

- User authentication
- Due date management
- Fine calculation
- Book reservation
- GUI using JavaFX or Swing
- Spring Boot REST API integration

---

## 👨‍💻 Author

**Harshit Deore**

GitHub: https://github.com/harshitdeore