import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utils {
	public static String InputUsuario(String mensagem, Scanner leitor)
	{
		String input;

		System.out.print(mensagem);
		input = leitor.nextLine();
		return input;
	}

	public static Float InputUsuarioFloat(String mensagem, Scanner leitor)
	{
		float valor;
		String input;

		System.out.print(mensagem);
		input = leitor.nextLine();
		try {
			valor = Float.parseFloat(input);
		}
		catch(Exception e) {
			System.out.println("Valor informado precisa ser um valor numérico.");
			return null;
		}
		return valor;
	}

	public static LocalDate InputUsuarioLocalDate(String mensagem, Scanner leitor)
	{
		LocalDate data;

		System.out.println(mensagem);
		try {
			data = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} catch (Exception e) {
			System.out.println("A data informada precisa ser válida e estar no seguinte formato: (dd/mm/aaaa).");
			leitor.nextLine();
			return null;
		}
		leitor.nextLine();
		return data;
	}
}
