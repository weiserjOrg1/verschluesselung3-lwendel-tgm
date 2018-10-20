package lwendel.cipher;

import java.awt.event.*;

public class Controller implements ActionListener {

	//attributes
	private View v;
	
	//constructor
	public Controller() {
		this.v = new View(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.v.getButtonSelected() == 1) { //Shift
			int shiftValue;
			try {
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
		if (this.v.getButtonSelected() == 2) { //Substitution
			SubstitutionCipher cipher = new SubstitutionCipher(this.v.getSecrAlph());
			if (this.v.isDecrPressed(e)) {
				this.v.setOutText(cipher.decrypt(this.v.getInText()));
			}
			if (this.v.isEncrPressed(e)) {
				this.v.setOutText(cipher.encrypt(this.v.getInText()));
			}
		}
		if (this.v.getButtonSelected() == 3) { //Keyword
			KeywordCipher cipher = new KeywordCipher(this.v.getSecrAlph());
			if (this.v.isDecrPressed(e)) {
				this.v.setOutText(cipher.decrypt(this.v.getInText()));
			}
			if (this.v.isEncrPressed(e)) {
				this.v.setOutText(cipher.encrypt(this.v.getInText()));
			}
		}
		if (this.v.getButtonSelected() == 4) { //Shift
			int transposValue;
			try {
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
