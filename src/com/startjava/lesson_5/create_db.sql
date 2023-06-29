CREATE DATABASE Jaegers;

\c jaegers

DROP TABLE IF EXISTS jaeger;

CREATE TABLE jaeger (
    id SERIAL PRIMARY KEY,
    model_name TEXT,
    mark TEXT,
    height INTEGER,
    weight DECIMAL,
    status TEXT,
    origin TEXT,
    launch DATE,
    kaiju_kill INTEGER)
;

\ir init_db.sql
\ir queries.sql