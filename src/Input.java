import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Input {
	public static String InputUsuario(String mensagem) {
		String input;

		System.out.print(mensagem);
		input = Main.leitor.nextLine();
		return input;
	}

	public static Float InputUsuarioFloat(String mensagem) {
		float valor;
		String input;

		System.out.print(mensagem);
		input = Main.leitor.nextLine();
		try {
			valor = Float.parseFloat(input);
		} catch (Exception e) {
			System.out.println("ERROR:\nValor informado precisa ser numérico.");
			return null;
		}
		return valor;
	}

	public static LocalDate InputUsuarioLocalDate(String mensagem) {
		LocalDate data;

		System.out.println(mensagem);
		try {
			data = LocalDate.parse(Main.leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} catch (Exception e) {
			System.out.println("ERROR:\nA data informada precisa ser válida e estar no seguinte formato: (dd/mm/aaaa).");
			Main.leitor.nextLine();
			return null;
		}
		Main.leitor.nextLine();
		return data;
	}
}
