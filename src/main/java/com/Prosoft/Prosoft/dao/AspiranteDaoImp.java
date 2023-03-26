package com.Prosoft.Prosoft.dao;

import com.Prosoft.Prosoft.models.Aspirante;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AspiranteDaoImp implements AspiranteDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Aspirante> getAspirantes() {
        String query = "FROM Aspirante";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public Aspirante eliminar(Long id) {
        Aspirante aspirante = entityManager.find(Aspirante.class, id);
        entityManager.remove(aspirante);
        return aspirante;
    }

    @Override
    public void registrar(Aspirante aspirante) {
        entityManager.merge(aspirante);
    }
}
