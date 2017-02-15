package module3;

import java.util.Date;

public class HomeWork33 {
    public static void main(String[] args) {
        Course course1 = new Course(new Date(116, 10-1, 15 ), "AAA");
        Course course2 = new Course(new Date(116, 9-1, 15 ), "BBB");
        Course course3 = new Course(new Date(116, 8-1, 15 ), "CCC");
        Course course4 = new Course(new Date(116, 7-1, 15 ), "DDD");
        Course course5 = new Course(new Date(116, 6-1, 15 ), "EEE");

        Student[] students = new Student[8];
        students[0] = new Student("Лея", "Шеренга", 1);
        students[1] = new Student("Забулдыгин", new Course[] { course1, course3 });
        students[2] = new CollegeStudent("Моня", "Плешивый", 1);
        students[3] = new CollegeStudent("Кулебякин", new Course[] { course2 } );
        students[4] = new CollegeStudent("Ханна", "Вошь", 2, new Course[] { course5, course4}, 25, "ПТУ-8", 5, 56789);
        students[5] = new SpecialStudent("Пупкин", new Course[] { course2, course3 } );
        students[6] = new SpecialStudent("Абрам", "Гитлер", 1, new Course[] { course1 }, 50, "ПТУ-8", 5, 12345);
        students[7] = new SpecialStudent(1048576);
    }
}

class Course {
    private Date startDate;
    private String name;
    private int hoursDuration;
    private String teacherName;

    public Course(Date startDate, String name) {
        this.startDate = startDate;
        this.name = name;
    }

    public Course(String name, int hoursDuration, String teacherName) {
        this.name = name;
        this.hoursDuration = hoursDuration;
        this.teacherName = teacherName;
    }
}

class Student {
    private String firstName;
    private String lastName;
    private int group;
    protected Course[] coursesTaken;
    protected int age;

    public Student() {}

    public Student(String firstName, String lastName, int group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public Student(String lastName, Course[] coursesTaken) {
        this.lastName = lastName;
        this.coursesTaken = coursesTaken;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Course[] getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(Course[] coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class CollegeStudent extends Student {
    private String collegeName;
    private int rating;
    private long id;

    public CollegeStudent() { super(); }

    public CollegeStudent(String firstName, String lastName, int group) {
        super(firstName, lastName, group);
    }

    public CollegeStudent(String lastName, Course[] coursesTaken) {
        super(lastName, coursesTaken);
    }

    public CollegeStudent(String firstName, String lastName, int group, Course[] coursesTaken, int age,
                          String collegeName, int rating, long id) {
        super(firstName, lastName, group);
        super.coursesTaken = coursesTaken;
        super.age = age;
        this.collegeName = collegeName;
        this.rating = rating;
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

class SpecialStudent extends CollegeStudent {
    private long secretKey;
    private String email;

    public SpecialStudent(String firstName, String lastName, int group, Course[] coursesTaken, int age, String collegeName, int rating, long id) {
        super(firstName, lastName, group, coursesTaken, age, collegeName, rating, id);
    }

    public SpecialStudent(String lastName, Course[] coursesTaken) {
        super(lastName, coursesTaken);
    }

    public SpecialStudent(long secretKey) {
        super();
        this.secretKey = secretKey;
    }

    public long getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(long secretKey) {
        this.secretKey = secretKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



