package com.Prosoft.Prosoft.controllers;

import com.Prosoft.Prosoft.dao.AspiranteDao;
import com.Prosoft.Prosoft.dao.UsuarioDao;
import com.Prosoft.Prosoft.models.Aspirante;
import com.Prosoft.Prosoft.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AspiranteController {
    @Autowired
    private AspiranteDao aspiranteDao;

    @Autowired
    private JWTUtil jwtUtil;

@RequestMapping(value = "api/aspirantes/{id}", method = RequestMethod.GET)
    public Aspirante getAspitante(@PathVariable Long id ){
        Aspirante aspirante = new Aspirante();
        aspirante.setId(id);
        aspirante.setNombre("Jordy");
        aspirante.setApellido("Muñoz");
        aspirante.setDocumentos("Cedula");
        aspirante.setDocumento("1030697211");
        aspirante.setTelefono("3005610036");
        aspirante.setEmail("jordy@prosoft.com");
        return aspirante;
    }
    //Listar Aspirantes
    @RequestMapping(value = "api/aspirantes", method = RequestMethod.GET)
    public List<Aspirante> getAspitantes(@RequestHeader(value = "Authorization")String token){

        if(!validarToken(token)) {return null;}

        return aspiranteDao.getAspirantes();
    }

    private boolean validarToken(String token){

        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;

    }

    //Agregar aspirante
    @RequestMapping(value = "api/aspirantes", method = RequestMethod.POST)
    public void registrarAspirante(@RequestBody Aspirante aspirante){
        aspiranteDao.registrar(aspirante);
    }

    //Eliminar Aspirantes
    @RequestMapping(value = "api/aspirantes/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value = "Authorization")String token,
                              @PathVariable Long id){
        if(!validarToken(token)) {return;}
        aspiranteDao.eliminar(id);
    }

}
