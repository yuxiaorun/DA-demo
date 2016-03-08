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
		schools=factory.createSchool("学校");
		students=factory.createStudents("学生");
		 Random random = new Random();
		for(School s : schools){
			s.createPreferenceList(students);
			for(int i=0;i<s.getPreferenceList().size();i++){
			Student stu=(Student) s.getPreferenceList().get(i);
			stu.myRank[s.getId()]=i;
			//System.out.println(stu.name+"rank["+s.getId()+"]"+stu.myRank[s.getId()]);
			}
			System.out.println(s.getName()+"偏好:");
			for(Participator st:s.getPreferenceList()){
				System.out.print(st.getName()+",");
			}
			System.out.println();
		}
		for(Student s:students){
			s.createPreferenceList(schools);
			System.out.println(s.getName()+"偏好:");
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
			System.out.println("------------第"+(i+1)+"轮------------");
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
		System.out.println(m.getStudents().get(2).getName()+"学校"+m.getStudents().get(2).myschool.getName());
	}	
}
