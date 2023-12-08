package chapter21.Homework_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: kyp16
 * @Date: 2023/12/7
 **/
public class Homework01Server {
    public static void main(String[] args) throws IOException {


        ServerSocket serverSocket=new ServerSocket(9999);
        System.out.println("服务器，在9999端口监听，等待连接");

        Socket socket = serverSocket.accept();
        System.out.println("socket="+socket.getClass());


        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String s=bufferedReader.readLine();
        System.out.println(s);





        OutputStream outputStream = socket.getOutputStream();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("helclient,字符流");

        bufferedWriter.newLine();
        bufferedWriter.flush();



        bufferedWriter.close();
        bufferedReader.close();

        socket.close();
        serverSocket.close();


        System.out.println("服务器socket关闭");
    }
}
