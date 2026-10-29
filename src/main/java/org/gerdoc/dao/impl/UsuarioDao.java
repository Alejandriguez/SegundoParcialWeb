package org.gerdoc.dao.impl;

import org.gerdoc.model.Alumno;

import java.util.List;

public interface UsuarioDao
{
    List<Usuario> findAll( );
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
    Usuario update(Usuario usuario);

}
