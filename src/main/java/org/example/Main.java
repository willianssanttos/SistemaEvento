package org.example;

import org.example.model.Evento;
import org.example.model.Usuario;
import org.example.service.EventoService;
import org.example.service.UsuarioService;
import org.example.util.Constantes;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String ARQUIVO_EVENTOS = "events.data";

    private List<Usuario> usuarios;
    private List<Evento> eventos;

    public Main() {
        this.usuarios = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void consultarEventos() {
        System.out.println("Eventos cadastrados:");
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }

    public void participarEvento(Usuario usuario, Evento evento) {
        // Implemente a lógica para confirmar a participação do usuário no evento
    }

    public void visualizarEventosConfirmados(Usuario usuario) {
        // Implemente a lógica para visualizar os eventos confirmados pelo usuário
    }

    public void cancelarParticipacao(Usuario usuario, Evento evento) {
        // Implemente a lógica para cancelar a participação do usuário no evento
    }

    public void ordenarEventosProximos() {
        // Implemente a lógica para ordenar os eventos por proximidade de horário
    }

    public void informarEventosPassados() {
        // Implemente a lógica para informar os eventos que já ocorreram
    }

    public void salvarEventosEmArquivo() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ARQUIVO_EVENTOS))) {
            outputStream.writeObject(eventos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarEventosDoArquivo() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ARQUIVO_EVENTOS))) {
            eventos = (List<Evento>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	UsuarioService usuarioService = new UsuarioService();
    	EventoService eventoService = new EventoService();
        Main sistema = new Main();
        sistema.carregarEventosDoArquivo();
        
        boolean eventoRodando = true;

        Constantes.aberturaEvento();

        while (eventoRodando) {
            System.out.println(Constantes.menu);
            String menu = scanner.nextLine();

            if (!menu.isBlank()) {
                int menuNum = Integer.parseInt(menu);

                switch (menuNum) {

                    case 1:

			        // Exemplo de cadastro de usuário
			        Usuario usuario = new Usuario();
			
			
			        System.out.println(Constantes.cadastroUsuarioNome);
			        usuario.setNome(scanner.nextLine());
			        
			        System.out.println(Constantes.cadastroUsuarioEndereço);
			        usuario.setEndereco(scanner.nextLine());
			        
			        System.out.println(Constantes.cadastroUsuarioCidade);
			        usuario.setCidade(scanner.nextLine());
			        
			        if (usuarioService.usuario)
			        
			        System.out.println("Usuário cadastrado com sucesso");
			        break;
                }

        // Exemplo de cadastro de evento
        Evento evento = new Evento();
        
        
        sistema.cadastrarEvento(evento);

        // Exemplo de consulta de eventos
        sistema.consultarEventos();

        // Exemplo de participação em evento
        sistema.participarEvento(usuario, evento);

        // Exemplo de visualização de eventos confirmados
        sistema.visualizarEventosConfirmados(usuario);

        // Exemplo de cancelamento de participação
        sistema.cancelarParticipacao(usuario, evento);

        // Exemplo de ordenação de eventos próximos
        sistema.ordenarEventosProximos();

        // Exemplo de informação de eventos passados
        sistema.informarEventosPassados();

        // Salvar eventos em arquivo
        sistema.salvarEventosEmArquivo();

        scanner.close();
    }
}
