package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.provinceDao;
import dao.schoolDao;
import vo.province;
import vo.school;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}
     public static void main(String[] args) throws SQLException {
		//schoolDao d=new schoolDao();
		provinceDao d=new provinceDao();
		ArrayList<province> SH=d.queryprovince();
    	int count=0;
		for(province s:SH)          
		{
			count++;
			System.out.println(s.toString());
		}
		System.out.println("***************");
		System.out.println(count);
	}
}
