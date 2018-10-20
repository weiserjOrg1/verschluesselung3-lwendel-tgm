package lwendel.cipher;

import java.awt.event.*;

/**
 * This is the controller for the GUI. He manages the function of the buttons.
 * @author lwendel
 * @version 2018-10-20
 */

public class Controller implements ActionListener {

	//attributes
	private View v;
	
	//constructor
	public Controller() {
		this.v = new View(this);
	}
	
	//methods

	@Override
	public void actionPerformed(ActionEvent e) {
		//I could have used switch-case, but "if" was my first thought
		//Shift
		if (this.v.getButtonSelected() == 1) {
			int shiftValue;
			try { //because sShiftCipher() works with int
				shiftValue = Integer.parseInt(this.v.getSecrAlph());
			} catch (NumberFormatException exc) {
				shiftValue = 0;
			}
			ShiftCipher cipher = new ShiftCipher(shiftValue);
			if (this.v.isDecrPressed(e)) {
				this.v.setOutText(cipher.decrypt(this.v.getInText()));
			}
			if (this.v.isEncrPressed(e)) {
				this.v.setOutText(cipher.encrypt(this.v.getInText()));
			}
		}
		
		//Substitution
		if (this.v.getButtonSelected() == 2) {
			SubstitutionCipher cipher = new SubstitutionCipher(this.v.getSecrAlph());
			if (this.v.isDecrPressed(e)) {
				this.v.setOutText(cipher.decrypt(this.v.getInText()));
			}
			if (this.v.isEncrPressed(e)) {
				this.v.setOutText(cipher.encrypt(this.v.getInText()));
			}
		}
		
		//Keyword
		if (this.v.getButtonSelected() == 3) {
			KeywordCipher cipher = new KeywordCipher(this.v.getSecrAlph());
			if (this.v.isDecrPressed(e)) {
				this.v.setOutText(cipher.decrypt(this.v.getInText()));
			}
			if (this.v.isEncrPressed(e)) {
				this.v.setOutText(cipher.encrypt(this.v.getInText()));
			}
		}
		
		//Transposition
		if (this.v.getButtonSelected() == 4) { 
			int transposValue;
			try { //because TranspositionCipher() works with int
				transposValue = Integer.parseInt(this.v.getSecrAlph());
			} catch (NumberFormatException exc) {
				transposValue = 0;
			}
			TranspositionCipher cipher = new TranspositionCipher(transposValue);
			if (this.v.isDecrPressed(e)) {
				this.v.setOutText(cipher.decrypt(this.v.getInText()));
			}
			if (this.v.isEncrPressed(e)) {
				this.v.setOutText(cipher.encrypt(this.v.getInText()));
			}
		}
	}
}
