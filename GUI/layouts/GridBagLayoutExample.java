import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GridBagLayoutExample extends JFrame {
	private static final long serialVersionUID = 1L;

	public GridBagLayoutExample() {
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPane.add(new JButton("Button 1"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		contentPane.add(new JButton("Button 2"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(new JButton("Button 3"), gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		contentPane.add(new JButton("Button 4"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(new JButton("Button 5"), gbc);
	}

	public static void main(String[] args) {
		GridBagLayoutExample frame = new GridBagLayoutExample();
		frame.pack();
		frame.setTitle("GridBagLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // center-screen
		frame.setVisible(true);
	}

}