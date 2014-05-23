
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ListaCliente lista = new ListaCliente();
		
		HashMap<String, LeitorClientes> listaArquivos = new HashMap<String, LeitorClientes>();

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

			} else if (comando.equals("addFile")) { 
				// adiciona nome de arquivo para posterior abertura
				String nomeArquivo = scanner.nextLine();
				listaArquivos.put(nomeArquivo, new LeitorClientes(nomeArquivo));
			} else  if (comando.equals("openFile")) {
				// abre arquivo - se arquivo não foi adicionado, não faz nada
				String nomeArquivo = scanner.nextLine();
				if (listaArquivos.containsKey(nomeArquivo)) {
					LeitorClientes leitor = listaArquivos.get(nomeArquivo);
					try {
						leitor.abreArquivo();
					} catch (FileNotFoundException e) {
						System.out.println("Arquivo nao existe: "+nomeArquivo);
					}
				}
				
			} else  if (comando.equals("readFile")) {
				// lê todo o arquivo e carrega em lista
				String nomeArquivo = scanner.nextLine();
				if (listaArquivos.containsKey(nomeArquivo)) {
					LeitorClientes leitor = listaArquivos.get(nomeArquivo);
					
					while (leitor.haMaisClientes()) {
						Cliente cliente;
						try {
							cliente = leitor.proximoCliente();
							lista.add(cliente);
							System.out.println("Cliente adicionado: " + cliente.getNome());
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
					}
				}
				
			} else  if (comando.equals("closeFile")) {
				// fecha arquivo
				String nomeArquivo = scanner.nextLine();
				if (listaArquivos.containsKey(nomeArquivo)) {
					LeitorClientes leitor = listaArquivos.get(nomeArquivo);
					leitor.fechaArquivo();
				}
			}

		} while (true);

		scanner.close();

	}
}
