import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class CustomerForm extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField tfID;
	private JButton btnAdd;
	private JLabel lblName;
	private JTextField tfName;
	private JButton btnUpdate;
	private JLabel lblAge;
	private JTextField tfAge;
	private JButton btnDelete;
	private JTable tblCustomer;
	private DefaultTableModel modelCustomer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerForm frame = new CustomerForm();
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
	public CustomerForm() {
		setTitle("CustomerForm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 250);
		setLocationRelativeTo(null); // center-screen
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{50, 0, 50};
		gbl_contentPane.rowHeights = new int[]{30, 30, 30, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblID = new JLabel("ID");
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.anchor = GridBagConstraints.EAST;
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 0;
		contentPane.add(lblID, gbc_lblID);
		
		tfID = new JTextField();
		GridBagConstraints gbc_tfID = new GridBagConstraints();
		gbc_tfID.insets = new Insets(0, 0, 5, 5);
		gbc_tfID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfID.gridx = 1;
		gbc_tfID.gridy = 0;
		contentPane.add(tfID, gbc_tfID);
		tfID.setColumns(10);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAddClicked();
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 0;
		contentPane.add(btnAdd, gbc_btnAdd);
		
		lblName = new JLabel("NAME");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		contentPane.add(lblName, gbc_lblName);
		
		tfName = new JTextField();
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.insets = new Insets(0, 0, 5, 5);
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.gridx = 1;
		gbc_tfName.gridy = 1;
		contentPane.add(tfName, gbc_tfName);
		tfName.setColumns(10);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnUpdateClicked();
			}
		});
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.fill = GridBagConstraints.BOTH;
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 0);
		gbc_btnUpdate.gridx = 2;
		gbc_btnUpdate.gridy = 1;
		contentPane.add(btnUpdate, gbc_btnUpdate);
		
		lblAge = new JLabel("AGE");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.EAST;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 2;
		contentPane.add(lblAge, gbc_lblAge);
		
		tfAge = new JTextField();
		GridBagConstraints gbc_tfAge = new GridBagConstraints();
		gbc_tfAge.insets = new Insets(0, 0, 5, 5);
		gbc_tfAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAge.gridx = 1;
		gbc_tfAge.gridy = 2;
		contentPane.add(tfAge, gbc_tfAge);
		tfAge.setColumns(10);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDeleteClicked();
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 2;
		contentPane.add(btnDelete, gbc_btnDelete);
		
		tblCustomer = new JTable();
		tblCustomer.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				tblCustomerSelected(e);
			}
		});
		JScrollPane scpCustomer = new JScrollPane(tblCustomer);
		GridBagConstraints gbc_scpCustomer = new GridBagConstraints();
		gbc_scpCustomer.gridwidth = 3;
		gbc_scpCustomer.fill = GridBagConstraints.BOTH;
		gbc_scpCustomer.gridx = 0;
		gbc_scpCustomer.gridy = 3;
		contentPane.add(scpCustomer, gbc_scpCustomer);
		
		loadTableModel();
	}
	
	private void loadTableModel() {
		String[] columnNames = {"ID", "NAME", "AGE"};
		Object[][] data = {
				{1, "Hồ Đình Khả", 50},
				{2, "Lương An Vinh", 26},
				{3, "Lê Triệu Ngọc Đức", 40},
				{4, "Trần Văn Thắng", 52},
				{5, "Lê Thị Chung", 40},
				{6, "SonKK", 44}
		};
		modelCustomer = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // all-cells
			}
		};
		tblCustomer.setModel(modelCustomer);
	}
	
	private void tblCustomerSelected(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int selectedRow = tblCustomer.getSelectedRow();
			if (selectedRow != -1) {
				tfID.setText(tblCustomer.getValueAt(selectedRow, 0).toString());
				tfName.setText(tblCustomer.getValueAt(selectedRow, 1).toString());
				tfAge.setText(tblCustomer.getValueAt(selectedRow, 2).toString());
			}
		}
	}
	
	private void btnAddClicked() {
		String id = tfID.getText();
		String name = tfName.getText();
		String age = tfAge.getText();
		modelCustomer.addRow(new Object[]{id, name, age});
	}
	
	private void btnUpdateClicked() {
		int selectedRow = tblCustomer.getSelectedRow();
		if (selectedRow != -1) {
			modelCustomer.setValueAt(tfName.getText(), selectedRow, 1);
			modelCustomer.setValueAt(tfAge.getText(), selectedRow, 2);
		}
	}
	
	private void btnDeleteClicked() {
		int selectedRow = tblCustomer.getSelectedRow();
		if (selectedRow != -1) {
			int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (confirm == JOptionPane.YES_OPTION) {
				modelCustomer.removeRow(selectedRow);
			}
		}
	}
}
