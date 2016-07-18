import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //Gson的使用Demo下面的是可追加形式的
//        outPut();
        //下面的是把object直接转化为json哦
        //objectOutput();
        //下面是涉及到嵌套套的,直接上List版本的
//        arrayOutput();
        //尝试着读一下
        //inPut();
        //如果读一个数组
//        inPutArray();
        //读混合型的呢?
//        inPutMix();
        //下面是高级内容测试
        testTypeAdapter();
    }

    private static void outPut() throws IOException {
         Writer writer=new FileWriter("outside.json");
         Gson gson=new GsonBuilder().create();
         gson.toJson("pain",writer);
         gson.toJson(123,writer);
         writer.close();
    }

    private static void objectOutput() throws IOException {
        Writer writer=new FileWriter("test1.json");
        //excludeFieldsWithoutExposeAnnotation
        Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Student student=new Student("Harbin",24,"pain");
        System.out.println( gson.toJson(student));
        writer.close();
    }

    private static void arrayOutput() throws IOException {
        Writer writer=new FileWriter("teacher.json");
        Gson gson=new Gson();
        List<Student> students=new ArrayList<Student>();
        students.add(0,new Student("HPW",23));
        students.add(1,new Student("ZGD",24));
        Teacher teacher=new Teacher("ZTY",24,students);
        gson.toJson(teacher,writer);
        writer.close();

    }

    private static void inPut() throws IOException {
        Reader reader=new InputStreamReader(new FileInputStream("test.json"));
        Gson gson=new Gson();
        Student student=gson.fromJson(reader,Student.class);
        System.out.println(student.getName());
    }

    private static void inPutArray() throws IOException {
        Reader reader=new InputStreamReader(new FileInputStream("inputtest.json"));
        Gson gson=new Gson();
        List<Student> students=gson.fromJson(reader,new TypeToken<List<Student>>(){}.getType());
        System.out.println(students.size());
    }

    private static void inPutMix () throws IOException {
        Reader reader=new InputStreamReader(new FileInputStream("teacher.json"));
        Gson gson=new GsonBuilder().create();
        Teacher teacher=gson.fromJson(reader,Teacher.class);
        List<Student> l=teacher.getStudents();
        for (int i=0;i<l.size();i++){
            System.out.println(l.get(i).getName());
        }
        System.out.println(teacher.toString());
    }

    private static void testTypeAdapter() throws IOException {
        Gson gson=new GsonBuilder().registerTypeAdapter(Lesson.class, new TypeAdapter<Lesson>() {
            @Override
            public void write(JsonWriter jsonWriter, Lesson lesson) throws IOException {
                jsonWriter.beginObject();
                jsonWriter.name("name1").value(lesson.getLessonName());
                jsonWriter.name("teacher1").value(lesson.getLessonTeacher());
                jsonWriter.name("number1").value(lesson.getLessonNumber());
                jsonWriter.endObject();
            }

            @Override
            public Lesson read(JsonReader jsonReader) throws IOException {
                jsonReader.beginObject();
                Lesson lesson=new Lesson();
                while (jsonReader.hasNext()){
                    switch (jsonReader.nextName()){
                        case "name1":
                            lesson.setLessonName(jsonReader.nextString());
                            break;
                        case "teacher1":
                            lesson.setLessonTeacher(jsonReader.nextString());
                            break;
                        case "number1":
                            lesson.setLessonNumber(jsonReader.nextInt());
                            break;
                    }

                }
                jsonReader.endObject();
                return lesson;

            }
        }).create();
/*        Writer writer=new FileWriter("lesson.json");
        gson.toJson(new Lesson("JAVA","PAIN",250),writer);
        writer.close();*/
        Reader reader=new InputStreamReader(new FileInputStream("lesson.json"));
        Lesson lesson=gson.fromJson(reader,Lesson.class);
        System.out.println(lesson.toString());
    }
}
