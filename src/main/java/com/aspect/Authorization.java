package com.aspect;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import io.github.cdimascio.dotenv.Dotenv;

public class Authorization {

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    // Method to verify the password
    public static boolean verifyPassword(String enteredPassword) throws NoSuchAlgorithmException {
        String hashedEnteredPassword = hashPassword(enteredPassword);
        Dotenv dotenv = Dotenv.load();
        String storedHashedPassword = dotenv.get("passwd");
        return hashedEnteredPassword.equals(storedHashedPassword);
    }
}
