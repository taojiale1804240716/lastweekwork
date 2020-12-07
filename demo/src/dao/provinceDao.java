package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tools.jdbcUtil;
import vo.province;
import vo.school;

public class provinceDao {

	  public ArrayList<province> queryprovince() throws SQLException{
	    	 ArrayList<province> SH=new ArrayList<province>();
	    	 jdbcUtil jdbc=new jdbcUtil();   	 
	    	 String sql="select * from hat_province";
	    	 ResultSet rs=jdbc.query(sql);
	    	 
	    	 while(rs.next()){
	    		 //首先新建一个school
	    		 province  p=new province(rs.getInt("display_order"),rs.getString("area_id"),rs.getString("area_name"));	    		 
	    		 SH.add(p);
	    	 }
	    	 return SH;
	     }
	public provinceDao() {
		// TODO Auto-generated constructor stub
	}

}
