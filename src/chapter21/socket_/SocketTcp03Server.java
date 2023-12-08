package chapter21.socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: kyp16
 * @Date: 2023/12/7
 **/
public class SocketTcp02Server {
    public static void main(String[] args) throws IOException {


        ServerSocket serverSocket=new ServerSocket(9999);
        System.out.println("服务器，在9999端口监听，等待连接");

        Socket socket = serverSocket.accept();
        System.out.println("socket="+socket.getClass());


        InputStream inputStream = socket.getInputStream();

        byte[] buf=new byte[1024];
        int readlen=0;
        while((readlen=inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,readlen));
        }



        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("第二,client".getBytes());

        socket.shutdownOutput();

        outputStream.close();
        inputStream.close();


        socket.close();
        serverSocket.close();


        System.out.println("服务器socket关闭");
    }
}
