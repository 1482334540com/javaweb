package cn.jsp;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String phone;
    private  String color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Student(Integer id, String name, Integer age, String phone, String color) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.color = color;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}