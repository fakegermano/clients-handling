

import java.io.*;

public class LeitorClientes {
	private String arquivo;
	private BufferedReader fonteDados;

	public LeitorClientes(String arquivo) {
		this.arquivo = arquivo;
	}

	public void abreArquivo() throws FileNotFoundException {
		File arq = new File(arquivo);
		if (!arq.isFile()) {
			throw new FileNotFoundException();
		}
		this.fonteDados = new BufferedReader(new InputStreamReader(
				new FileInputStream(arq)));
	}

	public void fechaArquivo() {
		try {
			this.fonteDados.close();
		} catch (IOException e) {
			return;
		}
	}

	public Cliente proximoCliente() throws IOException {
		Cliente novo = new Cliente();
		boolean flag = false;
		String fonteDados = this.fonteDados.readLine();
		String vetorDados[] = fonteDados.split(";");
		String msg = "";
		if (ValidaEntrada.validaNome(vetorDados[0])) {
			novo.setNome(vetorDados[0]);
		} else {
			flag = true;
			msg += "N";
		}
		if (ValidaEntrada.validaSobrenome(vetorDados[1])) {
			novo.setSobrenome(vetorDados[1]);
		} else {
			flag = true;
			msg += "S";
		}
		if (ValidaEntrada.validaEndereco(vetorDados[2])) {
			novo.setEndereco(vetorDados[2]);
		} else {
			flag = true;
			msg += "E";
		}
		if (ValidaEntrada.validaCidade(vetorDados[3])) {
			novo.setCidade(vetorDados[3]);
		} else {
			flag = true;
			msg += "C";
		}
		if (ValidaEntrada.validaEstado(vetorDados[4])) {
			novo.setEstado(vetorDados[4]);
		} else {
			flag = true;
			msg += "X";
		}
		if (ValidaEntrada.validaCEP(vetorDados[5])) {
			novo.setCep(vetorDados[5]);
		} else {
			flag = true;
			msg += "Y";
		}
		if (ValidaEntrada.validaTelefone(vetorDados[6])) {
			novo.setTelefone(vetorDados[6]);
		} else {
			flag = true;
			msg += "T";
		}
		if (flag == true) {
			throw new IOException("Cliente invalido - " + msg);
		}
		return novo;
	}

	public boolean haMaisClientes() {
		boolean a = false;
		try {
			a = this.fonteDados.ready();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

}
