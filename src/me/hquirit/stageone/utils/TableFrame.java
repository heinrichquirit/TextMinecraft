package me.hquirit.stageone.utils;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1182392804468502948L;

	private DefaultTableModel model;
	private JTable table;
	
	public TableFrame(String title, DefaultTableModel model, int x, int y, Dimension dim)
	{
		super(title);
		this.model = model;
		table = new JTable(model) {
			
			private static final long serialVersionUID = 6640250866750612022L;

			// Prevent user from editing table data
			public boolean isCellEditable(int row, int column) {                
				return false;
			}
			
		};
		JScrollPane pane = new JScrollPane(table);
		add(pane);
		table.setFillsViewportHeight(true);
		setSize(x, y);
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table.setPreferredScrollableViewportSize(dim);
	}
	
	public void display()	
	{
		setVisible(true);
		table.setVisible(true);
	}
	
	public DefaultTableModel getTableModel()
	{
		return model;
	}
	
	public JTable getJTable()
	{
		return table;
	}
	
}
