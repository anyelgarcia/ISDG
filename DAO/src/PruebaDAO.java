
public class PruebaDAO {
	
	   public static void main(String[] args) {
		      StudentDao studentDao = new StudentDaoImpl();

		      //print all students
		      for (StudentTransfer student : studentDao.getAllStudents()) {
		         System.out.println("Student: [ID : " + student.getid() + ", Name : " + student.getName() + " ]");
		      }


		      //update student
		      StudentTransfer student =studentDao.getAllStudents().get(0);
		      student.setName("Michael");
		      studentDao.updateStudent(student);

		      //get the student
		      studentDao.getStudent(0);
		      System.out.println("Student: [ID : " + student.getid() + ", Name : " + student.getName() + " ]");		
		   }
}
