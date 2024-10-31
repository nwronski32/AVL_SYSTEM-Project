package SYSTEM;
import SYSTEM.APPARATUS_TYPE;
import SYSTEM.firehouse;


public class apparatus {

	private int unit;
	private APPARATUS_TYPE type;
	
	
	
	public apparatus(Integer unit, APPARATUS_TYPE type) {
		if(type == APPARATUS_TYPE.RIC) {
			this.unit = -1;
			this.type = type;
			
		}
		else if(type == APPARATUS_TYPE.SEARCH) {
			this.unit = -2;
			this.type = type;
		}
		else {
		
		this.unit = unit;
		this.type = type;
		}
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		if(this.getType() == APPARATUS_TYPE.E) {
			str.append("E");
			str.append(String.valueOf(this.getUnit()));
			return str.toString();
		}
		else if(this.getType() == APPARATUS_TYPE.TK) {
			str.append("TK");
			str.append(String.valueOf(this.getUnit()));
			return str.toString();
		}
		else if(this.getType() == APPARATUS_TYPE.RS) {
			str.append("RS");
			str.append(String.valueOf(this.getUnit()));
			return str.toString();
		}
		else if(this.getType() == APPARATUS_TYPE.RE) {
			str.append("RE");
			str.append(String.valueOf(this.getUnit()));
			return str.toString();
		}
		else if(this.getType() == APPARATUS_TYPE.RIC) {
			str.append("RIC");
			return str.toString();
		}
		else if(this.getType() == APPARATUS_TYPE.SEARCH) {
			str.append("SEARCH");
			return str.toString();
		}
		else {return null;}
	}
	
	
	
	public APPARATUS_TYPE getType() {
		return this.type;
	}
	
	public int getUnit() {
		return this.unit;
	}
	
	

}
