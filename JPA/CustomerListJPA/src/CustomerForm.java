/* 
 * Menu Help >> Eclipse Marketplace... >> Search and install the 'WindowBuilder Current' plugin
 * Right-click project >> New >> Other >> WindowBuilder >> Swing Designer >> JFrame
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import daos.CustomerDAO;
import entities.Customer;
import models.GenericTableModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class CustomerForm extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextField tfID;
	private JButton btnAdd;
	private JTextField tfName;
	private JButton btnUpdate;
	private JTextField tfAge;
	private JButton btnDelete;
	private JTable tblCustomer;
	private GenericTableModel<Customer> modelCustomer;

	public CustomerForm() {
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPane.add(new JLabel("ID"), gbc);

		tfID = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		contentPane.add(tfID, gbc);

		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAddClicked();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 0;
		contentPane.add(btnAdd, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		contentPane.add(new JLabel("NAME"), gbc);

		tfName = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 1;
		contentPane.add(tfName, gbc);

		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnUpdateClicked();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 1;
		contentPane.add(btnUpdate, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPane.add(new JLabel("AGE"), gbc);

		tfAge = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 2;
		contentPane.add(tfAge, gbc);

		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDeleteClicked();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 2;
		contentPane.add(btnDelete, gbc);

		tblCustomer = new JTable();
		tblCustomer.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				tblCustomerSelected(e);
			}
		});
		JScrollPane scpCustomer = new JScrollPane(tblCustomer);
		scpCustomer.setPreferredSize(new java.awt.Dimension(300, 100));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		contentPane.add(scpCustomer, gbc);
	}

	private void loadCustomerTable() {
		String[] columnNames = { "ID", "NAME", "AGE" };
		try {
			List<Customer> custs = CustomerDAO.getAll();
			modelCustomer = new GenericTableModel<Customer>(custs, columnNames, Customer::getId, Customer::getName, Customer::getAge);
			tblCustomer.setModel(modelCustomer);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
		int id = Integer.parseInt(tfID.getText());
		String name = tfName.getText();
		int age = Integer.parseInt(tfAge.getText());
		Customer newCust = new Customer(id, name, age);
		try {
			boolean result = CustomerDAO.insert(newCust);
			if (result) {
				List<Customer> custs = CustomerDAO.getAll();
				modelCustomer.setData(custs);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void btnUpdateClicked() {
		int id = Integer.parseInt(tfID.getText());
		String name = tfName.getText();
		int age = Integer.parseInt(tfAge.getText());
		Customer newCust = new Customer(id, name, age);
		try {
			boolean result = CustomerDAO.update(newCust);
			if (result) {
				List<Customer> custs = CustomerDAO.getAll();
				modelCustomer.setData(custs);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void btnDeleteClicked() {
		int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (confirm == JOptionPane.YES_OPTION) {
			int id = Integer.parseInt(tfID.getText());
			try {
				boolean result = CustomerDAO.delete(id);
				if (result) {
					List<Customer> custs = CustomerDAO.getAll();
					modelCustomer.setData(custs);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		CustomerForm frame = new CustomerForm();
		frame.pack();
		frame.setTitle("CustomerForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // center-screen
		frame.setVisible(true);
		frame.loadCustomerTable();
	}

}