package lwendel.cipher;

/**
 * this is the class for crupting with a substitution alphabet. Very simple.
 * @author lars
 * @version 11-10-18
 */

public class SubstitutionCipher extends MonoAlphabeticCipher{
	
	//constructor
	public SubstitutionCipher(String secretAlphabet) {
		this.setSecretAlphabet(secretAlphabet);
	}
	
	//methods
	
	//set-Method(s)
	public void setSecretAlphabet(String secretAlphabet) {
		super.setSecretAlphabet(secretAlphabet); //using the MonoAlphabeticCipher-method
	}
}
