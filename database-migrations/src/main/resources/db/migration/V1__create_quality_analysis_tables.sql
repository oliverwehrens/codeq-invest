CREATE TABLE ARTEFACT (
  ID                BIGSERIAL PRIMARY KEY,
  NAME              TEXT             NOT NULL,
  SONARIDENTIFIER   VARCHAR(50)      NOT NULL,
  CHANGEPROBABILITY DOUBLE PRECISION NOT NULL
);

CREATE TABLE QUALITY_PROFILE (
  ID BIGSERIAL PRIMARY KEY
);

CREATE TABLE QUALITY_REQUIREMENT (
  ID                        BIGSERIAL PRIMARY KEY,
  PROFILE_ID                BIGINT REFERENCES QUALITY_PROFILE (ID),
  REMEDIATIONCOSTS          INT         NOT NULL,
  NONREMEDIATIONCOSTS       INT         NOT NULL,
  WEIGHTINGMETRICVALUE      BIGINT      NOT NULL,
  WEIGHTINGMETRICIDENTIFIER VARCHAR(50) NOT NULL,
  METRICIDENTIFIER          VARCHAR(50) NOT NULL,
  OPERATOR                  VARCHAR(2)  NOT NULL,
  THRESHOLD                 BIGINT      NOT NULL
);

CREATE TABLE QUALITY_ANALYSIS (
  ID         BIGSERIAL PRIMARY KEY,
  PROFILE_ID BIGINT REFERENCES QUALITY_PROFILE (ID)
);

CREATE TABLE QUALITY_VIOLATION (
  ID             BIGSERIAL PRIMARY KEY,
  ANALYSIS_ID    BIGINT REFERENCES QUALITY_ANALYSIS (ID),
  REQUIREMENT_ID BIGINT REFERENCES QUALITY_REQUIREMENT (ID),
  VIOLATION_ID   BIGINT REFERENCES ARTEFACT (ID)
);