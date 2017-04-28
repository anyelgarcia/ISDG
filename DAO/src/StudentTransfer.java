
public class StudentTransfer {
   private String name;
   private int id;

   StudentTransfer(String name, int id){
      this.name = name;
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getid() {
      return id;
   }

   public void setid(int id) {
      this.id = id;
   }
}