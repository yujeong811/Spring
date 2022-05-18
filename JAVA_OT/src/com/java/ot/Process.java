package com.java.ot;

public class Process {
	public String process(String input) {
		String str = "";

		if (input != null) {

			try {
				Integer.parseInt(input);
				str += "숫자:";
			} catch (Exception e) {
				str += "문자:";
			}

		}
		
		str += input;

		return str;
	}
}
