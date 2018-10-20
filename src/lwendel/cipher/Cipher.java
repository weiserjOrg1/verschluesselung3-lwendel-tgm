package lwendel.cipher;

/**
 * This is an interface with the basics of crypting.
 * @author lwendel
 * @version 11-10-18
 */
public interface Cipher {
	
	public String encrypt(String text);
	public String decrypt(String text);
	
}
