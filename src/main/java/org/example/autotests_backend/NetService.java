package org.example.autotests_backend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


//singleton
public class NetService {

    private static volatile NetService INSTANCE;

    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public static NetService getInstance() throws IOException {
        if (INSTANCE == null) {
            synchronized (NetService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NetService();
                }
            }
        }
            return INSTANCE;
    }

    private NetService() throws IOException {
        Socket socket = new Socket("localhost", 8189);
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
    }

    public DataInputStream getInputStream() {
        return inputStream;
    }

    public DataOutputStream getOutputStream() {
        return outputStream;
    }
}
