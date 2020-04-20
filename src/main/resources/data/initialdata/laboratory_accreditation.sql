CREATE TABLE laboratory_accreditation (
    id INTEGER NOT NULL,
    name VARCHAR(50),
    ssd VARCHAR(5), -- TODO: Is it really from SSD? I cannot find the actual SSD vocabulary.
    PRIMARY KEY(id));

INSERT INTO laboratory_accreditation (id, name, ssd) VALUES (0, 'Accredited', 'L001A');
INSERT INTO laboratory_accreditation (id, name, ssd) VALUES (1, 'None', 'L003A');
INSERT INTO laboratory_accreditation (id, name, ssd) VALUES (2, 'Other', 'Other');
INSERT INTO laboratory_accreditation (id, name, ssd) VALUES (3, 'Third party assessment', 'L002A');
