package com.KaOSrp19;

import com.KaOSrp19.util.ConectorBD;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConectorBD.getConnection();

    }
}
