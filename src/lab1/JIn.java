package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class JIn {
    static String getString() {
        String text = null;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            text = bfr.readLine();
        }catch(IOException e){e.printStackTrace();}
        return text;
    }

    static int getInteger() {
         int integer = -1;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            integer = Integer.parseInt(bfr.readLine());
        }catch(IOException e){e.printStackTrace();}
        return integer;
    }
}