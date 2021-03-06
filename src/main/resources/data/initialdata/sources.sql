CREATE TABLE sources(
    id INTEGER not NULL,
    name VARCHAR(255) not NULL,
    comment VARCHAR(255),
    PRIMARY KEY (id));
    
INSERT INTO sources (id, name, comment) VALUES (0, 'EVENTS (MEETING OR CONFERENCE)', '');
INSERT INTO sources (id, name, comment) VALUES (1, 'PUBLISHED SCIENTIFIC STUDIES', '');
INSERT INTO sources (id, name, comment) VALUES (2, 'PUBLISHED SCIENTIFIC STUDIES: Predictive microbial models and underlying data', '');
INSERT INTO sources (id, name, comment) VALUES (3, 'PUBLISHED SCIENTIFIC STUDIES: Dose-response data and models', '');
INSERT INTO sources (id, name, comment) VALUES (4, 'PUBLISHED SCIENTIFIC STUDIES: Toxicological data and models', '');
INSERT INTO sources (id, name, comment) VALUES (5, 'PUBLISHED SCIENTIFIC STUDIES: Contamination data and exposure models', '');
INSERT INTO sources (id, name, comment) VALUES (6, 'UNPUBLISHED STUDIES (EXPERIMENTS-OBSERVATIONS)', '');
INSERT INTO sources (id, name, comment) VALUES (7, 'UNPUBLISHED STUDIES (EXPERIMENTS-OBSERVATIONS): Studies and surveys', 'Studies and surveys carried out by industry, association (society), etc.');
INSERT INTO sources (id, name, comment) VALUES (8, 'UNPUBLISHED STUDIES (EXPERIMENTS-OBSERVATIONS):   Laboratory (private, research) databases', '');
INSERT INTO sources (id, name, comment) VALUES (9, 'NATIONAL OR INTERNATIONAL OFFICIAL DATA: Food monitoring data', '');
INSERT INTO sources (id, name, comment) VALUES (10, 'NATIONAL OR INTERNATIONAL OFFICIAL DATA:  Human health surveillance data', 'e.g. laboratory diagnostic data, historical outbreaks investigations, biomonitoring survey');
INSERT INTO sources (id, name, comment) VALUES (11, 'NATIONAL OR INTERNATIONAL OFFICIAL DATA: Food consumption survey or regional diet data', '');
INSERT INTO sources (id, name, comment) VALUES (12, 'NATIONAL OR INTERNATIONAL OFFICIAL DATA: Food safety databases', '');
INSERT INTO sources (id, name, comment) VALUES (13, 'OTHER SURVEYS AND QUESTIONNAIRES', '');
INSERT INTO sources (id, name, comment) VALUES (14, 'RISK ASSESSMENTS', 'Risk assessments carried out by national or international agencies and research institutes');
INSERT INTO sources (id, name, comment) VALUES (15, 'RISK ASSESSMENTS:  International risk assessment agencies data', '');
INSERT INTO sources (id, name, comment) VALUES (16, 'RISK ASSESSMENTS: Risk assessments models', '');
INSERT INTO sources (id, name, comment) VALUES (17, 'EXPERT KNOWLEDGE ELICITATION AND EXPERT OPINIONS', '');