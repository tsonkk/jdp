import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

public class BorderLayoutExample extends JFrame {
	private static final long serialVersionUID = 1L;

	public BorderLayoutExample() {
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		contentPane.add(new JButton("NORTH"), BorderLayout.NORTH);
		contentPane.add(new JButton("SOUTH"), BorderLayout.SOUTH);
		contentPane.add(new JButton("WEST"), BorderLayout.WEST);
		contentPane.add(new JButton("EAST"), BorderLayout.EAST);
		contentPane.add(new JButton("CENTER"), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		BorderLayoutExample frame = new BorderLayoutExample();
		frame.pack();
		frame.setTitle("BorderLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // center-screen
		frame.setVisible(true);
	}

}