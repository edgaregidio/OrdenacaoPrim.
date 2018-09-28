package br.busca;

public class BuscaSequencial {
	
	public static long tempoBuscaMili;
	public static long tempoBuscaNano;

	// GET E SET
	
	public static long getTempoBuscaMili() {
		return tempoBuscaMili;
	}
	
	private static void setTempoBuscaMili(long tempoBuscaMili) {
		BuscaSequencial.tempoBuscaMili = tempoBuscaMili;
	}
	
	public static long getTempoBuscaNano() {
		return tempoBuscaNano;
	}
	
	private static void setTempoBuscaNano(long tempoBuscaNano) {
		BuscaSequencial.tempoBuscaNano = tempoBuscaNano;
	}

	// M�TODO BUSCAR
	
	public static String buscaPalavra(String[] vetor, String palavraBuscar) {
		
		long comecoMili = System.currentTimeMillis();
		long comecoNano = System.nanoTime();
		String resposta = "Not";

		for (int i = 0; i < vetor.length; i++) {

			if (vetor[i].equalsIgnoreCase(palavraBuscar)) {

				setTempoBuscaMili(System.currentTimeMillis() - comecoMili);
				setTempoBuscaNano(System.nanoTime() - comecoNano);
				resposta = "Palavra Encontrada!!\n\nPalavra: " + vetor[i] + "\nPosi��o no Dicion�rio: " + (i + 1)
						+ "\nTempo" + " de Busca em Milissegundos: " + getTempoBuscaMili()
						+ "\nTempo de Busca em Nanosegundos: " + getTempoBuscaNano();
				break;
			}

		}
		if (resposta.equalsIgnoreCase("Not")) {
			resposta = "Palavra N�o Encontrada!!\n\n Verifique a Digita��o da Palavra e Tente Novamente!!";
		}
		return resposta;
	}


}
