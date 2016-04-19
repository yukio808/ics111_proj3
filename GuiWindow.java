import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
public class GuiWindow extends JFrame implements ActionListener{
  public GuiWindow(String title){
    super(title);
    setBounds(20,50,200,100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public void setBounds(int tl, int tr, int bl, int br){
    this.setBounds(tl, tr, bl, br);
  }
  public void initMenu(){
    JMenuBar menu = new JMenuBar();
    this.setJMenuBar(menu);
    JMenu file = new JMenu("File");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem quit = new JMenuItem("Quit");
    quit.addActionListener(this);
    menu.add(file);
    menu.add(open);
  }
  public void actionPerformed(ActionEvent ae){
    String choice = ae.getActionCommand();
    if(choice.equals("Quit")) {
      System.exit(0);
    }
    else if(choice.equals("Open")) {

    }
  }
}
