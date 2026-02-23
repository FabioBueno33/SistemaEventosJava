package service;

import model.Evento;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EventoService {

    private List<Evento> eventos = new ArrayList<>();

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public List<Evento> listarEventosOrdenados() {
        eventos.sort(Comparator.comparing(Evento::getHorario));
        return eventos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }
}
