package lwendel.cipher;

/**
 * 
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
		for (int i = 0 ; i < keyword.length() ; i++) {
			String curCh = String.valueOf(keyword.charAt(i));
			if (!key.contains(curCh)) {
				key += curCh;
			}
		}
		for (int i = 0 ; i < alphabet.length() ; i++) {
			String curCh = String.valueOf(alphabet.charAt(i));
			if (!key.contains(curCh)) {
				key += curCh;
			}
		}
		super.setSecretAlphabet(key);
	}

}
