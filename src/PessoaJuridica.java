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

        System.out.println("Digite o nome:");
        pessoa.nome = leitor.nextLine();

        System.out.println("Digite a razão social:");
        pessoa.razaoSocial = leitor.nextLine();

        System.out.println("Digite o CNPJ:");
        pessoa.cnpj = leitor.nextLine();

        System.out.println("Digite o rendimento:");
        pessoa.rendimento = leitor.nextFloat();

        System.out.println("Digite a data de inauguração:");
        pessoa.dataInauguracao = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Digite o logradouro:");
        leitor.nextLine();
        endereco.logradouro = leitor.nextLine();

        System.out.println("Digite o numero:");
        endereco.numero = leitor.nextLine();

        System.out.println("Este endereço é comercial? S/N:");
        String endCom = leitor.nextLine();

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
