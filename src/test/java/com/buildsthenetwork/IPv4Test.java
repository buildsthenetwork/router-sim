package com.buildsthenetwork;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.buildsthenetwork.IPv4.IPv4Value;
import com.buildsthenetwork.IPv4.NetMask;

public class IPv4Test {
    @Test
    public void testMask() {
        IPv4Value netmask = new NetMask("255.255.255.0");

        assertNotNull(netmask);
        assertEquals("255.255.255.0", netmask.toString());
    }

    @Test
    public void testInvalidMask() {
        assertThrows(IllegalArgumentException.class, () -> {
            new NetMask("255.0.255.0");
        });
    }
}
