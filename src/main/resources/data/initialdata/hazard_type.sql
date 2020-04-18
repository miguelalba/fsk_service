CREATE TABLE hazard_type (
    id INTEGER not NULL,
    name VARCHAR(255) not NULL,
    PRIMARY KEY(id));

INSERT INTO hazard_type (id, name) VALUES (1, 'Biogenic amines');
INSERT INTO hazard_type (id, name) VALUES (2, 'Chemical elements');
INSERT INTO hazard_type (id, name) VALUES (3, 'Food additives');
INSERT INTO hazard_type (id, name) VALUES (4, 'Microorganisms');
INSERT INTO hazard_type (id, name) VALUES (5, 'Not in list');
INSERT INTO hazard_type (id, name) VALUES (6, 'Nutrients');
INSERT INTO hazard_type (id, name) VALUES (7, 'Organic contaminants');
INSERT INTO hazard_type (id, name) VALUES (8, 'Pesticide residues');
INSERT INTO hazard_type (id, name) VALUES (9, 'Radioactivity and isotopes');
INSERT INTO hazard_type (id, name) VALUES (10, 'Residue definition');
INSERT INTO hazard_type (id, name) VALUES (11, 'Toxins');
INSERT INTO hazard_type (id, name) VALUES (12, 'Veterinary medicinal products');
INSERT INTO hazard_type (id, name) VALUES (13, 'Other');