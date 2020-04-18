CREATE TABLE sampling_method (
    id INTEGER NOT NULL,
    name VARCHAR(255),
    sampmd CHAR(5) NOT NULL, -- EFSA's SSD sampMethod (xs:string(5))
    comment VARCHAR(255),
    PRIMARY KEY (id));

INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (0, 'According to 97/747/EC', 'N010A', 'Directive 97/747/EC - Fixing the levels and frequencies of sampling provided for by Council Directive 96/23/EC for the monitoring of certain substances and residues thereof in certain animal products');
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (1, 'According to Dir. 2002/63/EC', 'N009A', 'Directive 2002/63/EC - Community methods of sampling for the official control of pesticide residues');
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (2, 'According to Reg 152/2009', 'N014A', 'Commission Regulation (EC) No 152/2009 of 27 January 2009 laying down the methods of sampling and analysis for the official control of feed.');
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (3, 'According to Reg 1882/2006', 'N012A', '"Commission Regulation (EC) (EC) No 1882/2006 of 19 December 2006, laying down methods of sampling and analysis for the official control of the levels of nitrates in certain foodstuffs"');
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (4, 'According to Reg 1883/2006', 'N015A', 'Commission Regulation (EC) No 1883/2006 of 19 December 2006 laying down methods of sampling and analysis for the official control of levels of dioxins and dioxin-like PCBs in certain foodstuffs');
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (5, 'According to Reg 333/2007', 'N011A', 'Commission Regulation (EC) No 333/2007 laying down the methods of sampling and analysis for the official control of the levels of lead, cadmium, mercury, inorganic tin, 3-MCPD and benzo(a)pyrene in foodstuffs');
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (6, 'According to Reg 401/2006', 'N013A', 'Commission Regulation (EC) No 401/2006 of 23 February 2006 laying down the methods of sampling and analysis for the official control of the levels of mycotoxins in foodstuffs.');
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (7, 'HACCP and owns check', 'N019A', null);
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (8, 'Individual', 'N030A', null);
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (9, 'Individual/single', 'N001A', null);
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (10, 'Industry sampling', 'N016A', null);
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (11, 'Not applicable', 'N020A', null);
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (12, 'Official and industry sampling', 'N018A', null);
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (13, 'Official sampling', 'N017A', null);
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (14, 'Pooled', 'N031A', null);
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (15, 'Pooled/batch', 'N002A', null);
INSERT INTO sampling_method (id, name, sampmd, comment) VALUES (16, 'Unknown', 'N008A', null);
