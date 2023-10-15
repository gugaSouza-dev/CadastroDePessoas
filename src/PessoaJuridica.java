import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridica extends Pessoa {
	public String razaoSocial;
	public String cnpj;
	public LocalDate dataInauguracao;

	@Override
	public float CalcularImposto(float rendimento) {
		if (rendimento <= 3000)
			return rendimento * 0.03f;
		else if (rendimento <= 6000)
			return rendimento * 0.05f;
		else if (rendimento <= 10000)
			return rendimento * 0.07f;
		else
			return rendimento * 0.09f;
	}

	public static PessoaJuridica CadastrarPessoa() {
		PessoaJuridica pessoa = new PessoaJuridica();

		pessoa.nome = Input.InputUsuario("Informe o nome:");
		pessoa.razaoSocial = Input.InputUsuario("Informe a razão social:");
		pessoa.cnpj = Input.InputUsuario("Informe o CNPJ:");
		pessoa.rendimento = Input.InputUsuarioFloat("Informe o rendimento, separando os centavos por ponto (.): ");
		if (pessoa.rendimento == null)
			return null;
		pessoa.dataInauguracao = Input.InputUsuarioLocalDate("Informe a data de inauguração: (dd/mm/aaaa): ");
		if (pessoa.dataInauguracao == null)
			return null;
		return pessoa;
	}

	public static void SalvarPessoa(PessoaJuridica pessoa, Endereco endereco, ArrayList<PessoaJuridica> listaPessoasJuridicas) {
		pessoa.endereco = endereco;
		listaPessoasJuridicas.add(pessoa);
		System.out.println("Cadastro realizado!");
	}

	public static void ListarPessoas(List<PessoaJuridica> listaPessoas) {
		for (PessoaJuridica pessoas : listaPessoas) {
			System.out.println("Nome: " + pessoas.nome
					+ "\nRazão Social: " + pessoas.razaoSocial
					+ "\nCNPJ: " + pessoas.cnpj
					+ "\nData de Inauguração: " +
					pessoas.dataInauguracao.format(DateTimeFormatter.ofPattern(
							"dd/MM/yyyy"))
					+ "\nEndereço: " + pessoas.endereco.logradouro + " - nº" + pessoas.endereco.numero);
			System.out.println("Aperte ENTER para continuar");
			Main.leitor.nextLine();
		}
	}
}
