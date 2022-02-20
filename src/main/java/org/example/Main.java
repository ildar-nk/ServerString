package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try (
                final ServerSocket serverSocket = new ServerSocket(9999);

        ){
            while (true){
                try {
                    final Socket socket = serverSocket.accept();
                    final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    final OutputStream outputStream = socket.getOutputStream();
                    String line;
                    while ((line = reader.readLine()) != null){
                        System.out.println("line = " + line);
                        outputStream.write(line.getBytes(StandardCharsets.UTF_8));
                        outputStream.flush();
                    }
                    socket.close();

                } catch (Exception e){

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//        final Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
////            System.out.println("I'm alive");
//                }
//            }
//
//        });
//        thread.start();
//        thread.join();
    }
}
