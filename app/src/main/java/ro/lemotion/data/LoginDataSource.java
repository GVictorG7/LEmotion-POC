package ro.lemotion.data;

import java.io.IOException;

import ro.lemotion.data.model.LoggedInUser;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    private static final String DUMMY_USERNAME = "contact@lemotion.ro";
    private static final String DUMMY_PASSWORD = "lemotion";

    public Result login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            if (DUMMY_USERNAME.equals(username) && DUMMY_PASSWORD.equals(password)) {
                LoggedInUser fakeUser =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                "LEmotion Contact");
                return new Result.Success(fakeUser);
            }
            return new Result.Failure();
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
