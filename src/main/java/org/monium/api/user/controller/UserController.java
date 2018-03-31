package org.monium.api.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private PasswordEncoder encoder;

  @RequestMapping("/hello")
  public String hi(@RequestParam String pass) {
    return encoder.encode(pass);
  }
}
