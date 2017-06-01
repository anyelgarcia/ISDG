package DIedrAl_Project.negocio.calendario;

import java.io.Serializable;


public class Fecha implements Serializable{
	
	public final static String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};	
	public final static String[] DIAS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	public final static String[] ANOS = {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980"};
	
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

}
