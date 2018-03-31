package org.monium.api.user.repository.specification;

import org.monium.api.core.model.ModelEntity;
import org.monium.api.core.repository.Specification;
import org.monium.api.user.model.User;

public abstract class UserSpecification implements Specification<User> {

    @Override
    public Class<User> getType() {
        return User.class;
    }
}
