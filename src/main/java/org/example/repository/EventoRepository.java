package org.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.example.model.Evento;

public class EventoRepository {
    private List<Evento> eventos;

    public EventoRepository() {
        this.eventos = new ArrayList<>();
        carregarEventos();
    }

	private void carregarEventos() {
		// TODO Auto-generated method stub
		
	}

    // Métodos para interação com eventos
}