package service;

import model.Evento;
import model.Categoria;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EventoService {

    private List<Evento> eventos = new ArrayList<>();
    private final String ARQUIVO = "events.data";

    public EventoService() {
        carregarEventos();
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
        salvarEventos();
    }

    public List<Evento> listarEventosOrdenados() {
        eventos.sort(Comparator.comparing(Evento::getHorario));
        return eventos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    private void salvarEventos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Evento e : eventos) {
                writer.write(
                        e.getNome() + ";" +
                        e.getEndereco() + ";" +
                        e.getCategoria() + ";" +
                        e.getHorario() + ";" +
                        e.getDescricao()
                );
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar eventos.");
        }
    }

    private void carregarEventos() {
        File file = new File(ARQUIVO);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");

                String nome = partes[0];
                String endereco = partes[1];
                Categoria categoria = Categoria.valueOf(partes[2]);
                LocalDateTime horario = LocalDateTime.parse(partes[3]);
                String descricao = partes[4];

                Evento evento = new Evento(nome, endereco, categoria, horario, descricao);
                eventos.add(evento);
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar eventos.");
        }
    }
}
