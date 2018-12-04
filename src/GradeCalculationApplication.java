import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GradeCalculationApplication extends JFrame{
	JTabbedPane tab;
	AttendanceTable at;
	
	/* -------------------------- */
	GetGradeTable gt;
	StatisticTable st;
	
	GradeCalculationApplication() throws SQLException{
		tab = new JTabbedPane(JTabbedPane.TOP);
		JPanel attendance = new JPanel();
		JPanel inputScore = new JPanel();
		JPanel getGrade = new JPanel();
		JPanel statistic = new JPanel();
		
		at = new AttendanceTable();
		gt = new GetGradeTable();
		st = new StatisticTable();
		
		// panel 한글 체크
		attendance.add(at);
		getGrade.add(gt);
		statistic.add(st);
		
		tab.addTab("Attend", attendance);
		tab.addTab("Input", inputScore);
		tab.addTab("Grade", getGrade);
		tab.addTab("Static", statistic);
		
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(tab);
		setTitle("project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(1000, 600);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) throws SQLException {
		new GradeCalculationApplication();
	}

}
