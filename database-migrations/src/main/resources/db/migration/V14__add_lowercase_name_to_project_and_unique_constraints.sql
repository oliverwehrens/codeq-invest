ALTER TABLE PROJECT ADD COLUMN LOWERCASENAME TEXT NOT NULL UNIQUE;
ALTER TABLE PROJECT ADD CONSTRAINT NAME_UNIQUE UNIQUE (NAME);