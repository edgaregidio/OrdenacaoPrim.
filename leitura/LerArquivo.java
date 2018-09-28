package br.leitura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {

	private static String arq1 = "C:/Users/Jefferson/Workspace - FASAM/Dicionário/English(American)1.txt";
	private static String arq2 = "C:/Users/Jefferson/Workspace - FASAM/Dicionário/Portuguese(Brazilian)2.txt";
	private static String arq3 = "C:/Users/Jefferson/Workspace - FASAM/Dicionário/Spanish3.txt";
	private static BufferedReader lerArq;

	public static String[] lerArq(int numArq) {
		String[] vetorVolta = new String[tamanhoVetor(numArq)];
		String arquivo;
		int contador = 0;
		if (numArq == 1) {
			arquivo = arq1;
		} else if (numArq == 2) {
			arquivo = arq2;
		} else {
			arquivo = arq3;
		}

		try {
			FileReader arq = new FileReader(arquivo);
			lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();
			linha = lerArq.readLine();
			while (linha != null) {

				vetorVolta[contador] = linha;
				linha = lerArq.readLine();
				contador++;

			}
		} catch (IOException e) {

		}

		return vetorVolta;
	}

	public static int tamanhoVetor(int numArq) {

		String arquivo;
		int tamanho = 0;
		if (numArq == 1) {
			arquivo = arq1;
		} else if (numArq == 2) {
			arquivo = arq2;
		} else {
			arquivo = arq3;
		}

		try {
			FileReader arq = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);

			tamanho = Integer.parseInt(lerArq.readLine());
			arq.close();
		} catch (IOException e) {

		}
		return tamanho;
	}

}
