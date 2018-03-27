package org.monium.api.core.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EntityRepository<T> {

    @PersistenceContext
    protected EntityManager em;

    public List<T> findAllBySpecification(Specification<T> specification) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        // use specification.getType() to create a Root<T> instance
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(specification.getType());
        Root<T> root = criteriaQuery.from(specification.getType());
        // get predicate from specification
        Predicate predicate = specification.toPredicate(root, criteriaBuilder);
        // set predicate and execute query
        criteriaQuery.where(predicate);
        return em.createQuery(criteriaQuery).getResultList();
    }

}
