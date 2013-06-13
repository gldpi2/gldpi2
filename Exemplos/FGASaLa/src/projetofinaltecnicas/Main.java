package projetofinaltecnicas;

import java.sql.*;
import javax.swing.*;
import db.*;
import janelas.MenuPrincipal;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author itallorossi
 */

public class Main {

    public static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // TODO code application logic here
        Conectar conect = new Conectar();

        /**
         * Criação do Documento de Log
         */
        try{
            Handler console = new ConsoleHandler();
            Handler file = new FileHandler("./FGASaLa%g.txt");

            console.setLevel(Level.ALL);

            file.setLevel(Level.ALL);
            file.setFormatter(new java.util.logging.SimpleFormatter());

            log.addHandler(file);
            log.addHandler(console);

            log.setUseParentHandlers(false);
        }catch(IOException e){
            e.printStackTrace();
        }

        /**
         * Colocando senha e usuário do banco de dados de duas formas:
         * 1. Pedindo ao usuário que insira as informações do banco de dados
         * 2. Colocando o padrão do XAMPP
         */
        conect.setUSER(JOptionPane.showInputDialog(null,"Entre com o USER do banco de dados","USER",JOptionPane.QUESTION_MESSAGE));
        conect.setPW(JOptionPane.showInputDialog(null,"Entre com o PASSWORD do banco de dados","PASSWORD",JOptionPane.QUESTION_MESSAGE));
        //conect.setUSER("root");
        //conect.setPW("");

        log.info("Programa iniciado!");

        /**
         * Recolhe do sistema o idioma padrão da máquina
         */
        
        Locale locale = Locale.getDefault();
        
        try
        {
            conect.conectar();
            new MenuPrincipal(locale.toString()).setVisible(true);
            log.info("Conectado com o banco de dados, aplicação iniciada com sucesso!");
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"O programa será fechado!\nUSER e/ou PASSWORD são invalidos tente outra vez!","ERRO!!!",JOptionPane.ERROR_MESSAGE);
            log.severe("Não foi possivel conectar com o banco de dados, a aplicação foi fechada!");
            ex.printStackTrace();
        }
    }
}