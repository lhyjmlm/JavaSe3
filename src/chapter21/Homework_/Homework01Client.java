package chapter21.Homework_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author: kyp16
 * @Date: 2023/12/7
 **/
public class Homework01Client {
    public static void main(String[] args) throws IOException {

        Socket socket=new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("客户端socket返回="+socket.getClass());

        OutputStream outputStream = socket.getOutputStream();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("helloserver,字符流");

        bufferedWriter.newLine();
        bufferedWriter.flush();


        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String s=bufferedReader.readLine();
        System.out.println(s);


      bufferedReader.close();
        bufferedWriter.close();

        socket.close();
        System.out.println("客户端socket关闭了");


    }
}
