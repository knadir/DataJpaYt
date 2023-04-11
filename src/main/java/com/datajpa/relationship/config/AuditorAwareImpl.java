package com.datajpa.relationship.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.datajpa.relationship.security.services.UserDetailsImpl;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication..." + authentication);
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }
        return Optional.of(authentication.getName());
    }

}
