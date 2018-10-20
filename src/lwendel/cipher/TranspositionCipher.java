package lwendel.cipher;

/**
 * 
 * @author lwendel
 * @version 2018-10-20
 */

public class TranspositionCipher implements Cipher{

	//attributes
	private int transposlvl;
	
	//constructor
	public TranspositionCipher(int transpositionLevel) {
		this.setTranspositionLevel(transpositionLevel);
	}

	public void setTranspositionLevel(int transpositionLevel) {
		if (transpositionLevel > 0) {
			this.transposlvl = transpositionLevel;
		} else {
			this.transposlvl = 1;
		}
	}
	
	public String encrypt(String text) {
		String encrText = "";
		if (text.length() <= transposlvl) {
			return text;
		}
		long a = text.length() / this.transposlvl;
		int b = text.length() / this.transposlvl;
		if (a > b) b = b + 1;
		char[][] hv = new char[b][this.transposlvl]; //[x][y]
		int letter = 0;
		for (int i = 0 ; i < b ; i++ ) {
			for (int j = 0 ; j < this.transposlvl ; j++) {
				hv[i][j] = text.charAt(letter);
				letter++;
			}
		}
		for (int i = 0 ; i < this.transposlvl ; i++ ) {
			for (int j = 0 ; j < b ; j++) {
				encrText += String.valueOf(hv[j][i]);
			}
		}
		return encrText;
	}
	
	public String decrypt(String text) {
		String decrText = "";
		if (text.length() <= transposlvl) {
			return text;
		}
		long a = text.length() / this.transposlvl;
		int b = text.length() / this.transposlvl;
		if (a > b) b = b + 1;
		char[][] hv = new char[b][this.transposlvl]; //[x][y]
		int letter = 0;
		for (int i = 0 ; i < this.transposlvl ; i++ ) {
			for (int j = 0 ; j < b ; j++) {
				hv[j][i] = text.charAt(letter);
				letter++;
			}
		}
		for (int i = 0 ; i < b ; i++ ) {
			for (int j = 0 ; j < this.transposlvl ; j++) {
				decrText += String.valueOf(hv[i][j]);
			}
		}
		
		return decrText;
	}
}
