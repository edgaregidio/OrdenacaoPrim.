package br.busca;

public class BuscaBinaria {
	
	public static long tempoBuscaMili;
	public static long tempoBuscaNano;
	
	// 	GET E SET
	
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
	
	// MÉTODO BINÁRIO
	
	public static String buscaPalavra(String[] vetor, String palavraBuscar, int comeco, int fim) {
		long comecoMili = System.currentTimeMillis();
		long comecoNano = System.nanoTime();
		
		int meio;
		int comparar;

		try{
			
			if (comeco > fim) {
			
				return "PALAVRA NÃO ENCONTRADA!!\\n\\n Verifique a digitação da palavra e tente novamente!!";
			}
			
			meio = (comeco + fim) / 2;
			comparar = palavraBuscar.compareTo(vetor[meio]);
			
			if (comparar == 0) {
				setTempoBuscaMili(System.currentTimeMillis() - comecoMili);
				setTempoBuscaNano(System.nanoTime() - comecoNano);
				return "PALAVRA ENCONTRADA!!\n\nPalavra: " + vetor[meio]
						+ "\nPosição no dicionário ordenado por alfabeto: " + (meio+1) + "\nTempo" + " de busca em Milissegundos: "
						+ getTempoBuscaMili() + "\nTempo de busca em nanosegundos: " + getTempoBuscaNano();
			}
			else if(comparar<0){
				return buscaPalavra(vetor,palavraBuscar,comeco,meio-1);
			}
			else{
				return buscaPalavra(vetor,palavraBuscar,meio+1,fim);
			}
		}
		catch(Exception e){
			return "PALAVRA NÃO ENCONTRADA!!\n\n Verifique a digitação da palavra e tente novamente!!";
		}

		
	}


}
