package br.ordenacao;

public class BubbleSort {
	
	private static long tempoMili;
	private static long tempoNano;

	// GET E SET
	
	private static void setTempoMili(long tempoMili) {
		BubbleSort.tempoMili = tempoMili;
	}
	
	private static void setTempoNano(long tempoNano) {
		BubbleSort.tempoNano = tempoNano;
	}
	
	public static long getTempoMili() {
		return tempoMili;
	}
	
	public static long getTempoNano() {
		return tempoNano;
	}
	
	// MÉTODO BUBBLE
	
	public static String[] bubbleSort(String[] desordenado) {

		long comecoMili = System.currentTimeMillis();
		long comecoNano = System.nanoTime();

		for (int i = desordenado.length; i >= 1; i--) {

			for (int j = 1; j < i; j++) {
				if (desordenado[j - 1].length() > desordenado[j].length()) {
					String aux = desordenado[j];
					desordenado[j] = desordenado[j - 1];
					desordenado[j - 1] = aux;
				}
			}
		}

		setTempoMili(System.currentTimeMillis() - comecoMili);
		setTempoNano(System.nanoTime() - comecoNano);

		return desordenado;

	}


}
