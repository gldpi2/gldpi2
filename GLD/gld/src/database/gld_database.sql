CREATE DATABASE gld_database;

USE gld_database;

CREATE TABLE mensuration (
    id_mensuration INT AUTO_INCREMENT PRIMARY KEY,
    
    flow FLOAT NOT NULL,
    tension FLOAT NOT NULL,
    frequency FLOAT NOT NULL,
    tension FLOAT NOT NULL,
    power_factor FLOAT NOT NULL,
    active_potency FLOAT NOT NULL
);