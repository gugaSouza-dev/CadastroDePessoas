public class Endereco {
    public String logradouro;
    public String numero;
    public boolean comercial;

    public static Endereco CadastrarEndereco() {
        Endereco endereco = new Endereco();
        String enderecoComercial;

        endereco.logradouro = Input.InputUsuario("Informe o logradouro:");
        endereco.numero = Input.InputUsuario("Informe o numero:");
        enderecoComercial = Input.InputUsuario("Este endereço é comercial? S/N:");
        endereco.comercial = enderecoComercial.equalsIgnoreCase("S");
        return endereco;
    }
}
