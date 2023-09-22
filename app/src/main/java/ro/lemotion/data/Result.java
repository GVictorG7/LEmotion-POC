package ro.lemotion.data;

import androidx.annotation.NonNull;
import ro.lemotion.data.model.LoggedInUser;

/**
 * A class that holds a result success w/ data or an error exception.
 */
public class Result {
    private Result() {
    }

    @NonNull
    @Override
    public String toString() {
        if (this instanceof Result.Success) {
            Result.Success success = (Result.Success) this;
            return "Success[data=" + success.getData().toString() + "]";
        } else if (this instanceof Result.Error) {
            Result.Error error = (Result.Error) this;
            return "Error[exception=" + error.getException().toString() + "]";
        }
        return "";
    }

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
        private final Exception exception;

        public Error(Exception error) {
            this.exception = error;
        }

        public Exception getException() {
            return this.exception;
        }
    }
}