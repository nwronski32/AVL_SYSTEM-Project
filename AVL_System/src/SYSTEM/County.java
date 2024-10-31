package SYSTEM;
import SYSTEM.firehouse;
import java.util.ArrayList;

public class County {

	private ArrayList<firehouse> firehouses;
	
	public County() {
	this.firehouses = new ArrayList<firehouse>();
	}
	
	public ArrayList<firehouse> getFH(){
		return this.firehouses;
	}
	
	public void addFh(firehouse fh) {
		this.firehouses.add(fh);
	}
}
