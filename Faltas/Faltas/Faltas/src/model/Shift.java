package model;

import java.time.LocalTime;
import java.util.Hashtable;

public class Shift {
	
	//private String
	
	public final static int LUNES_N = 0;
	public final static int MARTES_N = 1;
	public final static int MIERCOLES_N = 2;
	public final static int JUEVES_N = 3;
	public final static int VIERNES_N = 4;
	
	public final static String LUNES = "LUNES";
	public final static String MARTES = "MARTES";
	public final static String MIERCOLES = "MIERCOLES";
	public final static String JUEVES = "JUEVES";
	public final static String VIERNES = "VIERNES";
	
	public final static String INCOMPLETO = "INCOMPLETO";
	public final static String TARDE = "TARDE";
	public final static String FALTA = "FALTA";
	public final static String EXCUSA = "EXCUSA";
	public final static String COMPLETO = "COMPLETO";
	public final static String NO_SALE = "NO SALE";
	
	private LocalTime start;

	private LocalTime finish;
	
	private String day;
	
	private String date;
	
	private String state;
	
	private String code;
	
	public Shift(LocalTime start, LocalTime finish, String day, String code) {
		this.start = start;
		this.finish = finish;
		this.day = day;
		state = FALTA;
		this.code = code;
	}
	
	public String toString() {
		String data = "";
		return data;
	}
	

}
