package chapter21.Homework_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author: kyp16
 * @Date: 2023/12/7
 **/
public class UdpHomework02SendB {
    public static void main(String[] args) throws IOException {


        DatagramSocket socket = new DatagramSocket(9998);

        byte[] data="明天吃火锅".getBytes();

        DatagramPacket packet=new DatagramPacket
                (data,data.length, InetAddress.getLocalHost(),9999);

        socket.send(packet);



        byte[]buf=new byte[1024];
         packet = new DatagramPacket(buf, buf.length);

        socket.receive(packet);

        int length=packet.getLength();
        data=packet.getData();

        String s=new String(data,0,length);
        System.out.println(s);


        socket.close();
        System.out.println("B段退出");
    }
}
