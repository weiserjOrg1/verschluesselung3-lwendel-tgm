package lwendel.cipher;

/**
 * This is a class for crypting with a single alphabet.
 * @author lwendel
 * @version 11-10-18
 */

public class MonoAlphabeticCipher implements Cipher {

	//attributes
	private String secretAlphabet; //The crypting-key
	
	//constructor
	public MonoAlphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzßäöü"; //standard-key = alphabet
	}
	
	//methods
	
	//get-method(s)
	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}
	
	//set-method(s)
	protected void setSecretAlphabet(String secretAlphabet) {
		//I am checking for mistakes in this class because it makes less code only writing it once.
		boolean ok = true; //it is true until something tells him it's not
		for (int j = 0 ; j < 1 ; j++) {
			if (secretAlphabet.length() != 30) {
				ok = false;
				break;
			}
			for (int i = 0 ; i < 33 ; i++) { //it isn't allowed to contain one of the first 32 "things" in the ASCII-table
				char x = (char) i;
				String y = "" + x;
				if (secretAlphabet.contains(y)) {
					ok = false;
					break;
				}
			}
			for (int i = 0 ; i < 30 ; i++) { //cant't be longer than 30 letters and no equal characters
				if (secretAlphabet.lastIndexOf(secretAlphabet.charAt(i)) != secretAlphabet.indexOf(secretAlphabet.charAt(i))) {
					ok = false;
					break;
				}
			}
		}
		if (ok) {
			this.secretAlphabet = secretAlphabet; //changed
		} else {
			System.out.println("There is at least one mistake in the secret alphabet"); //stays normal alphabet
		}
	}

	//method for encrypting, changing only the defined 30-letter-key 
	public String encrypt(String text) {
		text = text.toLowerCase(); //only working in lowerCase
		String cryptedText = ""; //variable for saving the whole text and returning it
		boolean mistake = false; //we'll get there in a second
		for (int i = 0 ; i < text.length() ; i++) { //the whole String
			int x = text.charAt(i); //the current character, in decimal
			switch (x) { //switch-case for all 30 letters : simple, but unpleasant
			case 97 : cryptedText += this.secretAlphabet.charAt(0);
				break;
			case 98 : cryptedText += this.secretAlphabet.charAt(1);
				break;
			case 99 : cryptedText += this.secretAlphabet.charAt(2);
				break;
			case 100 : cryptedText += this.secretAlphabet.charAt(3);
				break;
			case 101 : cryptedText += this.secretAlphabet.charAt(4);
				break;
			case 102 : cryptedText += this.secretAlphabet.charAt(5);
				break;
			case 103 : cryptedText += this.secretAlphabet.charAt(6);
				break;
			case 104 : cryptedText += this.secretAlphabet.charAt(7);
				break;
			case 105 : cryptedText += this.secretAlphabet.charAt(8);
				break;
			case 106 : cryptedText += this.secretAlphabet.charAt(9);
				break;
			case 107 : cryptedText += this.secretAlphabet.charAt(10);
				break;
			case 108 : cryptedText += this.secretAlphabet.charAt(11);
				break;
			case 109 : cryptedText += this.secretAlphabet.charAt(12);
				break;
			case 110 : cryptedText += this.secretAlphabet.charAt(13);
				break;
			case 111 : cryptedText += this.secretAlphabet.charAt(14);
				break;
			case 112 : cryptedText += this.secretAlphabet.charAt(15);
				break;
			case 113 : cryptedText += this.secretAlphabet.charAt(16);
				break;
			case 114 : cryptedText += this.secretAlphabet.charAt(17);
				break;
			case 115 : cryptedText += this.secretAlphabet.charAt(18);
				break;
			case 116 : cryptedText += this.secretAlphabet.charAt(19);
				break;
			case 117 : cryptedText += this.secretAlphabet.charAt(20);
				break;
			case 118 : cryptedText += this.secretAlphabet.charAt(21);
				break;
			case 119 : cryptedText += this.secretAlphabet.charAt(22);
				break;
			case 120 : cryptedText += this.secretAlphabet.charAt(23);
				break;
			case 121 : cryptedText += this.secretAlphabet.charAt(24);
				break;
			case 122 : cryptedText += this.secretAlphabet.charAt(25);
				break;
			case 223 : cryptedText += this.secretAlphabet.charAt(26); //ß
				break;
			case 228 : cryptedText += this.secretAlphabet.charAt(27); //ä
				break;
			case 246 : cryptedText += this.secretAlphabet.charAt(28); //ö
				break;
			case 252 : cryptedText += this.secretAlphabet.charAt(29); //ü
				break;
			default : cryptedText += text.charAt(i); //everything outside stays the same
				mistake = true; //if anything outside of the secretAlphabet stays the same...
			}
		}
		if (mistake) { //...this is typed into the console
			System.out.println("Some letters couldn't be encrypted");
		}
		return cryptedText;
	}
	
	//method for decrypting
	public String decrypt(String text) {
		text = text.toLowerCase(); //only working in lowerCase
		String normText = ""; //variable for saving the whole text and returning it
		String alphabet = "abcdefghijklmnopqrstuvwxyzßäöü"; //taking the real alphabet for help, a bit more thinking outside of the box
		boolean mistake = false; //the same as before
		for (int i = 0 ; i < text.length() ; i++) { //editing the whole text
			int index;
			try {
				index = this.secretAlphabet.indexOf(text.charAt(i)); //index is the index of the position of the crypted text in secretAlphabet
				normText += alphabet.charAt(index); //and uses this position in the normal alphabet
			} catch (StringIndexOutOfBoundsException exc) { //if the char isn't in the secretAlphabet, -1 is returned, which isn't an index of a String
				normText += text.charAt(i); //everything outside of the 30-letter-key stays the same
				mistake = true;
			}
		
		}
		if (mistake) { //the same as before
			System.out.println("Some letters couldn't be decrypted");
		}
		return normText;
	}
}
