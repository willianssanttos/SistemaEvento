package org.example.repository;

import org.example.model.Usuario;
import org.example.util.RepositoryUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioRepository<ObjectMapper> {
	
	private static final String USUARIOS_JSON = "./usuarios.json";
    private List<Usuario> usuarioList;
    
    private RepositoryUtil utilidades;

    private ObjectMapper mapeador;
    
    public UsuarioRepository() {
        utilidades = new RepositoryUtil();
        mapeador = new ObjectMapper();
        usuarioList = new ArrayList<>();

        try {
            byte[] dados = utilidades.lerArquivo(USUARIOS_JSON);
            usuarioList = mapeador.readValue(dados, new TypeReference<>() {
            });
        } catch (IOException e) {
        	usuarioList = new ArrayList<>();
        }
        
      
        public Usuario consultarUsuarioPorNome(String usuarioNome) {
            for (Usuario dados : usuarioList) {
                if (dados.getNome().equals(usuarioNome)) {
                    return dados;
                }
            }
            
            return null;
        }

        
        public boolean atualizarBaseDados() {
            try {
                String saida = mapeador.writerWithDefaultPrettyPrinter().writeValueAsString(usuarioList);
                utilidades.persistirArquivo(USUARIOS_JSON, saida);
            } catch (IOException e) {
                e.printStackTrace();
                return true;
            }
            return false;
        }
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        try {
            usuarioList.add(usuario);
            String saida = mapeador.writerWithDefaultPrettyPrinter().writeValueAsString(usuarioList);
            utilidades.persistirArquivo(USUARIOS_JSON, saida);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return usuario;
    }
}