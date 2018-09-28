package br.ordenacao;

public class SelectionSort {
	
	private static long tempoMili;
	private static long tempoNano;

	// GET E SET
	
	private static void setTempoMili(long tempoMili) {
		SelectionSort.tempoMili = tempoMili;
	}
	
	private static void setTempoNano(long tempoNano) {
		SelectionSort.tempoNano = tempoNano;
	}
	
	public static long getTempoMili() {
		return tempoMili;
	}
	
	public static long getTempoNano() {
		return tempoNano;
	}
	
	// MÉTODO SELECTSORT

	public static String[] selectionSort(String[] desordenado) {

		long comecoMili = System.currentTimeMillis();
		long comecoNano = System.nanoTime();

		for (int i = 0; i < desordenado.length - 1; i++) {
			int indice = i;
			for (int j = i + 1; j < desordenado.length; j++)
				if (desordenado[j].length() < desordenado[indice].length())
					indice = j;

			String palavraMenor = desordenado[indice];
			desordenado[indice] = desordenado[i];
			desordenado[i] = palavraMenor;
		}

		setTempoMili(System.currentTimeMillis() - comecoMili);
		setTempoNano(System.nanoTime() - comecoNano);

		return desordenado;
	}


}
