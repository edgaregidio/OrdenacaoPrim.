package br.busca;

public class BuscaBinaria {

	public static long tempoBuscaMili;
	public static long tempoBuscaNano;

	/*public static String buscaPalavra(String[] vetor, String palavraBuscar) {
		String retorno = "";
		String[] vetorAlfabeto = vetor.clone();
		Arrays.sort(vetorAlfabeto);
		long comecoMili = System.currentTimeMillis();
		long comecoNano = System.nanoTime();
		int r = Arrays.binarySearch(vetorAlfabeto, palavraBuscar);
		setTempoBuscaMili(System.currentTimeMillis() - comecoMili);
		setTempoBuscaNano(System.nanoTime() - comecoNano);

		if (r >= 0) {
			retorno = "Palavra Encontrada!!\n\nPalavra: " + vetorAlfabeto[r]
					+ "\nPosição no Dicionário Ordenado Por Alfabeto: " + r + "\nTempo" + " de Busca em Milissegundos: "
					+ getTempoBuscaMili() + "\nTempo de Busca em Nanosegundos: " + getTempoBuscaNano();

		} else {
			retorno = "Palavra Não Encontrada!!\n\n Verifique a Digitação da Palavra e Tente Novamente!!";
		}
		return retorno;
	}
*/
	public static String buscaPalavra(String[] vetor, String palavraBuscar, int comeco, int fim) {
		long comecoMili = System.currentTimeMillis();
		long comecoNano = System.nanoTime();
		
		int meio;
		int comparar;

		try{
		if (comeco > fim) {
			return "Palavra Não Encontrada!!\n\n Verifique a Digitação da Palavra e Tente Novamente!!";
		}
		meio = (comeco + fim) / 2;
		comparar = palavraBuscar.compareTo(vetor[meio]);
		if (comparar == 0) {
			setTempoBuscaMili(System.currentTimeMillis() - comecoMili);
			setTempoBuscaNano(System.nanoTime() - comecoNano);
			return "Palavra Encontrada!!\n\nPalavra: " + vetor[meio]
					+ "\nPosição no Dicionário Ordenado Por Alfabeto: " + (meio+1) + "\nTempo" + " de Busca em Milissegundos: "
					+ getTempoBuscaMili() + "\nTempo de Busca em Nanosegundos: " + getTempoBuscaNano();
		}
		else if(comparar<0){
			return buscaPalavra(vetor,palavraBuscar,comeco,meio-1);
		}
		else{
			return buscaPalavra(vetor,palavraBuscar,meio+1,fim);
		}
		}
		catch(Exception e){
			return "Palavra Não Encontrada!!\n\n Verifique a Digitação da Palavra e Tente Novamente!!";
		}

		
	}

	public static long getTempoBuscaMili() {
		return tempoBuscaMili;
	}

	private static void setTempoBuscaMili(long tempoBuscaMili) {
		BuscaBinaria.tempoBuscaMili = tempoBuscaMili;
	}

	public static long getTempoBuscaNano() {
		return tempoBuscaNano;
	}

	private static void setTempoBuscaNano(long tempoBuscaNano) {
		BuscaBinaria.tempoBuscaNano = tempoBuscaNano;
	}

}
