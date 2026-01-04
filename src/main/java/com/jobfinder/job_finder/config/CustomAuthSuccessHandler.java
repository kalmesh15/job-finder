package com.jobfinder.job_finder.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException {

        for (GrantedAuthority authority : authentication.getAuthorities()) {

            String role = authority.getAuthority();

            if ("ROLE_JOB_SEEKER".equals(role)) {
                response.sendRedirect("/jobseeker/dashboard");
                return;
            }

            if ("ROLE_EMPLOYER".equals(role)) {
                response.sendRedirect("/employer/dashboard");
                return;
            }
        }

        response.sendRedirect("/login");
    }
}
