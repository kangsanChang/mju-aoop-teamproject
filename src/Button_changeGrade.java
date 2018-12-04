import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Button_changeGrade extends JFrame {
	public Button_changeGrade() {
		int Ap = 15;
		int A = 15;
		int Bp = 15;
		int B = 15;
		int Cp = 15;
		int C = 15;
		int D = 5;
		int F = 5;
		String strAp = Integer.toString(Ap);
		String strA = Integer.toString(A);
		String strBp = Integer.toString(Bp);
		String strB = Integer.toString(B);
		String strCp = Integer.toString(Cp);
		String strC = Integer.toString(C);
		String strD = Integer.toString(D);
		String strF = Integer.toString(F);
		// test
		//int intAp = Integer.parseInt(Ap);
		
		String title[] = {"A+", "A", "B+", "B", "C+", "C", "D", "F"};
		String data[][] = {
				{strAp, strA, strBp, strB, strCp, strC, strD, strF}
		};
		JTable table_changeGrade = new JTable(data, title);
		JScrollPane sp = new JScrollPane(table_changeGrade);
		this.add(sp, BorderLayout.CENTER);
		
		
		JPanel controlButton = new JPanel(new BorderLayout());
		JButton btn_save = new JButton("SAVE");
		controlButton.add(btn_save, BorderLayout.EAST);
		this.add(controlButton, BorderLayout.SOUTH);
		
		this.setTitle("Change Grade Percent");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 120);
		setVisible(true);
		
		
		ActionListener listen_save = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value = table_changeGrade.getModel().getValueAt(0, 0).toString();
			}
		};
	}
}
