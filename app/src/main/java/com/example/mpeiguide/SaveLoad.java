package com.example.mpeiguide;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLoad {

    public static void save(Context context,String fileName, Object object) throws IOException {
        FileOutputStream fileOutputStream = context.openFileOutput(fileName,Context.MODE_PRIVATE);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(object);
        outputStream.flush();
        outputStream.close();
        fileOutputStream.close();
    }

    public static Object load(Context context,String fileName) throws Exception{
        FileInputStream fileInputStream = context.openFileInput(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }

}
