package com.automated_legal.system.models;

public class UserPasswordVerification {

    public static boolean verifyPassword(String enteredPassword, String hashedPassword) {
        // Hash the entered password using the same method as during password creation
        String enteredPasswordHashed = UserPasswordHashing.hashPassword(enteredPassword);

        // Compare the hashed passwords
        return enteredPasswordHashed != null && enteredPasswordHashed.equals(hashedPassword);
    }

}

