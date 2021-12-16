package com.company;

import java.io.IOException;

public interface Conectionable {
    int open=1;
    int close=0;

   default int openConnection() {return open;}

     default int closeConnection() {return close;}
     void checkConnection();
     void readOneRecordByIndex() throws IOException;
     void checkOneRecordKey() throws IOException;
    void readOneRecordByKey() throws Exception;
    void readSetRecords();
    void findAllNumberRecord();
    void addRecordInDatabase();

    void updateRecordByIndex(Database value, int index);

    void updateRecordByKey(String key, String value);

}
