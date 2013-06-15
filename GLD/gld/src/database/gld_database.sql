CREATE DATABASE gld_database;

USE gld_database;

CREATE TABLE mensuration (
    id_mensuration INT UNSIGNED ZEROFILL AUTO_INCREMENT PRIMARY KEY,
    
    id_meter INT UNSIGNED ZEROFILL, 
    flow FLOAT NOT NULL,
    tension FLOAT NOT NULL,
    frequency FLOAT NOT NULL,
    power_factor FLOAT NOT NULL,
    active_potency FLOAT NOT NULL
);