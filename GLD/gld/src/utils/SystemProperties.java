package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wagner
 */
public class SystemProperties {

    /**
     * Variável global que armazena as propriedades do sistema definida no
     * arquivo PropertiesFile.
     */
    public static Properties properties;

    /**
     * Método contrutor da classe SystemProperties.
     */
    public SystemProperties() {
        SystemProperties.properties = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream(System.getProperty("user.dir") + "/src/utils/PropertiesFile.txt");

            SystemProperties.properties.load(in);

            in.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SystemProperties.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SystemProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static void main(final String[] args) {
//        SystemProperties p = new SystemProperties();
//    }
}
