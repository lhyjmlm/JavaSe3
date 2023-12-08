package chapter21.socket_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author: kyp16
 * @Date: 2023/12/7
 **/
public class SocketTcp01Client  {
    public static void main(String[] args) throws IOException {

        Socket socket=new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("客户端socket返回="+socket.getClass());

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("word,server".getBytes());

        outputStream.close();

        socket.close();
        System.out.println("客户端socket关闭了");


    }
}
