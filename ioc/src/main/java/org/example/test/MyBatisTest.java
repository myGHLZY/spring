package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.RoomMapper;
import org.example.pojo.Room;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class MyBatisTest {

    public static void main(String[] args) throws Exception {

        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(in);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        RoomMapper roomMapper = sqlSession.getMapper(RoomMapper.class);

        List<Room> rooms= roomMapper.list();

        for(Room room:rooms){
            System.out.println(room);
        }

        // 上述代码的自动注入

    }

}
