package uz.pdp.conf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfiguration {

    public final String[] WHITE_LIST = {
            "/book",
            "/home/me",
            "/auth/login",
            "/auth/register",
    };

    private final CustomUserDetailsService userDetailsService;
    private final CustomAuthenticationHandler customAuthenticationHandler;

    @Autowired
    public SecurityConfiguration(CustomUserDetailsService userDetailsService, CustomAuthenticationHandler customAuthenticationHandler) {
        this.userDetailsService = userDetailsService;
        this.customAuthenticationHandler = customAuthenticationHandler;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .requestMatchers(WHITE_LIST)
                .permitAll() // open Urls
//                .requestMatchers("/home/admin").hasRole("ADMIN")
//                .requestMatchers("/home/user").hasRole("USER")
                .anyRequest()
                .authenticated();

        http.formLogin()
                .loginPage("/auth/login")
                .usernameParameter("uname")
                .passwordParameter("pwd")
//                .loginProcessingUrl("/auth/login") //
                .failureHandler(customAuthenticationHandler)
                .defaultSuccessUrl("/home", true);

        http.userDetailsService(userDetailsService);
        http.logout()
                .logoutUrl("/auth/logout")
                .deleteCookies("JSESSIONID")
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", HttpMethod.POST.name()))
                .logoutSuccessUrl("/auth/login");

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User.withDefaultPasswordEncoder()
//                .username("ketmon")
//                .password("123")
//                .roles("USER")
//                .build();
//        UserDetails user2 = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("123")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

}
