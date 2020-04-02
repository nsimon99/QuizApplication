import java.util.ArrayList;
import java.util.Arrays;


    
class Student
{
  int studentId;
  String studentName;
  String studentUniversity;

  Student(int studentId, String studentName, String studentUniversity)
  {
    this.studentId = studentId;
    this.studentName = studentName;
    this.studentUniversity = studentUniversity;
  }

}


class Results
{
  int resultId;
  int studentId;
  int score;
  String grade;

  Results(int resultId, int studentId, int score, String grade)
  {
    this.resultId = resultId;
    this.studentId = studentId;
    this.score = score;
    this.grade = grade;
  }
}

class Examples {
  Student student1 = new Student(101,"ABC","ABC University");
  Student student2 = new Student(102,"LMN","LMN University");
  Student student3 = new Student(103,"PQR","PQR University");
  Student student4 = new Student(104,"UVW","UVW University");
  Student student5 = new Student(105,"XYZ","ZYZ University");
  ArrayList<Student> s = new ArrayList<Student>(Arrays.asList(student1, student2, student3, student4, student5));

  Results result1 = new Results(111,101,70,"A");
  Results result2 = new Results(222,102,30,"D");
  Results result3 = new Results(333,103,90,"A+");
  Results result4 = new Results(444,104,55,"B");
  Results result5 = new Results(555,105,45,"C");
  ArrayList<Results> r = new ArrayList<Results>(Arrays.asList(result1, result2, result3, result4, result5));

  String topStudentName = getTopStudentName(s,r);
  Examples e = new Examples();
  



static String getTopStudentName(ArrayList<Student> s,  ArrayList<Results> r)
{
  String topStudentName = "";
  int id = 0;

  for(int i = 0; i< r.size(); i = i++ ) {
    int topScore = 0;
    if (r.get(i).score > topScore) {
     id = r.get(i).studentId;
      topScore = r.get(i).score;
    }
    
   
   
  }
  for(Student student: s) {
    if(student.studentId == id) {
      topStudentName = student.studentName;
    }
  }



  return topStudentName;
}



}
