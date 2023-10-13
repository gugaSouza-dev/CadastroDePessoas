import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PessoaJuridica extends Pessoa{
    public String razaoSocial;
    public String cnpj;
    public LocalDate dataInauguracao;
    public List<PessoaJuridica> listaPessoasJuridicas;

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

    public void CadastrarPessoa(Scanner leitor, PessoaJuridica pessoa)
    {
        Endereco endereco = new Endereco();
        String endCom;

		pessoa.nome = Utils.InputUsuario("Informe o nome:", leitor);
		pessoa.razaoSocial = Utils.InputUsuario("Informe a razão social:", leitor);
		pessoa.cnpj = Utils.InputUsuario("Informe o CNPJ:", leitor);
		pessoa.rendimento = Utils.InputUsuarioFloat("Informe o rendimento, separando os centavos por ponto (.): ", leitor);
        if (pessoa.rendimento == null)
            return;
        pessoa.dataInauguracao = Utils.InputUsuarioLocalDate("Informe a data de inauguração: (dd/mm/aaaa): ", leitor);
        if (pessoa.dataInauguracao == null)
            return;
        endereco.logradouro = Utils.InputUsuario("Informe o logradouro:", leitor);
        endereco.numero = Utils.InputUsuario("Informe o numero:", leitor);
        endCom = Utils.InputUsuario("Este endereço é comercial? S/N:", leitor);
        endereco.comercial = endCom.equalsIgnoreCase("S");
        pessoa.endereco = endereco;
        pessoa.listaPessoasJuridicas.add(pessoa);
        System.out.println("Cadastro realizado com sucesso!");
    }


    public void ListarPessoas(Scanner leitor, List<PessoaJuridica> listaPessoas) {
        for (PessoaJuridica pessoas : listaPessoas) {
            System.out.println("Nome: " + pessoas.nome
                    + "\nRazão Social: " + pessoas.razaoSocial
                    + "\nCNPJ: " + pessoas.cnpj
                    + "\nData de Inauguração: " +
                    pessoas.dataInauguracao.format(DateTimeFormatter.ofPattern(
                            "dd/MM/yyyy"))
                    + "\nEndereço: " + pessoas.endereco.logradouro + " - nº" + pessoas.endereco.numero);
            System.out.println("Aperte ENTER para continuar");
            leitor.nextLine();
        }
    }
}
