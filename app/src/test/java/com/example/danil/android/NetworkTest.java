package com.example.danil.android;

import org.junit.Test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by _dani on 07.02.2017.
 */
public class NetworkTest {
    @Test
    public void ipAddressTest() throws UnknownHostException, SocketException {

        InetAddress inetAddress = InetAddress.getLoopbackAddress();

        byte [] googleDNS = new byte[]{8,8,8,8};
        inetAddress = InetAddress.getByAddress(googleDNS);
        assertTrue(inetAddress.getHostName().contains("google.com"));
        assertEquals("8.8.8.8", inetAddress.getHostAddress());

        inetAddress = InetAddress.getLoopbackAddress();
        assertEquals("127.0.0.1", inetAddress.getHostAddress());

        Enumeration<NetworkInterface> networkInterface = NetworkInterface.getNetworkInterfaces();
        while (networkInterface.hasMoreElements()){
            NetworkInterface networkInterface1 = networkInterface.nextElement();
            System.out.println(networkInterface1.getDisplayName());
        }
    }
}
