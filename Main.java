package t9.parte2;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ListaCliente lista = new ListaCliente();

		Scanner scanner = new Scanner(System.in);
		String comando;

		do {
			comando = scanner.nextLine();

			if (comando.equals("add")) {

				/* Recebe entradas. */
				System.out.println("Primeiro nome:");
				String nome = scanner.nextLine();
				System.out.println("Sobrenome:");
				String sobrenome = scanner.nextLine();
				System.out.println("Endereco:");
				String endereco = scanner.nextLine();
				System.out.println("Cidade:");
				String cidade = scanner.nextLine();
				System.out.println("Estado:");
				String estado = scanner.nextLine();
				System.out.println("CEP:");
				String cep = scanner.nextLine();
				System.out.println("Telefone:");
				String telefone = scanner.nextLine();

				/* Valida entrada. */
				if (ValidaEntrada.validaNome(nome)
						&& ValidaEntrada.validaSobrenome(sobrenome)
						&& ValidaEntrada.validaEndereco(endereco)
						&& ValidaEntrada.validaCidade(cidade)
						&& ValidaEntrada.validaEstado(estado)
						&& ValidaEntrada.validaCEP(cep)
						&& ValidaEntrada.validaTelefone(telefone)) {

					/* Salva cliente na lista. */
					Cliente cliente = new Cliente();
					cliente.setNome(nome);
					cliente.setSobrenome(sobrenome);
					cliente.setEndereco(endereco);
					cliente.setCidade(cidade);
					cliente.setEstado(estado);
					cliente.setCep(cep);
					cliente.setTelefone(telefone);

					lista.add(cliente);
					System.out.println("Adicionado!");

				} else {
					System.out.println("Dados invalidos!");
				}

			} else if (comando.equals("search")) {

				ArrayList<Cliente> mySearch = lista.search(scanner.nextInt());
				System.out.println();

				if (mySearch.isEmpty()) {
					System.out.println("Nao ha clientes a serem exibidos.");
				} else {
					for (Cliente cliente : mySearch) {
						System.out.println(cliente.toString());
					}
				}

			} else if (comando.equals("exit")) {

				break;

			}

		} while (true);

		scanner.close();

	}
}
