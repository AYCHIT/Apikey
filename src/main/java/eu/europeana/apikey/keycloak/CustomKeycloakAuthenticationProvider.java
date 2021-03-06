package eu.europeana.apikey.keycloak;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Authentication provider used to authenticate clients following the client credentials grant type
 */
@Service
public class CustomKeycloakAuthenticationProvider extends KeycloakAuthenticationProvider {

    private static final Logger LOG = LogManager.getLogger(CustomKeycloakAuthenticationProvider.class);

    private KeycloakManager keycloakManager;

    public CustomKeycloakAuthenticationProvider(KeycloakManager keycloakManager) {
        this.keycloakManager = keycloakManager;
    }

    public Authentication authenticate(String clientId, String clientSecret) {
        LOG.debug("Authenticating client {}", clientId);
        KeycloakPrincipal<KeycloakSecurityContext> principal =
                keycloakManager.authenticateClient(clientId, clientSecret);
        if (principal != null) {
            return new KeycloakAuthenticationToken(principal,
                    keycloakManager.getAuthorities(principal.getKeycloakSecurityContext().getAccessToken()));
        }
        LOG.info("Authentication for client {} failed!", clientId);
        return null;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        return authenticate(authentication.getName(), authentication.getCredentials().toString());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
