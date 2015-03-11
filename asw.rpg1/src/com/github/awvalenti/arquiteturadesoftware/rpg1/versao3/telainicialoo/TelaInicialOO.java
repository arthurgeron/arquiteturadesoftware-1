package com.github.awvalenti.arquiteturadesoftware.rpg1.versao3.telainicialoo;

import java.awt.Frame;
import java.awt.GridLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.github.awvalenti.arquiteturadesoftware.rpg1.versao1.procedimental.Main;

public class TelaInicialOO {

	public TelaInicialOO(Elemento[][] disposicaoInicial) throws IOException {

		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int numeroLinhas = disposicaoInicial.length;
		int numeroColunas = disposicaoInicial[0].length;

		frame.setLayout(new GridLayout(numeroLinhas, numeroColunas));

		for (int i = 0; i < numeroLinhas; i++) {
			for (int j = 0; j < numeroColunas; j++) {
				frame.add(new JLabel(new ImageIcon(ImageIO.read(TelaInicialOO.class.getResourceAsStream(
						disposicaoInicial[i][j].getCaminhoImagem())))));
			}
		}

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		alterarElemento(1,1, Elemento.PERSONAGEM, frame);
	}

	public void alterarElemento(int linha, int coluna, Elemento novoElemento, JFrame frame) throws IOException {
		((JLabel) frame.getContentPane().getComponent(linha * frame.getContentPane().WIDTH + coluna)).setIcon(new ImageIcon(ImageIO.read(Main.class.getResourceAsStream(novoElemento.getCaminhoImagem()))));
	}

}
