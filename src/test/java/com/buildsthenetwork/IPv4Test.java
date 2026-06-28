package com.buildsthenetwork;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.buildsthenetwork.IPv4.IPv4Value;
import com.buildsthenetwork.IPv4.NetMask;

// TODO write better test names
public class IPv4Test {

    @ParameterizedTest
    @ValueSource(strings = {
        "0.0.0.0", // 0
        "128.0.0.0",
        "192.0.0.0",
        "224.0.0.0",
        "240.0.0.0",
        "248.0.0.0",
        "252.0.0.0",
        "254.0.0.0",
        "255.0.0.0", // 8
        "255.128.0.0",
        "255.192.0.0",
        "255.224.0.0",
        "255.240.0.0",
        "255.248.0.0",
        "255.252.0.0",
        "255.254.0.0",
        "255.255.0.0", // 16
        "255.255.128.0",
        "255.255.192.0",
        "255.255.224.0",
        "255.255.240.0",
        "255.255.248.0",
        "255.255.252.0",
        "255.255.254.0",
        "255.255.255.0", // 24
        "255.255.255.128",
        "255.255.255.192",
        "255.255.255.224",
        "255.255.255.240",
        "255.255.255.248",
        "255.255.255.252",
        "255.255.255.254",
        "255.255.255.255", // 32
    })
    public void testContiguousMaskBitsStrings(String mask) {
        IPv4Value netmask = new NetMask(mask);
        assertNotNull(netmask);
        assertEquals(mask, netmask.toString());
    }

    @ParameterizedTest
    @ValueSource(ints = {
        0b00000000_00000000_00000000_00000000, // 0
        0b10000000_00000000_00000000_00000000,
        0b11000000_00000000_00000000_00000000,
        0b11100000_00000000_00000000_00000000,
        0b11110000_00000000_00000000_00000000,
        0b11111000_00000000_00000000_00000000,
        0b11111100_00000000_00000000_00000000,
        0b11111110_00000000_00000000_00000000,
        0b11111111_00000000_00000000_00000000, // 8
        0b11111111_10000000_00000000_00000000,
        0b11111111_11000000_00000000_00000000,
        0b11111111_11100000_00000000_00000000,
        0b11111111_11110000_00000000_00000000,
        0b11111111_11111000_00000000_00000000,
        0b11111111_11111100_00000000_00000000,
        0b11111111_11111110_00000000_00000000,
        0b11111111_11111111_00000000_00000000, // 16
        0b11111111_11111111_10000000_00000000,
        0b11111111_11111111_11000000_00000000,
        0b11111111_11111111_11100000_00000000,
        0b11111111_11111111_11110000_00000000,
        0b11111111_11111111_11111000_00000000,
        0b11111111_11111111_11111100_00000000,
        0b11111111_11111111_11111110_00000000,
        0b11111111_11111111_11111111_00000000, // 24
        0b11111111_11111111_11111111_10000000,
        0b11111111_11111111_11111111_11000000,
        0b11111111_11111111_11111111_11100000,
        0b11111111_11111111_11111111_11110000,
        0b11111111_11111111_11111111_11111000,
        0b11111111_11111111_11111111_11111100,
        0b11111111_11111111_11111111_11111110,
        0b11111111_11111111_11111111_11111111, // 32
    })
    public void testContiguousMaskBits(int mask) {
        IPv4Value netmask = new NetMask(mask);
        assertNotNull(netmask);
        assertEquals(mask, netmask.getValue());
    }


    

    @ParameterizedTest
    @ValueSource(strings = {
        "0.0.0.128",
        "255.0.255.0",
        "255.128.0.1",
        "255.255.0.128",
        "255.0.0.255",
        "255.0.1.0"
    })
    public void testInvalidMaskStrings(String mask) {
        assertThrows(IllegalArgumentException.class, () -> {
            new NetMask(mask);
        });
    }

    
}
