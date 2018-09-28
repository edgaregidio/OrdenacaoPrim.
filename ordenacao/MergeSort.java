package br.ordenacao;

public class MergeSort {
	
	private static long tempoMili;
	private static long tempoNano;
	
	// 	GET E SET
	
	private static void setTempoMili(long tempoMili) {
		MergeSort.tempoMili = tempoMili;
	}
	
	private static void setTempoNano(long tempoNano) {
		MergeSort.tempoNano = tempoNano;
	}
	
	public static long getTempoMili() {
		return tempoMili;
	}
	
	public static long getTempoNano() {
		return tempoNano;
	}

	// MÉTODOS MERGE
	
	public static String[] mergeSort(String[] desordenado, int comeco, int fim) {

		long comecoMili = System.currentTimeMillis();
		long comecoNano = System.nanoTime();

		if (comeco < fim) {
			int meio = (comeco + fim) / 2;
			mergeSort(desordenado, comeco, meio);
			mergeSort(desordenado, meio + 1, fim);
			merge(desordenado, comeco, meio, fim);
		}

		setTempoMili(System.currentTimeMillis() - comecoMili);
		setTempoNano(System.nanoTime() - comecoNano);
		return desordenado;
	}

	private static void merge(String[] desordenado, int comeco, int meio, int fim) {
		String[] aux = new String[desordenado.length];
		for (int i = comeco; i <= fim; i++) {
			aux[i] = desordenado[i];
		}

		int auxEsquerda = comeco;
		int auxDireita = meio + 1;
		int atual = comeco;

		while (auxEsquerda <= meio && auxDireita <= fim) {
			if (aux[auxEsquerda].length() <= aux[auxDireita].length()) {
				desordenado[atual] = aux[auxEsquerda];
				auxEsquerda++;

			} else {
				desordenado[atual] = aux[auxDireita];
				auxDireita++;
			}
			atual++;
		}

		int restante = meio - auxEsquerda;
		for (int i = 0; i <= restante; i++) {
			desordenado[atual + i] = aux[auxEsquerda + i];
		}
	}


}
