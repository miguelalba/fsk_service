CREATE TABLE language (
    code CHAR(2) NOT NULL,
    name VARCHAR(50) NOT NULL,
    comment VARCHAR (50),
    PRIMARY KEY(code));

INSERT INTO language (code, name) VALUES ('bg', 'Bulgarian');
INSERT INTO language (code, name) VALUES ('cs', 'Czech');
INSERT INTO language (code, name) VALUES ('da', 'Danish');
INSERT INTO language (code, name) VALUES ('nl', 'Dutch');
INSERT INTO language (code, name) VALUES ('en', 'English');
INSERT INTO language (code, name) VALUES ('et', 'Estonian');
INSERT INTO language (code, name) VALUES ('fi', 'Finnish');
INSERT INTO language (code, name) VALUES ('fr', 'French');
INSERT INTO language (code, name) VALUES ('de', 'German');
INSERT INTO language (code, name) VALUES ('el', 'Greek');
INSERT INTO language (code, name) VALUES ('hu', 'Hungarian');
INSERT INTO language (code, name) VALUES ('is', 'Icelandic');
INSERT INTO language (code, name) VALUES ('ga', 'Irish');
INSERT INTO language (code, name) VALUES ('it', 'Italian');
INSERT INTO language (code, name) VALUES ('lv', 'Latvian');
INSERT INTO language (code, name) VALUES ('lt', 'Lithuanian');
INSERT INTO language (code, name) VALUES ('mt', 'Maltese');
INSERT INTO language (code, name) VALUES ('no', 'Norwegian');
INSERT INTO language (code, name) VALUES ('pl', 'Polish');
INSERT INTO language (code, name) VALUES ('pt', 'Portuguese');
INSERT INTO language (code, name) VALUES ('ro', 'Romanian');
INSERT INTO language (code, name) VALUES ('sk', 'Slovakian');
INSERT INTO language (code, name) VALUES ('sl', 'Slovene');
INSERT INTO language (code, name) VALUES ('es', 'Spanish');
INSERT INTO language (code, name) VALUES ('sv', 'Swedish');
