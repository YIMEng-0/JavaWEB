
/*
	�����������̣�������web��������web������web container
	web��������֪������ЩServlet����֪���У�logout,login,delete!!!!!!!
	����֪����Щ���е�Servlet��ʵ����SUN��˾��Servlet�ӿ�
*/
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Tomcat //Tomcat�������Ǵ�java����ʵ�ֵģ�û��ʹ�������������
{
	public static void main(String[] args) throws Exception{
		
		System.out.println("��������Tomcat�����������Ժ�...");
		System.out.println("Tomcat�����������ɹ�����ʼ����������ķ���");
		Scanner s = new Scanner(System.in);
		System.out.print("����������·����");
		//��ȡ�û�������·��
		String requestPath = s.next();
		//Tomcat�������������web.xml�ļ�
		//Tomcat��������ǰ�Ѵ����Ѿ�д����
		//web.xml�ļ�����Servlet�淶�������޸�
		//web.xml�ļ��Ĵ��λ��Ҳ��Servlet�淶�������޸�
		//web.xml�ļ������е�������ϢҲ��Servlet�淶�����������д
		//web.xml�ļ��ı�д�ߣ�javaweb����Ա
		FileReader reader = new FileReader("web.xml");
		Properties pro = new Properties();
		pro.load(reader);
		reader.close();

		//ͨ��key��ȡvalue
		String className = pro.getProperty(requestPath);

		//ͨ��������ƴ�������
		Class c = Class.forName(className);
		Servlet servlet = (Servlet)c.newInstance();

		//����ӿڵ��ü���
		//��̬
		servlet.service();
		
	}
}
