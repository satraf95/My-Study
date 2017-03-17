package Cv4;


public class BIT_CV4_desifrovani {

	public static void main(String[] args) {
		String zpravaCeasar = "yxvxlwxd adtd wjsmnb wnsbyrbn wj txwlr benqx ajvnwn" ;
		System.out.println(zpravaCeasar);
		System.out.println("Najsi smysluplnou zpravu, zase tolik jich neni ;-), ten nas je na s posunem 17");
		for (byte posun = 1; posun < 26; posun+=1){			
			//byte posun = 1;
			String ceasar = CeasarZasifrovat(zpravaCeasar,posun); // fungovat bude i obracene / symetricka
			System.out.print("Zprava po zasifrovani Ceasarovou sifrou s posunem o " +posun +": ");
			System.out.println(ceasar);	
			}
		System.out.println("!!!!!!!!!!!!!!!!Konec CEASARa!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		String zpravaAtbash = "qvm gvm pwl hv lwezar qrg wzo mva lhgzgmr hv wlaer qzp wzovpl nfav wllkizewb qrg"; //http://www.hanginghyena.com/solvers_a/atbash-cipher-decoder
		System.out.println(zpravaAtbash);
		String zpravaReseniAtbash = atbashDecode(zpravaAtbash);
		System.out.println(zpravaReseniAtbash);
		System.out.println("!!!!!!!!!!!!!!!!Konec ATBASe!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
}
	
	public static String atbashDecode (String zprava){ 
	int [] abc = new int[26];
	int pom = 0;
	for (int i = 0; i<26;i+=1){	
		int t = (int)'a' + pom;
	//	System.out.println(t);
		abc [i] = t;
		pom++;
	}
	// obracena abeceda
	int [] xyz = new int[26];
	pom = 0;
	for (int i = 0; i<26;i+=1){	
		int t = (int)'z' - pom;
	//	System.out.println(t);
		xyz [i] = t;
		pom++;
	}
	
	String zpravaNova = "";
	char [] c = new char[(zprava.length())];;

	for(int i =0; i < zprava.length(); i+=1){
		for(int j=0;j<26;j++) {
		//	if(zprava.charAt(i)==){
				
		//	}
			if (zprava.charAt(i)==32){ //mezera
				 zpravaNova +=" ";
				 break;
			}
			else if(abc[j]==zprava.charAt(i))   
			    {
			     c[i]=(char)xyz[j];
			     zpravaNova += c[i];
			     break;    
			    }
		}
	}
	
	return zpravaNova;
	}

	
	public static String CeasarZasifrovat (String zpravaBez, byte posun) {
		
		//	byte posun =-1;
		String zasifrovana = "";
		
		for (int i = 0; i < zpravaBez.length(); i+=1) {
		// 	System.out.println(i);
			char c = zpravaBez.charAt(i);
		//	String c = zpravaBez.substring(i,i+1); zbytecny
		//	System.out.println(c);
			int cisloChar = (int)c;
			if (cisloChar==32){
				
			}
		//	System.out.println(cisloChar);
	            cisloChar += posun;
	            // kontrola pre a podteceni
	        	int pomocnik=0;
	        	if (cisloChar > (int)'z'){
	            	cisloChar -= 26;
	            	pomocnik =-26;
	            }
	            else if (cisloChar < (int)'a'){
	            	cisloChar +=26;
	            	pomocnik = 26;
	            }
	        	if ((char)cisloChar==32+posun+pomocnik){
	    			zasifrovana +=" "; 
	    		}	
	        	else{
	        		char znak = (char)cisloChar;
	        		zasifrovana += znak;
	        	}
		}
		return zasifrovana;
	}
}