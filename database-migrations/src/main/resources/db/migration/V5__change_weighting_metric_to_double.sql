ALTER TABLE QUALITY_REQUIREMENT DROP COLUMN WEIGHTINGMETRICVALUE;
ALTER TABLE QUALITY_REQUIREMENT ADD COLUMN WEIGHTINGMETRICVALUE DOUBLE PRECISION NOT NULL;