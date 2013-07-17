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
    `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_mensuration),
    FOREIGN KEY (id_meter) REFERENCES meter(id_meter)
);

CREATE TABLE IF NOT EXISTS user (
    id_user INT UNSIGNED ZEROFILL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    register VARCHAR(12) NOT NULL,
    password VARCHAR(10) NOT NULL,
    profile INT(1) UNSIGNED NOT NULL,
    email VARCHAR(50),
    cell_oi VARCHAR(13),
    cell_vivo VARCHAR(13),
    cell_tim VARCHAR(13),
    cell_claro VARCHAR(13),
    enable INT(1) UNSIGNED,
    PRIMARY KEY (id_user),
    UNIQUE (register)
);

CREATE TABLE guideline_rate(
id_rate INT UNSIGNED ZEROFILL AUTO_INCREMENT ,
guideline_rate VARCHAR( 50 ) NOT NULL ,
peak_demand FLOAT,
out_peak_demand FLOAT,
peak_energy_dry FLOAT,
out_peak_energy_dry FLOAT,
peak_energy_humid FLOAT,
out_peak_energy_humid FLOAT,
value_transpassed FLOAT,
`timestamp` timestamp DEFAULT CURRENT_TIMESTAMP ,
PRIMARY KEY ( id_rate )
)