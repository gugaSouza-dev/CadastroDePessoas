import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PessoaFisica extends Pessoa {
	public String cpf;
	public LocalDate dataNascimento;

	public List<PessoaFisica> listaPessoasFisicas;


	@Override
	public float CalcularImposto(float rendimento) {
		if (rendimento <= 1500)
			return (0);
		else if (rendimento <= 3500)
			return rendimento * 0.02f;
		else if (rendimento <= 6000)
			return rendimento * 0.035f;
		else
			return rendimento * 0.05f;
	}

	public static void CadastrarPessoa(Scanner leitor, PessoaFisica pessoa) {
		Endereco novoEndereco = new Endereco();
		String enderecoComercial;

		System.out.print("Digite o nome: ");
		pessoa.nome = leitor.nextLine();

		System.out.print("Digite o cpf: ");
		pessoa.cpf = leitor.nextLine();

		System.out.print("Digite o rendimento: ");
		pessoa.rendimento = leitor.nextFloat();

		System.out.print("Digite a data de nascimento: (dd/mm/aaaa: ");
		pessoa.dataNascimento = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		Period idade = Period.between(pessoa.dataNascimento, LocalDate.now());
		if (idade.getYears() >= 18)
			System.out.println("Idade Válida");
		else {
			System.out.println("Idade Invalida");
			return;
		}

		System.out.println("Digite o logradouro: ");
		leitor.nextLine();
		novoEndereco.logradouro = leitor.nextLine();

		System.out.println("Digite o número: ");
		novoEndereco.numero = leitor.nextLine();

		System.out.println("Este endereço é comercial? S/N: ");

		enderecoComercial = leitor.nextLine();
		novoEndereco.comercial = enderecoComercial.equalsIgnoreCase("S");

		pessoa.endereco = novoEndereco;
		pessoa.listaPessoasFisicas.add(pessoa);
		System.out.println("Cadastro realizado!");
	}

	public static void ListarPessoas(Scanner leitor, List<PessoaFisica> listaPessoas) {
			for (PessoaFisica pessoa : listaPessoas) {
				System.out.println("Nome: " + pessoa.nome
						+ "\nCPF: " + pessoa.cpf
						+ "\nData de Nascimento: "
						+ pessoa.dataNascimento.format(DateTimeFormatter.ofPattern(
								"dd/MM/yyyy"))
						+ "\nEndereço: " + pessoa.endereco.logradouro + " - nº" + pessoa.endereco.numero);
				System.out.println("Aperte ENTER para continuar");
				leitor.nextLine();
			}

	}
}