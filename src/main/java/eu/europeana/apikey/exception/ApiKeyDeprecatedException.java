package eu.europeana.apikey.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when trying to perform an action on a deprecated API key
 */
@ResponseStatus(HttpStatus.GONE)
public class ApiKeyDeprecatedException extends ApiKeyException {

    public ApiKeyDeprecatedException(String id) {
        super("The API key " + id + " is deprecated!");
    }

    @Override
    public boolean doLogStacktrace() {
        return false;
    }
}
