import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class EmailForm extends JFrame {
	private static final long serialVersionUID = 1L;

	public EmailForm() {
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10)); // padding(top, left, bottom, right)

		JPanel pnlName = new JPanel(new GridBagLayout());
		pnlName.setBorder(new CompoundBorder(new TitledBorder("Name"), new EmptyBorder(0, 10, 0, 10)));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.EAST; // right-alignment
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlName.add(new JLabel("First name:"), gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		pnlName.add(new JLabel("Last name:"), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlName.add(new JLabel("Title:"), gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		pnlName.add(new JLabel("Nick name:"), gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		pnlName.add(new JLabel("Format:"), gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST; // left-alignment
		gbc.gridx = 1;
		gbc.gridy = 0;
		pnlName.add(new JTextField(10), gbc);
		gbc.gridx = 3;
		gbc.gridy = 0;
		pnlName.add(new JTextField(10), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		pnlName.add(new JTextField(10), gbc);
		gbc.gridx = 3;
		gbc.gridy = 1;
		pnlName.add(new JTextField(10), gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		pnlName.add(new JComboBox<String>(), gbc);

		JPanel pnlEmail = new JPanel(new BorderLayout());
		pnlEmail.setBorder(new CompoundBorder(new TitledBorder("Email"), new EmptyBorder(0, 10, 0, 10)));
		JPanel pnlDetails = new JPanel(new GridBagLayout());
		// pnlDetails.setBorder(new LineBorder(Color.black)); // for DEBUG
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlDetails.add(new JLabel("Email address:"), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		pnlDetails.add(new JTextField(15), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		pnlDetails.add(new JTextArea(10, 15), gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		pnlDetails.add(new JLabel("Mail format:"), gbc);

		JPanel pnlFormat = new JPanel(new FlowLayout(FlowLayout.LEFT));
		// pnlFormat.setBorder(new LineBorder(Color.black)); // for DEBUG
		JRadioButton rbHtml = new JRadioButton("HTML");
		JRadioButton rbPlain = new JRadioButton("Plain");
		JRadioButton rbCustom = new JRadioButton("Custom");
		ButtonGroup group = new ButtonGroup();
		group.add(rbHtml);
		group.add(rbPlain);
		group.add(rbCustom);
		pnlFormat.add(rbHtml);
		pnlFormat.add(rbPlain);
		pnlFormat.add(rbCustom);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		pnlDetails.add(pnlFormat, gbc);

		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new BoxLayout(pnlButtons, BoxLayout.Y_AXIS));
		// pnlButtons.setBorder(new LineBorder(Color.black)); // for DEBUG
		JButton btnAdd = new JButton("Add");
		btnAdd.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnAdd.getPreferredSize().height)); // fill horizontal
		pnlButtons.add(btnAdd);
		JButton btnEdit = new JButton("Edit");
		btnEdit.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnEdit.getPreferredSize().height)); // fill horizontal
		pnlButtons.add(btnEdit);
		JButton btnDelete = new JButton("Delete");
		btnDelete.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnDelete.getPreferredSize().height)); // fill horizontal
		pnlButtons.add(btnDelete);
		JButton btnDefault = new JButton("As Default");
		btnDefault.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnDefault.getPreferredSize().height)); // fill horizontal
		pnlButtons.add(btnDefault);

		pnlEmail.add(pnlDetails, BorderLayout.CENTER);
		pnlEmail.add(pnlButtons, BorderLayout.EAST);

		contentPane.add(pnlName);
		contentPane.add(pnlEmail);
	}

	public static void main(String[] args) {
		EmailForm frame = new EmailForm();
		frame.pack();
		frame.setTitle("EmailForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // center-screen
		frame.setVisible(true);
	}

}