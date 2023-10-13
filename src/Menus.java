	import java.util.ArrayList;
	import java.util.Scanner;

	public class Menus extends Pessoa{

		public static void menuPessoaFisica(Scanner leitor) {
			String opcao;
			PessoaFisica pessoa = new PessoaFisica();
			pessoa.listaPessoasFisicas = new ArrayList<>();

			do {
				System.out.println("Escolha uma opção: \n 1 - Cadastrar Pessoa Física \n 2 - Pessoa Listar Pessoas Físicas \n 0 - Sair");
				opcao = leitor.nextLine();

				switch (opcao) {
					case "1":
						PessoaFisica.CadastrarPessoa(leitor, pessoa);
						break;
					case "2":
						if (pessoa.listaPessoasFisicas.isEmpty())
							System.out.println("Lista vazia");
						else
							PessoaFisica.ListarPessoas(leitor, pessoa.listaPessoasFisicas);
						break;
					default:
						break;
				}
			} while (!opcao.equals("0"));
		}

		public static void menuPessoaJuridica(Scanner leitor) {
			String opcao;
			PessoaJuridica pessoa = new PessoaJuridica();
			pessoa.listaPessoasJuridicas = new ArrayList<>();

			do {
				System.out.println("Escolha uma opção: \n 1 - Cadastrar Pessoa Jurídica \n 2 - Pessoa Listar Pessoas Jurídicas \n 0 - Sair");
				opcao = leitor.nextLine();
				switch (opcao)
				{
					case "1":
						pessoa.CadastrarPessoa(leitor, pessoa);
						break;
					case "2":
						if (pessoa.listaPessoasJuridicas.isEmpty())
							System.out.println("Lista Vazia");
						else
							pessoa.ListarPessoas(leitor, pessoa.listaPessoasJuridicas);
						break;
					default:
						break;
				}
			} while (!opcao.equals("0"));
		}
	}

