import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Student extends Participator{
public School myschool;
public int[] myRank;
public Student(String name,int schoolnumber,int id){
	this.name=name;
	myRank=new int[schoolnumber+1];
	this.id=id;
}
public void lookForSchool(int i){
	School target=(School) this.preferenceList.get(i);
	System.out.println(name+"向"+target.getName()+"投志愿了！");
	target.addInWaitingList(myRank[target.getId()]);
	
}
public float happiness(){
	return 0;
}
public void setSchool(School school){
	this.myschool=school;
}
public int getId(){
	return id;
}
public List<Participator> createPreferenceList(List<School> schools) {
	Collections.shuffle(schools);
	for(int i=0;i<5;i++){
		this.preferenceList.add(schools.get(i));
	}
	return preferenceList;
}
}
