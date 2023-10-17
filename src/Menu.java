import java.util.ArrayList;

public class Menu extends Pessoa {
	public static void MenuPrincipal(ArrayList<PessoaFisica> listaPessoasFisicas, ArrayList<PessoaJuridica> listaPessoasJuridicas) {
		String opcao;

		System.out.println("Bem vindo ao sistema do cadastro de Pessoas Físicas e Jurídicas");
		do {
			System.out.println("Escolha uma opção: \n1 - Pessoa Física \n2 - Pessoa Juridica \n3 - Listar todas as pessoas cadastradas\n0 - Sair");
			opcao = Main.leitor.nextLine();
			switch (opcao) {
				case "1":
					Menu.menuPessoaFisica(listaPessoasFisicas);
					break;
				case "2":
					Menu.menuPessoaJuridica(listaPessoasJuridicas);
					break;
				case "3":
					Pessoa.ListarTodasPessoas(listaPessoasFisicas, listaPessoasJuridicas);
					break;
				default:
					break;
			}
		} while (!opcao.equals("0"));
	}

	public static void menuPessoaFisica(ArrayList<PessoaFisica> listaPessoasFisicas) {
		String opcao;
		PessoaFisica pessoa = new PessoaFisica();

		do {
			System.out.println("Escolha uma opção: \n1 - Cadastrar Pessoa Física \n2 - Pessoa Listar Pessoas Físicas \n0 - Voltar");
			opcao = Main.leitor.nextLine();

			switch (opcao) {
				case "1":
					PessoaFisica.CadastrarPessoa(pessoa, listaPessoasFisicas);
					break;
				case "2":
					PessoaFisica.ListarPessoas(listaPessoasFisicas);
					break;
				default:
					break;
			}
		} while (!opcao.equals("0"));
	}

	public static void menuPessoaJuridica(ArrayList<PessoaJuridica> listaPessoasJuridicas) {
		PessoaJuridica pessoa = new PessoaJuridica();
		String opcao;

		do {
			System.out.println("Escolha uma opção: \n1 - Cadastrar Pessoa Jurídica \n2 - Pessoa Listar Pessoas Jurídicas \n0 - Voltar");
			opcao = Main.leitor.nextLine();
			switch (opcao) {
				case "1":
					PessoaJuridica.CadastrarPessoa(pessoa, listaPessoasJuridicas);
					break;
				case "2":
					PessoaJuridica.ListarPessoas(listaPessoasJuridicas);
					break;
				default:
					break;
			}
		} while (!opcao.equals("0"));
	}
}

