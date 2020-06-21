package cn.hncu.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;

import cn.hncu.login.factory.CustomerDocumentFactory;

public class RegDemo extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");//必须要设置在获得Printwrite之前，都则设置无效
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		boolean flag=false;
		
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		
		
		Document dom =CustomerDocumentFactory.getDocument();
		Element root=dom.getRootElement();
		Iterator<Element> it=root.elementIterator();
		while(it.hasNext()){
			Element ele=it.next();
			String nameR=ele.attributeValue("name");//这里传过来的值可能是null.所以我们必须在前台要预防一下，当然在这里也要考虑一下
			String pwdR=ele.attributeValue("pwd");
			if(name.equals(nameR)&&pwd.equals(pwdR)){
				flag=true;
				break;
			}
		}
		if(flag){
			out.print("此用户已注册！！");
			out.print("<a href='jsps/Reg.jsp'>返回注册</a>");
		}else{
			Element ele=root.addElement("user");
			ele.addAttribute("name", name);
			ele.addAttribute("pwd", pwd);
			CustomerDocumentFactory.Save();
			out.print("注册成功！！");
			out.print("<a href='index.jsp'>返回登录</a>");
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
