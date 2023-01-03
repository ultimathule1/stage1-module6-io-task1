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
            System.out.println(e.getMessage());
        }
        String name = str.substring(str.toString().indexOf("Name: ") + "Name: ".length());
        int age = Integer.parseInt(str.substring(str.toString().indexOf("Age: ") + "Age: ".length()));
        String email = str.substring(str.toString().indexOf("Email: ") + "Email: ".length());
        long phone = Long.parseLong(str.substring(str.toString().indexOf("Phone: ") + "Phone: ".length()));

        return new Profile(name, age, email, phone);
    }
}
