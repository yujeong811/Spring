package com.java.ot;

import java.util.Scanner;

public class Main {
	private Input inputIns = new Input();
	private Process processIns = new Process();
	private Output outputIns = new Output();

	public static void main(String[] args) {
		
		Main main =  new Main();
		
		// �Է�
		String input = main.inputIns.input();
		
		// ó��
		String result = main.processIns.process(input);

		// ���
		main.outputIns.output(result);

	}

}
