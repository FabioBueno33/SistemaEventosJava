import model.*;
import service.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EventoService eventoService = new EventoService();

        System.out.println("=== Cadastro de Usuário ===");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();

        Usuario usuario = new Usuario(nome, email, cidade);

        while (true) {
            System.out.println("\n1 - Cadastrar evento");
            System.out.println("2 - Listar eventos");
            System.out.println("3 - Meus eventos");
            System.out.println("0 - Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Nome do evento: ");
                String nomeEvento = sc.nextLine();

                System.out.print("Endereço: ");
                String endereco = sc.nextLine();

                System.out.print("Descrição: ");
                String descricao = sc.nextLine();

                System.out.print("Categoria (FESTA, ESPORTIVO, SHOW, CULTURAL, OUTROS): ");
                String categoriaStr = sc.nextLine();
                Categoria categoria = Categoria.valueOf(categoriaStr.toUpperCase());

                System.out.print("Data e hora (yyyy-MM-dd HH:mm): ");
                String data = sc.nextLine();
                LocalDateTime horario = LocalDateTime.parse(
                        data, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                Evento evento = new Evento(
                        nomeEvento, endereco, categoria, horario, descricao);

                eventoService.adicionarEvento(evento);
                System.out.println("Evento cadastrado!");
            }

            else if (opcao == 2) {
                for (Evento e : eventoService.listarEventosOrdenados()) {
                    System.out.println(e);
                }
            }

            else if (opcao == 3) {
                for (Evento e : usuario.getEventosConfirmados()) {
                    System.out.println(e);
                }
            }

            else if (opcao == 0) {
                break;
            }
        }
    }
}
