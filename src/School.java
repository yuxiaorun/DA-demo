import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class School extends Participator{
	private List<Integer> waitinglist = new ArrayList<Integer>();
	private int slotsnumber;
	public School(String name,int slotsnumber,int id){
		this.name=name;
		this.slotsnumber=slotsnumber;
		this.id=id;
	}
	public List<Student> addmit(){
			   Collections.sort(waitinglist);
			   List<Student> loser=new ArrayList<Student>();
			   while(waitinglist.size()>slotsnumber){
				   Student s=(Student) this.preferenceList.get(waitinglist.get(waitinglist.size()-1));
				   waitinglist.remove(waitinglist.size()-1);
					  System.out.println(name+"Ìß³öÁË"+s.getName());
				   s.setSchool(null);
				   loser.add(s);
			   }
			   for(int i=0;i<waitinglist.size();i++){		  
				   Student s=(Student) this.preferenceList.get(waitinglist.get(i));
					  s.setSchool(this);
				  }
			   System.out.print(name+"µÄwaiting list:");
			   for(int i=0;i<waitinglist.size();i++){			
					  // System.out.println(waitinglist.get(i));
				   System.out.print(this.preferenceList.get(waitinglist.get(i)).getName());
				   
			   }
			   System.out.println();			   
			   return loser;
	}
	public void addInWaitingList(int rank){
		waitinglist.add(rank);
	}
	public int getId(){
		return id;
	}
	public List<Participator> createPreferenceList(
			Collection<? extends Participator> allObjects) {
		preferenceList.addAll(allObjects);
		Collections.shuffle(preferenceList);
		return preferenceList;
	}
}
