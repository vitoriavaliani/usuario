package com.valiani.usuario.business;

import com.valiani.usuario.business.converter.UsuarioConverter;
import com.valiani.usuario.business.dto.UsuarioDTO;
import com.valiani.usuario.infrastructure.entity.Usuario;
import com.valiani.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.converterParaUsuario(usuarioDTO);
        return usuarioConverter.converterParaUsuarioDTO(
                usuarioRepository.save(usuario)
        );
    }
}
