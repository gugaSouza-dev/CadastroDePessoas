import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static final Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<PessoaFisica> listaPessoasFisicas = new ArrayList<>();
        ArrayList<PessoaJuridica> listaPessoasJuridicas = new ArrayList<>();

        Menu.MenuPrincipal(listaPessoasFisicas, listaPessoasJuridicas);
    }
}