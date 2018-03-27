package org.monium.api.core.repository;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractSpecification<T> implements Specification<T> {

  @Override
  public Class<T> getType() {
    ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
    return (Class<T>) type.getActualTypeArguments()[0];
  }
}
