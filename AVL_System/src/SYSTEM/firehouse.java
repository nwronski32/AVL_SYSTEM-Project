package SYSTEM;
import java.util.ArrayList;

import SYSTEM.apparatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import SYSTEM.APPARATUS_TYPE;
import SYSTEM.INCIDENT_TYPE;
import SYSTEM.County;
import SYSTEM.mapquestAPI;
import SYSTEM.apparatus;

public class firehouse {
	
	private ArrayList<apparatus> pieces;
	private int crews;
	private String address;
	private int id;

	public firehouse(int id ,int crews, String address) {
		this.pieces = new ArrayList<apparatus>();
		this.id = id;
		this.crews = crews;
		this.address = address;
		
	}
	
	public void addApp(apparatus app) {
		if(app.getUnit() == id) {
			this.pieces.add(app);
			crews++;
		}
	}
	
	
	public String getAdd() {
	return this.address; 
	}
	public int getCrews() {
		return this.crews;
	}
	
	public apparatus pull(APPARATUS_TYPE type) {
		for(apparatus app: this.pieces) {
			if(app.getType().equals(type)&& this.crews > 0) {
				boolean pull = pieces.remove(app);
				if(pull) {
					System.out.println(String.valueOf(app.getType())+ 
							String.valueOf(app.getUnit())+" Dispatched \n");
				}
				this.crews --;
				return app;
				
			}
		}
		return null;
	}
	
	public apparatus pullSpecial() {
		for(apparatus app: this.pieces) {
			if(app.getType().equals(APPARATUS_TYPE.RS)|| app.getType().equals(APPARATUS_TYPE.RE)||app.getType().equals(APPARATUS_TYPE.TK)) {
				boolean pull = pieces.remove(app);
				if(pull) {
					System.out.println(String.valueOf(app.getType())+ 
							String.valueOf(app.getUnit())+" Dispatched \n");
				}
				this.crews --;
				return app;
				
			}
		}
		return null;
	}
	public apparatus pullSquad() {
		for(apparatus app: this.pieces) {
			if(app.getType().equals(APPARATUS_TYPE.RS)|| app.getType().equals(APPARATUS_TYPE.RE)) {
				boolean pull = pieces.remove(app);
				if(pull) {
					System.out.println(String.valueOf(app.getType())+ 
							String.valueOf(app.getUnit())+" Dispatched \n");
				}
				this.crews --;
				return app;
				
			}
		}
		return null;
	}
	
}
