-- Type of sampling program (Programme type in EFSA's SSD)
CREATE TABLE sampling_program (
    id INTEGER NOT NULL,
    name VARCHAR(255),
    progtype CHAR(5),
    PRIMARY KEY(id));

INSERT INTO sampling_program (id, name, progtype) VALUES (0, 'Clinical investigations', 'K020A');
INSERT INTO sampling_program (id, name, progtype) VALUES (1, 'Control and eradication programmes', 'K021A');
INSERT INTO sampling_program (id, name, progtype) VALUES (2, 'Diet study', 'K010A');
INSERT INTO sampling_program (id, name, progtype) VALUES (3, 'EU increased control programme on imported food', 'K019A');
INSERT INTO sampling_program (id, name, progtype) VALUES (4, 'Industry - private programme', 'K012A');
INSERT INTO sampling_program (id, name, progtype) VALUES (5, 'Monitoring', 'K022A');
INSERT INTO sampling_program (id, name, progtype) VALUES (6, 'Monitoring - active', 'K023A');
INSERT INTO sampling_program (id, name, progtype) VALUES (7, 'Monitoring - EFSA specifications', 'K025A');
INSERT INTO sampling_program (id, name, progtype) VALUES (8, 'Monitoring - passive', 'K024A');
INSERT INTO sampling_program (id, name, progtype) VALUES (9, 'Official (EU) programme', 'K009A');
INSERT INTO sampling_program (id, name, progtype) VALUES (10, 'Official (National and EU) programme', 'K018A');
INSERT INTO sampling_program (id, name, progtype) VALUES (11, 'Official (National) programme', 'K005A');
INSERT INTO sampling_program (id, name, progtype) VALUES (12, 'Other - Combination of several programmes', 'K014A');
INSERT INTO sampling_program (id, name, progtype) VALUES (13, 'Surveillance', 'K026A');
INSERT INTO sampling_program (id, name, progtype) VALUES (14, 'Surveillance active', 'K030A');
INSERT INTO sampling_program (id, name, progtype) VALUES (15, 'Surveillance passive', 'K031A');
INSERT INTO sampling_program (id, name, progtype) VALUES (16, 'Survey', 'K013A');
INSERT INTO sampling_program (id, name, progtype) VALUES (17, 'Survey - EU baseline survey', 'K027A');
INSERT INTO sampling_program (id, name, progtype) VALUES (18, 'Survey - national survey', 'K028A');
INSERT INTO sampling_program (id, name, progtype) VALUES (19, 'Unspecified', 'K029A');
