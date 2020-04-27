CREATE TABLE ind_sum (
    id INTEGER NOT NULL,
    name VARCHAR(50),
    ssd CHAR(5), -- TODO: Could not find it in EFSA's SDD
    PRIMARY KEY(id));

INSERT INTO ind_sum (id, name, ssd) VALUES (0, 'Individual', 'P001A');
INSERT INTO ind_sum (id, name, ssd) VALUES (1, 'Part of a sum', 'P002A');
INSERT INTO ind_sum (id, name, ssd) VALUES (2, 'Sum', 'P003A');
INSERT INTO ind_sum (id, name, ssd) VALUES (3, 'Sum based on subset', 'P004A');
