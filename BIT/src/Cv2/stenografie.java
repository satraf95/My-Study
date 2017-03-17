package Cv2;

import java.io.*;

public class stenografie {
	public static void main(String[] args) throws IOException{
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream("obr2.bmp"));
		
		//preskoceni hlavicky 
		for(int i = 0; i < 54; i++){
			bi.read();
		}
		final int MAX_SIZE = 500; //max delka zpravy
		for (int n = 0; n < MAX_SIZE; n++){
			String s = "";
			//slozeni binarniho cisla
			for(int i = 0; i < 8; i++){
				s = s + bi.read() % 2;
			}
			//prevedeni cisla z binarni do desitkove a vypsani znaku podle ASCII tabulky
			int decimal = Integer.parseInt(s, 2);	
			char a = (char)decimal;
			
			System.out.print(a);
			
			//ukonecni zpravy
			if(decimal == '\n'){
				break;
			}
		}
		bi.close();
	}

}
