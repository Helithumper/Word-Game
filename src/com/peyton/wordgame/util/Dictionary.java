package com.peyton.wordgame.util;

import java.io.File;
import java.util.Scanner;

public class Dictionary {
	private String[] dictionary;
	
	public Dictionary(){
		File file = new File(Dictionary.class.getResource("nounlist.txt").getPath());
		
		try{
			Scanner reader = new Scanner(file);
			int i = 0;
			dictionary = new String[1000];
			while (reader.hasNextLine()) {
				dictionary[i] = reader.nextLine();
				i++;
			}
			reader.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String getWord(int index){return dictionary[index];}
	
}
