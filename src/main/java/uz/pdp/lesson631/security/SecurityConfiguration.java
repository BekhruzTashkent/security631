package uz.pdp.lesson631.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration   //this class gonna be bean
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication() // to save all created persons in spring
                .withUser("super-admin").password(passwordEncoder().encode("super-admin")).roles("SUPER-ADMIN")
                .and()
                .withUser("moderator").password(passwordEncoder().encode("moderator")).roles("MODERATOR")
                .and()
                .withUser("operator").password(passwordEncoder().encode("operator")).roles("OPERATOR");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    //make all requests authenticated with http basic
                .csrf().disable()//now we can post in postman
                .authorizeRequests()//in antMatches first we should put those who have more names like USER, DIRECTOR, MANAGER
                // .antMatchers(HttpMethod.GET, "api/product/*").hasAnyRole("USER", "DIRECTOR", "MANAGER") //** means any, * means only that we defined
                // .antMatchers(HttpMethod.GET, "api/product/**").hasAnyRole("DIRECTOR", "MANAGER")//all path with GET api/prod... can do manager
                // .antMatchers("api/product/**").hasRole("DIRECTOR") //all path with api/prod... can do director
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    PasswordEncoder passwordEncoder(){  //we should encode our passwords
        return new BCryptPasswordEncoder();

    }



}
