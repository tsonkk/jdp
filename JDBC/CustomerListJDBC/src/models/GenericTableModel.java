package models;

import java.util.List;
import java.util.function.Function;

import javax.swing.table.AbstractTableModel;

public class GenericTableModel<T> extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	private List<T> data;
	private String[] columnNames;
	private Function<T, Object>[] columnExtractors;

	@SafeVarargs
	public GenericTableModel(List<T> data, String[] columnNames, Function<T, Object>... extractors) {
		this.data = data;
		this.columnNames = columnNames;
		this.columnExtractors = extractors;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int row, int col) {
		return columnExtractors[col].apply(data.get(row));
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	public void setData(List<T> data) {
		this.data = data;
		fireTableDataChanged();
	}
	
}