package org.example.service;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.example.model.Evento;
import org.example.model.Usuario;
import org.example.repository.EventoRepository;
import org.example.repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    public Usuario usuarioNovo (Usuario usuario) {
    	
    	if(usuario.getNome().trim().equals("")) {
    		System.err.println("Não possivel cadastrar com o campo nome vazio!");
    		return null;
    	}
    	
    	if(usuario.getEndereco().trim().equals("")) {
    		System.err.println("Não possivel cadastrar com o campo endereço vazio!");
    		return null;
    	}
    	
    	if(usuario.getCidade().trim().equals("")) {
    		System.err.println("Não possivel cadastrar com o campo cidade vazio!");
    		return null;
    	}
    	return usuarioRepository.cadastrarUsuario(usuario);
    }
}
