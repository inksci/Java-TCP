package inksci;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_short {
    public static void main(String[] args) throws Exception {
    	System.out.println( "Start" );
    	
        ServerSocket ss = null;
        Socket socket = null;
        // ����3333�˿�
        ss = new ServerSocket( 12701 );
        
        while(true){
	        // �ȴ����տͻ��˵�����
	        socket = ss.accept();
	        System.out.println( "Connected" );
	        
	    	Socket s = socket;
	        // send.
	        OutputStream out_2 = (OutputStream) s.getOutputStream();
	        out_2.write("hello Tcp ���ǿͻ��ˣ�".getBytes("utf-8"));
	        
	        // receive and close.
	        InputStream in_2 = s.getInputStream();
	        byte[] buf = new byte[1024];
	        int len = in_2.read(buf);
	        
	        String str_receive = new String(buf,0,len,"utf-8");
	        
	        System.out.println( "���յ���" + str_receive );
	
	        s.close();
        }

    }
}
