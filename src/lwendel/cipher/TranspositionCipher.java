package lwendel.cipher;

/**
 * This is the class for the TranspositionCipher.
 * @author lwendel
 * @version 2018-10-21
 */

public class TranspositionCipher implements Cipher{

	//attributes
	private int transposlvl;
	
	//constructor
	public TranspositionCipher(int transpositionLevel) {
		this.setTranspositionLevel(transpositionLevel);
	}

	//methods
	
	//method for encrypting
	public String encrypt(final String text) {
		String encrText = "";
		if (text.length() <= transposlvl) {
			return text;
		}
		
		//writing it onto the Array the one way...
		int b = (int) Math.ceil(text.length() / (double) this.transposlvl);
		char[][] hv = new char[b][this.transposlvl];
		int letter = 0;
		for (int i = 0 ; i < b ; i++ ) {
			for (int j = 0 ; j < this.transposlvl ; j++) {
				if (text.length() <= letter) break;
				hv[i][j] = text.charAt(letter);
				letter++;
			}
		}
		
		//reading it of the Array the other way
		for (int i = 0 ; i < this.transposlvl ; i++ ) {
			for (int j = 0 ; j < b ; j++) {
				if (!String.valueOf(hv[j][i]).equals(null)) {
					encrText += String.valueOf(hv[j][i]);
				}
			}
		}
		return encrText;
	}
	
	//method for decrypting (reversing encrypt)
	public String decrypt(String text) {
		String decrText = "";
		if (text.length() <= transposlvl) {
			return text;
		}
		int b = (int) Math.ceil(text.length() / (double) this.transposlvl);
		char[][] hv = new char[b][this.transposlvl];
		int letter = 0;
		for (int i = 0 ; i < this.transposlvl ; i++ ) {
			for (int j = 0 ; j < b ; j++) {
				if (text.length() <= letter) break;
				hv[j][i] = text.charAt(letter);
				letter++;
			}
		}
		for (int i = 0 ; i < b ; i++ ) {
			for (int j = 0 ; j < this.transposlvl ; j++) {
				if (!String.valueOf(hv[i][j]).equals(null)) {
					decrText += String.valueOf(hv[i][j]);
				}
			}
		}
		
		return decrText;
	}
	
	//set-method(s)
		public void setTranspositionLevel(int transpositionLevel) {
			//I don't know how to transposition with a level of -1 so...
			if (transpositionLevel > 0) {
				this.transposlvl = transpositionLevel;
			} else {
				this.transposlvl = 1;
			}
		}
		
}
