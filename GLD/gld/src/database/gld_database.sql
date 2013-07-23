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

CREATE TABLE IF NOT EXISTS guideline_rate (
  id_rate int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  guideline_rate varchar(50) NOT NULL,
  demand float DEFAULT NULL,
  peak_demand float DEFAULT NULL,
  off_peak_demand float DEFAULT NULL,
  consumption float DEFAULT NULL,
  comsumption_dry_peak float DEFAULT NULL,
  consumption_dry_off_peak float DEFAULT NULL,
  consumption_humid_peak float DEFAULT NULL,
  consumption_humid_off_peak float DEFAULT NULL,
  transpassed_off_peak float DEFAULT NULL,
  transpassed_peak float DEFAULT NULL,
  timestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  category varchar(50) DEFAULT NULL,
  limit varchar(10) DEFAULT NULL,
  icms float DEFAULT NULL,
  PRIMARY KEY (id_rate)
)

CREATE TABLE IF NOT EXISTS contract (
  id_contract int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  id_rate int(10) unsigned zerofill NOT NULL,
  peak_demand float DEFAULT NULL,
  off_peak_demand float DEFAULT NULL,
  timestamp timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id_contract),
  KEY id_rate (id_rate)
)

ALTER TABLE contract
  ADD CONSTRAINT fk_id_rate FOREIGN KEY (id_rate) REFERENCES guideline_rate (id_rate) ON DELETE CASCADE ON UPDATE CASCADE;
