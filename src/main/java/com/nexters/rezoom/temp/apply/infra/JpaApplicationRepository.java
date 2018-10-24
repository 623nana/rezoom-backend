package com.nexters.rezoom.temp.apply.infra;

import com.nexters.rezoom.temp.apply.domain.Application;
import com.nexters.rezoom.temp.apply.repository.ApplicationRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class JpaApplicationRepository implements ApplicationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Application application) {
        entityManager.persist(application);
    }

    @Transactional
    @Override
    public Application findById(long applicationId) {
        return entityManager.find(Application.class, applicationId);
    }

}
