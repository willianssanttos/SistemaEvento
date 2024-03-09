package org.example.service;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.example.model.Evento;
import org.example.model.Usuario;
import org.example.repository.EventoRepository;
import org.example.repository.UsuarioRepository;

public class SistemaEventos {
	
	    private List<Evento> eventos;

	    public SistemaEventos() {
	        eventos = new ArrayList<>();
	        carregarEventos();
	    }

	    // Método para cadastrar um evento
	    public void cadastrarEvento(Evento evento) {
	        eventos.add(evento);
	        salvarEventos();
	    }

	    // Método para participar de um evento
	    public void participarEvento(Evento evento, Usuario usuario) {
	        // Implemente a lógica de participação aqui
	    }

	    // Método para cancelar participação em um evento
	    public void cancelarParticipacao(Evento evento, Usuario usuario) {
	        // Implemente a lógica de cancelamento de participação aqui
	    }

	    // Método para ordenar os eventos por horário
	    public void ordenarEventosPorHorario() {
	        Collections.sort(eventos, Comparator.comparing(Evento::getHorario));
	    }

	    // Método para verificar se um evento está ocorrendo no momento
	    public boolean eventoOcorrendoAgora(Evento evento) {
	        Date agora = new Date();
	        return evento.getHorario().after(agora);
	    }

	    // Método para carregar os eventos a partir do arquivo
	    private void carregarEventos() {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("events.data"))) {
	            eventos = (List<Evento>) ois.readObject();
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Erro ao carregar eventos: " + e.getMessage());
	        }
	    }

	    // Método para salvar os eventos no arquivo
	    private void salvarEventos() {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("events.data"))) {
	            oos.writeObject(eventos);
	        } catch (IOException e) {
	            System.out.println("Erro ao salvar eventos: " + e.getMessage());
	        }
	    }

    public static void main(String[] args) {
    	 SistemaEventos sistema = new SistemaEventos();

         // Exemplo de uso do sistema
         Evento evento1 = new Evento("Festa de Aniversário", "Rua A, 123", "Festa", new Date(), "Venha comemorar conosco!");
         sistema.cadastrarEvento(evento1);

         Evento evento2 = new Evento("Show de Rock", "Avenida B, 456", "Show", new Date(), "Apresentação das melhores bandas de rock!");
         sistema.cadastrarEvento(evento2);

         // Ordenar os eventos por horário
         sistema.ordenarEventosPorHorario();

         // Verificar se um evento está ocorrendo agora
         for (Evento evento : sistema.eventos) {
             if (sistema.eventoOcorrendoAgora(evento)) {
                 System.out.println("O evento '" + evento.getNome() + "' está ocorrendo agora!");
             }
         }
     }
 }