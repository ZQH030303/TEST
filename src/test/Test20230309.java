package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/** @author 朱启煌 */
public class Test20230309 {
    public static void main(String[] args) throws UnknownHostException {
//        192.168.0.100
        InetAddress address = InetAddress.getByName("DESKTOP-MCAKAH2");
        System.out.println(address);
        String name = address.getHostName();
        System.out.println(name);
        String ip = address.getHostAddress();
        System.out.println(ip);

    }
}
