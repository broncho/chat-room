package com.bittech.chatroom.client.multi;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author: secondriver
 * Created: 2019/2/24
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class ReadDataFromServerThread extends Thread {
    
    private final Socket client;
    
    public ReadDataFromServerThread(Socket client) {
        this.client = client;
    }
    
    @Override
    public void run() {
        try {
            InputStream clientInput = client.getInputStream();
            Scanner scanner = new Scanner(clientInput);
            while (true) {
                String message = scanner.nextLine();
                System.out.println("来自服务器的消息:" + message);
                if (message.equals("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
