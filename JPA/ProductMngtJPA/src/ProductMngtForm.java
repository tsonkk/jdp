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

import daos.CategoryDAO;
import daos.ProductDAO;
import entities.Category;
import entities.Product;
import models.GenericTableModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class ProductMngtForm extends JFrame {
	private static final long serialVersionUID = 1L;
	private int selectedCatID = 0;
	
	/* pnlCategory */
	private JTextField tfCatID;
	private JTextField tfCatName;
	private JButton btnCatAdd;
	private JButton btnCatUpdate;
	private JButton btnCatDelete;
	private JTable tblCategory;
	private GenericTableModel<Category> modelCategory;
	
	/* pnlProduct */
	private JTextField tfProdID;
	private JTextField tfProdName;
	private JTextField tfProdPrice;
	private JButton btnProdAdd;
	private JButton btnProdUpdate;
	private JButton btnProdDelete;
	private JTable tblProduct;
	private GenericTableModel<Product> modelProduct;

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
		try {
			List<Category> cats = CategoryDAO.getAll();
			modelCategory = new GenericTableModel<Category>(cats, columnNames, Category::getId, Category::getName);
			tblCategory.setModel(modelCategory);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void tblCategorySelected(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int selectedRow = tblCategory.getSelectedRow();
			if (selectedRow != -1) {
				selectedCatID = (int) tblCategory.getValueAt(selectedRow, 0);
				/* pnlCategory */
				tfCatID.setText(selectedCatID + "");
				tfCatName.setText(tblCategory.getValueAt(selectedRow, 1).toString());
				/* pnlProduct */
				loadProductTable();
				tfProdID.setText("");
				tfProdName.setText("");
				tfProdPrice.setText("");
			}
		}
	}

	private void btnCatAddClicked() {
		int id = Integer.parseInt(tfCatID.getText());
		String name = tfCatName.getText();
		Category newCat = new Category(id, name);
		try {
			boolean result = CategoryDAO.insert(newCat);
			if (result) {
				List<Category> cats = CategoryDAO.getAll();
				modelCategory.setData(cats);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void btnCatUpdateClicked() {
		int id = Integer.parseInt(tfCatID.getText());
		String name = tfCatName.getText();
		Category newCat = new Category(id, name);
		try {
			boolean result = CategoryDAO.update(newCat);
			if (result) {
				List<Category> cats = CategoryDAO.getAll();
				modelCategory.setData(cats);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void btnCatDeleteClicked() {
		int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (confirm == JOptionPane.YES_OPTION) {
			int id = Integer.parseInt(tfCatID.getText());
			try {
				boolean result = CategoryDAO.delete(id);
				if (result) {
					List<Category> cats = CategoryDAO.getAll();
					modelCategory.setData(cats);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/* pnlProduct */
	private void loadProductTable() {
		String[] columnNames = { "ID", "NAME", "PRICE" };
		try {
			List<Product> prods = ProductDAO.getByCatID(selectedCatID);
			modelProduct = new GenericTableModel<Product>(prods, columnNames, Product::getId, Product::getName, Product::getPrice);
			tblProduct.setModel(modelProduct);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
		int id = Integer.parseInt(tfProdID.getText());
		String name = tfProdName.getText();
		int price = Integer.parseInt(tfProdPrice.getText());
		Product newProd = new Product(id, name, price, selectedCatID);
		try {
			boolean result = ProductDAO.insert(newProd);
			if (result) {
				List<Product> prods = ProductDAO.getByCatID(selectedCatID);
				modelProduct.setData(prods);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void btnProdUpdateClicked() {
		int id = Integer.parseInt(tfProdID.getText());
		String name = tfProdName.getText();
		int price = Integer.parseInt(tfProdPrice.getText());
		Product newProd = new Product(id, name, price, selectedCatID);
		try {
			boolean result = ProductDAO.update(newProd);
			if (result) {
				List<Product> prods = ProductDAO.getByCatID(selectedCatID);
				modelProduct.setData(prods);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void btnProdDeleteClicked() {
		int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (confirm == JOptionPane.YES_OPTION) {
			int id = Integer.parseInt(tfProdID.getText());
			try {
				boolean result = ProductDAO.delete(id);
				if (result) {
					List<Product> prods = ProductDAO.getByCatID(selectedCatID);
					modelProduct.setData(prods);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
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
	}

}