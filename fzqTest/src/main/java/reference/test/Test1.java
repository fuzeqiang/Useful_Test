package reference.test;

import file.test.School;

/**
 * Created by fuzeqiang(100918) on 2016/7/18 0018.
 */
public class Test1 {
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    private School school = null;

    public void test(School school) {
        school = new School();
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.school);
        test1.test(test1.getSchool());
        System.out.println(test1.school);
    }

}
