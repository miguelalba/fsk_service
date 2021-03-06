CREATE TABLE language (
    id INTEGER NOT NULL,
    code CHAR(2) NOT NULL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY(code));

INSERT INTO language (id, code, name) VALUES (0, 'bg', 'Bulgarian');
INSERT INTO language (id, code, name) VALUES (1, 'cs', 'Czech');
INSERT INTO language (id, code, name) VALUES (2, 'da', 'Danish');
INSERT INTO language (id, code, name) VALUES (3, 'nl', 'Dutch');
INSERT INTO language (id, code, name) VALUES (4, 'en', 'English');
INSERT INTO language (id, code, name) VALUES (5, 'et', 'Estonian');
INSERT INTO language (id, code, name) VALUES (6, 'fi', 'Finnish');
INSERT INTO language (id, code, name) VALUES (7, 'fr', 'French');
INSERT INTO language (id, code, name) VALUES (8, 'de', 'German');
INSERT INTO language (id, code, name) VALUES (9, 'el', 'Greek');
INSERT INTO language (id, code, name) VALUES (10, 'hu', 'Hungarian');
INSERT INTO language (id, code, name) VALUES (11, 'is', 'Icelandic');
INSERT INTO language (id, code, name) VALUES (12, 'ga', 'Irish');
INSERT INTO language (id, code, name) VALUES (13, 'it', 'Italian');
INSERT INTO language (id, code, name) VALUES (14, 'lv', 'Latvian');
INSERT INTO language (id, code, name) VALUES (15, 'lt', 'Lithuanian');
INSERT INTO language (id, code, name) VALUES (16, 'mt', 'Maltese');
INSERT INTO language (id, code, name) VALUES (17, 'no', 'Norwegian');
INSERT INTO language (id, code, name) VALUES (18, 'pl', 'Polish');
INSERT INTO language (id, code, name) VALUES (19, 'pt', 'Portuguese');
INSERT INTO language (id, code, name) VALUES (20, 'ro', 'Romanian');
INSERT INTO language (id, code, name) VALUES (21, 'sk', 'Slovakian');
INSERT INTO language (id, code, name) VALUES (22, 'sl', 'Slovene');
INSERT INTO language (id, code, name) VALUES (23, 'es', 'Spanish');
INSERT INTO language (id, code, name) VALUES (24, 'sv', 'Swedish');
