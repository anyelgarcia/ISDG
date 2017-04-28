public class Configurador {
	//un configurador Singleton de una aplicación
	 
 private String url;
 private String baseDatos;
 private static Configurador instancia=null;
 
 public static Configurador getInstancia(String url,String baseDatos) {
  if (instancia==null) 
      	 instancia=new Configurador(url,baseDatos); 
 return instancia;
 }
 
 private Configurador(String url,String baseDatos){
    this.url=url;
    this.baseDatos=baseDatos;
 }
 
public String getUrl() {
 return url;
 }
 
public void setUrl(String url) {
 this.url = url;
 }
 
public String getBaseDatos() {
 return baseDatos;
 }
 
public void setBaseDatos(String baseDatos) {
 this.baseDatos = baseDatos;
 }
}




