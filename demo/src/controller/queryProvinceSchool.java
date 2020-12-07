package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.provinceDao;
import dao.schoolDao;
import vo.province;
import vo.school;


/**
 * Servlet implementation class queryProvinceSchool
 */
@WebServlet("/queryProvinceSchool")
public class queryProvinceSchool extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryProvinceSchool() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String area_id= request.getParameter("area_id");
		System.out.println("显示数据:");
		System.out.println(area_id);
		String jsonStr ="";
		//分别得到城市和省份的数据
		schoolDao citydao=new schoolDao();
		provinceDao provincedao=new provinceDao();
		if(area_id==null)//省份页面还没有选择
		{
			//将省份的信息用json表示
		  
			ArrayList<province> prolist                ;
			try {
				prolist=provincedao.queryprovince() ;
				//将数组里面的数据放入map中
//				for(int i=0;i<prolist.size();i++)
//			{					
//					map.put(String.valueOf(prolist.get(i).getPid()), prolist.get(i).getProvincial());
//			}
				jsonStr=new Gson().toJson(prolist);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else//选择了省份
		{
			try {
				ArrayList<school> slist=citydao.queryschoolBypID(area_id);
				
				slist.toString();
				//for(int i=0;i<clist.size();i++)
				//{					
					//map.put(String.valueOf(clist.get(i).getPid()), clist.get(i).getProvincial());
				//}
				jsonStr=new Gson().toJson(slist);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		  response.setCharacterEncoding("utf-8");
		  response.setContentType("text/xml;charset=utf-8");   
		  response.setHeader("Cache-Control", "no-cache");  

		  //确保在取得PrintWriter对象之前先设置response的编码；顺序搞错将无法解决中文乱码问题！
		  PrintWriter out = response.getWriter();
   
		//PrintWriter out =response.getWriter();
		  //System.out.println(map);
		System.out.println(jsonStr);//输入json字符串	
		//String json = new Gson().toJson(map);
		out.print(jsonStr);
		out.flush();
		out.close();	
	}
	
}

   
