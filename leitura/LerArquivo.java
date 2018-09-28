package br.leitura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LerArquivo {
	
	private static String[] vetorVolta;
	private static BufferedReader br;
	

	public static String[] lerArq() {
		
		try {

			JFileChooser fc = new JFileChooser("");
			fc.setDialogTitle("Escolha Um  Dicionario Na Pasta Do Projeto");
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivo de Texto.txt", "txt");
			fc.setFileFilter(filtro);
			fc.showOpenDialog(fc);
			File arq = fc.getSelectedFile();
			File file = new File(arq.getPath());
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
			int tamanho = Integer.parseInt(br.readLine());
			vetorVolta = new String[tamanho];

			for (int i = 0; i < vetorVolta.length; i++) { 
                vetorVolta[i] = br.readLine(); 
            }
			}
		catch (IOException e) {
			
		}

		return vetorVolta;
	}

}
