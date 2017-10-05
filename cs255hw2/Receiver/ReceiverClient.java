package cs255hw2.Receiver;

import java.io.*;

import java.net.*;

public class ReceiverClient {

    private Socket currentSocket;
    private InputStream incoming;
    private PrintStream outGoing;
    private byte[] toReturn;

    public ReceiverClient() {
        try {
            this.currentSocket = new Socket("10.15.1.21", 4467);
            //this.incoming = new DataInputStream(this.currentSocket.getInputStream());
            this.incoming = this.currentSocket.getInputStream();
            this.outGoing = new PrintStream(this.currentSocket.getOutputStream());
        } catch (UnknownHostException e) {
            // System.out.println("SH UHE");
        } catch (IOException ex) {
            // System.out.println("SH IOE");
        }

    }

    public byte[] getPckt() {
        byte[] store = null;
        try {
            store = new byte[1024];
            System.out.println("Waiting for pckt");
            this.incoming.read(store, 0, 1024);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return store;
    }

    public void closeSocket() {
        try {
            this.currentSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}