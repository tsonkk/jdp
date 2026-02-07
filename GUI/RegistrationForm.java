/* 
 * Menu Help >> Eclipse Marketplace... >> Search and install the 'WindowBuilder Current' plugin
 * Right-click project >> New >> Other >> WindowBuilder >> Swing Designer >> JFrame
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationForm extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField tfName;
	private JLabel lblFavorite;
	private JPanel pnlFavorite;
	private JCheckBox ckbGolf;
	private JCheckBox ckbCricket;
	private JCheckBox ckbBadminton;
	private JLabel lblGender;
	private JPanel pnlGender;
	private JRadioButton rdbFemale;
	private JRadioButton rdbMale;
	private JLabel lblComments;
	private JTextArea taComments;
	private JButton btnSubmit;
	private JButton btnReset;
	private ButtonGroup bgGender = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationForm() {
		setResizable(false);
		setTitle("RegistrationForm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null); // center-screen
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10)); // margin
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{100, 300};
		gbl_contentPane.rowHeights = new int[]{30, 30, 30, 50, 30};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.fill = GridBagConstraints.BOTH;
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		contentPane.add(lblName, gbc_lblName);
		
		tfName = new JTextField();
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.insets = new Insets(0, 0, 5, 0);
		gbc_tfName.fill = GridBagConstraints.BOTH;
		gbc_tfName.gridx = 1;
		gbc_tfName.gridy = 0;
		contentPane.add(tfName, gbc_tfName);
		
		lblFavorite = new JLabel("Favorite sports:");
		lblFavorite.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblFavorite = new GridBagConstraints();
		gbc_lblFavorite.insets = new Insets(0, 0, 5, 5);
		gbc_lblFavorite.fill = GridBagConstraints.BOTH;
		gbc_lblFavorite.gridx = 0;
		gbc_lblFavorite.gridy = 1;
		contentPane.add(lblFavorite, gbc_lblFavorite);
		
		pnlFavorite = new JPanel();
		GridBagConstraints gbc_pnlFavorite = new GridBagConstraints();
		gbc_pnlFavorite.insets = new Insets(0, 0, 5, 0);
		gbc_pnlFavorite.fill = GridBagConstraints.BOTH;
		gbc_pnlFavorite.gridx = 1;
		gbc_pnlFavorite.gridy = 1;
		contentPane.add(pnlFavorite, gbc_pnlFavorite);
		pnlFavorite.setLayout(new GridLayout(0, 1, 0, 0));
		
		ckbCricket = new JCheckBox("Cricket");
		pnlFavorite.add(ckbCricket);
		
		ckbBadminton = new JCheckBox("Badminton");
		pnlFavorite.add(ckbBadminton);
		
		ckbGolf = new JCheckBox("Golf");
		pnlFavorite.add(ckbGolf);
		
		lblGender = new JLabel("Gender:");
		lblGender.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.fill = GridBagConstraints.BOTH;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 0;
		gbc_lblGender.gridy = 2;
		contentPane.add(lblGender, gbc_lblGender);
		
		pnlGender = new JPanel();
		GridBagConstraints gbc_pnlGender = new GridBagConstraints();
		gbc_pnlGender.insets = new Insets(0, 0, 5, 0);
		gbc_pnlGender.fill = GridBagConstraints.BOTH;
		gbc_pnlGender.gridx = 1;
		gbc_pnlGender.gridy = 2;
		contentPane.add(pnlGender, gbc_pnlGender);
		pnlGender.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdbMale = new JRadioButton("Male");
		bgGender.add(rdbMale);
		pnlGender.add(rdbMale);
		
		rdbFemale = new JRadioButton("Female");
		bgGender.add(rdbFemale);
		pnlGender.add(rdbFemale);
		
		lblComments = new JLabel("Comments:");
		GridBagConstraints gbc_lblComments = new GridBagConstraints();
		gbc_lblComments.fill = GridBagConstraints.BOTH;
		gbc_lblComments.insets = new Insets(0, 0, 5, 5);
		gbc_lblComments.gridx = 0;
		gbc_lblComments.gridy = 3;
		contentPane.add(lblComments, gbc_lblComments);
		
		taComments = new JTextArea();
		taComments.setLineWrap(true);
		GridBagConstraints gbc_taComments = new GridBagConstraints();
		gbc_taComments.insets = new Insets(0, 0, 5, 0);
		gbc_taComments.fill = GridBagConstraints.BOTH;
		gbc_taComments.gridx = 1;
		gbc_taComments.gridy = 3;
		contentPane.add(taComments, gbc_taComments);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSubmitClicked();
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.anchor = GridBagConstraints.EAST;
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 0;
		gbc_btnSubmit.gridy = 4;
		contentPane.add(btnSubmit, gbc_btnSubmit);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnResetClicked();
			}
		});
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.anchor = GridBagConstraints.WEST;
		gbc_btnReset.gridx = 1;
		gbc_btnReset.gridy = 4;
		contentPane.add(btnReset, gbc_btnReset);
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
}