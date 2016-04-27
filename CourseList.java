import java.util.ArrayList;
public class CourseList{
  private ArrayList<Course> courses;
  private int itt;//Incase we need a itterator

  public CourseList(){
    courses = new ArrayList<Course>();
  }

  public void add(Course c){
    courses.add(c);
  }

  public ArrayList <Course> getCourses() {
     return courses;
  }

  public String toString(){
    String temp = "";
    temp += "[";
    for(int i = 0; i < courses.size(); i++){
      temp += courses.get(i).toString();
    }
    temp += "]";
    return temp;
  }

  public String toJSON(){
    String temp = "";
    temp += "{\n";
    temp += "  \"courses\" : [\n";
    for(int i = 0; i < courses.size(); i++){
      if(i == courses.size() - 1){
        temp += "" + courses.get(i).toJSON() + "\n";
      }else{
        temp += "" + courses.get(i).toJSON() + ",\n";
      }
    }
    temp += "   ]\n";
    temp += "}\n";

    return temp;
  }
  public String toXML(){
    String temp = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
    temp += "<courseList>\n";
    for(int i = 0; i < courses.size(); i++){
      temp += "" + courses.get(i).toXML();
    }
    temp += "</courseList>\n";
    return temp;
  }

}
