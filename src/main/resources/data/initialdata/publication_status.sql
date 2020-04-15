CREATE TABLE publication_status(
    id VARCHAR(50) not NULL,
    name VARCHAR(50) not NULL,
    comment VARCHAR(255),
    PRIMARY KEY (id));

INSERT INTO publication_status (id, name, comment) VALUES ('Publication Status_1', 'Accepted', 'Accepted for publication after peer reviewing.');
INSERT INTO publication_status (id, name, comment) VALUES ('Publication Status_2', 'Draft', 'Document drafted');
INSERT INTO publication_status (id, name, comment) VALUES ('Publication Status_3', 'Forthcoming', 'Document to be published');
INSERT INTO publication_status (id, name, comment) VALUES ('Publication Status_4', 'Legal', 'Legal document');
INSERT INTO publication_status (id, name, comment) VALUES ('Publication Status_5', 'Non peer reviewed', 'A document that is not peer reviewed');
INSERT INTO publication_status (id, name, comment) VALUES ('Publication Status_10', 'Other', '');
INSERT INTO publication_status (id, name, comment) VALUES ('Publication Status_6', 'Peer reviewed', 'The process by which articles are chosen to be included in a refereed journal. An editorial board consisting of experts in the same field as the author review the article and decide if it is authoritative enough for publication.');
INSERT INTO publication_status (id, name, comment) VALUES ('Publication Status_7', 'Published', 'Published document');
INSERT INTO publication_status (id, name, comment) VALUES ('Publication Status_8', 'Rejected', 'Rejected for publication after peer reviewing.');
INSERT INTO publication_status (id, name, comment) VALUES ('Publication Status_9', 'Unpublished', 'Unpublished document');
