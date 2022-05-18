package com.java.ot;

import java.util.Scanner;

public class Main {
	private Input inputIns = new Input();
	private Process processIns = new Process();
	private Output outputIns = new Output();

	public static void main(String[] args) {
		
		Main main =  new Main();
		
		// 입력
		String input = main.inputIns.input();
		
		// 처리
		String result = main.processIns.process(input);

		// 출력
		main.outputIns.output(result);

	}

}
