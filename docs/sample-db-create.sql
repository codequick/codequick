CREATE ROLE codequick_user LOGIN
  CREATEDB CREATEROLE
   VALID UNTIL 'infinity';

CREATE DATABASE codequick_db
  WITH ENCODING='UTF8'
       OWNER=codequick_user
       CONNECTION LIMIT=-1;

CREATE SCHEMA sample
       AUTHORIZATION codequick_user;
	   