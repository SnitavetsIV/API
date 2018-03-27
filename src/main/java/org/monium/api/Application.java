package org.monium.api;

import org.monium.api.security.CustomUserDetails;
import org.monium.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Autowired
  public void authenticationManager(AuthenticationManagerBuilder builder, UserService userService)
      throws Exception {
    builder.userDetailsService(userDetailsService(userService));
  }

  private UserDetailsService userDetailsService(UserService userService) {
    return username -> new CustomUserDetails(userService.findUserByName(username));
  }
}
