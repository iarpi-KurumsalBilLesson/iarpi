CREATE TABLE BSMGRIRPROT002 (
    id              SERIAL PRIMARY KEY,
    doc_type        VARCHAR(50) NOT NULL,
    doc_type_text   VARCHAR(255) NOT NULL,
    is_passive      BOOLEAN NOT NULL,
    com_id          INT
--                                 CONSTRAINT fk_com_code
--                                     FOREIGN KEY (com_code) REFERENCES BSMGRIRPGEN001 (COM_CODE) -- BSMGRIRPGEN001 tablosuna 1-m ilişki ile bağlanma
);

ALTER TABLE bsmgrirpwcm001
    ALTER COLUMN is_passive SET NOT NULL;



ALTER TABLE bsmgrirpwcm001
    ADD COLUMN com_id INT;


ALTER TABLE bsmgrirpwcm001
    ADD CONSTRAINT fk_com_id
        FOREIGN KEY (com_id)
            REFERENCES BSMGRIRPGEN001 (id);



