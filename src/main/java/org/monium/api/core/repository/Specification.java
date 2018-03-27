package org.monium.api.core.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface Specification<T> {
  boolean isSatisfiedBy(T t);

  Predicate toPredicate(Root<T> root, CriteriaBuilder cb);

  Class<T> getType();
}
