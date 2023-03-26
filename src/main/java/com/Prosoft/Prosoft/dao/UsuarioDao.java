package com.Prosoft.Prosoft.dao;

import com.Prosoft.Prosoft.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    void eliminar(Long id);

    List<Usuario> getUsuarios();

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
