package org.monium.api.user.repository;

import org.monium.api.core.repository.EntityRepository;
import org.monium.api.user.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends EntityRepository<User> {}
