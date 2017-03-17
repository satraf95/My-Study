package Cv4;

import java.util.*;

public class Kryptoanalyza {

	public static Scanner sc = new Scanner(System.in);

	public static void Sifra1(String text) {

		text = text.toLowerCase();
		int posun = 1;
		String zprava = "";
		int tmp;

		do  {
			for (char znak : text.toCharArray()) {
				if (znak == ' ') {
					zprava += znak;
				} else {
					tmp = (int) znak;
					tmp -= posun;

					if (tmp < 'a') {
						tmp += 26;
					}
					zprava += (char) tmp;

				}
			}
			System.out.println("(" + posun + ") " + zprava);
			zprava = "";
			posun++;
			
			
		}while(posun != 27);

	}
	
	public static String Sifra2(String text){
		text = text.toLowerCase();
		char p = 'a';
		char p1 = 'z';
		String zprava = "";
		char[] abeceda = new char[27];
		char[] kAbeceda = new char[27];
		
		for(int i = 0; i < 26; i++){
			abeceda[i] = p;
			kAbeceda[i] = p1;
			p++;
			p1--;
		}
		abeceda[26] = ' ';
		kAbeceda[26] = ' ';
				
		for(char znak: text.toCharArray()){
			for(int i = 0; i < 27; i++){
				if(znak == abeceda[i]){//nalezení znaku
					zprava += kAbeceda[i];
					break;
				}
			}
		}
		
		return zprava;
	}

	public static void main(String[] args) {
		String text = "qzp oelev yrqvn l nirav qzp oelev e povxr qzgr nb ybxsln easfif p mvyvhfn z qhnv awv avnr hkqzgr "
				+ "mzn awz hv a sevaw av ezmv sozh mfa klqwgv kzmr yorav qvm gilxsf yorav siwlyxr qrna silfwz mlsb erav "
				+ "nb kirqwvn lwkfhg nzgrxpl qra qhr mzn avnv nzoz nb yovhp p nbhovmpzn hkizsznv z mlsz kzilf xezoz nb kir"
				+ "qwvn wfxs mzh ilhgv e ebh z gvkmb glfslf yrqr arnmrxmr glfslf kl hevgvxs wre hiwxv mvilayrqr nb kirqwvn "
				+ "yora nb kirqwvn yora nb hevgf wlarqvnv nb yrqvn l nira wfxsz oer z nb qr ilayrqvnvg";
		String text1 = "xqlm frf anebqvy ifvpuav fr enqbinyv n gl wfv cynxny mvw gnx nol nm hzerf ifvpuav cynxnyv n gl "
				+ "wfv oly fgnfgal";


		System.out.println("Sifra 1:\n");
		Sifra1(text1);
		System.out.print("\n");
		System.out.println("Sifra 2:\n" + Sifra2(text));
		

		

	}

}
