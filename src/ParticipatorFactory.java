import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParticipatorFactory {
	static int STU_NUM = 6;
	static int SCH_NUM = 3;
    public List<Student> createStudents(String name){
    	List<Student> students=new ArrayList<Student>();
    	 Random random = new Random();
    	for(int i=1;i<=STU_NUM;i++){
    		Student s=new Student(name+i,SCH_NUM,i);
    		students.add(s);
    	}
    	return students;
    }
    public List<School> createSchool(String name){
    	List<School> schools=new ArrayList<School>();
    	for(int i=1;i<=SCH_NUM;i++){
    		School s=new School(name+i,STU_NUM/SCH_NUM,i);
    		schools.add(s);
    	}
    	return schools;
    }
} 
