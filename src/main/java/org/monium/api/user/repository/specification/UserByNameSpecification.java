package org.monium.api.user.repository.specification;

import org.monium.api.user.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Objects;

public class UserByNameSpecification extends UserSpecification {

  private final String username;

  public UserByNameSpecification(String username) {
    this.username = username;
  }

  @Override
  public boolean isSatisfiedBy(User user) {
    return Objects.equals(username, user.getUsername());
  }

  @Override
  public Predicate toPredicate(Root<User> root, CriteriaBuilder cb) {
    return cb.equal(root.get(User.Fields.username), username);
  }
}
