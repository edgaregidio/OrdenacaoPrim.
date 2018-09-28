package br.ordenacao;

public class InsertionSort {
	
	private static long tempoMili;
	private static long tempoNano;

	// GET E SET
	
	private static void setTempoMili(long tempoMili) {
		InsertionSort.tempoMili = tempoMili;
	}
	
	private static void setTempoNano(long tempoNano) {
		InsertionSort.tempoNano = tempoNano;
	}
	
	public static long getTempoMili() {
		return tempoMili;
	}
	
	public static long getTempoNano() {
		return tempoNano;
	}
	
	// MÉTODO INSERT

	public static String[] insertionSort(String[] desordenado) {

		long comecoMili = System.currentTimeMillis();
		long comecoNano = System.nanoTime();

		for (int i = 0; i < desordenado.length; i++) {
			String a = desordenado[i];
			for (int j = i - 1; j >= 0 && desordenado[j].length() > a.length(); j--) {
				desordenado[j + 1] = desordenado[j];
				desordenado[j] = a;
			}
		}

		setTempoMili(System.currentTimeMillis() - comecoMili);
		setTempoNano(System.nanoTime() - comecoNano);

		return desordenado;
	}


}
