import java.util.Scanner;

import biblioteca.Alexandria;
import biblioteca.Livro;

public class App {
    public static void main(String[] args) {
//cria um objeto da classe Alexandria
        Alexandria biblioteca = new Alexandria();
//cria um objeto da classe Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
//variável que armazena a opção escolhida pelo usuário
        int opcao;//laço de repetição que exibe o menu enquanto o usuário não escolher a opção de sair
        do {
//exibe o menu com escolhas de opções
            System.out.println("\n1. Cadastrar livro");
            System.out.println("2. Listar livros");
            System.out.println("3. Emprestar livro");
            System.out.println("4. Devolver livro");
            System.out.println("5. Sair\n");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
//switch case que verifica a opção escolhida pelo usuário
            switch (opcao) {
//caso a opção seja 1 - cadastrar livro
                case 1:
                    System.out.print("Digite o título do livro: ");
//o usuario digita o título do livro
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
//e o autor
                    String autor = scanner.nextLine();
//cria um objeto do tipo livro com o título e autor digitados
                    biblioteca.cadastrarLivro(new Livro(titulo, autor));
//executa a função cadastrar livro da classe Alexandria
//finaliza o case
                    break;

//caso a opção seja 2 - listar livros
                case 2:
//executa a função listar livros da classe Alexandria
                    biblioteca.listarLivros();
//finaliza o case
                    break;
                case 3:
//caso a opção seja 3 - emprestar livro
                    System.out.print("Digite o título do livro para emprestar: \n");
//o usuário digita o título do livro
                    String tituloEmprestimo = scanner.nextLine();
//a função emprestar livro da classe Alexandria é executada
                    biblioteca.emprestarLivro(tituloEmprestimo);
//finaliza o case
                    break;

                case 4:
//caso a opção seja 4 - devolver livro
                    System.out.print("Digite o título do livro para devolver: \n");
//o usuário digita o título do livro
                    String tituloDevolucao = scanner.nextLine();
//a função devolver livro da classe Alexandria é executada
                    biblioteca.devolverLivro(new Livro(tituloDevolucao, ""));
//finaliza o case
                    break;
                case 5:
//caso o usuário escolha a opção 5 - sair
                    System.out.println("Saindo...");
//é exibida uma mensagem de saída e o programa é finalizado
                    break;
                default:
//caso o usuário escolha uma opção diferente das anteriores
                    System.out.println("Opção inválida!");
            }
//o menu será exibido enquanto o usuário não escolher a opção de sair
        } while (opcao != 5);
//fecha o scanner
        scanner.close();
    }
}