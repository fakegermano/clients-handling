package t9.parte2;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ListaCliente {

	private ArrayList<Cliente> lista;

	public ListaCliente() {
		this.lista = new ArrayList<Cliente>();
	}

	public void add(Cliente cliente) {
		lista.add(cliente);
	}

	public ArrayList<Cliente> search(int opt) {
		ArrayList<Cliente> myList = new ArrayList<Cliente>();

		Pattern pattern;
		Matcher matcher;
		for (Cliente cliente : this.lista) {
			switch (opt) {
			case 0:
				pattern = Pattern.compile("\\d{2} [2357]{4}\\-[2357].*");

				matcher = pattern.matcher(cliente.getTelefone());
				if (matcher.lookingAt()) {
					myList.add(cliente);
				}

				break;
			case 1:
				pattern = Pattern.compile(".*([a-z])([a-z])[a-z]\\2\\1.*");

				matcher = pattern.matcher(cliente.getNome().toLowerCase());
				if (matcher.lookingAt()) {
					myList.add(cliente);
				}

				break;
			case 2:
				pattern = Pattern.compile(".*([^aeiou][aeiou]){3}.*");

				matcher = pattern.matcher(cliente.getSobrenome().toLowerCase());
				if (matcher.lookingAt()) {
					myList.add(cliente);
				}

				break;
			case 3:
				pattern = Pattern.compile("\\A[\\S]+\\s[\\S]+\\s[\\S]+\\Z");

				matcher = pattern.matcher(cliente.getCidade());
				if (matcher.lookingAt()) {
					myList.add(cliente);
				}

				break;
			case 4:
				pattern = Pattern.compile(".*\\-.*");

				matcher = pattern.matcher(cliente.getSobrenome());
				if (matcher.lookingAt()) {
					myList.add(cliente);
				}

				break;
			case 5:
				pattern = Pattern.compile("([a-zA-Z])[^$]*\\$\\1.*");

				matcher = pattern.matcher(cliente.getCidade().concat("$")
						.concat(cliente.getEstado()));
				if (matcher.lookingAt()) {
					myList.add(cliente);
				}

				break;
			case 6:
				String regex1 = "(\\d)(\\d) ((?=.*\\1).*(?=.*\\2).*)";
				String regex2 = "(\\d)\\1 .*(?=\\1.*(?=\\1)).*";
				char array[] = cliente.getTelefone().toCharArray();
				if (array[0] == array[1]) {
					pattern = Pattern.compile(regex2);
				} else {
					pattern = Pattern.compile(regex1);
				}
				matcher = pattern.matcher(cliente.getTelefone().substring(0, 9));
				if (matcher.lookingAt()) {
					myList.add(cliente);
				}

				break;
			case 7:
				pattern = Pattern.compile("[^$]*([aeiouAEIOU])[^$]*([aeiouAEIOU])[^$]*"
						+ "\\$((?=.*\\1(?=.*\\2))|(?=.*\\2(?=.*\\1))).*");
				matcher = pattern.matcher(cliente.getNome().concat("$")
						.concat(cliente.getSobrenome()));
				if (matcher.lookingAt()) {
					myList.add(cliente);
				}
				break;
			}
		}
		return myList;
	}
}
