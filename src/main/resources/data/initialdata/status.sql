CREATE TABLE status (
    id INTEGER NOT NULL,
    name VARCHAR(10) NOT NULL,
    comment VARCHAR(128),
    PRIMARY KEY(id));

INSERT INTO status (id, name, comment) VALUES (1, 'Curated', 'Model classified according to certain quality criteria.');
INSERT INTO status (id, name, comment) VALUES (2, 'Uncurated', 'Model not classified according to certain quality criteria.');
INSERT INTO status (id, name) VALUES (3, 'Other');
