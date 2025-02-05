package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String string = input.readLine(); string != null && !string.isEmpty(); string = input.readLine()) {
                        System.out.println(string);
                        if (string.contains("msg=")) {
                            String msg = string.split("msg=")[1].split(" ")[0];
                            if ("Hello".equals(msg)) {
                                output.write("Hello\r\n\r\n".getBytes());
                            } else if ("Exit".equals(msg)) {
                                server.close();
                                output.write("server shut down\r\n\r\n".getBytes());
                            } else {
                                output.write("What\r\n\r\n".getBytes());
                            }
                        }
                    }
                    output.flush();
                }
            }
        }
    }
}