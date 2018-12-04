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
		
		// get total student count
		String countsql = ("SELECT COUNT(stukey) FROM student");
		PreparedStatement pstmts = DB.prepareStatement(countsql);
		ResultSet count = pstmts.executeQuery();
		int rowCount = 0;
		while(count.next()) { rowCount = Integer.parseInt(count.getString(1)); }
		System.out.println(rowCount);
		// DB get cal ratio
		String ratiosql = ("SELECT * FROM cal_ratio_settings;");
		PreparedStatement ratiopstmt = DB.prepareStatement(ratiosql);
		ResultSet ra = ratiopstmt.executeQuery();
		int[] ratioArray = new int[8];
		while(ra.next()) {
			for(int i=0; i<8; i++) {
				ratioArray[i] = ra.getInt(i+1);
				System.out.println(ratioArray[i]);
			}
		}
		String title[] = {"", "attend / "+ratioArray[0], "midExam / "+ratioArray[1], "finExam / "+ratioArray[2],
				"HW / "+ratioArray[3], "QUIZ / "+ratioArray[4], "announce / "+ratioArray[5], 
				"Report / "+ratioArray[6], "etc / "+ratioArray[7], "Total", "Grade"};

		// DB get max ratio
		String maxsql = ("SELECT * FROM max_settings;");
		PreparedStatement maxpstmt = DB.prepareStatement(maxsql);
		ResultSet max = maxpstmt.executeQuery();
		int[] maxArray = new int[8];
		while(max.next()) {
			for(int i=0; i<8; i++) {
				maxArray[i] = max.getInt(i+1);
				System.out.println(maxArray[i]);
			}
		}
		// DB attendance score
		String attsql = ("SELECT * FROM attendance;");
		PreparedStatement attpstmt = DB.prepareStatement(attsql);
		ResultSet at = attpstmt.executeQuery();
		int[] attScore = new int[rowCount];
		int attstudent = 0;
		double attcount = 0;
		String late = "late"; String no = "no"; String ok = "ok";
		while(at.next()) {
			for(int i = 1; i<18; i++) {
				String temp = at.getString(i);
				if(temp == null) {
					attcount += 0.5;
				} else if (temp.equals("late")) {
					attcount += 0.5;
				} else if (temp.equals("ok")) {
					attcount += 1;
				}
			}
			attScore[attstudent] = (int)attcount;
			System.out.println(attScore[attstudent]);
			attstudent ++;
			attcount = 0;
		}
		// DB get score
		String sql = ("SELECT st.name, sc.mid, sc.final, sc.hw, sc.quiz, sc.announcement, sc.report, sc.etc FROM student st, score sc WHERE st.stukey = sc.stukey;");
		PreparedStatement pstmt = DB.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		String data[][] = new String[rowCount][];
		int[] Score = new int[8];
		int totalScore = 0;
		int n = 0;
		while(rs.next()) {
			Score[0] = attScore[n]*ratioArray[0]/maxArray[0];
			System.out.println(attScore[n]);
			System.out.println(ratioArray[0]);
			System.out.println(maxArray[0]);
			
			totalScore += Score[0];
			for(int i=2; i<=8; i++) {
				Score[i-1] = rs.getInt(i)*ratioArray[i-1]/maxArray[i-1];
				totalScore += Score[i-1];
			}
			data[n] = new String[]  {
					rs.getString(1)
					//,Integer.toString(rs.getInt(2)*ratioArray[1]/maxArray[1])
					,Integer.toString(Score[0])
					,Integer.toString(Score[1])
					,Integer.toString(Score[2])
					,Integer.toString(Score[3])
					,Integer.toString(Score[4])
					,Integer.toString(Score[5])
					,Integer.toString(Score[6])
					,Integer.toString(Score[7])
					,Integer.toString(totalScore) 
					,"A+"};
			totalScore = 0;
			n++;
		}
		
        // ----------------------------------------------------
        JTable table_score = new JTable(data, title);
        JScrollPane sp = new JScrollPane(table_score);
        
        this.add(sp, BorderLayout.CENTER);
//        this.setSize(WIDTH, HEIGHT);
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