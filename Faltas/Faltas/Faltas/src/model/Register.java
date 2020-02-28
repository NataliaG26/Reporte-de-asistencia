package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Hashtable;

public class Register {
	
	private Hashtable<String, Monitor> monitores;
	
	public final static String DATABASE = "";

	//private String assistance;
	
	
	public Register() {
		monitores = new Hashtable<String, Monitor>();
		readInfoMonitores();
		readSchedule();
		//readAssistance();
		//toStringAssistance();
	}
	
	private void readInfoMonitores() {
		BufferedReader br = null;
	      try {
	         br =new BufferedReader(new FileReader(DATABASE));	         
	         String line = br.readLine();
	         String [] fields = line.split(";");
	         line = br.readLine();
	         while (!line.contains("*")) {
	            //leer 
	        	 fields = line.split(";");
	        	 //apodo - code - name
	        	 Monitor monitor = new Monitor(fields[2], fields[1]);
	        	 monitores.put(fields[1], monitor);
	         }
	         
	         br.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.out.println("error");
	      }
	}
	
	private void readSchedule() {
		BufferedReader br = null;
	      try {
	         br =new BufferedReader(new FileReader(DATABASE));	         
	         String line = br.readLine();
	         String [] fields = null; 
	         Monitor monitor = null;
	         while (!line.contains("*")) {
	            //leer 
	        	 //agregar turno monitor
	        	 //0 hora de inicio - 1 L - 2 M - 3 M - 4 J - 5 V
	        	 fields = line.split(";"); 
	        	 //Lunes
	        	 monitor = monitores.get(fields[1]);
	        	 if(monitor != null) {
	        		 monitor.newShift(fields[0], Shift.LUNES);
	        	 }
	        	 monitor = monitores.get(fields[2]);
	        	 if(monitor != null) {
	        		 monitor.newShift(fields[0], Shift.MARTES);
	        	 }
	        	 monitor = monitores.get(fields[3]);
	        	 if(monitor != null) {
	        		 monitor.newShift(fields[0], Shift.MIERCOLES);
	        	 }
	        	 monitor = monitores.get(fields[4]);
	        	 if(monitor != null) {
	        		 monitor.newShift(fields[0], Shift.JUEVES);
	        	 }
	        	 monitor = monitores.get(fields[5]);
	        	 if(monitor != null) {
	        		 monitor.newShift(fields[0], Shift.VIERNES);
	        	 }
	         }
	         
	         br.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.out.println("error");
	      }
	}
	
	public void readAssistance(String assistance) {
		BufferedReader br = null;
	      try {
	         br =new BufferedReader(new FileReader(assistance));	         
	         String line = br.readLine();
	         String [] fields = null;
	         Monitor monitor = null;
	         while (!line.contains("*")) {
	        	 fields = line.split(";");
	            //leer 
	        	//agregar asistencia
	        	 //verificar 
	        	 // 0 Fecha - 1 Dia - 2 Código - 3 Nombre - 4 Hora inicio - 5 Hora final
	        	 monitor = monitores.get(fields[2]);
	        	 monitor.addShift(fields[4], fields[5], Integer.parseInt(fields[1]));

	         }
	         
	         br.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.out.println("error");
	      }
	}
	
	public void toStringAssistance(String fileName) {
		try {
			File f = new File(fileName);
			PrintWriter exitCSV = new PrintWriter(f);
			
			exitCSV.write("");
			exitCSV.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Hashtable<String, Monitor> getMonitores() {
		return monitores;
	}

}
