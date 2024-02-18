# API Testing Example with Restassured and TestNG
This repo demonstrates how to do API Test Automation using Restassured and TestNG.

<!--ts-->
* [API Testing Example with Restassured and TestNG](#api-testing-example-with-restassured-and-testng)
   * [Application under Test](#application-under-test)
   * [Exactly what APIs are we testing?](#exactly-what-apis-are-we-testing)
      * [Add User](#add-user)
      * [Login User](#login-user)
      * [Logout User](#logout-user)
      * [Delete User](#delete-user)
   * [Repository Structure](#repository-structure)
   * [Run the tests](#run-the-tests)
   * [Resources](#resources)

<!-- Created by https://github.com/ekalinin/github-markdown-toc -->
<!-- Added by: rashad, at: Sat Feb 17 05:18:10 PM EST 2024 -->

<!--te-->

## Application under Test

We will be testing the [Thinking Tester Contact List App](https://thinking-tester-contact-list.herokuapp.com/)

Specifically, the [API](https://documenter.getpostman.com/view/4012288/TzK2bEa8)

## Exactly what APIs are we testing?

In case Thinking App goes down or the API is updated, here is the gist of the current APIs tested at the time of writing.

### Add User

```
POST Request ->
https://thinking-tester-contact-list.herokuapp.com/users

Request Body ->
{
    "firstName": "Test",
    "lastName": "User",
    "email": "test@fake.com",
    "password": "myPassword"
}

Response Status ->
201
```

### Login User

```
POST Request ->
https://thinking-tester-contact-list.herokuapp.com/users/login

Request Body ->
{
    "email": "test2@fake.com",
    "password": "myNewPassword"
}

Response Status ->
200

Response Body ->
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MDgyMWYzMDYyZmJiMjEzZTJhZDlhMjAiLCJpYXQiOjE2MTk3M
}
```

### Logout User

```
POST Request ->
https://thinking-tester-contact-list.herokuapp.com/users/logout

Header ->
Authorization: Bearer $token

Response Status ->
200
```

### Delete User

```
DELETE Request ->
https://thinking-tester-contact-list.herokuapp.com/users/me

Header ->
Authorization: Bearer $token

Response Status ->
200
```

## Repository Structure
```
src/test/java/ThinkTester/ContactListApp
├── Apis
│   └── UserApi.java #Contains the User API Endpoints & Request Specifications
├── Tests
│   └── ApiTests
│       └── UserApiTest.java #Tests each API
└── Utils
    ├── Environment.java #Specifies the Base URI
    └── UserFactory.java #Creates data for a Random User
```

## Run the tests

### Run the API Tests
```
mvn clean verify -Dtest=*ApiTest
```

## Resources

Hopefully, we'll be adding a Youtube demo and Blog tutorial soon.
