CREATE TABLE hero
(hero_id INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 1) PRIMARY KEY,
 first_name varchar(50),
 last_name varchar(50),
 alter_ego varchar(75));
 
 INSERT INTO "PUBLIC"."HERO"
( "FIRST_NAME", "LAST_NAME", "ALTER_EGO" )
VALUES ( 'Tony', 'Stark', 'Ironman')

INSERT INTO "PUBLIC"."HERO"
( "FIRST_NAME", "LAST_NAME", "ALTER_EGO" )
VALUES ( 'Steve', 'Rogers', 'Captain America')

INSERT INTO "PUBLIC"."HERO"
( "FIRST_NAME", "LAST_NAME", "ALTER_EGO" )
VALUES ( 'Clark', 'Kent', 'Superman')

INSERT INTO "PUBLIC"."HERO"
( "FIRST_NAME", "LAST_NAME", "ALTER_EGO" )
VALUES ( 'Bruce', 'Wayne', 'Batman')

INSERT INTO "PUBLIC"."HERO"
( "FIRST_NAME", "LAST_NAME", "ALTER_EGO" )
VALUES ( 'Peter', 'Parker', 'Spiderman')