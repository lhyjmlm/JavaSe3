package chapter21.socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author: kyp16
 * @Date: 2023/12/7
 **/
public class SocketTcp02Client {
    public static void main(String[] args) throws IOException {

        Socket socket=new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("客户端socket返回="+socket.getClass());

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("word,server".getBytes());


        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();

        byte[] buf=new byte[1024];
        int readlen=0;
        while((readlen=inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,readlen));
        }



        outputStream.close();
        inputStream.close();

        socket.close();
        System.out.println("客户端socket关闭了");


    }
}
