package eu.europeana.apikey.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when the keycloak client could not be found
 * @author Patrick Ehlert
 * Created on 18 nov 2019
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class MissingKCClientException extends ApiKeyException {

    public MissingKCClientException(String apiKey) {
        super("Error retrieving client information", "No keycloak client was found for API key " + apiKey);
    }

    @Override
    public boolean doLogStacktrace() {
        return false;
    }
}
