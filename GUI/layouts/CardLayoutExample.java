import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private CardLayout card = new CardLayout(40, 30);
	private JPanel contentPane;

	public CardLayoutExample() {
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(card);

		JButton jb1 = new JButton("Button 1");
		JButton jb2 = new JButton("Button 2");
		JButton jb3 = new JButton("Button 3");

		contentPane.add(jb1);
		contentPane.add(jb2);
		contentPane.add(jb3);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		card.next(contentPane);
	}

	public static void main(String[] args) {
		CardLayoutExample frame = new CardLayoutExample();
		// frame.pack();
		frame.setSize(300, 300);
		frame.setTitle("CardLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // center-screen
		frame.setVisible(true);
	}

}