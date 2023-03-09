package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ZQH15920086758
 */
public class Client2 {
    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket("127.0.0.1", 10001);

        Scanner sc = new Scanner(System.in);

        while (true) {
            Socket socket = new Socket("127.0.0.1", 10001);
//            System.out.print("请输入：");
            String str = sc.nextLine();
            if("886".equals(str)){
                socket.close();
                break;
            }
            OutputStream os = socket.getOutputStream();
            os.write(str.getBytes());

            socket.shutdownOutput();

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
        }

//        socket.close();
    }
}
