import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisica extends Pessoa {
	public String cpf;
	public LocalDate dataNascimento;

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

	public static PessoaFisica CadastrarPessoa() {
		PessoaFisica pessoa = new PessoaFisica();

		pessoa.nome = Input.InputUsuario("Informe o nome: ");
		pessoa.cpf = Input.InputUsuario("Informe o cpf: ");
		pessoa.rendimento = Input.InputUsuarioFloat("Informe o valor rendimento, separando os centavos por ponto (.): ");
		if (pessoa.rendimento == null)
			return null;
		pessoa.dataNascimento = Input.InputUsuarioLocalDate("Informe a data de nascimento: (dd/mm/aaaa): ");
		if (pessoa.dataNascimento == null)
			return null;
		Period idade = Period.between(pessoa.dataNascimento, LocalDate.now());
		if (idade.getYears() >= 18)
			System.out.printf("Idade Válida (%d anos)\n", idade.getYears());
		else {
			System.out.printf("Idade Invalida (%d anos)\n", idade.getYears());
			return null;
		}
		return pessoa;
	}

	public static void SalvarPessoa(PessoaFisica pessoa, Endereco endereco, ArrayList<PessoaFisica> listaPessoasFisicas) {
		pessoa.endereco = endereco;
		listaPessoasFisicas.add(pessoa);
		System.out.println("Cadastro realizado!");
	}

	public static void ListarPessoas(List<PessoaFisica> listaPessoas) {
		for (PessoaFisica pessoa : listaPessoas) {
			System.out.println("Nome: " + pessoa.nome
					+ "\nCPF: " + pessoa.cpf
					+ "\nData de Nascimento: "
					+ pessoa.dataNascimento.format(DateTimeFormatter.ofPattern(
					"dd/MM/yyyy"))
					+ "\nEndereço: " + pessoa.endereco.logradouro + " - nº" + pessoa.endereco.numero);
			System.out.println("Aperte ENTER para continuar");
			Main.leitor.nextLine();
		}
	}
}