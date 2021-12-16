package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class WorkWithDatabase implements Conectionable{
    Scanner sc=new Scanner(System.in);
   private Database[] databases;

    public WorkWithDatabase(Database[] databases) {
        this.databases = databases;
    }

    @Override
    public  int openConnection() {
        System.out.println("Connection is open!");
        return 1;
    }

    @Override
     public int closeConnection() {
        System.out.println("Connection is close!");
        return 0;
    }

    @Override
    public void checkConnection() {
        if (openConnection() == open) {
            System.out.println("Connection is open!");
        }else{
            System.out.println("Connection is close!");
        }
    }

    @Override
    public void readOneRecordByIndex() throws IOException {
        try {
        int index = sc.nextInt();
        System.out.println(JsonSerializer.getDatabase()[index]);
            } catch (IOException e) {
            System.out.println("This index not found!");
            readOneRecordByIndex();
        }
    }

    @Override
    public void checkOneRecordKey() throws IOException {
            String key= sc.nextLine();
            for (int i = 0; i < JsonSerializer.getDatabase().length; i++) {
                if (JsonSerializer.getDatabase()[i].getKey().equals(key) && JsonSerializer.getDatabase()[i].getKey().contains(key)) {
                    System.out.println(JsonSerializer.getDatabase()[i]);
                }
                if (!JsonSerializer.getDatabase().equals(key)){
                    throw new IOException("Not found that record!");
                }
            }
    }

    public void readOneRecordByKey() throws Exception{
           String key = sc.nextLine();
            for (int i = 0; i < databases.length; i++) {
                if (databases[i].equals(key)&& databases[i].getKey().contains(key)) {
                    System.out.println(databases[i]);
                }
            }
            if (!JsonSerializer.getDatabase().equals(key)){
            throw new Exception("This key not found!");
        }
    }

    @Override
    public void readSetRecords()throws ArrayIndexOutOfBoundsException{
        try {
            int firstIndex = sc.nextInt();
            int secondIndex = sc.nextInt();
            System.out.println(Arrays.copyOfRange(JsonSerializer.getDatabase(),firstIndex,secondIndex));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("This index not found!");
            readSetRecords();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findAllNumberRecord() {
        try {
            System.out.println(JsonSerializer.getDatabase().length);
        } catch (IOException e) {
            System.out.println("Not found file!");
        }
    }

    @Override
    public void addRecordInDatabase() {
        try {
            JsonSerializer.writeDatabase(databases);
        } catch (IOException e) {
            System.out.println("Not found file!");
        }
    }

    @Override
    public void updateRecordByIndex(Database value, int index) {
        try{
            index=sc.nextInt();
            databases[index] = value;
        }catch (IndexOutOfBoundsException ex){
            System.out.println("Not found file!");
        }catch (NumberFormatException nfe){
            System.out.println("Please enter the number!");
        }
    }

    @Override
    public void updateRecordByKey(String key, String value) {
        try {
            value=sc.nextLine();
            for (int i = 0; i < databases.length; i++){
                if(databases[i].getKey().equals(key)){
                    databases[i].setValue(value);
                    return;
                }
            }
            throw new Exception("Элемент по такому ключу не найден");
        }catch (Exception ex){
            System.out.println("Not found file!");
        }
    }

    @Override
    public String toString() {
        return "WorkWithDatabase{" +
                "databases=" + Arrays.toString(databases) +
                '}';
    }
}

