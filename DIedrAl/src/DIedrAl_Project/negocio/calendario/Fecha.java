package DIedrAl_Project.negocio.calendario;

import java.io.Serializable;


public class Fecha implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -494027824297485536L;
	public final static String[] MESES = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};	
	public final static String[] DIAS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	public final static String[] AÑOS = {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980",  "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950",  "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920",  "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910"};
	
	private int dia;
    private String mes;
    private int anyo;
    private int hora;
    
    public Fecha(int dia, String mes, int anyo, int hora) {
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
		this.hora = hora;
	}

	public int getDia() {
        return this.dia;
    }

    void setDia(int value) {
        this.dia = value;
    }

    public String getMes() {
        return this.mes;
    }

    void setMes(String value) {
        this.mes = value;
    }

    public int getAño() {
        return this.anyo;
    }
    
    public int getMesIndex(){
    	for(int i=0; i<12; i++){
    		if(MESES[i].equals(mes))
    			return i;
    	}
    	return -1;
    }

    void setAño(int value) {
        this.anyo = value;
    }

    public int getHora() {
        return this.hora;
    }

    void setHora(int value) {
        this.hora = value;
    }
    
   public String toString(){
	   return dia + "-" + mes + "-" + anyo + "-" + hora;
   }

}
