import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Button_changePercent extends JFrame {
	DB_function local_DB = null;
	int[] ratioArray = null;

	public Button_changePercent(DB_function DB) throws SQLException {
		local_DB = DB;
		ratioArray = local_DB.get_ratioArray();
		
		String title[] = {"attend", "midExam", "finExam", "HW", "QUIZ", "conf", "Report", "etc"};
		String data[][] = {
				{Integer.toString(ratioArray[0])
				,Integer.toString(ratioArray[1])
				,Integer.toString(ratioArray[2])
				,Integer.toString(ratioArray[3])
				,Integer.toString(ratioArray[4])
				,Integer.toString(ratioArray[5])
				,Integer.toString(ratioArray[6])
				,Integer.toString(ratioArray[7])}
		};
		JTable table_changeGrade = new JTable(data, title);
		JScrollPane sp = new JScrollPane(table_changeGrade);
		this.add(sp, BorderLayout.CENTER);

		JPanel controlButton = new JPanel(new BorderLayout());
		JButton btn_save = new JButton("SAVE");
		btn_save.addActionListener(listen_save);
		controlButton.add(btn_save, BorderLayout.EAST);
		this.add(controlButton, BorderLayout.SOUTH);
		
		this.setTitle("Change Score Percent");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 120);
		setVisible(true);
	}
	
	ActionListener listen_save = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			for(int i=0; i<8; i++) System.out.println(ratioArray[i]);
		}
	};
}
