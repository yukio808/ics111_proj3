import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
public class Project extends JFrame implements ActionListener{
  public Project(String title) {
    super(title);
    setBounds(60,60,600,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JMenuBar menu = new JMenuBar();
    this.setJMenuBar(menu);
    JMenu file = new JMenu("File");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem quit = new JMenuItem("Quit");
    JMenu courses = new JMenu("Courses");
    JMenuItem add = new JMenuItem("Add a Course");
    quit.addActionListener(this);
    add.addActionListener(this);
    open.addActionListener(this);
    menu.add(file);
    file.add(open);
    file.add(quit);
    menu.add(courses);
    courses.add(add);
  }
  public void actionPerformed(ActionEvent ae){
    String choice = ae.getActionCommand();
    if(choice.equals("Quit")) {
      System.exit(0);
    }
    if(choice.equals("File")){

    }
    else if(choice.equals("Open")){

    }

    else if(choice.equals("Add a Course")) {
      CourseInput dlg = new CourseInput(this);
      String[] newCourse = dlg.run();
      if (newCourse[0] != null) {
        //newCourse[0] = name;
        //newCourse[1] = instructor;
        //newCourse[2] = Double.parseDouble(newCourse[2]);
        System.out.println(newCourse[2]);
        //newCourse[3] = Double.parseDouble(newCourse[3]);

        JOptionPane.showMessageDialog(this,
          newCourse[0] + newCourse[1] + newCourse[2] + newCourse[3]);
      }
    }
  }
  public static void main(String[] args) {
    Project myApp = new Project("Project 3");
    myApp.setVisible(true);
  }
}
