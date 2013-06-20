/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wagner
 */
public class Properties {

    public static int refreshTimeMilis = 0;

    public Properties() {

        FileReader file = null;

        try {

            file = new FileReader(System.getProperty("user.dir") + "/src/utils/PropertiesFile.txt");

            BufferedReader reader = new BufferedReader(file);
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#") || line.startsWith("\n") || line.length() == 0) {
                    continue;
                }

                int equalPos = line.indexOf("=");
                String option = line.substring(0, equalPos);

                switch (option) {
                    case "REFRESH_TIME":
                        this.refreshTimeMilis = new Integer(line.substring(equalPos + 1));
                        System.out.println(this.refreshTimeMilis);
                        break;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (this.refreshTimeMilis <= 0) {
                refreshTimeMilis = 1000;
            }

            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

//    public int getRefreshTimeMilis() {
//        return refreshTimeMilis;
//    }
    public static void main(final String[] args) {
        Properties p = new Properties();
    }
}
