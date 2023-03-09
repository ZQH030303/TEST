package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ZQH15920086758
 */
public class Server {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        ServerSocket ss = new ServerSocket(10001);

        while (true) {
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            int b;
            if((b = isr.read()) != -1){
                System.out.print("已接收：" + (char)b);
                while((b = isr.read()) != -1){
                    System.out.print((char)b);
                }
                System.out.print('\n');
            }

            System.out.print("请输入：");
            String str = sc.nextLine();
            OutputStream os = socket.getOutputStream();
            os.write(str.getBytes());
            if(str.indexOf("再见") != -1){
                socket.close();
                ss.close();
                break;
            }

            socket.shutdownOutput();
        }
    }
}
