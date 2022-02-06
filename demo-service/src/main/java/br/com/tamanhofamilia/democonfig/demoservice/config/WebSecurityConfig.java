package br.com.tamanhofamilia.democonfig.demoservice.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/swagger-ui.*", "/swagger-ui/*","/v3/api-docs", "/v3/api-docs/*")
                    .anonymous()
                .anyRequest()
                    .authenticated();
    }
}
