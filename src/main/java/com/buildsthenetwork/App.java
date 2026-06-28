package com.buildsthenetwork;

import com.buildsthenetwork.IPv4.IPv4Value;
import com.buildsthenetwork.IPv4.NetAddress;
import com.buildsthenetwork.IPv4.NetMask;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        IPv4Value addr = new NetAddress("192.168.10.10");
        IPv4Value mask = new NetMask("255.255.0.0");
        System.out.println(addr);
        System.out.println(mask);
        IPv4Value netid = new NetAddress(IPv4Value.compareValue(addr, mask, IPv4Value.Bitwise.AND));
        System.out.println(netid);
    }
}
