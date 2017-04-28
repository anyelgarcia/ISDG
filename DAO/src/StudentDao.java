
import java.util.List;

public interface StudentDao {
   public List<StudentTransfer> getAllStudents();
   public StudentTransfer getStudent(int id);
   public void updateStudent(StudentTransfer student);
   public void deleteStudent(StudentTransfer student);
}