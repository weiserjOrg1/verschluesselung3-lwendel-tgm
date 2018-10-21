package lwendel.cipher;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * The Frame that opens when running the class Controller.
 * @author lwendel
 * @version 2018-10-20
 */

public class View extends JFrame {
	
	//attributes
	public JButton encr, decr;
	public JTextArea secrAlph, outText, inText;
	public JRadioButton shift, substitution, keyword, transposition;
	public ButtonGroup grp;
	public JPanel np, sp;
	public Controller c;
	
	//constructor
	public View(Controller c1) {
		//adding the constructor-given objects
		this.c = c1;
		
		//defining all attributes
		
		//The Panels are for adding multiple buttons in BorderLayout.NORTH and BorderLayout.SOUTH
		this.np = new JPanel(new FlowLayout());
		this.sp = new JPanel(new FlowLayout());
		
		this.encr = new JButton("encrypt");
		this.decr = new JButton("decrypt");
		this.secrAlph = new JTextArea();
		this.outText = new JTextArea();
		this.inText = new JTextArea();

		//The buttons for choosing the cipher-type
		this.grp = new ButtonGroup();
		this.shift = new JRadioButton("shift");
		this.substitution = new JRadioButton("substitution");
		this.keyword = new JRadioButton("keyword");
		this.transposition = new JRadioButton("transposition");

		//shiftCipher is the selected one 
		this.shift.setSelected(true);

		//so there can only be one thing equipped
		this.grp.add(this.shift);
		this.grp.add(this.substitution);
		this.grp.add(this.keyword);
		this.grp.add(this.transposition);
		
		//editing the TextAreas
		Dimension d = new Dimension(220, 250);
		this.outText.setPreferredSize(d);
		this.inText.setPreferredSize(d);
		this.inText.setLineWrap(true);
		this.outText.setLineWrap(true);
		this.secrAlph.setLineWrap(true);
		Border b1 = BorderFactory.createLineBorder(Color.RED);
		this.outText.setBorder(b1);
		this.outText.setEditable(false);
		
		Border b2 = BorderFactory.createLineBorder(Color.BLACK);
		this.inText.setBorder(b2);
		
		Border b3 = BorderFactory.createLineBorder(Color.BLACK);
		this.secrAlph.setBorder(b3);

		//setting everything important for the JFrame
		this.setSize(700, 200);
		this.setTitle("Cipher");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		//The actionListener only reacts when either encrypt or decrypt is pressed
		this.encr.addActionListener(this.c);
		this.decr.addActionListener(this.c);
		
		//adding to the South-Panel
		this.sp.add(this.encr);
		this.sp.add(this.decr);
		//adding to the North-Panel
		this.np.add(this.shift);
		this.np.add(this.substitution);
		this.np.add(this.keyword);
		this.np.add(this.transposition);
		
		//adding everything to the Frame
		this.add(this.secrAlph, BorderLayout.CENTER);
		this.add(this.np, BorderLayout.NORTH);
		this.add(this.sp, BorderLayout.SOUTH);
		this.add(this.inText, BorderLayout.WEST);
		this.add(this.outText, BorderLayout.EAST);
		
		this.setVisible(true); //the most important one
		
	}
	
	//methods
	
	//self explanatory
	public boolean isEncrPressed(ActionEvent e) {
		if (e.getSource() == this.encr) {
			return true;
		}
		return false;
	}
	
	//self explanatory
	public boolean isDecrPressed(ActionEvent e) {
		if (e.getSource() == this.decr) {
			return true;
		}
		return false;
	}
	
	//get-method(s)
	
	//returns a value for the chosen Button
	public int getButtonSelected() {
		if (this.shift.isSelected()) {
			return 1;
		}
		if (this.substitution.isSelected()) {
			return 2;
		}
		if (this.keyword.isSelected()) {
			return 3;
		}
		if (this.transposition.isSelected()) {
			return 4;
		}
		
		return 0;
	}
	
	public String getInText() {
		return this.inText.getText();
	}
	
	public String getSecrAlph() {
		return this.secrAlph.getText();
	}
	
	//set-method(s)
	public void setOutText(String text) {
		this.outText.setText(text);
	}
}
