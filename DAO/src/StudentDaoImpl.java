
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
	
   //list is working as a database
   List<StudentTransfer> students;

   public StudentDaoImpl(){
      students = new ArrayList<StudentTransfer>();
      StudentTransfer student1 = new StudentTransfer("Robert",0);
      StudentTransfer student2 = new StudentTransfer("John",1);
      students.add(student1);
      students.add(student2);		
   }
   @Override
   public void deleteStudent(StudentTransfer student) {
      students.remove(student.getid());
      System.out.println("Student: id " + student.getid() + ", deleted from database");
   }

   //retrive list of students from the database
   @Override
   public List<StudentTransfer> getAllStudents() {
      return students;
   }

   @Override
   public StudentTransfer getStudent(int rollNo) {
      return students.get(rollNo);
   }

   @Override
   public void updateStudent(StudentTransfer student) {
      students.get(student.getid()).setName(student.getName());
      System.out.println("Student: id " + student.getid() + ", updated in the database");
   }
}