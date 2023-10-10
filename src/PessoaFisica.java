import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisica extends Pessoa {
    public String cpf;
    public LocalDate dataNascimento;

    public List<PessoaFisica> listaPessoasFisicas;


    @Override
    public float CalcularImposto(float rendimento) {
        if (rendimento <= 1500)
            return (0);
        else if (rendimento <= 3500)
            return (rendimento *= 0.02f);
        else if (rendimento <= 6000)
            return (rendimento *= 0.035f);
        else
            return (rendimento *= 0.05f);
    }
}
