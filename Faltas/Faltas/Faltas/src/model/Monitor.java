package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Monitor {
	
	//turnos asigandos
	private Hashtable<String, Shift> shifts;
	
	private String name;
	private String code;
	//private Stirng 
	
	//private List<Shift> shifts;
	
	public Monitor(String name, String code) {
		shifts = new Hashtable<String, Shift>();
		this.name = name;
		this.code = code;
	}
	
	public void newShift(String startt, String day) {
		String[] sTime = startt.split(":");
		code = day+sTime[0];
		LocalTime start = LocalTime.of(Integer.parseInt(sTime[0]), Integer.parseInt(sTime[1]));
		LocalTime finish = LocalTime.of(Integer.parseInt(sTime[0]), 59);
		Shift shift = new Shift(start, finish, day, code);
		shifts.put(code, shift);
	}
	
	public Hashtable<String, Shift> getTurnos() {
		return shifts;
	}
	
	public void addShift(String start, String finish, int day) {
		String[] sTime = start.split(":");
		code = day+sTime[0];
		String key = "";
		if(day == Shift.LUNES_N) {
			key = Shift.LUNES+sTime[0];
		}else if( day == Shift.MARTES_N) {
			
		}else if( day == Shift.MIERCOLES_N) {
			
		}else if( day == Shift.JUEVES_N) {
			
		}else {
			
		}
		Shift shift = shifts.get(key);
		if(shift == null) {
			newShift(start, day(day));
			
		}
	}
	
	public String day(int day) {
		String sDay = "";
		if(day == Shift.LUNES_N) {
			sDay = Shift.LUNES;
		}else if( day == Shift.MARTES_N) {
			sDay = Shift.MARTES;
		}else if( day == Shift.MIERCOLES_N) {
			sDay = Shift.MIERCOLES;
		}else if( day == Shift.JUEVES_N) {
			sDay = Shift.JUEVES;
		}else {
			sDay = Shift.VIERNES;
		}
		return sDay;
	}
	
}

