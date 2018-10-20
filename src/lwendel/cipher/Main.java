package lwendel.cipher;

/**
 * The Main-Class.
 * @author lwendel
 * @version 2018-10-20
 */

public class Main {
	public static void main(String[] args) {
		//Substitution
		SubstitutionCipher nr1 = new SubstitutionCipher("qw!rtz�iop5��lkjhgfdsayxcvbnm�");
		String x = nr1.encrypt("h�ll� w�rld peolpl�");
		System.out.println(x);
		System.out.println(nr1.decrypt(x));
		
		//Shift
		ShiftCipher nr2 = new ShiftCipher(5);
		String y = nr2.encrypt("h�ll� w�rld peolpl�");
		System.out.println(y);
		System.out.println(nr2.decrypt(y));
		
		//Keyword
		KeywordCipher nr3 = new KeywordCipher("gruezine");
		String z = nr3.encrypt("abcdefghijklmnopqrstuvwxyz����");
		System.out.println(z);
		System.out.println(nr3.decrypt(z));
		
		//Transposition
		TranspositionCipher nr4 = new TranspositionCipher(3);
		String w = nr4.encrypt("abcdefghijklmnopqrstuvwxyz����");
		System.out.println(w);
		System.out.println(nr4.decrypt(w));
		
		//GUI
		Controller c = new Controller();
	}
}
