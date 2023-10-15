import java.util.ArrayList;

public class Pessoa {
	public String nome;
	public Float rendimento;
	public Endereco endereco;

	public float CalcularImposto(float rendimento) {
		return rendimento;
	}

	public static void ListarTodasPessoas(ArrayList<PessoaFisica> listaPessoasFisicas, ArrayList<PessoaJuridica> listaPessoasJuridicas) {
		if (listaPessoasJuridicas.isEmpty())
			System.out.println("Lista de pessoas jurídicas está vazia.");
		else
			PessoaJuridica.ListarPessoas(listaPessoasJuridicas);
		if (listaPessoasFisicas.isEmpty())
			System.out.println("Lista de pessoas físicas está vazia.");
		else
			PessoaFisica.ListarPessoas(listaPessoasFisicas);
	}
}
