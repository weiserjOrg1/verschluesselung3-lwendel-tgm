package lwendel.cipher;

/**
 * The Main-Class.
 * @author lwendel
 * @version 2018-10-20
 */

public class Main {
	public static void main(String[] args) {
		SubstitutionCipher nr1 = new SubstitutionCipher("qw!rtz§iop5äölkjhgfdsayxcvbnmß");
		String x = nr1.encrypt("hällö würld peolplß");
		System.out.println(x);
		System.out.println(nr1.decrypt(x));
		ShiftCipher nr2 = new ShiftCipher(5);
		String y = nr2.encrypt("hällö würld peolplß");
		System.out.println(y);
		System.out.println(nr2.decrypt(y));
		Controller c = new Controller();
		KeywordCipher nr3 = new KeywordCipher("gruezine");
		String z = nr3.encrypt("abcdefghijklmnopqrstuvwxyzßäöü");
		System.out.println(z);
		System.out.println(nr3.decrypt(z));
		TranspositionCipher nr4 = new TranspositionCipher(3);
		String w = nr4.encrypt("abcdefghijklmnopqrstuvwxyzßäöü");
		System.out.println(w);
		System.out.println(nr4.decrypt(w));
	}
}
