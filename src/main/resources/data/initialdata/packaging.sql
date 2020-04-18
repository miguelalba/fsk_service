CREATE TABLE packaging (
    id INTEGER not NULL,
    name VARCHAR(255) not NULL,
    ssd CHAR(5) not NULL, -- EFSA's SSD prodPackaging (xs:string(5))
    comment VARCHAR(255),
    PRIMARY KEY(id));

INSERT INTO packaging (id, name, ssd) VALUES (0, 'Aluminium foil - aluminium sheet', 'H510A');
INSERT INTO packaging (id, name, ssd) VALUES (1, 'Artificial casing', 'H066A');
INSERT INTO packaging (id, name, ssd) VALUES (2, 'Artificial fibre fabric', 'H032A');
INSERT INTO packaging (id, name, ssd) VALUES (3, 'Blister (film)', 'H600A');
INSERT INTO packaging (id, name, ssd) VALUES (4, 'Cardboard - paperboard', 'H012A');
INSERT INTO packaging (id, name, ssd) VALUES (5, 'Cellophane', 'H011A');
INSERT INTO packaging (id, name, ssd) VALUES (6, 'Combined aluminium and film packaging', 'H161A');
INSERT INTO packaging (id, name, ssd) VALUES (7, 'Combined material', 'H150A');
INSERT INTO packaging (id, name, ssd) VALUES (8, 'Combined paper and film packaging', 'H160A');
INSERT INTO packaging (id, name, ssd) VALUES (9, 'Combined styropor and film packaging', 'H162A');
INSERT INTO packaging (id, name, ssd) VALUES (10, 'Fabric - textile material', 'H030A');
INSERT INTO packaging (id, name, ssd) VALUES (11, 'Glass', 'H200A');
INSERT INTO packaging (id, name, ssd) VALUES (12, 'High-grade steel or stainless steel or: Fine steel', 'H534A');
INSERT INTO packaging (id, name, ssd) VALUES (13, 'Jute', 'H034A');
INSERT INTO packaging (id, name, ssd) VALUES (14, 'Laminated film; composite film', 'H151A');
INSERT INTO packaging (id, name, ssd) VALUES (15, 'Metal', 'H500A');
INSERT INTO packaging (id, name, ssd) VALUES (16, 'Metal alloy', 'H501A');
INSERT INTO packaging (id, name, ssd) VALUES (17, 'Mixed fibre fabric', 'H033A');
INSERT INTO packaging (id, name, ssd) VALUES (18, 'Natural fibre fabric', 'H031A');
INSERT INTO packaging (id, name, ssd) VALUES (19, 'No information', 'H999A');
INSERT INTO packaging (id, name, ssd) VALUES (20, 'Not packed (loose; open)', 'H001A');
INSERT INTO packaging (id, name, ssd) VALUES (21, 'Packed', 'H003A');
INSERT INTO packaging (id, name, ssd) VALUES (22, 'Paper', 'H010A');
INSERT INTO packaging (id, name, ssd) VALUES (23, 'Parchment', 'H015A');
INSERT INTO packaging (id, name, ssd) VALUES (24, 'PET Polyethylene terephthalate', 'H125A');
INSERT INTO packaging (id, name, ssd) VALUES (25, 'Plastic - plastic film', 'H100A');
INSERT INTO packaging (id, name, ssd) VALUES (26, 'Polyacryl', 'H124A');
INSERT INTO packaging (id, name, ssd) VALUES (27, 'Polyamide', 'H115A');
INSERT INTO packaging (id, name, ssd) VALUES (28, 'Polycarbonate', 'H118A');
INSERT INTO packaging (id, name, ssd) VALUES (29, 'Polyethylene', 'H106A');
INSERT INTO packaging (id, name, ssd) VALUES (30, 'Polymethane', 'H121A');
INSERT INTO packaging (id, name, ssd) VALUES (31, 'Polypropylene', 'H107A');
INSERT INTO packaging (id, name, ssd) VALUES (32, 'Polystyrene', 'H109A');
INSERT INTO packaging (id, name, ssd) VALUES (33, 'Polyvinyl chloride', 'H103A');
INSERT INTO packaging (id, name, ssd) VALUES (34, 'Porcelain - earthenware - ceramics', 'H210A');
INSERT INTO packaging (id, name, ssd) VALUES (35, 'Protective gas package', 'H004A');
INSERT INTO packaging (id, name, ssd) VALUES (36, 'Steel', 'H530A');
INSERT INTO packaging (id, name, ssd) VALUES (37, 'Tin Free Steel (TFS - sheets- steel sheets with chromium plating)', 'H535A');
INSERT INTO packaging (id, name, ssd) VALUES (38, 'Tinplate', 'H520A');
INSERT INTO packaging (id, name, ssd) VALUES (39, 'Tinplate soldered, not varnished', 'H524A');
INSERT INTO packaging (id, name, ssd) VALUES (40, 'Tinplate, soldered', 'H522A');
INSERT INTO packaging (id, name, ssd) VALUES (41, 'Tinplate, varnished - partly varnished', 'H523A');
INSERT INTO packaging (id, name, ssd) VALUES (42, 'Vacuum package', 'H005A');
INSERT INTO packaging (id, name, ssd) VALUES (43, 'Wax paper - wax cardboard', 'H013A');
INSERT INTO packaging (id, name, ssd) VALUES (44, 'Wood - wood wool', 'H020A');
INSERT INTO packaging (id, name, ssd) VALUES (45, 'Wrapped', 'H002A');