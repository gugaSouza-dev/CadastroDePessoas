import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String opcao;

        System.out.println("Bem vindo ao sistema do cadastro de Pessoas Físicas e Jurídicas");
        do {
            System.out.println("Escolha uma opção: \n 1 - Pessoa Física \n 2 - Pessoa Juridica \n 0 - Sair");
            opcao = leitor.nextLine();
            switch (opcao) {
                case "1":
                    Menus.menuPessoaFisica(leitor);
                    break;
                case "2":
                    Menus.menuPessoaJuridica(leitor);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("default");
                    break;
            }
        } while (!opcao.equals("0"));
    }
}