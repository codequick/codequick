
CREATE SEQUENCE sample.tb_sample_id_seq;

CREATE TABLE sample.tb_sample (
                id INTEGER NOT NULL DEFAULT nextval('sample.tb_sample_id_seq'),
                char_field VARCHAR(50),
                date_field DATE,
                timestamp_field TIMESTAMP,
                boolean_field BOOLEAN,
                float_field REAL,
                CONSTRAINT tb_sample_pk PRIMARY KEY (id)
);


ALTER SEQUENCE sample.tb_sample_id_seq OWNED BY sample.tb_sample.id;
