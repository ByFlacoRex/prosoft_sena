package com.Prosoft.Prosoft.dao;

import com.Prosoft.Prosoft.models.Aspirante;

import java.util.List;

public interface AspiranteDao {

    List<Aspirante> getAspirantes();


    Aspirante eliminar(Long id);

    void registrar(Aspirante aspirante);
}
