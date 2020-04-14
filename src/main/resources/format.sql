CREATE TABLE format(
    id VARCHAR(50) not NULL,
    name VARCHAR(255) not NULL,
    comment VARCHAR(255),
    PRIMARY KEY (id));

INSERT INTO format(id, name) VALUES ('Format_2', '.fskx');
INSERT INTO format(id, name) VALUES ('Format_1', '.pmfx');
INSERT INTO format(id, name) VALUES ('Format_3', 'Other');