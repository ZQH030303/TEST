package test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author ZQH15920086758
 */
public class UdpSend {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10087);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入：");
            String str = sc.nextLine();
            if("886".equals(str)){
                break;
            }
            byte[] bytes = str.getBytes();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            int port = 10086;
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length,address,port);

            ds.send(dp);
        }


        ds.close();
    }
}
