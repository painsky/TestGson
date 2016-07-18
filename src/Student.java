import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pain on 16/7/18.
 */
public class Student {
 /*   这个注解是用来起别名的方法,下面是初级用法
    @SerializedName("studentname")*/
    //装逼的时候用高级,这个可以统一前台后台命名哦
    @SerializedName(value = "stuentname",alternate = {"name","ename"})
    //然后他喵的注意一下.只要有Expose注解的,没用这个注解的一律不会生成json...表示被坑过,这个是标注暴露属性的
    @Expose(deserialize = true,serialize = true)
    private String name;
    @Expose(deserialize = true,serialize = true)
    private int age;
    @Expose(deserialize = false,serialize = false)
    private  String home="";
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String home, int age, String name) {
        this.home = home;
        this.age = age;
        this.name = name;
    }
}
