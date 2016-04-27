import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
public class CourseTableModel extends AbstractTableModel {
   private String[] columnNames = {"name","instructor","courseNumber","credits"};
   private ArrayList<Course> courses;
   public CourseTableModel(CourseList courseList) {
     courses = courseList.getCourses();
   }
   public int getColumnCount() {
      return columnNames.length;
   }
   public int getRowCount() {
      int size;
      if (courses == null) {
         size = 0;
      }
      else {
         size = courses.size();
      }
      return size;
   }
   public Object getValueAt(int row, int col) {
      Object temp = null;
      if (col == 0) {
         temp = courses.get(row).getCourseName();
      }
      else if (col == 1) {
         temp = courses.get(row).getInstructor();
      }
      else if (col == 2) {
         temp = new Integer(courses.get(row).getCrn());
      }
      else if (col == 3) {
         temp = new Double(courses.get(row).getCourseCredit());
      }
      return temp;
   }
   public String getColumnName(int col) {
      return columnNames[col];
   }
   public Class getColumnClass(int col) {
      if (col == 2) {
         return Integer.class;
      }
      else if (col == 3) {
         return Double.class;
      }
      else {
         return String.class;
      }
   }
}
