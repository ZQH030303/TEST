package test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author ZQH15920086758
 */
public class UdpReceive {
    public static void main(String[] args) throws IOException {
        //端口：10086
        DatagramSocket ds = new DatagramSocket(10086);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        while (true) {
            ds.receive(dp);

            byte[] data = dp.getData();
            int len = dp.getLength();
            String ip = dp.getAddress().getHostAddress();

            System.out.println("ip为：" + ip + "的人发送了数据：" + new String(data,0,len));
        }
    }
}
