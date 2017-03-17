package Cv3;

import java.util.*;

public class Kryptografie {

	public static String CeasarovaSifra(String text) {
		text = text.toLowerCase();
		System.out.println("Caesarova sifra\n");
		int posun = 3;
		System.out.println("Posun: " + posun);
		System.out.println("Puvodni zprava: " + text);
		String zprava = "";		
		int znakASCII;
		char sZnak;

		for (char znak : text.toCharArray()) {

			znakASCII = (int) znak;
			znakASCII += posun;
			if (znakASCII > 'z') {
				znakASCII -= 26;
			}
			sZnak = (char) znakASCII;
			zprava += sZnak;
		}

		return zprava;
	}

	public static String MonoalfabetickaSubstituce(String text) {
		text = text.toLowerCase();
		System.out.println("Monoalfabeticka substitucni sifra\n");
		System.out.println("Puvodni zprava: " + text);
		char pismeno = 'a';
		int kPismeno = 'm';
		int poziceS = 0;
		int poziceL = 1;
		String zprava = "";
		char[] abeceda = new char[26];
		char[] kodovaAbeceda = new char[26];

		for (int i = 0; i < 26; i++) {
			abeceda[i] = pismeno;
			pismeno++;
		}
		for (int j = 0; j < 26; j++) {
			if (j % 2 == 0) {
				kodovaAbeceda[j] = (char) (kPismeno + poziceL);
				poziceL++;
			} else {
				kodovaAbeceda[j] = (char) (kPismeno - poziceS);
				poziceS++;
			}
		}
		System.out.println(Arrays.toString(abeceda));
		System.out.println(Arrays.toString(kodovaAbeceda));
		for (char znak : text.toCharArray()) {
			for (int i = 0; i < 26; i++) {
				if (znak == abeceda[i]) {
					zprava += kodovaAbeceda[i];
					break;
				}
			}
		}

		return zprava;
	}

	public static void HomofonniSifra(String text) {
		text = text.toLowerCase();
		System.out.println("Homofonni sifra\n");
		System.out.println("Puvodni zprava: " + text);
		char pismeno = 'a';
		int znakyCelkem = 0;
		int delkaPole = 0;
		int kod = 1;
		char[] abeceda = new char[26];
		int[] pocetZnaku = new int[26];

		for (int i = 0; i < 26; i++) {
			abeceda[i] = pismeno;
			pismeno++;
			pocetZnaku[i] = 0;
		}
		for (char znak : text.toCharArray()) {
			znakyCelkem++;
			for (int i = 0; i < 26; i++) {
				if (znak == abeceda[i]) {
					pocetZnaku[i] = pocetZnaku[i] + 1;

				}
			}
		}
		char[] Znaky = new char[73];
		System.out.println(Arrays.toString(abeceda));
		System.out.println(Arrays.toString(pocetZnaku));
		pismeno -= 26;
		for (int i = 0; i < 26; i++) {
			double pznak = pocetZnaku[i];
			delkaPole = (int) ((pznak / znakyCelkem) * 100);

			int[] kodovani = new int[delkaPole];
			for (int j = 0; j < delkaPole; j++) {
				kodovani[j] = kod;
				kod += 1;
			}
			System.out.println("znak " + pismeno + ": " + Arrays.toString(kodovani));
			pismeno++;
			
			
		}

	}

	public static String AlbertihoSifra(String text) {
		text = text.toLowerCase();
		System.out.println("Albertiho sifra\n");
		System.out.println("Puvodni zprava: " + text);
		char pismeno = 'a';
		int kPismeno = 'm';
		int poziceS = 0;
		int poziceL = 1;
		String zprava = "";
		char[] abeceda = new char[26];
		char[] kodovaAbeceda = new char[26];
		char[] kodovaAbeceda2 = new char[26];

		for (int i = 0; i < 26; i++) {
			abeceda[i] = pismeno;
			pismeno++;
		}
		for (int j = 0; j < 26; j++) {
			if (j % 2 == 0) {
				kodovaAbeceda[j] = (char) (kPismeno + poziceL);
				poziceL++;
			} else {
				kodovaAbeceda[j] = (char) (kPismeno - poziceS);
				poziceS++;
			}
		}
		int tmp = 25;
		for (int k = 0; k < 26; k++) {
			kodovaAbeceda2[k] = kodovaAbeceda[tmp];
			tmp--;
		}
		int count = 0;
		System.out.println(Arrays.toString(abeceda));
		System.out.println(Arrays.toString(kodovaAbeceda));
		System.out.println(Arrays.toString(kodovaAbeceda2));
		for (char znak : text.toCharArray()) {
			for (int i = 0; i < 26; i++) {
				if (znak == abeceda[i]) {
					if (count % 2 == 0) {
						zprava += kodovaAbeceda[i];
						count++;
						break;
					} else {
						zprava += kodovaAbeceda2[i];
						count++;
						break;
					}
				}
			}
		}

		return zprava;
	}

	public static void main(String[] args) {
		String text = "zeptaslisebudespetminutvypadatjakoblbecnezeptaslisebudesblbcempocelyzivot";

		System.out.println("Zakodovana zprava: " + CeasarovaSifra(text) + "\n");
		System.out.println("Zakodovana zprava: " + MonoalfabetickaSubstituce(text) + " \n");
		System.out.println("Zakodovana zprava: " + AlbertihoSifra(text) + "\n");
		HomofonniSifra(text);

	}

}
