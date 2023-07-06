package MateAcademy.exception;

/**
 * In this task you have UserService class with getUserScore() method. Method receives two parameters:
 * an array of strings records and a single string element email.
 *
 * records represent database of users, each user has two parameters - email and score stored as
 * single string, so record looks like this: "someEmail@gmail.com:userScore".
 *
 * userScore is in integer format and has value in range 0 - Integer.MAX_VALUE.
 *
 * Your task here is to find out if records contains user with certain email that you receive:
 *
 * if user exists, return his score in int format;
 * if not - throw an exception UserNotFoundException with the message "User with given email doesn't
 * exist" (since it's our custom logic, you should create your own, UNCHECKED, exception because in
 * this case it will be unexpected behaviour).
 */

public class ExceptionRunner {
    public static void main(String[] args) {
//        String[] records = {"testEmail@gmail.com:100",
//                "user@yahoo.com:1",
//                "second-user@gmail.com:20"};
//        String email = "testEmail@gmail.com";

        String[] records = {"testEmail@gmail.com:100"};
        String email = "invalidEmail@gmail.com";

//        String[] records = {"alice@mail.us:0"};
//        String email = "alice@mail.us:0_+";


        UserService userService = new UserService();
//        userService.getUserScore(records,email);
        System.out.println(userService.getUserScore(records, email));
    }
}



