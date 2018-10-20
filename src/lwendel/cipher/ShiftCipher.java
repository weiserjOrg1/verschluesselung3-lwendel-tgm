package lwendel.cipher;

/**
 * This is the class for using the Caesar-crypting. Basically: Moving the secretAlphabet.
 * @author lwendel
 * @version 2018-10-20
 */

public class ShiftCipher extends MonoAlphabeticCipher {

	//constructor
	public ShiftCipher(int value) {
		//We don't take negative values here
		if (value >= 0) {
			this.setShiftValue(value);
		} else {
			this.setShiftValue(0);
		}
		
	}
	
	//methods
	
	//set-method(s)
	public void setShiftValue(int value) {
		value = value % 30; //everything above 30 would be unnecessary
		String alphabet = "abcdefghijklmnopqrstuvwxyzßäöü";
		String secrAlphabet = "";
		
		//adding everything behind the value, including the value
		for (int i = value ; i < 30 ; i++) {
			secrAlphabet += alphabet.charAt(i);
		}
		
		//adding everything in front of the value
		for (int i = 0 ; i < value ; i++) {
			secrAlphabet += alphabet.charAt(i);
		}
		
		super.setSecretAlphabet(secrAlphabet); //using the MonoAlphabeticCipher-method
	}
}
