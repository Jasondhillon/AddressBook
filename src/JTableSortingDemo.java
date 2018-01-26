import java.awt.event.*;

import javax.swing.*;



public class JTableSortingDemo{
	private JTable table;

	public JTableSortingDemo(){
		
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() == 1){
					JTable target = (JTable)e.getSource();
						int row = table.convertRowIndexToModel(target.getSelectedRow());
					StringBuffer sb = new StringBuffer();
					String lineSeparator = ", ";
					sb.append(table.getModel().getValueAt(row, 0) + lineSeparator);
					sb.append(table.getModel().getValueAt(row, 1) + lineSeparator);
					sb.append(table.getModel().getValueAt(row, 2));
					JOptionPane.showMessageDialog(null, sb.toString());
				}
			}
		});
		table.setAutoCreateRowSorter(true);
	}


}

