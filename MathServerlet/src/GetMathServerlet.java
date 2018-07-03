
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import dao.Mathdao;
import bean.Mathbean;
public class GetMathServerlet extends HttpServlet {
	/**
	 * Constructor of the object.
	 */
	public GetMathServerlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		json��ʽ����{}��������jsonObject�ļ����á�����������jsonArray;
		try {
//			�����ݿ��ȡ��������
			ArrayList<Mathbean>math=Mathdao.getMath();
//			��list�е����ݷ�װ��һ��jsonArray����
			JSONArray jsonArray=new JSONArray();
			for (Mathbean mathbean : math) {
				JSONObject mathJson=(JSONObject) JSONObject.toJSON(mathbean);
				jsonArray.add(mathJson);
			}
//			��jsonArray������Ϊjson���������Żؿͻ���
			response.getOutputStream().write(jsonArray.toString().getBytes());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
