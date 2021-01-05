-- create schemas
CREATE USER asptsm_dev PASSWORD 'asptsm_dev';
ALTER ROLE asptsm_dev SET SEARCH_PATH = "$user",public;
CREATE SCHEMA AUTHORIZATION asptsm_dev;
