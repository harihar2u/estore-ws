-- create schemas
CREATE USER andis_6 PASSWORD 'andis_6';
ALTER ROLE andis_6 SET SEARCH_PATH = "$user",public;
CREATE SCHEMA AUTHORIZATION andis_6;
