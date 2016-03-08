import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Match {
	private List<Student> students;
	private List<School> schools;
	private List<Student> losers;
	protected ParticipatorFactory factory = new ParticipatorFactory();
	public List<Student> getStudents(){
		return students;
	}
	public List<School> getSchools(){
		return schools;
	}
	public void initiate(int stunum,int schnum){
		ParticipatorFactory.SCH_NUM=schnum;
		ParticipatorFactory.STU_NUM=stunum;
		schools=factory.createSchool("ѧУ");
		students=factory.createStudents("ѧ��");
		 Random random = new Random();
		for(School s : schools){
			s.createPreferenceList(students);
			for(int i=0;i<s.getPreferenceList().size();i++){
			Student stu=(Student) s.getPreferenceList().get(i);
			stu.myRank[s.getId()]=i;
			//System.out.println(stu.name+"rank["+s.getId()+"]"+stu.myRank[s.getId()]);
			}
			System.out.println(s.getName()+"ƫ��:");
			for(Participator st:s.getPreferenceList()){
				System.out.print(st.getName()+",");
			}
			System.out.println();
		}
		for(Student s:students){
			s.createPreferenceList(schools);
			System.out.println(s.getName()+"ƫ��:");
			for(Participator st:s.getPreferenceList()){
				System.out.print(st.getName()+",");
			}
			System.out.println();
		}
		run();
	}
	public void run(){
		List<Student> t=students;
		for(int i=0;i<5;i++){
			System.out.println("------------��"+(i+1)+"��------------");
		for(Student s:t){
			s.lookForSchool(i);
		}
		List<Student> losers=new ArrayList<Student>();
		for(int j=0;j<schools.size();j++){
			losers.addAll(schools.get(j).addmit());
		}
		t=losers;
		}
	}
	public static void main(String[] args) {
		Match m= new Match();
		m.initiate(100, 5);
		System.out.println(m.getStudents().get(2).getName()+"ѧУ"+m.getStudents().get(2).myschool.getName());
	}	
}
