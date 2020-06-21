package cn.hncu.login.factory;

import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class CustomerDocumentFactory {
	private static Document dom=null;//需要共享一个dom，所以需要设置为static 
	private static String name="user.xml";
	private static String filename;
	static{
		SAXReader read=new SAXReader();
		 filename=CustomerDocumentFactory.class.getClassLoader().getResource(name).getPath();
				 try {
					dom=read.read(filename);
				} catch (DocumentException e) {
					e.printStackTrace();
				}
	}
	
	public static  Document getDocument(){
		return dom;
	}
	
	public static void Save() {
		XMLWriter wr;
		try {
			wr = new XMLWriter(new FileOutputStream(filename));
		}catch (Exception e1) {
			throw new RuntimeException("存储文件时读文件失败");
		}
		try {
			wr.write(dom);
		} catch (IOException e) {
			throw new RuntimeException("写文件失败"+e.getMessage());
		}finally{
			try {
				if(wr!=null){
				wr.close();
				}
			} catch (IOException e) {
				throw new RuntimeException("关流失败"+e.getMessage());
			
			}
		}
	}
	
}
