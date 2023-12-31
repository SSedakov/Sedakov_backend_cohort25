package de.ait.bootapp.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

        httpSecurity
                .authorizeRequests()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/events/register/**").permitAll() //
                .antMatchers("/api/**").authenticated();

        httpSecurity
                .exceptionHandling()
                .defaultAuthenticationEntryPointFor(((request, response, authException) -> {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    response.getWriter().write("{ \"message\": \"User unauthorized\"}");
                }), new AntPathRequestMatcher("/api/**"));

        httpSecurity
                .formLogin();
        return httpSecurity.build();
    }

}
