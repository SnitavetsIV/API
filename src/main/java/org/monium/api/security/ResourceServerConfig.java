package org.monium.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  @Override
  public void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        .antMatchers("/**")
        .permitAll()

        // GUEST
        .antMatchers(HttpMethod.POST, "/api/users/**")
        .hasRole("ANONYMOUS")
        .antMatchers("/oauth/**")
        .hasRole("ANONYMOUS")
        .antMatchers(
            HttpMethod.GET,
            "/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**")
        .permitAll();
  }
}
