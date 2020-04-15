CREATE TABLE availability (
    id VARCHAR(50) not NULL,
    name VARCHAR(255) not NULL,
    comment VARCHAR(255),
    PRIMARY KEY (id));

INSERT INTO availability (id, name, comment) VALUES ('Availability_2', 'Closed access', '');
INSERT INTO availability (id, name, comment) VALUES ('Availability_4', 'Embargoed access', '');
INSERT INTO availability (id, name, comment) VALUES ('Availability_1', 'Open access', '');
INSERT INTO availability (id, name, comment) VALUES ('Availability_5', 'Other', '');
INSERT INTO availability (id, name, comment) VALUES ('Availability_3', 'Restricted access', '');
