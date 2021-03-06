package com.bittech.chatroom.client.multi;

import java.io.IOException;
import java.net.Socket;

/**
 * Author: secondriver
 * Created: 2019/2/24
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class MultiThreadClient {
    
    public static void main(String[] args) {
        try {
            //0.通过命令行获取参数
            int port = 6666;
            if (args.length > 0) {
                try {
                    port = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    System.out.println("端口参数不正确，采用默认端口" + port);
                }
            }
            String host = "127.0.0.1";
            if (args.length > 1) {
                host = args[1];
                //host格式校验
            }
            final Socket socket = new Socket(host, port);
            
            //1.往服务器发送数据
            new WriteDataToServerThread(socket).start();
            //2.从服务器读取数据
            new ReadDataFromServerThread(socket).start();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
