package tasks;

import java.awt.BorderLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Venster extends JFrame {
	private static final long serialVersionUID = 1L;
	private final JTextField textField = new JTextField();
	private final JButton button = new JButton("gok");

	private final int teRadenGetal = new Random().nextInt(10) + 1;
	private int beurten;

	Venster() {
		super("Hoger lager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(event -> gok());
		add(textField, BorderLayout.NORTH);
		add(button, BorderLayout.SOUTH);
		pack();
	}

	private void gok() {
		beurten++;
		try {
			int getal = Integer.parseInt(textField.getText());
			if (getal == teRadenGetal) {
				JOptionPane.showMessageDialog(this, "Gevonden in " + beurten + " beurt(en)");
			} else {
				JOptionPane.showMessageDialog(this, getal > teRadenGetal ? "Lager" : "Hoger");
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Tik een getal");
		}
	}
}
