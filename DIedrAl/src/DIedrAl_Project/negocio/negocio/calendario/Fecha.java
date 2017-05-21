package DIedrAl_Project.negocio.calendario;


public class Fecha {
	
	public final static String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};	
	public final static String[] DIAS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	public final static String[] ANOS = {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000"};
	
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

    public int getAnyo() {
        return this.anyo;
    }

    void setAnyo(int value) {
        this.anyo = value;
    }

    public int getHora() {
        return this.hora;
    }

    void setHora(int value) {
        this.hora = value;
    }

}
