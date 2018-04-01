package org.monium.api.user.service;

import org.monium.api.user.model.User;
import org.monium.api.user.repository.UserRepository;
import org.monium.api.user.repository.specification.UserByNameSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired private PasswordEncoder passwordEncoder;

  @Autowired private UserRepository rep;

  public User findUserByName(String username) {
    List<User> users = rep.findAllBySpecification(new UserByNameSpecification(username));
    return users.size() == 1 ? users.get(0) : null;
  }
}
