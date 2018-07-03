package dao;
	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Mathbean;

	public class Mathdao {
	  public static ArrayList<Mathbean>getMath() {
		  Connection connection=null;
		  Statement stmt=null;
		  ResultSet rs=null;
		  String sql=null;
		  try {
//			填写数据库相关信息，查找数据库相关页
			  String databaseName="app";
			  String host="localhost";
			  String port="3306";
			  String username="root";
			  String password="123aaa";
			  String drivername="com.mysql.jdbc.Driver";
			  String dbUrl="jdbc:mysql://";
			  String serverName=host+":"+port+"/";
			  String connName=dbUrl+serverName+databaseName;
//			  链接数据库服务器
			  Class.forName(drivername);
			  connection=DriverManager.getConnection(connName,username,password);
			  stmt = connection.createStatement();
//			  数据库连接完成后，就开始操作数据库了
//			  创建一个数据表
			  sql="select*from math order by math_id desc";
			  ResultSet rss=stmt.executeQuery(sql);
			  ArrayList<Mathbean>arrayList=new ArrayList<Mathbean>();
			  if(rss!=null){
				  while(rss.next()){
					  int math_id=rss.getInt("math_id");
					  String math_name=rss.getString("math_name");
					  String math_context=rss.getString("math_context");
					  String math_image_src=rss.getString("math_image_src");
					  int math_money=rss.getInt("math_money");			
					  String math_datetime=rss.getString("math_datetime");
					  Mathbean mathbean=new Mathbean();
					  mathbean.setMath_id(math_id);
					  mathbean.setMath_name( math_name);
					  mathbean.setMath_context(math_context);
					  mathbean.setMath_image_src(math_image_src);
					  mathbean.setMath_datetime(math_datetime);
					  mathbean.setMath_money(math_money);			  
					  arrayList.add(mathbean);
				  }
				  return arrayList;
			  } 
			  
		} catch (Exception e) {
			// TODO: handle exception
		}
		  return null;
		  
	}
	}

