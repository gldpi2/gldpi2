CREATE DATABASE gld_database;

USE gld_database;

CREATE TABLE meter (
    id_meter INT UNSIGNED ZEROFILL AUTO_INCREMENT PRIMARY KEY,
    
    id_environment INT UNSIGNED ZEROFILL NOT NULL
);

CREATE TABLE mensuration (
    id_mensuration INT UNSIGNED ZEROFILL AUTO_INCREMENT,
    
    id_meter INT UNSIGNED ZEROFILL NOT NULL, 
    flow FLOAT NOT NULL,
    tension FLOAT NOT NULL,
    frequency FLOAT NOT NULL,

    PRIMARY KEY (id_mensuration),
    FOREIGN KEY (id_meter) REFERENCES meter(id_meter)
);

