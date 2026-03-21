/* 
 * Menu Help >> Eclipse Marketplace... >> Search and install the 'WindowBuilder Current' plugin
 * Right-click project >> New >> Other >> WindowBuilder >> Swing Designer >> JFrame
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationForm extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextField tfName;
	private JCheckBox ckbGolf;
	private JCheckBox ckbCricket;
	private JCheckBox ckbBadminton;
	private JRadioButton rdbFemale;
	private JRadioButton rdbMale;
	private JTextArea taComments;
	private JButton btnSubmit;
	private JButton btnReset;
	private ButtonGroup bgGender = new ButtonGroup();

	public RegistrationForm() {
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10)); // padding(top, left, bottom, right)
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTHWEST; // top+left-alignment

		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPane.add(new JLabel("Name:"), gbc);

		tfName = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		contentPane.add(tfName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		contentPane.add(new JLabel("Favorite sports:"), gbc);

		JPanel pnlFavorite = new JPanel();
		pnlFavorite.setLayout(new BoxLayout(pnlFavorite, BoxLayout.Y_AXIS));
		ckbCricket = new JCheckBox("Cricket");
		pnlFavorite.add(ckbCricket);
		ckbBadminton = new JCheckBox("Badminton");
		pnlFavorite.add(ckbBadminton);
		ckbGolf = new JCheckBox("Golf");
		pnlFavorite.add(ckbGolf);
		gbc.gridx = 1;
		gbc.gridy = 1;
		contentPane.add(pnlFavorite, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPane.add(new JLabel("Gender:"), gbc);

		JPanel pnlGender = new JPanel();
		pnlGender.setLayout(new BoxLayout(pnlGender, BoxLayout.Y_AXIS));
		rdbMale = new JRadioButton("Male");
		bgGender.add(rdbMale);
		pnlGender.add(rdbMale);
		rdbFemale = new JRadioButton("Female");
		bgGender.add(rdbFemale);
		pnlGender.add(rdbFemale);
		gbc.gridx = 1;
		gbc.gridy = 2;
		contentPane.add(pnlGender, gbc);

		gbc.anchor = GridBagConstraints.WEST; // center+left-alignment
		gbc.gridx = 0;
		gbc.gridy = 3;
		contentPane.add(new JLabel("Comments:"), gbc);

		taComments = new JTextArea(3, 20);
		taComments.setLineWrap(true);
		gbc.gridx = 1;
		gbc.gridy = 3;
		contentPane.add(taComments, gbc);

		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnResetClicked();
			}
		});
		gbc.gridx = 1;
		gbc.gridy = 4;
		contentPane.add(btnReset, gbc);

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSubmitClicked();
			}
		});
		gbc.anchor = GridBagConstraints.EAST; // right-alignment
		gbc.gridx = 0;
		gbc.gridy = 4;
		contentPane.add(btnSubmit, gbc);
	}

	private void btnSubmitClicked() {
		String name = tfName.getText();
		String sports = "";
		if (ckbCricket.isSelected()) {
			sports += "Cricket ";
		}
		if (ckbBadminton.isSelected()) {
			sports += "Badminton ";
		}
		if (ckbGolf.isSelected()) {
			sports += "Golf ";
		}
		String gender = "";
		if (rdbMale.isSelected()) {
			gender = "Male";
		} else if (rdbFemale.isSelected()) {
			gender = "Female";
		}
		String comments = taComments.getText();
		String message = "Name: " + name + "\nFavorite sports: " + sports.toString().trim() + "\nGender: " + gender + "\nComments: " + comments;
		JOptionPane.showMessageDialog(this, message, "Registration Info", JOptionPane.INFORMATION_MESSAGE);
	}

	private void btnResetClicked() {
		tfName.setText("");
		ckbCricket.setSelected(false);
		ckbBadminton.setSelected(false);
		ckbGolf.setSelected(false);
		bgGender.clearSelection();
		taComments.setText("");
	}

	public static void main(String[] args) {
		RegistrationForm frame = new RegistrationForm();
		frame.pack();
		frame.setTitle("RegistrationForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // center-screen
		frame.setVisible(true);
	}

}