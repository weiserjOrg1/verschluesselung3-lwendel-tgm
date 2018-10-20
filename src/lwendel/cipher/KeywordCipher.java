package lwendel.cipher;

/**
 * This is a class for crypting with a keyword. Kind of like a more flexible SubstitutionAlphabet. F.e.: Keyword: "Koifish" secretAlphabet: "koifshabcdeghjlmnpqrtuvwxyzßäöü"
 * @author lwendel
 * @version 2018-10-20
 */

public class KeywordCipher extends MonoAlphabeticCipher {
	
	//constructor
	public KeywordCipher(String keyword) {
		this.setKeyword(keyword);
	}
	
	//methods
	
	public void setKeyword(String keyword) {
		String key = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyzßäöü";
		//adding letters ONCE
		for (int i = 0 ; i < keyword.length() ; i++) {
			String curCh = String.valueOf(keyword.charAt(i));
			if (!key.contains(curCh)) {
				key += curCh;
			}
		}
		
		//adding the rest of the alphabet
		for (int i = 0 ; i < alphabet.length() ; i++) {
			String curCh = String.valueOf(alphabet.charAt(i));
			if (!key.contains(curCh)) {
				key += curCh;
			}
		}
		
		super.setSecretAlphabet(key); //using the MonoAlphabeticCipher-method
	}

}
