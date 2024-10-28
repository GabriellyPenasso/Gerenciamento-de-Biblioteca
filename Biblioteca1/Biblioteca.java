import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getTitulo());
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("Lista de Livros:");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário registrado: " + usuario.getNome());
    }

    public void emprestarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                if (livro.isDisponivel()) {
                    livro.setDisponivel(false);
                    System.out.println("Livro emprestado com sucesso: " + titulo);
                    return;
                } else {
                    System.out.println("Livro indisponível para empréstimo.");
                    return;
                }
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void devolverLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                if (!livro.isDisponivel()) {
                    livro.setDisponivel(true);
                    System.out.println("Livro devolvido com sucesso: " + titulo);
                    return;
                } else {
                    System.out.println("O livro já estava disponível.");
                    return;
                }
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Gerenciamento de Biblioteca ---");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Registrar Usuário");
            System.out.println("4. Emprestar Livro");
            System.out.println("5. Devolver Livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    biblioteca.adicionarLivro(new Livro(titulo, autor));
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a matrícula do usuário: ");
                    String matricula = scanner.nextLine();
                    biblioteca.registrarUsuario(new Usuario(nome, matricula));
                    break;
                case 4:
                    System.out.print("Digite o título do livro para empréstimo: ");
                    String tituloEmprestimo = scanner.nextLine();
                    biblioteca.emprestarLivro(tituloEmprestimo);
                    break;
                case 5:
                    System.out.print("Digite o título do livro para devolução: ");
                    String tituloDevolucao = scanner.nextLine();
                    biblioteca.devolverLivro(tituloDevolucao);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            
        } while (opcao != 0);

        scanner.close();
    }
}

