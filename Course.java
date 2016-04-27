public class Course{
  private String name;
  private String instructor;
  private int courseNumber;
  private double credit;

  public Course(String n, String ins, int crn, double crd) {
    name = n;
    instructor = ins;
    courseNumber = crn;
    credit = crd;
  }
  public Course(){
    this("","",0,0.0);
  }

  public String getCourseName() {
    return name;
  }

  public String getInstructor() {
    return instructor;
  }

  public int getCrn() {
    return courseNumber;
  }

  public double getCourseCredit() {
    return credit;
  }

  public void setName(String n){
    name = n.trim();
    if(name.equalsIgnoreCase("")){
      name = "N/A";
    }
  }
  public void setInstructor(String ins){
    instructor = ins.trim();
    if(instructor.equalsIgnoreCase("")){
      instructor = "N/A";
    }
  }
  public void setCourseNumber(int crn){
    courseNumber = crn;
    if(courseNumber < 0){
      courseNumber = 0;
    }
  }
  public void setCredit(double crdt){
    credit = crdt;
    if(credit < 0){
      credit = 0.0;
    }
  }

  public String toString(){
    String temp = "";
    temp += name + ", ";
    temp += instructor + ", ";
    temp += courseNumber + ", ";
    temp += credit;
    return temp;
  }

  public String toJSON(){
    String temp = "";
    temp += "      {\n";
    temp += "        \"name\" : \"" + name + "\",\n";
    temp += "        \"instructor\" : \"" + instructor + "\",\n";
    temp += "        \"courseNumber\" : " + courseNumber + ",\n";
    temp += "        \"credit\" : " + credit + "\n";
    temp += "      }";
    return temp;
  }
  public String toXML(){
    String temp = "";
    temp += "   <course>\n";
    temp += "       <name>" + name + "</name>\n";
    temp += "       <instructor>" + instructor + "</instructor>\n";
    temp += "       <courseNumber>" + courseNumber + "</courseNumber>\n";
    temp += "       <credit>" + credit + "</credit>\n";
    temp += "   </course>\n";
    return temp;
  }

}
