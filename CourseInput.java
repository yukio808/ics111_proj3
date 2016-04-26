import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Frame;
import java.awt.Point;
public class CourseInput extends JDialog implements ActionListener {
   private String[] newCourse;
   private JTextField teachBox;
   private JTextField courseBox;
   private JTextField crnBox;
   private JComboBox creditList;
   private JButton btnOk;
   private JButton btnCancel;
   public CourseInput(Frame parent) {
      super(parent,"Add a Course",true);
      Point loc = parent.getLocation();
      setLocation(loc.x+80,loc.y+80);
      newCourse = new String[4]; // set to amount of data items
      JPanel panel = new JPanel();
      panel.setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(2,2,2,2);
      JLabel courseLabel = new JLabel("Enter course below:");
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridx = 0;
      gbc.gridy = 0;
      panel.add(courseLabel,gbc);
      courseBox = new JTextField(20);
      gbc.gridwidth = 2;
      gbc.gridx = 0;
      gbc.gridy = 1;
      panel.add(courseBox,gbc);
      JLabel teachLabel = new JLabel("Instructor:");
      gbc.gridx = 0;
      gbc.gridy = 2;
      panel.add(teachLabel,gbc);
      teachBox = new JTextField(30);
      gbc.gridwidth = 2;
      gbc.gridx = 0;
      gbc.gridy = 3;
      panel.add(teachBox,gbc);
      JLabel crnLabel = new JLabel("CRN:");//inprog
      gbc.gridwidth = 2;
      gbc.gridx = 0;
      gbc.gridy = 4;
      panel.add(crnLabel,gbc);
      crnBox = new JTextField(30);
      gbc.gridwidth = 1;
      gbc.gridx = 0;
      gbc.gridy = 5;
      panel.add(crnBox,gbc);
      JLabel creditLabel = new JLabel("Enter credits:");
      gbc.gridwidth = 1;
      gbc.gridx = 0;
      gbc.gridy = 6;
      panel.add(creditLabel,gbc);
      String[] creditString = {"1","2","3","4","5"};
      creditList = new JComboBox(creditString);
      gbc.gridwidth = 1;
      gbc.gridx = 0;
      gbc.gridy = 7;
      panel.add(creditList,gbc);
      JLabel spacer = new JLabel(" ");
      gbc.gridx = 0;
      gbc.gridy = 8;
      panel.add(spacer,gbc);
      btnOk = new JButton("Ok");
      btnOk.addActionListener(this);
      gbc.gridwidth = 1;
      gbc.gridx = 0;
      gbc.gridy = 9;
      panel.add(btnOk,gbc);
      btnCancel = new JButton("Cancel");
      btnCancel.addActionListener(this);
      gbc.gridx = 0;
      gbc.gridy = 10;
      panel.add(btnCancel,gbc);
      getContentPane().add(panel);
      pack();
   }
   public void actionPerformed(ActionEvent ae) {
      Object source = ae.getSource();
      if (source == btnOk) {
         newCourse[0] = courseBox.getText();
         newCourse[1] = teachBox.getText();
         newCourse[2] = crnBox.getText();
         newCourse[3] = (String)creditList.getSelectedItem();
      }
      else {
         newCourse[0] = null;
      }
      dispose();
   }
   public String[] run() {
      this.setVisible(true);
      return newCourse;
   }
}
