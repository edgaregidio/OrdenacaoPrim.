package br.ordenacao;

public class QuickSort {
	
	private static long tempoMili;
	private static long tempoNano;

	public static String[] quickSort(String[] desordenado, int esquerda, int direita) {

		long comecoMili = System.currentTimeMillis();
		long comecoNano = System.nanoTime();

		int esq = esquerda;
		int dir = direita;
		String pivo = desordenado[(esq + dir) / 2];
		String troca;
		while (esq <= dir)
		{
			while (desordenado[esq].length() < pivo.length())
			{
				esq = esq + 1;
			}
			while (desordenado[dir].length() > pivo.length())
			{
				dir = dir - 1;
			}
			if (esq <= dir)
			{
				troca = desordenado[esq];
				desordenado[esq] = desordenado[dir];
				desordenado[dir] = troca;
				esq = esq + 1;
				dir = dir - 1;
			}
		}
		if (dir > esquerda)
			quickSort(desordenado, esquerda, dir);
		if (esq < direita)
			quickSort(desordenado, esq, direita);
	

		setTempoMili(System.currentTimeMillis() - comecoMili);
		setTempoNano(System.nanoTime() - comecoNano);

		return desordenado;
	}

	private static void setTempoMili(long tempoMili) {
		QuickSort.tempoMili = tempoMili;
	}

	private static void setTempoNano(long tempoNano) {
		QuickSort.tempoNano = tempoNano;
	}

	public static long getTempoMili() {
		return tempoMili;
	}

	public static long getTempoNano() {
		return tempoNano;
	}


}
