package com.automated_legal.system.models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserPasswordHashing {

    public static String hashPassword (String password) {
        try {
            // Create SHA-512 MessageDigest instance
            MessageDigest digest = MessageDigest.getInstance("SHA-512");

            // Convert the password string to bytes
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);

            // Perform the hashing
            byte[] hashedBytes = digest.digest(passwordBytes);

            // Convert the hashed bytes to hexadecimal representation
            StringBuilder stringBuilder = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                stringBuilder.append(String.format("%02x", hashedByte));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("could not hash password");
        }
    }

}
