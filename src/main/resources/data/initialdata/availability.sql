CREATE TABLE availability (
    id INTEGER not NULL,
    name VARCHAR(255) not NULL,
    comment VARCHAR(255),
    PRIMARY KEY (id));

INSERT INTO availability (id, name, comment) VALUES (1, 'Open access', '');
INSERT INTO availability (id, name, comment) VALUES (2, 'Closed access', '');
INSERT INTO availability (id, name, comment) VALUES (3, 'Restricted access', '');
INSERT INTO availability (id, name, comment) VALUES (4, 'Embargoed access', '');
INSERT INTO availability (id, name, comment) VALUES (5, 'Other', '');
