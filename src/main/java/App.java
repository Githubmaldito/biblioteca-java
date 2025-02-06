//não sei porque, mas quando a classe usuário estava dentro do pacote "biblioteca", o código não funcionava
//por isso renomeei o pacote para "bibliotec"

import java.util.Scanner;

import DAO.UserDB;
import bibliotec.Alexandria;
import bibliotec.Livro;
import bibliotec.Sabios;
import bibliotec.Usuario;

public class App {
    public static void main(String[] args) {
        // cria um objeto da classe Alexandria
        Alexandria biblioteca = new Alexandria();
        Sabios historico = new Sabios(biblioteca);
        // cria um objeto da classe Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        // variável que armazena a opção escolhida pelo usuário
        int opcao;// laço de repetição que exibe o menu enquanto o usuário não escolher a opção de
        // sair
        do {
            // exibe o menu com escolhas de opções
            System.out.println("\n1. Cadastrar livro");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Listar livros");
            System.out.println("4. Listar usuários");
            System.out.println("5. Emprestar livro");
            System.out.println("6. Histório de empréstimos do usuário");
            System.out.println("7. Devolver livro");
            System.out.println("8. Sair\n");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            // switch case que verifica a opção escolhida pelo usuário
            switch (opcao) {
                // caso a opção seja 1 - cadastrar livro
                case 1:
                    System.out.print("Digite o título do livro: ");
                    // o usuario digita o título do livro
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    // e o autor
                    String autor = scanner.nextLine();
                    // cria um objeto do tipo livro com o título e autor digitados
                    biblioteca.cadastrarLivro(new Livro(titulo, autor, false));
                    // executa a função cadastrar livro da classe Alexandria
                    // finaliza o case
                    break;

                case 2:
                    System.out.println("Digite o nome do usuário: ");
                    // receber o nome do usuario
                    String nome = scanner.nextLine();

                    System.out.println("Digite a matrícula do usuário: ");
                    // receber a matrícula do usuário
                    String matricula = scanner.nextLine();

                    System.out.println("Digite o e-mail do usuário: ");
                    String email = scanner.nextLine();

                    historico.cadastrarUsuario(new Usuario(nome, email, matricula));

                    new UserDB().cadastrarUsuario(new Usuario(nome, email, matricula));
                    
                    break;

                // caso a opção seja 3 - listar livros
                case 3:
                    // executa a função listar livros da classe Alexandria
                    biblioteca.listarLivros();
                    // finaliza o case
                    break;

                case 4:
                        // caso a opção seja 4 - listar usuários
                        historico.listarUsuarios();
                        // executa a função listar usuários da classe Sabios
                        // finaliza o case
                        break;

                case 5:
                    // caso a opção seja 5 - emprestar livro
                    System.out.print("Digite o título do livro para emprestar: \n");
                    // o usuário digita o título do livro
                    String tituloEmprestimo = scanner.nextLine();
                    System.out.print("Digite a matrícula do usuário para emprestar o livro: \n");
                    // o usuário digita a matrícula do usuário
                    String tituloUsuario = scanner.nextLine();
                    //a função emprestar livro da classe Alexandria é executada
                    historico.emprestarLivro(tituloEmprestimo, tituloUsuario);
                    // finaliza o case
                    break;

                case 6:
                        // caso a opção seja 6 - histórico de empréstimos do usuário
                        System.out.print("Digite a matrícula do usuário para ver o histórico de empréstimos: \n");
                        // o usuário digita a matrícula do usuário
                        String matriculaHistorico = scanner.nextLine();
                        // a função histórico de empréstimos do usuário da classe Sabios é executada

                        historico.historicoEmprestimos(matriculaHistorico);
                        // e o histórico de empréstimos do usuário é exibido
                        
                        // finaliza o case
                        break;
                case 7:
                    // caso a opção seja 7 - devolver livro
                    System.out.print("Digite o título do livro para devolver: \n");
                    // o usuário digita o título do livro
                    String tituloDevolucao = scanner.nextLine();
                    // a função devolver livro da classe Sabios é executada
                    historico.devolverLivro(tituloDevolucao);
                    // finaliza o case
                    break;
                case 8:
                    // caso o usuário escolha a opção 8 - sair
                    System.out.println("Saindo...");
                    // é exibida uma mensagem de saída e o programa é finalizado
                    break;
                default:
                    // caso o usuário escolha uma opção diferente das anteriores
                    System.out.println("Opção inválida!");
            }
            // o menu será exibido enquanto o usuário não escolher a opção de sair
        } while (opcao != 8);
        // fecha o scanner
        scanner.close();
    }
}
