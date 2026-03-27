import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class GridLayoutExample extends JFrame {
	private static final long serialVersionUID = 1L;

	public GridLayoutExample() {
		JPanel contentPane = (JPanel) this.getContentPane();
		// contentPane.setLayout(new GridLayout(3, 2));
		contentPane.setLayout(new GridLayout(2, 3));

		contentPane.add(new JButton("Button 1"));
		contentPane.add(new JButton("Button 2"));
		contentPane.add(new JButton("Button 3"));
		contentPane.add(new JButton("Button 4"));
		contentPane.add(new JButton("Button 5"));
	}

	public static void main(String[] args) {
		GridLayoutExample frame = new GridLayoutExample();
		frame.pack();
		frame.setTitle("GridLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // center-screen
		frame.setVisible(true);
	}

}