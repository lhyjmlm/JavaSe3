package chapter21.Homework_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author: kyp16
 * @Date: 2023/12/7
 **/
public class UDPHomework02ReceiveA {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9999);

        byte[]buf=new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        System.out.println("接受段A等待接受数据");

        socket.receive(packet);

        int length=packet.getLength();
        byte[]data=packet.getData();

        String s=new String(data,0,length);
        System.out.println(s);


       data="明天见".getBytes();

        packet=new DatagramPacket
                (data,data.length, InetAddress.getLocalHost(),9998);

        socket.send(packet);

        socket.close();
        System.out.println("A段退出");
    }
}
