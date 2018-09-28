package br.principal;

import java.util.Arrays;

import javax.swing.JOptionPane;

import br.busca.BuscaBinaria;
import br.busca.BuscaSequencial;
import br.leitura.LerArquivo;
import br.ordenacao.BubbleSort;
import br.ordenacao.InsertionSort;
import br.ordenacao.MergeSort;
import br.ordenacao.QuickSort;
import br.ordenacao.SelectionSort;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean sair = false;
		Object[] ordenacao = { "1", "2", "3","4","5"};
		Object[] opcoes = {"1","2","3","4"};
		Object[] busca = {"1","2"};
		
		String[] vetor = LerArquivo.lerArq();
		for(int i = 0; i < vetor.length; i++){
			System.out.println(vetor[i]);
		}
		JOptionPane.showMessageDialog(null, "Dicionário Carregado e Pronto Para Uso!!","Dicionário Pronto!",1);

		do {
			
			int opcao = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Escolha Uma Opção:\n\n1 - Ordenar Dicionário\n2 - Voltar Dicionário Ao Original"
					+ "\n3 - Buscar Palavra\n4 - Sair\n\n", "Opções", 1, null, opcoes, null));
			
			switch(opcao){
			case 1:
				int opcaoOrdenamento = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Escolha Uma Ordenação A Seguir:\n\n1 - BubbleSort\n2 - Insertion Sort\n"
						+ "3 - Selection Sort\n4 - Merge Sort\n5 - Quick Sort\n\n","Escolha a Ordenação",1,null,ordenacao,null));
				JOptionPane.showMessageDialog(null,"Aguarde!!\n\nIsso Pode Demorar Alguns Minutos!","Aguarde",1);
				switch(opcaoOrdenamento){
				case 1:
					vetor = BubbleSort.bubbleSort(vetor);
					JOptionPane.showMessageDialog(null,"Dicionário Ordenado Com Bubble Sort!!\n\nTempo De Ordenação Em Milissegundos: "+BubbleSort.getTempoMili()+"\n"
							+ "Tempo De Ordenação Em Nanosegundos: "+BubbleSort.getTempoNano(),"Dicionário Ordenado/Bubble Sort",1);
					break;
				case 2:
					vetor = InsertionSort.insertionSort(vetor);
					JOptionPane.showMessageDialog(null,"Dicionário Ordenado Com Insertion Sort!!\n\nTempo De Ordenação Em Milissegundos: "+InsertionSort.getTempoMili()+"\n"
							+ "Tempo De Ordenação Em Nanosegundos: "+InsertionSort.getTempoNano(),"Dicionário Ordenado/Insertion Sort",1);
					break;
				case 3:
					vetor = SelectionSort.selectionSort(vetor);
					JOptionPane.showMessageDialog(null,"Dicionário Ordenado Com Selection Sort!!\n\nTempo De Ordenação Em Milissegundos: "+SelectionSort.getTempoMili()+"\n"
							+ "Tempo De Ordenação Em Nanosegundos: "+SelectionSort.getTempoNano(),"Dicionário Ordenado/Selection Sort",1);
					break;
				case 4:
					vetor = MergeSort.mergeSort(vetor, 0, vetor.length-1);
					JOptionPane.showMessageDialog(null,"Dicionário Ordenado Com Merge Sort!!\n\nTempo De Ordenação Em Milissegundos: "+MergeSort.getTempoMili()+"\n"
							+ "Tempo De Ordenação Em Nanosegundos: "+MergeSort.getTempoNano(),"Dicionário Ordenado/Merge Sort",1);
					break;
				case 5:
					vetor = QuickSort.quickSort(vetor, 0, vetor.length-1);
					JOptionPane.showMessageDialog(null,"Dicionário Ordenado Com Quick Sort!!\n\nTempo De Ordenação Em Milissegundos: "+QuickSort.getTempoMili()+"\n"
							+ "Tempo De Ordenação Em Nanosegundos: "+QuickSort.getTempoNano(),"Dicionário Ordenado/Quick Sort",1);
					break;	
				}
				for(int i = 0; i < vetor.length; i++){
					System.out.println(vetor[i]);
				}
				
				break;
			case 2:
				Arrays.sort(vetor);
				for(int i = 0; i < vetor.length; i++){
					System.out.println(vetor[i]);
				}
				JOptionPane.showMessageDialog(null,"Dicionário Original Inserido");

				break;
			case 3:
				Arrays.sort(vetor);
				String buscaFeita="";
				int buscar = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Escolha o Tipo De Busca:\n\n1 - Sequencial\n2 - "
						+ "Binária\n\n","Tipos De Busca",1,null,busca,null ));
				buscaFeita = JOptionPane.showInputDialog(null,"Informe a Palavra Que Deseja Buscar:\n\nPalavra:","Buscar Palavras",1);

				if(buscar==1){
					JOptionPane.showMessageDialog(null,""+BuscaSequencial.buscaPalavra(vetor, buscaFeita),"Busca Sequencial",1);
				}
				else{
					JOptionPane.showMessageDialog(null,""+BuscaBinaria.buscaPalavra(vetor, buscaFeita,0,vetor.length-1),"Busca Binaria",1);
				}
				
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Saindo!","Saindo",1);
				sair = true;
				break;
			}
				

		} while (!sair);
	}

}
