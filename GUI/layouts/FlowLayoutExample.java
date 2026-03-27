import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;

public class FlowLayoutExample extends JFrame {
	private static final long serialVersionUID = 1L;

	public FlowLayoutExample() {
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));

		contentPane.add(new JButton("Button 1"));
		contentPane.add(new JButton("Button 2"));
		contentPane.add(new JButton("Button 3"));
	}

	public static void main(String[] args) {
		FlowLayoutExample frame = new FlowLayoutExample();
		frame.pack();
		frame.setTitle("FlowLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // center-screen
		frame.setVisible(true);
	}

}