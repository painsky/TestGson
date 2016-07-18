/**
 * Created by pain on 16/7/18.
 */
public class Lesson {
    private String lessonName;
    private String lessonTeacher;
    private int lessonNumber;

    public Lesson() {
    }

    public Lesson(String lessonName, String lessonTeacher, int lessonNumber) {
        this.lessonName = lessonName;
        this.lessonTeacher = lessonTeacher;
        this.lessonNumber = lessonNumber;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonTeacher() {
        return lessonTeacher;
    }

    public void setLessonTeacher(String lessonTeacher) {
        this.lessonTeacher = lessonTeacher;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName='" + lessonName + '\'' +
                ", lessonTeacher='" + lessonTeacher + '\'' +
                ", lessonNumber=" + lessonNumber +
                '}';
    }
}
