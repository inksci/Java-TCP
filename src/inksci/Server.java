package inksci;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
    	System.out.println( "Start" );
    	
        ServerSocket ss = null;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedReader input = null;
        
        // ����3333�˿�
        ss = new ServerSocket( 12704 );
        // �ȴ����տͻ��˵�����
        socket = ss.accept();
        System.out.println( "Connected" );
        

    	Socket s = socket;
        // send.
        OutputStream out_2 = (OutputStream) s.getOutputStream();
        out_2.write("hello Tcp ���ǿͻ��ˣ�".getBytes("utf-8"));
        
        while(true){
        	
        	
            // receive.
            InputStream in_2 = s.getInputStream();
            byte[] buf = new byte[1024];
            int len = in_2.read(buf);
            
            String str_receive = new String(buf,0,len,"utf-8");
            
            System.out.println( "���յ���" + str_receive );
        	if( str_receive.equals("close")==false ){
                // send(reply).
                out_2 = (OutputStream) s.getOutputStream();
                out_2.write("reply".getBytes());
        	}else{
        		break;
        	}

        }
        
        s.close();

    }
}
