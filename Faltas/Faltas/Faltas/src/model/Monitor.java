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
	
	public void assistance(String startt, String finishh, int day) {
		String[] sTime = startt.split(":");//tiene la hora de inicio 
		int hourS = Integer.parseInt(sTime[0]);
		int minS = Integer.parseInt(sTime[1]);
		String[] fTime = startt.split(":");//tiene la hora de fin
		int hourF = Integer.parseInt(fTime[0]);
		int minF = Integer.parseInt(fTime[1]);
		
		String sDay = day(day);
		code = sDay+sTime[0];
		
		Shift shift = shifts.get(code);
		if(shift == null) {
			shift = shifts.get(sDay+(++hourS));
			minS = 00;
		}
		LocalTime start = LocalTime.of(hourS, minS);
		LocalTime finish = LocalTime.of(hourF, minF);
		
		boolean finished = false;
		while(!finished) {
			if(shift == null ) {
				if(finish.isBefore(start)) {
					finished = true;
				}else {
					//crear hora
					code = sDay+hourS;
					//corregir finish, casos 
					Shift otherShift = new Shift(start, finish, sDay, code);
				}
			}else {
				shift.setStart(start);
				if(finish.isBefore(shift.getFinish()) || finish.equals(shift.getFinish()) ) {
					shift.setFinish(finish);
					shift.actualizeStatus();
				}
				start = LocalTime.of(++hourS, 00);
				code = sDay+hourS;
				shift = shifts.get(code);
			}
		}
		
		//
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

