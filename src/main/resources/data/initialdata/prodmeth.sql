-- Production method
CREATE TABLE prodmeth (
    id INTEGER not NULL,
    name VARCHAR(255) not NULL,
    ssd CHAR(5) not NULL, -- EFSA's SSD prodProdMeth (xs:string(5))
    comment VARCHAR(400),
    PRIMARY KEY(id));

INSERT INTO prodmeth (id, name, ssd, comment) VALUES (0, 'Battery production', 'PD04A', 'Production of animals in cages (applies to poultry, rabbits)');
INSERT INTO prodmeth (id, name, ssd, comment) VALUES (1, 'Farmed Domestic or cultivated', 'Z0154', 'Animals produced in captivity (applies also to game and fish), plants produced by cultivation');
INSERT INTO prodmeth (id, name, ssd, comment) VALUES (2, 'Free range production', 'PD05A', 'Animals have continuous daytime access to open air enclosures covered with vegetation');
INSERT INTO prodmeth (id, name, ssd, comment) VALUES (3, 'Genetically modified', 'Z0214', 'Production using a species with a genetic modification');
INSERT INTO prodmeth (id, name, ssd, comment) VALUES (4, 'Integrated Pest Management', 'PD12A', 'A production method that uses effective and environmentally sensitive approach to pest management that relies on a combination of common-sense practices. Considers life cycles of pests and their interaction with the environment. Requires the management of pest damage by the most economical means, and with the least possible hazard to people, property, and the environment');
INSERT INTO prodmeth (id, name, ssd, comment) VALUES (5, 'Intensive Industrial production', 'PD08A', 'Production of animals in confinement with high stocking density');
INSERT INTO prodmeth (id, name, ssd, comment) VALUES (6, 'Non-organic production', 'PD09A', 'Products produced without use of organic production methods');
INSERT INTO prodmeth (id, name, ssd, comment) VALUES (7, 'Organic production', 'PD07A', 'A method of production which places the highest emphasis on environmental protection and, with regard to livestock production, animal welfare considerations. It avoids or largely reduces the use of synthetic chemical inputs such as fertilisers, pesticides, additives and medicinal products. (http://www.organic-europe.net/europe_eu/statistics-eurostat.asp)');
INSERT INTO prodmeth (id, name, ssd, comment) VALUES (8, 'Other production method', 'Z0216', null);
INSERT INTO prodmeth (id, name, ssd, comment) VALUES (9, 'Outdoor - Open-air growing condition', 'Z0208', 'Cultivation of plants and rearing of animals without the use of climate-controlled or protective structures');
INSERT INTO prodmeth (id, name, ssd, comment) VALUES (10, 'Production method unknown', 'Z0215', null);
INSERT INTO prodmeth (id, name, ssd, comment) VALUES (11, 'Traditional production', 'PD06A', 'Production of food using traditional - artisan methods');
INSERT INTO prodmeth (id, name, ssd, comment) VALUES (12, 'Under glass - protected growing condition', 'Z0211', 'Cultivation of plants, especially of out-of-season plants, in climate-controlled or protective structures');
INSERT INTO prodmeth (id, name, ssd, comment) VALUES (13, 'Wild or gathered or hunted', 'Z0153', 'Animal or plant products harvested from their natural environment');
