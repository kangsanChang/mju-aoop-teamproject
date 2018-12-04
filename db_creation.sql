CREATE DATABASE aoop_project;
USE aoop_project;

CREATE TABLE STUDENT (
  stukey INT UNSIGNED NOT NULL,
  name VARCHAR(255) NOT NULL,
  grade VARCHAR(5),
  PRIMARY KEY (stukey)
);

CREATE TABLE ATTENDANCE (
  stukey INT UNSIGNED NOT NULL,
  week1 VARCHAR(10),
  week2 VARCHAR(10),
  week3 VARCHAR(10),
  week4 VARCHAR(10),
  week5 VARCHAR(10),
  week6 VARCHAR(10),
  week7 VARCHAR(10),
  week8 VARCHAR(10),
  week9 VARCHAR(10),
  week10 VARCHAR(10),
  week11 VARCHAR(10),
  week12 VARCHAR(10),
  week13 VARCHAR(10),
  week14 VARCHAR(10),
  week15 VARCHAR(10),
  week16 VARCHAR(10),
  FOREIGN KEY (stukey) REFERENCES STUDENT(stukey) ON UPDATE CASCADE ON DELETE CASCADE,
  PRIMARY KEY (stukey)
);

CREATE TABLE SCORE (
  stukey INT UNSIGNED NOT NULL,
  mid INT UNSIGNED,
  final INT UNSIGNED,
  hw INT UNSIGNED,
  quiz INT UNSIGNED,
  announcement INT UNSIGNED,
  report INT UNSIGNED,
  etc INT UNSIGNED,
  FOREIGN KEY (stukey) REFERENCES STUDENT(stukey) ON UPDATE CASCADE ON DELETE CASCADE,
  PRIMARY KEY (stukey)
);

CREATE TABLE MAX_SETTINGS (
  maxmid INT UNSIGNED,
  maxfinal INT UNSIGNED,
  maxhw INT UNSIGNED,
  maxquiz INT UNSIGNED,
  maxannouncement INT UNSIGNED,
  maxreport INT UNSIGNED,
  maxetc INT UNSIGNED
);

CREATE TABLE CAL_RATIO_SETTINGS (
  attendratio INT UNSIGNED,
  midratio INT UNSIGNED,
  finalratio INT UNSIGNED,
  hwratio INT UNSIGNED,
  quizratio INT UNSIGNED,
  announcementratio INT UNSIGNED,
  reportratio INT UNSIGNED,
  etcratio INT UNSIGNED
);

CREATE TABLE GRADE_RATIO_SETTINGS (
  ap_ratio INT UNSIGNED,
  a_ratio INT UNSIGNED,
  bp_ratio INT UNSIGNED,
  b_ratio INT UNSIGNED,
  cp_ratio INT UNSIGNED,
  c_ratio INT UNSIGNED,
  d_ratio INT UNSIGNED,
  f_ratio INT UNSIGNED
);

INSERT INTO MAX_SETTINGS VALUES (100, 100, 100, 100, 100, 100, 100);
INSERT INTO CAL_RATIO_SETTINGS VALUES (10, 20, 20, 10, 10, 10, 10, 10);
INSERT INTO GRADE_RATIO_SETTINGS VALUES (15, 15, 15, 15, 15, 15, 5, 5);

INSERT INTO STUDENT VALUES (1,'김민준',NULL);
INSERT INTO STUDENT VALUES (2,'김서준',NULL);
INSERT INTO STUDENT VALUES (3,'김예준',NULL);
INSERT INTO STUDENT VALUES (4,'김도윤',NULL);
INSERT INTO STUDENT VALUES (5,'김주원',NULL);
INSERT INTO STUDENT VALUES (6,'김시우',NULL);
INSERT INTO STUDENT VALUES (7,'김지후',NULL);
INSERT INTO STUDENT VALUES (8,'김준서',NULL);
INSERT INTO STUDENT VALUES (9,'김지호',NULL);
INSERT INTO STUDENT VALUES (10,'김하준',NULL);
INSERT INTO STUDENT VALUES (11,'김현우',NULL);
INSERT INTO STUDENT VALUES (12,'김준우',NULL);
INSERT INTO STUDENT VALUES (13,'김지훈',NULL);
INSERT INTO STUDENT VALUES (14,'김도현',NULL);
INSERT INTO STUDENT VALUES (15,'김건우',NULL);
INSERT INTO STUDENT VALUES (16,'김우진',NULL);
INSERT INTO STUDENT VALUES (17,'김현준',NULL);
INSERT INTO STUDENT VALUES (18,'김민재',NULL);
INSERT INTO STUDENT VALUES (19,'김선우',NULL);
INSERT INTO STUDENT VALUES (20,'김서진',NULL);
INSERT INTO STUDENT VALUES (21,'김연우',NULL);
INSERT INTO STUDENT VALUES (22,'김정우',NULL);
INSERT INTO STUDENT VALUES (23,'김준혁',NULL);
INSERT INTO STUDENT VALUES (24,'김승현',NULL);
INSERT INTO STUDENT VALUES (25,'김지환',NULL);
INSERT INTO STUDENT VALUES (26,'김승우',NULL);
INSERT INTO STUDENT VALUES (27,'김유준',NULL);
INSERT INTO STUDENT VALUES (28,'김승민',NULL);
INSERT INTO STUDENT VALUES (29,'김민성',NULL);
INSERT INTO STUDENT VALUES (30,'김준영',NULL);

INSERT INTO SCORE VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (5, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (6, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (7, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (8, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (9, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (10, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (11, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (12, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (13, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (14, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (15, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (16, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (17, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (18, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (19, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (20, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (21, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (22, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (23, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (24, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (25, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (26, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (27, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (28, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (29, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO SCORE VALUES (30, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

INSERT INTO ATTENDANCE VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (16,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (17,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (18,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (19,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (20,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (21,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (22,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (23,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (24,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (25,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (26,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (27,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (28,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (29,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO ATTENDANCE VALUES (30,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);