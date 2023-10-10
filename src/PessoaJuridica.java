import java.time.LocalDate;
import java.util.List;

public class PessoaJuridica extends Pessoa{
    public String razaoSocial;
    public String cnpj;
    public LocalDate dataInauguracao;
    public List<PessoaJuridica> listaPessoasJuridicas;

    @Override
    public float CalcularImposto(float rendimento) {
        if (rendimento <= 3000)
            return (rendimento *= 0.03f);
        else if (rendimento <= 6000)
            return (rendimento *= 0.05f);
        else if (rendimento <= 10000)
            return (rendimento *= 0.07f);
        else
            return (rendimento *= 0.09f);
    }
}
