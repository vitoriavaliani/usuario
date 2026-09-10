package com.valiani.usuario.business.converter;

import com.valiani.usuario.business.dto.EnderecoDTO;
import com.valiani.usuario.business.dto.TelefoneDTO;
import com.valiani.usuario.business.dto.UsuarioDTO;
import com.valiani.usuario.infrastructure.entity.Endereco;
import com.valiani.usuario.infrastructure.entity.Telefone;
import com.valiani.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario converterParaUsuario(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(converterParaListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(converterParaListaTelefone(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Endereco> converterParaListaEndereco(List<EnderecoDTO> enderecoDTOS){
        return enderecoDTOS.stream().map(this::converterParaEndereco).toList();
    }

    public Endereco converterParaEndereco(EnderecoDTO enderecoDTO){
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public List<Telefone> converterParaListaTelefone(List<TelefoneDTO> telefoneDTOS){
        return telefoneDTOS.stream().map(this::converterParaTelefone).toList();
    }

    public Telefone converterParaTelefone(TelefoneDTO telefoneDTO){
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public UsuarioDTO converterParaUsuarioDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .enderecos(converterParaListaEnderecoDTO(usuario.getEnderecos()))
                .telefones(converterParaListaTelefoneDTO(usuario.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> converterParaListaEnderecoDTO(List<Endereco> endereco){
        return endereco.stream().map(this::converterParaEnderecoDTO).toList();
    }

    public EnderecoDTO converterParaEnderecoDTO(Endereco endereco){
        return EnderecoDTO.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }

    public List<TelefoneDTO> converterParaListaTelefoneDTO(List<Telefone> telefone){
        return telefone.stream().map(this::converterParaTelefoneDTO).toList();
    }

    public TelefoneDTO converterParaTelefoneDTO(Telefone telefone){
        return TelefoneDTO.builder()
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }
}
