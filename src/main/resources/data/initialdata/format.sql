CREATE TABLE format(
    id INTEGER not NULL,
    name VARCHAR(255) not NULL,
    comment VARCHAR(255),
    PRIMARY KEY (id));

INSERT INTO format(id, name) VALUES (2, '.fskx');
INSERT INTO format(id, name) VALUES (1, '.pmfx');
INSERT INTO format(id, name) VALUES (3, 'Other');