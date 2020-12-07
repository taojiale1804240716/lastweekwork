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
		System.out.println("��ʾ����:");
		System.out.println(area_id);
		String jsonStr ="";
		//�ֱ�õ����к�ʡ�ݵ�����
		schoolDao citydao=new schoolDao();
		provinceDao provincedao=new provinceDao();
		if(area_id==null)//ʡ��ҳ�滹û��ѡ��
		{
			//��ʡ�ݵ���Ϣ��json��ʾ
		  
			ArrayList<province> prolist                ;
			try {
				prolist=provincedao.queryprovince() ;
				//��������������ݷ���map��
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
		else//ѡ����ʡ��
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

		  //ȷ����ȡ��PrintWriter����֮ǰ������response�ı��룻˳�����޷���������������⣡
		  PrintWriter out = response.getWriter();
   
		//PrintWriter out =response.getWriter();
		  //System.out.println(map);
		System.out.println(jsonStr);//����json�ַ���	
		//String json = new Gson().toJson(map);
		out.print(jsonStr);
		out.flush();
		out.close();	
	}
	
}

   
