package com.example.demo.dao;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Student;

@Mapper
public interface StudentDao {
	    @Insert(" INSERT INTO STUDENT ( "
	          + "	   NAME, SCORE, GRADUATE,CREATE_DATE "
			  + "	   "
			  + " ) "
			  + " VALUES ( "
			  + "	   #{name}, #{score}, #{graduate}, NOW() "
			  + "	    "
			  + " ) ")
		public Integer insert(Student student);
		
		@Select(" SELECT "
			  + "	   ID, NAME, SCORE, GRADUATE, CREATE_DATE "
			  + " FROM "
			  + "	   STUDENT "
			  + " WHERE "
			  + "	   NAME = #{name} ")
		public Student findStudentByName(String name);
		
		@Update(" UPDATE "
			  + "	STUDENT "
			  + " SET "
			  + "	NAME = #{name}, SCORE = #{score},  "
			  + "   GRADUATE = #{graduate}, CREATE_DATE = NOW()  "
			  + " WHERE 1=1 "
			  + "	AND ID = #{id} ")
		public Integer update(Student student);
		
		@Delete("DELETE FROM STUDENT Where id = #{id}")
		public int deleteById(Integer id);
		
		@Select("SELECT * FROM STUDENT")
		public List<Student> getList();

		@Select("SELECT * FROM STUDENT WHERE id = #{id}")
		public Student getById(Integer id);
}
