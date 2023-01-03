package com.epam.mjc.io;

import java.io.File;
import java.io.IOException;

public class FileReader {
    public Profile getDataFromFile(File file) {
        int c;
        StringBuilder str = new StringBuilder();
        try (java.io.FileReader in = new java.io.FileReader(file)) {
            while ((c = in.read()) != -1) {
                str.append((char)c);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
        String name = getName(str.toString());
        int age = getAge(str.toString());
        String email = getEmail(str.toString());
        long phone = getPhone(str.toString());

        return new Profile(name, age, email, phone);
    }

    private String getName(String str) {
        StringBuilder retStr = new StringBuilder();
        for (int i = str.indexOf("Name: ") + "Name: ".length(); str.charAt(i) != '\n'; i++) {
            retStr.append(str.charAt(i));
        }
        return retStr.toString();
    }

    private int getAge(String str) {
        StringBuilder retStr = new StringBuilder();
        for (int i = (str.indexOf("Age: ") + "Age: ".length()); str.charAt(i) != '\n'; i++) {
            retStr.append(str.charAt(i));
        }
        return Integer.parseInt(retStr.toString());
    }

    private String getEmail(String str) {
        StringBuilder retStr = new StringBuilder();
        for (int i = str.indexOf("Email: ") + "Email: ".length(); str.charAt(i) != '\n'; i++) {
            retStr.append(str.charAt(i));
        }
        return retStr.toString();
    }

    private Long getPhone(String str) {
        StringBuilder retStr = new StringBuilder();
        for (int i = str.indexOf("Phone: ") + "Phone: ".length(); str.charAt(i) != '\n'; i++) {
            retStr.append(str.charAt(i));
        }
        return Long.parseLong(retStr.toString());
    }
}
