/* 
 * Menu Help >> Eclipse Marketplace... >> Search and install the 'WindowBuilder Current' plugin
 * Right-click project >> New >> Other >> WindowBuilder >> Swing Designer >> JFrame
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class ProductMngtForm extends JFrame {
	private static final long serialVersionUID = 1L;
	
	/* pnlCategory */
	private JTextField tfCatID;
	private JTextField tfCatName;
	private JButton btnCatAdd;
	private JButton btnCatUpdate;
	private JButton btnCatDelete;
	private JTable tblCategory;
	private DefaultTableModel modelCategory;
	
	/* pnlProduct */
	private JTextField tfProdID;
	private JTextField tfProdName;
	private JTextField tfProdPrice;
	private JButton btnProdAdd;
	private JButton btnProdUpdate;
	private JButton btnProdDelete;
	private JTable tblProduct;
	private DefaultTableModel modelProduct;

	public ProductMngtForm() {
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new FlowLayout());
		
		/* pnlCategory */
		JPanel pnlCategory = new JPanel(new GridBagLayout());
		pnlCategory.setBorder(new CompoundBorder(new TitledBorder("Category"), new EmptyBorder(0, 10, 10, 10)));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlCategory.add(new JLabel("ID"), gbc);

		tfCatID = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 0;
		pnlCategory.add(tfCatID, gbc);

		btnCatAdd = new JButton("ADD");
		btnCatAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCatAddClicked();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 0;
		pnlCategory.add(btnCatAdd, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlCategory.add(new JLabel("NAME"), gbc);

		tfCatName = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 1;
		pnlCategory.add(tfCatName, gbc);

		btnCatUpdate = new JButton("UPDATE");
		btnCatUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCatUpdateClicked();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 1;
		pnlCategory.add(btnCatUpdate, gbc);

		btnCatDelete = new JButton("DELETE");
		btnCatDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCatDeleteClicked();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 2;
		pnlCategory.add(btnCatDelete, gbc);

		tblCategory = new JTable();
		tblCategory.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				tblCategorySelected(e);
			}
		});
		JScrollPane scpCustomer = new JScrollPane(tblCategory);
		scpCustomer.setPreferredSize(new java.awt.Dimension(200, 100));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		pnlCategory.add(scpCustomer, gbc);
		
		/* pnlProduct */
		JPanel pnlProduct = new JPanel(new GridBagLayout());
		pnlProduct.setBorder(new CompoundBorder(new TitledBorder("Product"), new EmptyBorder(0, 10, 10, 10)));
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlProduct.add(new JLabel("ID"), gbc);

		tfProdID = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		pnlProduct.add(tfProdID, gbc);

		btnProdAdd = new JButton("ADD");
		btnProdAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnProdAddClicked();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 0;
		pnlProduct.add(btnProdAdd, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlProduct.add(new JLabel("NAME"), gbc);

		tfProdName = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 1;
		pnlProduct.add(tfProdName, gbc);

		btnProdUpdate = new JButton("UPDATE");
		btnProdUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnProdUpdateClicked();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 1;
		pnlProduct.add(btnProdUpdate, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		pnlProduct.add(new JLabel("PRICE"), gbc);

		tfProdPrice = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 2;
		pnlProduct.add(tfProdPrice, gbc);

		btnProdDelete = new JButton("DELETE");
		btnProdDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnProdDeleteClicked();
			}
		});
		gbc.gridx = 2;
		gbc.gridy = 2;
		pnlProduct.add(btnProdDelete, gbc);

		tblProduct = new JTable();
		tblProduct.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				tblProductSelected(e);
			}
		});
		JScrollPane scpProduct = new JScrollPane(tblProduct);
		scpProduct.setPreferredSize(new java.awt.Dimension(300, 100));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		pnlProduct.add(scpProduct, gbc);
		
		/* contentPane */
		contentPane.add(pnlCategory);
		contentPane.add(pnlProduct);
	}
	
	/* pnlCategory */
	private void loadCategoryTable() {
		String[] columnNames = { "ID", "NAME" };
		Object[][] data = { { 1, "Laptop" }, { 2, "Smartphone" }, { 3, "Tablet" } };
		modelCategory = new DefaultTableModel(data, columnNames);
		tblCategory.setModel(modelCategory);
	}
	
	private void tblCategorySelected(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int selectedRow = tblCategory.getSelectedRow();
			if (selectedRow != -1) {
				tfCatID.setText(tblCategory.getValueAt(selectedRow, 0).toString());
				tfCatName.setText(tblCategory.getValueAt(selectedRow, 1).toString());
			}
		}
	}

	private void btnCatAddClicked() {
		String id = tfCatID.getText();
		String name = tfCatName.getText();
		modelCategory.addRow(new Object[] { id, name });
	}

	private void btnCatUpdateClicked() {
		int selectedRow = tblCategory.getSelectedRow();
		if (selectedRow != -1) {
			modelCategory.setValueAt(tfCatName.getText(), selectedRow, 1);
		}
	}

	private void btnCatDeleteClicked() {
		int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (confirm == JOptionPane.YES_OPTION) {
			int selectedRow = tblCategory.getSelectedRow();
			if (selectedRow != -1) {
				modelCategory.removeRow(selectedRow);
			}
		}
	}
	
	/* pnlProduct */
	private void loadProductTable() {
		String[] columnNames = { "ID", "NAME", "PRICE" };
		Object[][] data = { { 1, "Macbook Air", 10 }, { 2, "Macbook Pro", 20 }, { 3, "iPhone X", 30 }, {4, "iPhone Xs", 40}, { 5, "iPhone 11", 50 }, { 6, "iPad Air", 60 }, { 7, "iPad Mini", 70 } };
		modelProduct = new DefaultTableModel(data, columnNames);
		tblProduct.setModel(modelProduct);
	}
	
	private void tblProductSelected(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int selectedRow = tblProduct.getSelectedRow();
			if (selectedRow != -1) {
				tfProdID.setText(tblProduct.getValueAt(selectedRow, 0).toString());
				tfProdName.setText(tblProduct.getValueAt(selectedRow, 1).toString());
				tfProdPrice.setText(tblProduct.getValueAt(selectedRow, 2).toString());
			}
		}
	}
	
	private void btnProdAddClicked() {
		String id = tfProdID.getText();
		String name = tfProdName.getText();
		String price = tfProdPrice.getText();
		modelProduct.addRow(new Object[] { id, name, price });
	}

	private void btnProdUpdateClicked() {
		int selectedRow = tblProduct.getSelectedRow();
		if (selectedRow != -1) {
			modelProduct.setValueAt(tfProdName.getText(), selectedRow, 1);
			modelProduct.setValueAt(tfProdPrice.getText(), selectedRow, 2);
		}
	}

	private void btnProdDeleteClicked() {
		int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (confirm == JOptionPane.YES_OPTION) {
			int selectedRow = tblProduct.getSelectedRow();
			if (selectedRow != -1) {
				modelProduct.removeRow(selectedRow);
			}
		}
	}

	public static void main(String[] args) {
		ProductMngtForm frame = new ProductMngtForm();
		frame.pack();
		frame.setTitle("ProductMngtForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // center-screen
		frame.setVisible(true);
		frame.loadCategoryTable();
		frame.loadProductTable();
	}

}