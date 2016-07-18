import java.util.List;

/**
 * Created by pain on 16/7/18.
 */
public class Teacher {
    private String teacherName;
    private int teacherAge;
    private List<Student> students;

    public Teacher(String teacherName, int teacherAge, List<Student> students) {
        this.teacherName = teacherName;
        this.teacherAge = teacherAge;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                ", teacherAge=" + teacherAge +
                ", students=" + students +
                '}';
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(int teacherAge) {
        this.teacherAge = teacherAge;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
