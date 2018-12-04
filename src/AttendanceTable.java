import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AttendanceTable extends JPanel {
	public AttendanceTable(){
        String title[] = {"title #1", "title #2", "title #3"};
        String data[][] = {
            {"1","adam", "26"},
            {"2","baba", "25"},
            {"3","challot", "26"}
        };
        // �뀒�씠釉� �깮�꽦
        JTable table = new JTable(data, title);
        JScrollPane sp = new JScrollPane(table);
       add(sp);
    }
}
