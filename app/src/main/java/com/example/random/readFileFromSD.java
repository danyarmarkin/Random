package com.example.random;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readFileFromSD{
    public static String file; // 1test github
    public static boolean initRead = false, ioe = false;

        public static void readFileSD() {
            // проверяем доступность SD
            if (!Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                System.out.println("SD карта не доступна");
                ioe = true;
                return;
            }//uyt
            // получаем путь к SD
            File sdPath = Environment.getExternalStorageDirectory();
            // добавляем свой каталог к пути
            sdPath = new File(sdPath.getAbsolutePath() + "/" + "random_data" );
            // формируем объект File, который содержит путь к файлу
            File sdFile = new File(sdPath, file);
            try {
                BufferedReader br = new BufferedReader(new FileReader(sdFile));
                String str = "";
                // читаем содержимое
                while ((str = br.readLine()) != null) {
                    Log.d("file line:", str);
                }

            } catch (FileNotFoundException e) {
                ioe = true;
                e.printStackTrace();

            } catch (IOException e) {
                ioe = true;
                e.printStackTrace();
            }
        }
}
