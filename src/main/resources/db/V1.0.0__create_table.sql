-- Country Table
CREATE TABLE BSMGRIRPGEN003
(
    id           SERIAL PRIMARY KEY,
    COUNTRY_CODE VARCHAR(4)  NOT NULL UNIQUE,
    COUNTRY_TEXT VARCHAR(80) NOT NULL
);

-- City Table
CREATE TABLE BSMGRIRPGEN004
(
    id         SERIAL PRIMARY KEY,          -- Otomatik artan id
    CITY_CODE  VARCHAR(4)  NOT NULL UNIQUE, -- CityCode benzersiz
    CITY_TEXT  VARCHAR(80) NOT NULL,        -- Şehir metni
    COUNTRY_ID INT,
    CONSTRAINT fk_city_country FOREIGN KEY (COUNTRY_ID) REFERENCES BSMGRIRPGEN003 (id) ON DELETE SET NULL
);

-- Language Table
CREATE TABLE BSMGRIRPGEN002
(
    id       SERIAL PRIMARY KEY,          -- Otomatik artan id
    LAN_CODE VARCHAR(4)  NOT NULL UNIQUE, -- Dil kodu benzersiz
    LAN_TEXT VARCHAR(80) NOT NULL         -- Dil metni
);

-- Company Table
CREATE TABLE BSMGRIRPGEN001
(
    id         SERIAL PRIMARY KEY,         -- Otomatik artan id
    COM_CODE   VARCHAR(4) NOT NULL UNIQUE, -- Şirket kodu benzersiz
    COM_TEXT   VARCHAR(80) NOT NULL        -- Şirket metni
);

-- Address Table
CREATE TABLE BSMGRIRPGEN0011
(
    id           SERIAL PRIMARY KEY,  -- Otomatik artan id
    COM_CODE_ID     INT NOT NULL, -- Şirket kodu foreign key
    COUNTRY_CODE_ID INT        NOT NULL, -- Ülke foreign key
    CITY_CODE_ID    INT        NOT NULL, -- Şehir foreign key
    ADDRESS1     TEXT,                -- Adres satırı 1
    ADDRESS2     TEXT,                -- Adres satırı 2
    CONSTRAINT fk_address_company FOREIGN KEY (COM_CODE_ID) REFERENCES BSMGRIRPGEN001 (id) ON DELETE CASCADE,
    CONSTRAINT fk_address_country FOREIGN KEY (COUNTRY_CODE_ID) REFERENCES BSMGRIRPGEN003 (id) ON DELETE CASCADE,
    CONSTRAINT fk_address_city FOREIGN KEY (CITY_CODE_ID) REFERENCES BSMGRIRPGEN004 (id) ON DELETE CASCADE
);

-- Company Language M-M
CREATE TABLE company_language
(
    company_id  INT NOT NULL,
    language_id INT NOT NULL,
    PRIMARY KEY (company_id, language_id),
    CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES BSMGRIRPGEN001 (id),
    CONSTRAINT fk_language_id FOREIGN KEY (company_id) REFERENCES BSMGRIRPGEN001 (id)
);

-- Unit Table
CREATE TABLE BSMGRIRPGEN005
(
    id             SERIAL PRIMARY KEY,
    UNIT_CODE      VARCHAR(3)  NOT NULL,
    UNIT_TEXT      VARCHAR(80) NOT NULL,
    IS_MAIN_UNIT   BOOLEAN,
    MAIN_UNIT_CODE VARCHAR(3)
);
-- Unit Table M-M
CREATE TABLE company_unit
(
    company_id INT NOT NULL,
    unit_id    INT NOT NULL,
    PRIMARY KEY (company_id, unit_id),
    CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES BSMGRIRPGEN001 (id),
    CONSTRAINT fk_unit_id FOREIGN KEY (unit_id) REFERENCES BSMGRIRPGEN005 (id)
);

-- Material Table
CREATE TABLE BSMGRIRPMAT001
(
    id            SERIAL PRIMARY KEY,
    DOC_TYPE      VARCHAR(4)  NOT NULL,
    DOC_TYPE_TEXT VARCHAR(80) NOT NULL,
    IS_PASSIVE    BOOLEAN
);
-- Material Table M-M
CREATE TABLE company_material
(
    company_id  INT NOT NULL,
    material_id INT NOT NULL,
    PRIMARY KEY (company_id, material_id),
    CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES BSMGRIRPGEN001 (id),
    CONSTRAINT fk_material_id FOREIGN KEY (material_id) REFERENCES BSMGRIRPMAT001 (id)
);

-- CostCenter Table
CREATE TABLE BSMGRIRPCCM001
(
    id            SERIAL PRIMARY KEY,
    DOC_TYPE      VARCHAR(4)  NOT NULL,
    DOC_TYPE_TEXT VARCHAR(80) NOT NULL,
    IS_PASSIVE    BOOLEAN
);
-- CostCenter Table M-M
CREATE TABLE company_costCenter
(
    company_id    INT NOT NULL,
    costCenter_id INT NOT NULL,
    PRIMARY KEY (company_id, costCenter_id),
    CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES BSMGRIRPGEN001 (id),
    CONSTRAINT fk_costCenter_id FOREIGN KEY (costCenter_id) REFERENCES BSMGRIRPCCM001 (id)
);

-- BOM Table
CREATE TABLE BSMGRIRPBOM001
(
    id            SERIAL PRIMARY KEY,
    DOC_TYPE      VARCHAR(4)  NOT NULL,
    DOC_TYPE_TEXT VARCHAR(80) NOT NULL,
    IS_PASSIVE    BOOLEAN
);
-- BOM Table M-M
CREATE TABLE company_bom
(
    company_id INT NOT NULL,
    bom_id     INT NOT NULL,
    PRIMARY KEY (company_id, bom_id),
    CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES BSMGRIRPGEN001 (id),
    CONSTRAINT fk_bom_id FOREIGN KEY (bom_id) REFERENCES BSMGRIRPBOM001 (id)
);

-- Route Table
CREATE TABLE BSMGRIRPROT001
(
    id            SERIAL PRIMARY KEY,
    DOC_TYPE      VARCHAR(4)  NOT NULL,
    DOC_TYPE_TEXT VARCHAR(80) NOT NULL,
    IS_PASSIVE    BOOLEAN
);
-- Route Table M-M
CREATE TABLE company_route
(
    company_id INT NOT NULL,
    route_id   INT NOT NULL,
    PRIMARY KEY (company_id, route_id),
    CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES BSMGRIRPGEN001 (id),
    CONSTRAINT fk_route_id FOREIGN KEY (route_id) REFERENCES BSMGRIRPROT001 (id)
);

-- Work-Center Table
CREATE TABLE BSMGRIRPWCM001
(
    id            SERIAL PRIMARY KEY,
    DOC_TYPE      VARCHAR(4)  NOT NULL,
    DOC_TYPE_TEXT VARCHAR(80) NOT NULL,
    IS_PASSIVE    BOOLEAN
);
-- Work-Center Table M-M
CREATE TABLE company_workCenter
(
    company_id    INT NOT NULL,
    workCenter_id INT NOT NULL,
    PRIMARY KEY (company_id, workCenter_id),
    CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES BSMGRIRPGEN001 (id),
    CONSTRAINT fk_workCenter_id FOREIGN KEY (workCenter_id) REFERENCES BSMGRIRPWCM001 (id)
);

-- Operation Table
CREATE TABLE BSMGRIRPROT003
(
    id            SERIAL PRIMARY KEY,
    DOC_TYPE      VARCHAR(4)  NOT NULL,
    DOC_TYPE_TEXT VARCHAR(80) NOT NULL,
    IS_PASSIVE    BOOLEAN
);
-- Operation Table M-M
CREATE TABLE company_operation
(
    company_id   INT NOT NULL,
    operation_id INT NOT NULL,
    PRIMARY KEY (company_id, operation_id),
    CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES BSMGRIRPGEN001 (id),
    CONSTRAINT fk_operation_id FOREIGN KEY (operation_id) REFERENCES BSMGRIRPROT003 (id)
);

INSERT INTO BSMGRIRPGEN001 (com_code, com_text)
VALUES ('COM1', 'trying company');

INSERT INTO BSMGRIRPGEN002 ( lan_code, lan_text)
VALUES ('TRY', 'trying language');

INSERT INTO BSMGRIRPGEN003 ( country_code, country_text)
VALUES ( 'TRU', 'test');

INSERT INTO BSMGRIRPGEN004 ( city_code, city_text, COUNTRY_ID)
VALUES ('CTY1', 'deneme', 1);

INSERT INTO BSMGRIRPGEN005 ( unit_code, unit_text, is_main_unit, main_unit_code)
VALUES ('UNI', 'deneme', TRUE,  'DN');

INSERT INTO BSMGRIRPMAT001 (doc_type, doc_type_text, is_passive)
VALUES ('DOC1', 'deneme', false);

INSERT INTO BSMGRIRPCCM001 (doc_type, doc_type_text, is_passive)
VALUES ('DOC2', 'deneme', false);

INSERT INTO BSMGRIRPBOM001 ( doc_type, doc_type_text, is_passive)
VALUES ('DOC3', 'deneme', false);

INSERT INTO BSMGRIRPROT001 (doc_type, doc_type_text, is_passive)
VALUES ('DOC3', 'deneme', false);

INSERT INTO BSMGRIRPROT001 ( doc_type, doc_type_text, is_passive)
VALUES ('DOC3', 'deneme', false);

INSERT INTO BSMGRIRPROT003 (doc_type, doc_type_text, is_passive)
VALUES ('DOC3', 'deneme', false);
