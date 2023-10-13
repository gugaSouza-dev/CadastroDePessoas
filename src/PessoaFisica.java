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
		Endereco endereco = new Endereco();
		String endCom;

		pessoa.nome = Utils.InputUsuario("Informe o nome: ", leitor);
		pessoa.cpf = Utils.InputUsuario("Informe o cpf: ", leitor);
		pessoa.rendimento = Utils.InputUsuarioFloat("Informe o valor rendimento, separando os centavos por ponto (.): ", leitor);
		if (pessoa.rendimento == null)
			return;
		pessoa.dataNascimento = Utils.InputUsuarioLocalDate("Informe a data de nascimento: (dd/mm/aaaa): ", leitor);
		if (pessoa.dataNascimento == null)
			return;
		Period idade = Period.between(pessoa.dataNascimento, LocalDate.now());
		if (idade.getYears() >= 18)
			System.out.printf("Idade Válida (%d anos)\n", idade.getYears());
		else {
			System.out.printf("Idade Invalida (%d anos)\n", idade.getYears());
			return;
		}
		endereco.logradouro = Utils.InputUsuario("Informe o logradouro:", leitor);
		endereco.numero = Utils.InputUsuario("Informe o numero:", leitor);
		endCom = Utils.InputUsuario("Este endereço é comercial? S/N:", leitor);
		endereco.comercial = endCom.equalsIgnoreCase("S");
		pessoa.endereco = endereco;
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