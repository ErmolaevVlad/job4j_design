package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String string = input.readLine();
                    System.out.println(string);
                    if (string != null && string.contains("msg=")) {
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
                    output.flush();
                } catch (Exception e) {
                    LOG.error("Error", e);
                }
            }
        } catch (Exception e) {
            LOG.error("Error", e);
        }
    }
}