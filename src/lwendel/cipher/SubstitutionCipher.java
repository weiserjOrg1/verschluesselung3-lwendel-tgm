package lwendel.cipher;

/**
 * this is the class to make an object
 * @author lars
 * @version 11-10-18
 */

public class SubstitutionCipher extends MonoAlphabeticCipher{
	
	public SubstitutionCipher(String secretAlphabet) {
		this.setSecretAlphabet(secretAlphabet);
	}
	
	public void setSecretAlphabet(String secretAlphabet) {
		super.setSecretAlphabet(secretAlphabet);
	}
}
