package me.hquirit.stageone.utils;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DataTable extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8312871814769426636L;
	
	private JTable table;
	private JScrollPane jScroll;
	private String[] columns;
	private Object[][] data;
	
	public DataTable(Object[][] data, String[] columns, int x, int y) 
	{
		setLayout(new FlowLayout());
		this.columns = columns;
		this.data = data;
		table = new JTable(data, columns) {

			private static final long serialVersionUID = 6640250866750612022L;

			// Prevent user from editing table data
			public boolean isCellEditable(int row, int column) 
			{                
				return false;
			}
			
		};
		
		setSize(x, y);
		table.setFillsViewportHeight(true);
		jScroll = new JScrollPane(table);
		add(jScroll);
	}
	
	public void display(String title, int x, int y)	
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table.setPreferredScrollableViewportSize(new Dimension(x, y));
		setResizable(false);
		// Center window
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle(title);
	}
	
	public String[] getColumns()
	{
		return columns;
	}
	
	public Object[][] getData()
	{
		return data;
	}
	
}
