package practice.p06;

public class Main {
    public static void main(String[] args) {

        Student doubles = new Student("더블에스");
        Student kim = new Student("김민수");
        Student park = new Student("박영희");

        Course os = new Course("OS");
        Course ds = new Course("Data Structures");
        Course java = new Course("Java");
        Course js = new Course("JavaScript");

        doubles.registerCourse(os);
        doubles.registerCourse(ds);
        doubles.registerCourse(java);
        doubles.registerCourse(js);

        kim.registerCourse(os);
        kim.registerCourse(java);

        park.registerCourse(ds);
        park.registerCourse(js);

        System.out.println(doubles);
        System.out.println(doubles.getCourses());

        System.out.println(kim);
        System.out.println(kim.getCourses());

        System.out.println(park);
        System.out.println(park.getCourses());
    }
}
