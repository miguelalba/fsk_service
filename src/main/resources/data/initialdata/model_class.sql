CREATE TABLE model_class (
    id INTEGER NOT NULL,
    name VARCHAR(64) NOT NULL,
    PRIMARY KEY(id));

INSERT INTO model_class (id, name) VALUES (0, '(Data)');
INSERT INTO model_class (id, name) VALUES (1, 'Consumption model');
INSERT INTO model_class (id, name) VALUES (2, 'Dose-response model');
INSERT INTO model_class (id, name) VALUES (3, 'Exposure model');
INSERT INTO model_class (id, name) VALUES (4, 'Health metrics model');
INSERT INTO model_class (id, name) VALUES (5, 'Other Empirical models');
INSERT INTO model_class (id, name) VALUES (6, 'Predictive model');
INSERT INTO model_class (id, name) VALUES (7, 'Process model');
INSERT INTO model_class (id, name) VALUES (8, 'QRA model');
INSERT INTO model_class (id, name) VALUES (9, 'Risk characterization model');
INSERT INTO model_class (id, name) VALUES (10, 'Toxicological reference value model');
