


public class ValidaEntrada {
	static String regex = "";
	/* Valida Nome */
	public static boolean validaNome(String nome) {
		regex = "[A-Z]{1}[a-z]*";
		return nome.matches(regex);
	}

	/* Valida Sobrenome. */
	public static boolean validaSobrenome(String sobrenome) {
		regex = "[a-zA-Z]+([ |-]?[a-zA-Z]+)*";
		return sobrenome.matches(regex);
	}

	/* Valida Endereco. */
	public static boolean validaEndereco(String endereco) {
		regex = "[\\d]+[ ]+[a-zA-Z]+([ ]?[a-zA-Z]+)*";
		return endereco.matches(regex);
	}

	/* Valida Cidade. */
	public static boolean validaCidade(String cidade) {
		regex = "[a-zA-Z]+([ ]?[a-zA-Z]+)*";
		return cidade.matches(regex);

	}

	/* Valida Estado. */
	public static boolean validaEstado(String estado) {
		regex = "[a-zA-Z]+([ ]?[a-zA-Z]+)*";
		return estado.matches(regex);
	}

	/* Valida CEP. */
	public static boolean validaCEP(String cep) {
		regex = "[\\d]{5}[-]{1}[\\d]{3}";
		return cep.matches(regex);
	}

	/* Valida Telefone. */
	public static boolean validaTelefone(String telefone) {
		regex = "[\\d&&[^0]]{1}[\\d]{1}[ ][\\d&&[^0]]{1}[\\d]{3}[-][\\d]{4}";
		return telefone.matches(regex);
	}
}
