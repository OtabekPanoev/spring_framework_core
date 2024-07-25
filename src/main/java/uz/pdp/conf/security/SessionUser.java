package uz.pdp.conf.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.pdp.model.AuthUser;

import java.util.Optional;

public interface SessionUser {
    static Optional<AuthUser> getSessionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object principal = authentication.getPrincipal();
        if (!(principal instanceof AuthUser user))
            return Optional.empty();

        return Optional.of(user);
    }
}
