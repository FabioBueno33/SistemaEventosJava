package service;

import model.Evento;
import java.io.*;
import java.util.List;

public class FileService {

    private static final String FILE_NAME = "events.data";

    public static void salvarEventos(List<Evento> eventos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Evento e : eventos) {
                writer.write(e.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
