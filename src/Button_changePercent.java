import java.awt.BorderLayout;
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
	public Button_changePercent() throws SQLException {
		Connection DB = makeConnection();
		
		String ratiosql = ("SELECT * FROM cal_ratio_settings");
		PreparedStatement ratiopstmt = DB.prepareStatement(ratiosql);
		ResultSet ra = ratiopstmt.executeQuery();
				while(ra.next()) {		
				String att = ra.getString("attendratio");
				String mid = ra.getString("midratio");
				String fin = ra.getString("finalratio");
				String hw = ra.getString("hwratio");
				String quiz = ra.getString("quizratio");
				String ann = ra.getString("announcementratio");
				String rep = ra.getString("reportratio");
				String etc = ra.getString("etcratio");
				
				String title[] = {"attend", "midExam", "finExam", "HW", "QUIZ", "conf", "Report", "etc"};
				String data[][] = {
						{att,mid,fin,hw,quiz,ann,rep,etc}
				};
				JTable table_changeGrade = new JTable(data, title);
				JScrollPane sp = new JScrollPane(table_changeGrade);
				this.add(sp, BorderLayout.CENTER);
		}
	
		JPanel controlButton = new JPanel(new BorderLayout());
		JButton btn_save = new JButton("SAVE");
		controlButton.add(btn_save, BorderLayout.EAST);
		this.add(controlButton, BorderLayout.SOUTH);
		
		this.setTitle("Change Score Percent");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 120);
		setVisible(true);
	}
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost/aoop_project?characterEncoding=UTF-8&serverTimezone=UTC";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("database connecting....");
			con = DriverManager.getConnection(url, "root", "pass");
			System.out.println("connection success !!");
		} catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch(SQLException ex) {
			System.out.println("SQL Exception : " + ex.getMessage());
		}
		return con;
	}
}
