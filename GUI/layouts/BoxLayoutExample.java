import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxLayoutExample extends JFrame {
	private static final long serialVersionUID = 1L;

	public BoxLayoutExample() {
		JPanel contentPane = (JPanel) this.getContentPane();
		// contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		contentPane.add(new JButton("Button 1"));
		contentPane.add(new JButton("Button 2"));
		contentPane.add(new JButton("Button 3"));
	}

	public static void main(String[] args) {
		BoxLayoutExample frame = new BoxLayoutExample();
		frame.pack();
		frame.setTitle("BoxLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // center-screen
		frame.setVisible(true);
	}

}