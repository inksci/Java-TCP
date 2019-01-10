package inksci;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * Client
 */
public class Client {

    	public static void main(String[] args) throws Exception {	
    	System.out.println( "Start" );
    	
        // setting.
    	
        String host = "192.168.43.15";
        int port = 12601;
        
        // connect.
        Socket s = new Socket( host , port );
        
        // receive.
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        System.out.println( "接收到：" + new String(buf,0,len,"utf-8") );
        
        
        // send and receive.
        OutputStream out = (OutputStream) s.getOutputStream();
        out.write("hello Tcp 我是客户端，哈哈！".getBytes("utf-8"));
        // receive.
        in = s.getInputStream();
        buf = new byte[1024];
        len = in.read(buf);
        System.out.println( "接收到：" + new String(buf,0,len) );
        
        // send and close.
        out = (OutputStream) s.getOutputStream();
        out.write("close".getBytes());
        // close.
        s.close();

        System.out.println( "finish!" );
        
    }
}