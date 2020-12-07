package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tools.jdbcUtil;
import vo.school;

public class schoolDao {

	public schoolDao() {
		// TODO Auto-generated constructor stub
	}
	
     public ArrayList<school> queryschool() throws SQLException{
    	 ArrayList<school> SH=new ArrayList<school>();
    	 jdbcUtil jdbc=new jdbcUtil();   	 
    	 String sql="select * from tb_school";
    	 ResultSet rs=jdbc.query(sql);
    	 
    	 while(rs.next()){
    		 //首先新建一个school
    		 school s=new school(rs.getString("school_id"),rs.getString("school_name"),rs.getString("school_type"),rs.getString("area_id"),rs.getString("area_name"),rs.getString("display_order"));
    		 
    		 SH.add(s);
    	 }
    	 return SH;
     }
     //根据省份id找到
     public ArrayList<school> queryschoolBypID(String area_id) throws SQLException{
    	 ArrayList<school> SH=new ArrayList<school>();
    	 jdbcUtil jdbc=new jdbcUtil();   	 
    	 String sql="select * from tb_school where area_id="+area_id;
    	 ResultSet rs=jdbc.query(sql);
    	 
    	 while(rs.next()){
    		 //首先新建一个school
    		 school s=new school(rs.getString("school_id"),rs.getString("school_name"),rs.getString("school_type"),rs.getString("area_id"),rs.getString("area_name"),rs.getString("display_order"));
    		 
    		 SH.add(s);
    	 }
    	 return SH;
     }
}
