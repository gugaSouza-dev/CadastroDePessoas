import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void menuPessoaFisica()  {
        Scanner leitor = new Scanner(System.in);

        String opcao;
        String enderecoComercial;
        PessoaFisica novaPessoa = new PessoaFisica();
        novaPessoa.listaPessoasFisicas = new ArrayList<PessoaFisica>();
        Endereco novoEndereco = new Endereco();

        do {
            System.out.println("Escolha uma opção: \n 1 - Cadastrar Pessoa Física \n 2 - Pessoa Listar Pessoas Físicas \n 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao) {
                case "1":

                    System.out.print("Digite o nome: ");
                    novaPessoa.nome = leitor.nextLine();

                    System.out.print("Digite o cpf: ");
                    novaPessoa.cpf = leitor.nextLine();

                    System.out.print("Digite o rendimento: ");
                    novaPessoa.rendimento = leitor.nextFloat();

                    System.out.print("Digite a data de nascimento: (dd/mm/aaaa: ");
                    novaPessoa.dataNascimento = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Period idade = Period.between(novaPessoa.dataNascimento, LocalDate.now());
                    if (idade.getYears() >= 18)
                        System.out.println("Idade Válida");
                    else
                    {
                        System.out.println("Idade Invalida");
                        break;
                    }

                    System.out.print("Digite o logradouro: ");
                    novoEndereco.logradouro = leitor.nextLine();

                    System.out.println("Digite o número: ");
                    novoEndereco.numero = leitor.nextLine();

                    System.out.println("Este endereço é comercial? S/N: ");

                    enderecoComercial = leitor.nextLine();
                    if (enderecoComercial.equalsIgnoreCase("S"))
                        novoEndereco.comercial = true;
                    else
                        novoEndereco.comercial = false;

                    novaPessoa.endereco = novoEndereco;
                    novaPessoa.listaPessoasFisicas.add(novaPessoa);
                    System.out.println("Cadastro realizado!");
                    break;

                case "2":
                    System.out.println("case 2");
                    if (novaPessoa.listaPessoasFisicas.size() > 0) {

                        for (PessoaFisica pessoa : novaPessoa.listaPessoasFisicas) {
                            System.out.println("Nome: " + pessoa.nome);
                            System.out.println("CPF: " + pessoa.cpf);
                            System.out.println("Data de Nascimento: " +
                                    pessoa.dataNascimento.format(DateTimeFormatter.ofPattern(
                                            "dd/MM/yyyy")));
                            System.out.println("Endereço: " + pessoa.endereco.logradouro + "-" + pessoa.endereco.numero);
                            System.out.println("Aperte ENTER para continuar");
                            leitor.nextLine();
                        }
                    }
                    else
                        System.out.println("Lista Vazia");
                    break;
                default:
                    break;
            }

        } while (!opcao.equals("0"));

    }

    public static void menuPessoaJuridica()
    {
        Scanner leitor = new Scanner(System.in);

        String opcao;
        PessoaJuridica pessoa = new PessoaJuridica();
        pessoa.listaPessoasJuridicas = new ArrayList<>();

        do {
            System.out.println("Escolha uma opção: \n 1 - Cadastrar Pessoa Jurídica \n 2 - Pessoa Listar Pessoas Jurídicas \n 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao)
            {
                case "1":
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

                    System.out.println("Digite o logradouro");
                    endereco.logradouro = leitor.next();

                    System.out.println("Digite o numero");
                    endereco.numero = leitor.nextLine();

                    System.out.println("Este endereço é comercial? S/N:");
                    String endCom = leitor.next();

                    if (endCom.equalsIgnoreCase("N")){
                        endereco.comercial = false;
                    } else {
                        endereco.comercial = true;
                    }

                    pessoa.endereco = endereco;

                    pessoa.listaPessoasJuridicas.add(pessoa);

                    System.out.println("Cadastro realizado com sucesso!");
                    break;
                case "2":
                    if (pessoa.listaPessoasJuridicas.size() > 0) {

                        for (PessoaJuridica pessoas : pessoa.listaPessoasJuridicas) {
                            System.out.println("Nome: " + pessoas.nome);
                            System.out.println("Razão Social: " + pessoas.razaoSocial);
                            System.out.println("CNPJ: " + pessoas.cnpj);
                            System.out.println("Data de Inauguração: " +
                                    pessoas.dataInauguracao.format(DateTimeFormatter.ofPattern(
                                            "dd/MM/yyyy")));
                            System.out.println("Endereço: " + pessoas.endereco.logradouro + "-" + pessoas.endereco.numero);
                            System.out.println("Aperte ENTER para continuar");
                            leitor.nextLine();
                        }
                    }
                    else
                        System.out.println("Lista Vazia");
                    break;
                case "0":
                    break;
                default:
                    break;
            }
        } while (!opcao.equals("0"));
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String opcao = "";

        System.out.println("Bem vindo ao sistema do cadastro de Pessoas Físicas e Jurídicas");

        do {
            System.out.println("Escolha uma opção: \n 1 - Pessoa Física \n 2 - Pessoa Juridica \n 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao) {
                case "1":
                    menuPessoaFisica();
                    break;
                case "2":
                    menuPessoaJuridica();
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