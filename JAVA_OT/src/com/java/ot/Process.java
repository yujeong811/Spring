package com.java.ot;

public class Process {
	public String process(String input) {
		String str = "";

		if (input != null) {

			try {
				Integer.parseInt(input);
				str += "����:";
			} catch (Exception e) {
				str += "����:";
			}

		}
		
		str += input;

		return str;
	}
}
