package MateAcademy.exception;

public class UserService {
    public int getUserScore(String[] records, String email) {
        //write your code here
        for (String str : records) {
            if (str.substring(0, str.indexOf(":")).equals(email)) {
                return Integer.parseInt(str.substring(str.indexOf(":") + 1));
            }
        }
        throw new UserNotFoundException("User with given email doesn't exist");
    }
}
