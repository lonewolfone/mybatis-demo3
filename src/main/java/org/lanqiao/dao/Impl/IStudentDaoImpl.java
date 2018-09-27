package org.lanqiao.dao.Impl;

import org.apache.log4j.Logger;
import org.lanqiao.dao.StudentDao;
import org.lanqiao.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.lanqiao.utils.mybatisUtils;
import java.io.IOException;
import java.util.List;

public class IStudentDaoImpl implements StudentDao {

    @Override
    public void addStu(Student student) throws IOException {
        //根据工具类：Utils包下的mybatisUtils类的方法，获取sqlSession对象
        SqlSession sqlSession= mybatisUtils.getSqlSession("mybatis-config.xml");
        //执行sql
        sqlSession.insert("addStudent",student);
        // MySql不自动提交事务，此处为手动提交事务
        sqlSession.commit();
        //关闭sqlsession
        mybatisUtils.realeaseSource(sqlSession);
    }

    @Override
    public List<Student> findStu() {
        Logger logger = Logger.getLogger(IStudentDaoImpl.class);
        logger.debug("这是dao的调试日志");
        logger.info("这是info级别的信息");
         //根据工具类：Utils包下的mybatisUtils类的方法，获取sqlSession对象
         SqlSession sqlSession= mybatisUtils.getSqlSession("mybatis-config.xml");
        //执行sql
        List<Student> allStudent = sqlSession.selectList("findAllStudent");
        //返回一个结果集，无需提交
        //关闭sqlsession
        mybatisUtils.realeaseSource(sqlSession);
        return allStudent;
    }
}
