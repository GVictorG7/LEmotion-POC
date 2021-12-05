package ro.lemotion.data;

import ro.lemotion.data.model.LoggedInUser;

/**
 * A class that holds a result success w/ data or an error exception.
 */
public class Result {
    // hide the private constructor to limit subclass types (Success, Error)
    private Result() {
    }

    @Override
    public String toString() {
        if (this instanceof Result.Success) {
            Result.Success success = (Result.Success) this;
            return "Success[data=" + success.getData().toString() + "]";
        } else if (this instanceof Result.Error) {
            Result.Error error = (Result.Error) this;
            return "Error[exception=" + error.getError().toString() + "]";
        }
        return "";
    }

    // Success sub-class
    public static final class Success extends Result {
        private final LoggedInUser data;

        public Success(LoggedInUser data) {
            this.data = data;
        }

        public LoggedInUser getData() {
            return this.data;
        }
    }

    public static final class Failure extends Result {
        public String getMessage() {
            return "Invalid credentials";
        }
    }

    // Error sub-class
    public static final class Error extends Result {
        private final Exception error;

        public Error(Exception error) {
            this.error = error;
        }

        public Exception getError() {
            return this.error;
        }
    }
}