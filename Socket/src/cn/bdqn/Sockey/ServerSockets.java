package cn.bdqn.Sockey;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSockets {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(56666);
			System.out.println("***�����������������ȴ��ͻ��˵�����***");
			Socket socket = serverSocket.accept();
			InputStream is = socket.getInputStream();
			byte [] bytes = new byte[1024];
			int data = 0;
			while((data = is.read(bytes))!=-1){
				String temp = new String(bytes, 0, data);
				System.out.println("���Ƿ���������ȡ�ͻ��˷���������Ϣ��"+temp);
			}
			socket.shutdownInput();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("��ӭ����");
			pw.flush();
			pw.close();
			os.close();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		

	}

}
