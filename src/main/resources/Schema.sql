CREATE TABLE IF NOT EXISTS Run(
id int NOT NULL,
title varchar(250) NOT NULL, 
started_On timestamp NOT NULL, 
completed_On timestamp NOT NULL,
miles varchar(255),
location varchar(255),
PRIMARY KEY(id)
);