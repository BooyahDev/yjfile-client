package yjfile.client;

import java.io.IOException;

public class YJFileClientException extends Exception {
    public YJFileClientException() {
        super();
    }

    public YJFileClientException(String message) {
        super(message);
    }

    public YJFileClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public YJFileClientException(Throwable cause) {
        super(cause);
    }

    protected YJFileClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
