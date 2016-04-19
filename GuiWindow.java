import javax.swing.*;
import java.awt.event.*;
class Project3 extends JFrame implements ActionListener {
   public Project3(String title) {
      super(title);
      setBounds(40,40,600,480);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);
      JMenu file = new JMenu("File");
      JMenuItem open = new JMenuItem("Open");
      open.addActionListener(this);
      file.add(open);
      JMenuItem save = new JMenuItem("Save");
      save.addActionListener(this);
      file.add(save);
      JMenuItem quit = new JMenuItem("Quit");
      quit.addActionListener(this);
      file.add(quit);
      menuBar.add(file);
      JMenu view = new JMenu("View");
   }
   public static void main(String[] args) {
      Project3 myApp = new Project3("Project3");
      myApp.setVisible(true);
   }
   public void actionPerformed(ActionEvent ae) {
      String choice = ae.getActionCommand();
      if (choice.equals("Open")) {
         JOptionPane.showMessageDialog(this,"You clicked Open");
      }
      else if (choice.equals("Save")) {
         JOptionPane.showMessageDialog(this,"You clicked Save");
      }
      else if (choice.equals("Quit")) {
         System.exit(0);
      }
   }
}
