package cn.hncu.login.Img;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ImgDemo extends HttpServlet {
	public static String  str="";
	public String getStr(){
		return str;
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		str="";
		int width=60;
		int height=30;
		BufferedImage bfi =new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g=bfi.getGraphics();
		g.setColor(Color.WHITE);//设置白色
	//	g.drawRect(0, 0, width, height);//画出白色的框
		g.fillRect(0, 0, width, height);//白色的矩形
		Random rom =new Random();//随机数的参数
		g.setFont(new Font("a", Font.BOLD, 20));
		
		for(int i=0;i<4;i++){
			g.setColor(new Color(rom.nextInt(256), rom.nextInt(256), rom.nextInt(256)));
			int num =rom.nextInt(10);//取10里面的随机数
			str+=num;
			g.drawString(num+"", i*14, 15+rom.nextInt(10));//注意x,y的坐标或我们认识不一样，y是从上往下的
		}
		for(int i=0;i<10;i++){
			g.setColor(new Color(rom.nextInt(256), rom.nextInt(256), rom.nextInt(256)));
			g.drawLine(rom.nextInt(width), rom.nextInt(height), rom.nextInt(width), rom.nextInt(height));
		}
//		HttpSession http=req.getSession();//将这里收集的验证码传到前台
//		http.setAttribute("str", str);
		ImageIO.write(bfi, "JPEG", resp.getOutputStream());
	}
}
