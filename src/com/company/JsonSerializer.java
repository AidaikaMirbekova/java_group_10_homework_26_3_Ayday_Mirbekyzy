package com.company;

import com.google.gson.Gson;

import java.io.*;

public class JsonSerializer {
    public static Database[] getDatabase() throws IOException {
        Gson gson = new Gson();
        try(Reader reader = new FileReader("Database.json")){
            Database[] databases = gson.fromJson(reader,Database[].class);
            for(int i = 0; i < databases.length; i++){
                databases[i].toString();
            }
            return databases;
        }
    }
    public static void writeDatabase(Database[] databases) throws IOException {
        Gson gson = new Gson();
        try(Writer writer = new FileWriter("Database.json")){
            String json = gson.toJson(databases);
            writer.write(json);
        }
    }
}
