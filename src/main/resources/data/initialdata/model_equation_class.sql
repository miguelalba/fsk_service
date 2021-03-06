CREATE TABLE model_equation_class (
    id INTEGER NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY(id));

INSERT INTO model_equation_class (id, name) VALUES (0, 'Chronic exposure : Lifetime Average Daily Dose');
INSERT INTO model_equation_class (id, name) VALUES (1, 'Acute exposure: acute dose calculation');
INSERT INTO model_equation_class (id, name) VALUES (2, 'Cumulative Lognormal (ED50, GSD)');
INSERT INTO model_equation_class (id, name) VALUES (3, 'Decreasing Log-logistic (Beta0, Beta1)');
INSERT INTO model_equation_class (id, name) VALUES (4, 'Decreasing Log10-Logistic (Beta0, Beta1)');
INSERT INTO model_equation_class (id, name) VALUES (5, 'Decreasing Logistic (Beta0, Beta1)');
INSERT INTO model_equation_class (id, name) VALUES (6, 'Decreasing Probit (Alpha, Beta)');
INSERT INTO model_equation_class (id, name) VALUES (7, 'Empirical');
INSERT INTO model_equation_class (id, name) VALUES (8, 'Gamma (Alpha, Beta)');
INSERT INTO model_equation_class (id, name) VALUES (9, 'Linear by Slope Factor (Slope)');
INSERT INTO model_equation_class (id, name) VALUES (10, 'Log-Logistic (Alpha, Beta)');
INSERT INTO model_equation_class (id, name) VALUES (11, 'Log-logistic with background (Alpha, Beta, Gamma)');
INSERT INTO model_equation_class (id, name) VALUES (12, 'Logistic (Alpha, Beta)');
INSERT INTO model_equation_class (id, name) VALUES (13, 'Multistage (Beta1, Beta2, Beta3)');
INSERT INTO model_equation_class (id, name) VALUES (14, 'Non-Threshold Linear (Reference point, Risk at Reference Point)');
INSERT INTO model_equation_class (id, name) VALUES (15, 'Non-Threshold Linear (Reference point, Risk at Reference Point)');
INSERT INTO model_equation_class (id, name) VALUES (16, 'Other');
INSERT INTO model_equation_class (id, name) VALUES (17, 'Probit (Alpha, Beta)');
INSERT INTO model_equation_class (id, name) VALUES (18, 'Restricted Log-Probit (Alpha, Beta, Gamma)');
INSERT INTO model_equation_class (id, name) VALUES (19, 'Restricted Weibull  (Alpha, Beta, Gamma)');
INSERT INTO model_equation_class (id, name) VALUES (20, 'Step Threshold (Threshold)');
INSERT INTO model_equation_class (id, name) VALUES (21, 'Threshold Linear (Reference point, Risk at Reference Point, Threshold)');
INSERT INTO model_equation_class (id, name) VALUES (22, 'Weibull (Alpha, Beta)');
