# 📚 QuizApp - Backend REST APIs

A Spring Boot-based backend application for managing quizzes. This app allows users to add, fetch, update, and delete quiz questions, as well as generate and submit quizzes.

---

## 🚀 Features

- Add and manage quiz questions
- Fetch questions by category
- Create and retrieve quizzes
- Submit answers and calculate scores
- Clean RESTful API design
- Easy to integrate with frontend (React, Angular, etc.)

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Postman / Swagger (for testing)**

---

## 📡 API Endpoints

### 📦 Question APIs

| Method | Endpoint                  | Description                          |
|--------|---------------------------|--------------------------------------|
| `POST` | `/addQuestion`            | Add a new question                   |
| `GET`  | `/getAllQuestions`        | Fetch all questions                  |
| `GET`  | `/getQuestionsByCategory` | Get questions filtered by category   |
| `GET`  | `/deleteById`             | Delete a question by its ID          |
| `GET`  | `/updateQuestion`         | Update a question                    |

### 🧠 Quiz APIs

| Method | Endpoint        | Description                                 |
|--------|-----------------|---------------------------------------------|
| `GET`  | `/createQuiz`   | Create a quiz based on category & limit     |
| `GET`  | `/getQuizById`  | Fetch quiz questions by quiz ID             |
| `POST` | `/submit`       | Submit quiz responses and get result/score  |

---

## ⚙️ Getting Started

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/piyushaanand/QuizAppBackend.git
cd QuizAppBackend
