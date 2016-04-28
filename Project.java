import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
public class Project extends JFrame implements ActionListener{
   private CourseTableModel tableModel;
   private JTable table;
   private CourseList cList;
   public Project(String title) {
      super(title);
      setBounds(60,60,600,400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JMenuBar menu = new JMenuBar();
      this.setJMenuBar(menu);
      JMenu file = new JMenu("File");
      JMenuItem save = new JMenuItem("Save");
      JMenuItem open = new JMenuItem("Open");
      JMenuItem quit = new JMenuItem("Quit");
      JMenu courses = new JMenu("Courses");
      JMenuItem add = new JMenuItem("Add a Course");
      quit.addActionListener(this);
      add.addActionListener(this);
      open.addActionListener(this);
      save.addActionListener(this);
      menu.add(file);
      file.add(save);
      file.add(open);
      file.add(quit);
      courses.add(add);
      menu.add(courses);
      //////
      cList = new CourseList();
      tableModel = new CourseTableModel(cList);
      table = new JTable(tableModel);
      table.setAutoCreateRowSorter(true);
      JScrollPane scrollPane = new JScrollPane(table);
      scrollPane.setPreferredSize(new Dimension(380,280));
      JPanel panel = new JPanel();
      panel.add(scrollPane);
      add(panel,BorderLayout.CENTER);
   }
   public void actionPerformed(ActionEvent ae){
      String choice = ae.getActionCommand();
      if(choice.equals("Quit")) {
         System.exit(0);
      }
      else if(choice.equals("Save")){
         JFileChooser fileCh = new JFileChooser();
         fileCh.setDialogTitle("Save to File:");
         int saveSelect = fileCh.showSaveDialog(this);
         if (saveSelect == JFileChooser.APPROVE_OPTION) {
            File SaveFile = fileCh.getSelectedFile();
            System.out.println("Save as file: " + SaveFile.getAbsolutePath());

            FileWriter fw = null;
            try {

               fw = new FileWriter(SaveFile);
            }
            catch (IOException e) {
               e.printStackTrace();
               System.exit(1);
            }
            PrintWriter pw = new PrintWriter(fw);
            pw.println(cList.toJSON());
            pw.close();
         }
      }
      else if(choice.equals("Open")) {    //Beginning of Open sequence - JFileChooser
         JFileChooser fileCh = new JFileChooser("./"); //current folder
         ObjectMapper mapper = new ObjectMapper();
         CourseList courses = null;
         int userChoice = fileCh.showOpenDialog(this);
         if (userChoice == JFileChooser.APPROVE_OPTION) {
            String filename = fileCh
               .getSelectedFile()
               .getAbsolutePath();
            try { //beginning of Jackson Parser usage
               courses = mapper.readValue(
                                          new File(filename), CourseList.class);
               cList = courses;
               tableModel = new CourseTableModel(cList);
               table.setModel(tableModel);
            }
            catch (IOException e) {
               e.printStackTrace();
               System.exit(1);
            }
         } //end of Jackson Parser usage
      }// end of Open sequence

      else if(choice.equals("Add a Course")) { //beginning of CourseInput
         CourseInput dlg = new CourseInput(this);
         String[] newCourse = dlg.run();
         if (newCourse[0] != null) {
            String name = newCourse[0];
            String instructor = newCourse[1];
            int crn = Integer.parseInt(newCourse[2]);
            Double credits = Double.parseDouble(newCourse[3]);
            Course new1 = new Course(name,instructor,crn,credits); //needs proper constructor
            cList.add(new1);
            tableModel = new CourseTableModel(cList);
            table.setModel(tableModel);
         }
      }
   }
   public static void main(String[] args) {
      Project myApp = new Project("Project 3");
      myApp.setVisible(true);
   }
}
