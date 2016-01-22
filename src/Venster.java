import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Venster extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final Path STERRENBEELDEN_PATH = Paths.get("/data/sterrenbeelden.txt");

	Venster() {
		/*
		 * super("Conversie"); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * JTextField textField = new JTextField(); JButton buttonHoofdLetters =
		 * new JButton("hoofdletters"); JButton buttonKleineLetters = new
		 * JButton("kleine letters"); buttonHoofdLetters.addActionListener(e ->
		 * textField.setText(textField.getText().toUpperCase()));
		 * buttonKleineLetters.addActionListener(e ->
		 * textField.setText(textField.getText().toLowerCase())); add(textField,
		 * BorderLayout.NORTH); add(buttonHoofdLetters, BorderLayout.WEST);
		 * add(buttonKleineLetters, BorderLayout.EAST); pack();
		 */

		super("Sterrenbeelden");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JList<String> listSterrenbeelden;
		try (Stream<String> stream = Files.lines(STERRENBEELDEN_PATH)) {
			listSterrenbeelden = new JList<>(stream.sorted().toArray(aantalElementen -> new String[aantalElementen]));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "Kan sterrenbeelden niet lezen");
			listSterrenbeelden = new JList<>();
		}
		add(new JScrollPane(listSterrenbeelden));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
