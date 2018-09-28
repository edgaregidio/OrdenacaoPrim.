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

	// MÉTODO BUSCAR
	
	public static String buscaPalavra(String[] vetor, String palavraBuscar) {
		
		long comecoMili = System.currentTimeMillis();
		long comecoNano = System.nanoTime();
		String resposta = "Not";

		for (int i = 0; i < vetor.length; i++) {

			if (vetor[i].equalsIgnoreCase(palavraBuscar)) {

				setTempoBuscaMili(System.currentTimeMillis() - comecoMili);
				setTempoBuscaNano(System.nanoTime() - comecoNano);
				resposta = "Palavra Encontrada!!\n\nPalavra: " + vetor[i] + "\nPosição no Dicionário: " + (i + 1)
						+ "\nTempo" + " de Busca em Milissegundos: " + getTempoBuscaMili()
						+ "\nTempo de Busca em Nanosegundos: " + getTempoBuscaNano();
				break;
			}

		}
		if (resposta.equalsIgnoreCase("Not")) {
			resposta = "Palavra Não Encontrada!!\n\n Verifique a Digitação da Palavra e Tente Novamente!!";
		}
		return resposta;
	}


}
