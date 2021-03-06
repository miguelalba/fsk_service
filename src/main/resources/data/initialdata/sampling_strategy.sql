CREATE TABLE sampling_strategy (
    id INTEGER NOT NULL,
    name VARCHAR(50),
    comment VARCHAR(700),
    PRIMARY KEY(id));

INSERT INTO sampling_strategy (id, name, comment) VALUES (0, 'Census', 'When the totality of a population or sub-population, on which the data are reported, is controlled.');
INSERT INTO sampling_strategy (id, name, comment) VALUES (1, 'Convenient sampling', '"Special instance of selective sampling where no randomisation is performed in extracting the sample but units are selected only on the basis of feasibility or ease of data collection. Sampling used in exploratory research where the researcher is interested in getting an inexpensive approximation of the truth. The subpopulations may or may not be determined on a risk basis.  The sampling from each subpopulation may not be proportional: the sample size is proportionally bigger for instance in subpopulations considered at high risk. This methodology is potentially subject to serious bias."');
INSERT INTO sampling_strategy (id, name, comment) VALUES (2, 'Not specified', null);
INSERT INTO sampling_strategy (id, name, comment) VALUES (3, 'Objective sampling', 'Planned strategy based on the selection of a random sample from a population on which the data are reported. Random sample is a sample which is taken under statistical consideration to provide representative data of population to be analysed.');
INSERT INTO sampling_strategy (id, name, comment) VALUES (4, 'Other', null);
INSERT INTO sampling_strategy (id, name, comment) VALUES (5, 'Selective sampling', 'Planned strategy based on the selection of a sample from a subpopulation (or more frequently from subpopulations) of a population on which the data are reported. The sampling is deliberately biased and is directed at the particular products or manufacturers. The subpopulations may or may not be determined on a risk basis. The specification of the ‘high - risk’ population comes from either scientific studies or previous analysis and information of other regions or countries.  The sampling procedure can be random or not. The sampling from each subpopulation may not be proportional: the sample size is proportionally bigger for instance in subpopulations considered at high risk.');
INSERT INTO sampling_strategy (id, name, comment) VALUES (6, 'Suspect sampling', 'Selection of an individual sample in order to confirm or reject a suspicion of non-conformity. It''s not a random sampling, therefore there is no sample extracted from the population.');
