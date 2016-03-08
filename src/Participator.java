import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class Participator {
	protected String name;
	protected int id;
	protected List<Participator> preferenceList = new ArrayList<Participator>();
	public List<Participator> getPreferenceList() {
		return preferenceList;
	}
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	
}
