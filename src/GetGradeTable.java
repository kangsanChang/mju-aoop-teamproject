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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GetGradeTable extends JPanel {
	public GetGradeTable() throws SQLException {
		this.setLayout(new BorderLayout());
		this.setSize(1000, 800);
		
		JPanel controlPanel = new JPanel(new BorderLayout()); // control area
		JPanel controlButton = new JPanel(); // button area
		JPanel controlSearch = new JPanel(); // searchbox area
		
		JButton btn_changeGrade = new JButton("Grade %");
		JButton btn_changePercent = new JButton("Score %");
		JButton btn_csvExport = new JButton("CSV Export");
		JTextField field_search = new JTextField(20);
		
        // -------------- button set --------------------------
		controlButton.add(btn_changeGrade);
		controlButton.add(btn_changePercent);
		controlButton.add(btn_csvExport);
		controlSearch.add(field_search);	
		controlPanel.add(controlSearch, BorderLayout.WEST);
		controlPanel.add(controlButton, BorderLayout.EAST);
		this.add(controlPanel, BorderLayout.NORTH);
		
		// ----------- DB -------------
		Connection DB = makeConnection();

		String ratiosql = ("SELECT * FROM settings");
		PreparedStatement ratiopstmt = DB.prepareStatement(ratiosql);
		ResultSet ra = ratiopstmt.executeQuery();
		int att = 0; int mid = 0; int fin = 0; int hw = 0; int quiz = 0; int ann = 0; int rep = 0; int etc = 0;
		while(ra.next()) {
				//att = Integer.parseInt(ra.getString("attendratio"));
				mid = Integer.parseInt(ra.getString("midratio"));
				fin = Integer.parseInt(ra.getString("finalratio"));
				hw = Integer.parseInt(ra.getString("hwratio"));
				quiz = Integer.parseInt(ra.getString("quizratio"));
				ann = Integer.parseInt(ra.getString("announcementratio"));
				rep = Integer.parseInt(ra.getString("reportratio"));
				etc = Integer.parseInt(ra.getString("etcratio"));
		}
		String title[] = {"", "attend / "+10, "midExam / "+mid, "finExam / "+fin,
				"HW / "+hw, "QUIZ / "+quiz, "announce / "+ann, 
				"Report / "+rep, "etc / "+etc, "Total", "Grade"};
		String sql = ("SELECT st.name, sc.mid, sc.final, sc.hw, sc.quiz, sc.announcement, sc.report, sc.etc FROM student st, score sc WHERE st.stukey = sc.stukey;");
		PreparedStatement pstmt = DB.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("name   attend   mid   final   hw   quiz   announ  report  etc");
		//String[][] data;
		int rowcount = 0;
		if(rs.last()) {
			rowcount = rs.getRow();
			rs.beforeFirst();
		}
		String data[][] = new String[rowcount][];
		int n = 0;
		while(rs.next()) {
			data[n] = new String[]  {rs.getString(1),"10",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),"100","A+"};
			n++;
		}
//		String attsql = ("SELECT * FROM attendence");
//		PreparedStatement attpstmt = DB.prepareStatement(attsql);
//		ResultSet at = attpstmt.executeQuery();
//		int[] attScore = new int[rowcount];
//		int attcount = 0;
//		while(at.next()) {
//			
//		}
		// --------------- mockup -----------------------------
//        String data[][] = {
//            {"adam","10","20","20","10","10","10","10","10","100","A+"},
//            {"max","10","20","20","10","10","10","10","10","100","A+"},
//            {"john","10","20","20","10","10","10","10","10","100","A+"}
//        };
        // ----------------------------------------------------
        JTable table_score = new JTable(data, title);
        JScrollPane sp = new JScrollPane(table_score);
        
        this.add(sp, BorderLayout.CENTER);
        
        this.setSize(1200, 800);
        this.setVisible(true);
        
        btn_changeGrade.addActionListener(listen_changeGrade);
        btn_changePercent.addActionListener(listen_changePercent);
	}
	
	// ------------------ DB connection --------------------
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
	
	ActionListener listen_changeGrade = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//JOptionPane.showMessageDialog(null, "test !!");
			Button_changeGrade action1 = new Button_changeGrade();
		}
	};
	ActionListener listen_changePercent = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//JOptionPane.showMessageDialog(null, "test !!");
			try {
				Button_changePercent action1 = new Button_changePercent();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
}
