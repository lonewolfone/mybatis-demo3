package test;

import org.lanqiao.dao.Impl.IStudentDaoImpl;
import org.lanqiao.dao.StudentDao;
import org.lanqiao.pojo.Student;
import org.junit.Test;
import java.io.IOException;
import java.util.List;

public class studentTest {
    @Test
    public void  addStudent() throws IOException {
        StudentDao studentDao = new IStudentDaoImpl();
        Student student1= new Student("旺财",29,"男");
        studentDao.addStu(student1);
    }

    @Test
    public void findAllStudent(){
        StudentDao studentDao = new IStudentDaoImpl();
        List<Student> allStudentList = studentDao.findStu();
        for (Student student:allStudentList){
            System.out.println(student);
        }
    }
}
