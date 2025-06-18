# 📖 Library Management System – Spring Boot REST API

**Module:** IT 3232  
**Coursework:** Practical for E-Commerce (ICAE 02)  
**Institution:** Faculty of Applied Science, University of Vavuniya  
**Date Submitted:** 13th June 2025

---

## 🔍 Project Description

This project is a **RESTful API** developed using **Spring Boot** for a Library Management System. It is designed to handle the core functionalities of a typical library, such as managing books, students, and borrow records.

The system demonstrates:

- ✅ Entity mapping and persistence with **JPA/Hibernate**
- ✅ RESTful API development using **Spring Boot**
- ✅ Input validation and business logic enforcement
- ✅ Custom error handling
- ✅ Database interaction with **MySQL**

---

## 📂 Project Structure

```

src/
├── models/
│    ├── Book.java
│    ├── Student.java
│    ├── Borrow.java
│    └── ErrorResponce.java
├── repository/
│    ├── BookRepo.java
│    ├── StudentRepo.java
│    └── BorrowRepo.java
├── service/
│    ├── BookService.java
│    ├── StudentService.java
│    └── BorrowService.java
├── controllers/
│    ├── BookController.java
│    ├── StudentController.java
│    └── BorrowController.java
└── exceptionHandler/
     └── GenericExceptionHandler.java

````

---

## 🧩 Model Descriptions

- **Book**  
  Stores information such as title, genre, number of copies, and availability.

- **Student**  
  Contains student details including name, ID, and borrow history.

- **Borrow**  
  Records borrowing activity, including borrow date, return date, and status.

- **ErrorResponce**  
  Custom error wrapper for standardized API error outputs.

---

## ✅ Task Implementation

### 1️⃣ Task 1: Map Models & Insert Data

- Entities are annotated with `@Entity`
- Mapped using **JPA annotations**
- Data can be added manually via SQL or using MySQL Workbench

> 🖼️ *Screenshot: Displaying Book & Student Data in MySQL*

---

### 2️⃣ Task 2: Filter Books by Genre

**Repository Query:**
```java
@Query("SELECT b FROM Book b WHERE b.genre = ?1")
List<Book> getByGenre(String genre);
````

**API Endpoint:**

```
GET /books/{genre}
```

> 🖼️ *Screenshot: Filtered books by genre*

---

### 3️⃣ Task 3: Find Students by Book ID

**Repository Query:**

```java
@Query("SELECT s FROM Student s JOIN s.borrows b WHERE b.book.id = ?1")
List<Student> getBorrowedStudent(String bookId);
```

**API Endpoint:**

```
GET /students/{bookId}
```

> 🖼️ *Screenshot: Students who borrowed a specific book*

---

### 4️⃣ Task 4: Borrowing Logic & Validation

Enhanced business rules implemented in `BorrowService`:

* ❌ Reject borrow if student has 2 or more unreturned books
* ❌ Reject borrow if no lendable copies available
* ✅ Automatically updates book inventory upon borrowing

**API Endpoint:**

```
POST /borrows/add
```

> 🖼️ *Screenshots:*
>
> * Successful Borrow (`newBorrowEntry.png`)
> * Failure: One copy left (`borrowEntryError.png`)
> * Failure: Too many unreturned books (`entityNotFound.png`)

---

## 🛠️ Error Handling

Centralized exception handling using `@RestControllerAdvice` in `GenericExceptionHandler.java`.

Handled Exceptions:

* `EntityNotFoundException`
* `DataIntegrityViolationException`
* Generic `Exception`

---

## 🔗 API Summary

| Method | Endpoint             | Description                               |
| ------ | -------------------- | ----------------------------------------- |
| GET    | `/books/{genre}`     | Get all books by genre                    |
| GET    | `/students/{bookId}` | Get students who borrowed a specific book |
| POST   | `/borrows/add`       | Add a new borrow entry                    |

---

## 🚀 Running the Project

1. Ensure **MySQL** server is running.
2. Update the `application.properties` file with your DB credentials.
3. Use an IDE like **IntelliJ** or **Eclipse** or run via terminal:

   ```
   mvn spring-boot:run
   ```
4. Use **Postman** or a similar tool to test the API endpoints.

---

## 📝 Conclusion

✔️ Models are correctly mapped and persisted
✔️ Custom queries are implemented for filtering and joins
✔️ Business rules enforced in the service layer
✔️ Custom error responses for failed operations
✔️ All specified tasks completed and demonstrated

---

## 📸 Screenshots Overview

| Screenshot             | Description                             |
| ---------------------- | --------------------------------------- |
| `getByGenre.png`       | Filter books by genre                   |
| `borrowedStudents.png` | Students who borrowed a particular book |
| `newBorrowEntry.png`   | Successful borrow entry                 |
| `borrowEntryError.png` | Failure: Book not available             |
| `entityNotFound.png`   | Failure: Student/book not found         |

---

## 📄 License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
You are free to use, modify, and distribute this software for academic or personal use with attribution.
