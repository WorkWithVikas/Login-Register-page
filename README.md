# Login-Register-page
# User Registration & Login System

A simple JavaFX application that provides user registration and login functionality with a MySQL database for storing user credentials.

## Features

- **Home Page**: A user-friendly interface with options to log in or register.
- **Login Page**: Allows users to log in with their email and password.
- **Registration Page**: Enables new users to sign up with their name, email, and password.
- **Back Button**: Navigation functionality to return to the home page from login or registration forms.
- **Database Integration**: User data is securely stored and retrieved from a MySQL database.



### Home Page

![1](https://github.com/user-attachments/assets/c82a698f-dc17-45c7-991b-73341aa1ce67)


### Login Page
![2](https://github.com/user-attachments/assets/0e5a5666-77b2-47a3-9a2a-6cb6abef6733)


### Registration Page
![2](https://github.com/user-attachments/assets/d9604477-2a52-4e91-9f2b-1a026e249138)


## Technologies Used

- **JavaFX**: For building the GUI.
- **MySQL**: For storing user data.
- **JDBC**: For database connectivity.

## Prerequisites

- Java Development Kit (JDK) 17 or later.
- MySQL database server installed and running.
- JavaFX SDK compatible with your JDK version.

## Database Setup

1. Create a MySQL database:
   ```sql
   CREATE DATABASE user_db;

   CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);


STRUCTURE ..

.
├── src
│   ├── registration
│   │   ├── Main.java
│   │   ├── Navigation.java
│   │   ├── LoginRegisterPage.java
│   │   └── styles.css
├── images
│   ├── icon.png
│   ├── background.jpg
├── README.md
