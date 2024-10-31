package SYSTEM;

import SYSTEM.apparatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import SYSTEM.APPARATUS_TYPE;
import SYSTEM.INCIDENT_TYPE;
import SYSTEM.County;
import SYSTEM.mapquestAPI;

public class incident {
	private apparatus[] assignment;
	private INCIDENT_TYPE type;
	private HashMap<Integer, firehouse> eta;
	private County county;
	private StringBuilder notes;
	private String address;
	private String TG;

	public incident(String type, String address, County county, StringBuilder notes, String TG) {
		this.notes = notes;
		this.county = county;
		this.TG = TG;
		this.address = address;
		this.eta = new HashMap<Integer, firehouse>();
		if (type.equals("box")) {
			apparatus ric = new apparatus(-1, APPARATUS_TYPE.RIC);
			apparatus search = new apparatus(-2, APPARATUS_TYPE.SEARCH);
			this.type = INCIDENT_TYPE.box;
			assignment = new apparatus[9];
			
			for (firehouse fh : this.county.getFH()) {
			    try {
			        int etaInt = mapquestAPI.getETA(fh.getAdd(), address);
			        if (etaInt != -1) { // -1 or another invalid response should be handled
			            eta.put(etaInt, fh);
			        } else {
			            System.out.println("Invalid ETA received for firehouse: " + fh.getAdd());
			        }
			    } catch (Exception e) {
			        System.out.println("Error while retrieving ETA for firehouse: " + fh.getAdd() + " - " + e.getMessage());
			    }
			}
			// start pull process
			// E, T, E, T, SEARCH, E, T, E, RIC
			ArrayList<Integer> sortedKeys = new ArrayList<Integer>(eta.keySet());
			Collections.sort(sortedKeys);
			assignment[4] = ric;
			assignment[7] = search;
			int order = 1;

			for (int etaTime : sortedKeys) {
			    apparatus fde = null;
			   
			    switch (order) {
			        case 1:
			            fde = eta.get(etaTime).pull(APPARATUS_TYPE.E);
			            if (fde != null) assignment[0] = fde;
			            break;
			        case 2:
			            fde = eta.get(etaTime).pull(APPARATUS_TYPE.TK);
			            if (fde != null) assignment[5] = fde;
			            break;
			        case 3:
			            fde = eta.get(etaTime).pull(APPARATUS_TYPE.E);
			            if (fde != null) assignment[1] = fde;
			            break;
			        case 4:
			            fde = eta.get(etaTime).pullSpecial();
			            if (fde != null) assignment[6] = fde;
			            break;
			        case 5:
			            fde = eta.get(etaTime).pull(APPARATUS_TYPE.E);
			            if (fde != null) assignment[2] = fde;
			            break;
			        case 6:
			            fde = eta.get(etaTime).pull(APPARATUS_TYPE.TK);
			            if (fde != null) assignment[8] = fde;
			            break;
			        case 7:
			            fde = eta.get(etaTime).pull(APPARATUS_TYPE.E);
			            if (fde != null) assignment[3] = fde;
			            break;
			    }

			    if (fde != null) {
			        order++;
			    }
			}
			}
		else if(type.equals("piawi")) {
			this.type = INCIDENT_TYPE.piawi;
			assignment = new apparatus[3];
			int order = 1;

			for (firehouse fh : this.county.getFH()) {
			    try {
			        int etaInt = mapquestAPI.getETA(fh.getAdd(), address);
			        if (etaInt != -1) { // -1 or another invalid response should be handled
			            eta.put(etaInt, fh);
			        } else {
			            System.out.println("Invalid ETA received for firehouse: " + fh.getAdd());
			        }
			    } catch (Exception e) {
			        System.out.println("Error while retrieving ETA for firehouse: " + fh.getAdd() + " - " + e.getMessage());
			    }
			}
			
			ArrayList<Integer> sortedKeys = new ArrayList<Integer>(eta.keySet());
			Collections.sort(sortedKeys);
			for (int etaTime : sortedKeys) {
			    apparatus fde = null;
			    switch (order) {
		        case 1:
		            fde = eta.get(etaTime).pull(APPARATUS_TYPE.E);
		            if (fde != null) assignment[0] = fde;
		            break;
		        case 2:
		            fde = eta.get(etaTime).pull(APPARATUS_TYPE.RS);
		            if (fde != null) assignment[1] = fde;
		            break;
		        case 3:
		            fde = eta.get(etaTime).pull(APPARATUS_TYPE.E);
		            if (fde != null) assignment[2] = fde;
		            break;
			    
			    }
			    if (fde != null) {
			        order++;
			    }
			}	
			
		}
		else if(type.equals("serv")) {
			this.type = INCIDENT_TYPE.serv;
			assignment = new apparatus[1];
			int order = 1;

			for (firehouse fh : this.county.getFH()) {
			    try {
			        int etaInt = mapquestAPI.getETA(fh.getAdd(), address);
			        if (etaInt != -1) { // -1 or another invalid response should be handled
			            eta.put(etaInt, fh);
			        } else {
			            System.out.println("Invalid ETA received for firehouse: " + fh.getAdd());
			        }
			    } catch (Exception e) {
			        System.out.println("Error while retrieving ETA for firehouse: " + fh.getAdd() + " - " + e.getMessage());
			    }
			}
			
			ArrayList<Integer> sortedKeys = new ArrayList<Integer>(eta.keySet());
			Collections.sort(sortedKeys);
			for (int etaTime : sortedKeys) {
			    apparatus fde = null;
			    switch (order) {
		        case 1:
		            fde = eta.get(etaTime).pull(APPARATUS_TYPE.E);
		            if (fde != null) assignment[0] = fde;
		            break;
			    
			    }
			    if (fde != null) {
			        order++;
			    }
			}	
			
		}
		
		
		}

	
	public void incUpdate(String notes) {
		this.notes.append("\n" + notes);
	}
	public void printInc() {
		StringBuilder rtrn = new StringBuilder();
		if(this.type.equals(INCIDENT_TYPE.box)) {
			rtrn.append("BOX ALARM: STRUCTURE FIRE" + "\n");
			rtrn.append("Address: " + this.address + "\n");
			rtrn.append("Notes: " + this.notes + "\n");
			rtrn.append("Radio Channel: " + this.TG + "\n");
			rtrn.append("Assignment: " + "\n");
			for(apparatus app: this.assignment) {
				rtrn.append(app.toString() + " ");
				
			}
		}
		else if(this.type.equals(INCIDENT_TYPE.piawi)) {
			rtrn.append("PERSONAL INJURY ACCIDENT WITH ENTRAPMENT" + "\n");
			rtrn.append("Address: " + this.address + "\n");
			rtrn.append("Notes: " + this.notes + "\n");
			rtrn.append("Radio Channel: " + this.TG + "\n");
			rtrn.append("Assignment: " + "\n");
			for(apparatus app: this.assignment) {
				rtrn.append(app.toString() + " ");
				
			}
		}
		else if(this.type.equals(INCIDENT_TYPE.serv)) {
			rtrn.append("SERVICE CALL" + "\n");
			rtrn.append("Address: " + this.address + "\n");
			rtrn.append("Notes: " + this.notes + "\n");
			rtrn.append("Radio Channel: " + this.TG + "\n");
			rtrn.append("Assignment: " + "\n");
			for(apparatus app: this.assignment) {
				rtrn.append(app.toString() + " ");
				
			}
		}
		
		
		
		
		System.out.println(rtrn.toString());
	}
	

}
