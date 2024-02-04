package com.example.pressadmin.config;

import jakarta.servlet.DispatcherType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.UUID;

import static java.nio.file.attribute.AclEntryPermission.DELETE;
import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl("/");

        http.authorizeHttpRequests((authorizeRequests) -> authorizeRequests //
                        .requestMatchers(new AntPathRequestMatcher("/assets/**"))
                        .permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/actuator/info"))
                        .permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/actuator/health"))
                        .permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/login"))
                        .permitAll()
                        .dispatcherTypeMatchers(DispatcherType.ASYNC)
                        .permitAll() // https://github.com/spring-projects/spring-security/issues/11027
                        .anyRequest()
                        .authenticated())
                .formLogin(
                        (formLogin) -> formLogin
                                .loginPage("/login")
                                .successHandler(successHandler)
                )
                .logout((logout) -> logout.logoutUrl("/logout"))
                .httpBasic(Customizer.withDefaults())
//                .csrf(csrf ->
//                        csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/instances") // Disable CSRF for /instances
//                ))
                .csrf(csrf -> csrf.disable())
        ;

//        http.addFilterAfter(new CustomCsrfFilter(), BasicAuthenticationFilter.class)
//                .csrf((csrf) -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                        .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler())
//                        .ignoringRequestMatchers(
//                                new AntPathRequestMatcher("/instances", POST.toString()),
//        new AntPathRequestMatcher("/instances/*", DELETE.toString()),
//        new AntPathRequestMatcher("/actuator/**")
//                                ))
        ;

        http.rememberMe((rememberMe) -> rememberMe.key(UUID.randomUUID().toString()).tokenValiditySeconds(1209600));

        return http.build();

    }

    // Required to provide UserDetailsService for "remember functionality"
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }
}