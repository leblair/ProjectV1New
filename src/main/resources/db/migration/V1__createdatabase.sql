CREATE TABLE IF NOT EXISTS anime (
    animeid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    text text,
    description text,
    type text,
    year int,
    image text);

INSERT INTO anime(text,description, type, year, image) VALUES
    ('text1','anime1','type1', 2020,'anime1.jpg'),
    ('text2','anime2', 'type2',2021,'anime2.jpg'),
    ('text3','anime3','type3',2019,'anime3.jpg'),
    ('text4','anime4','type4',2018,'anime4.jpg');

CREATE TABLE IF NOT EXISTS author(
    authorid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name text,
    imageurl text
);


CREATE TABLE anime_author(
    anime uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    authorid uuid REFERENCES author(authorid) ON DELETE CASCADE,
    PRIMARY KEY (animeid,authorid)

);

CREATE TABLE IF NOT EXISTS usertable (
    userid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    username text,
    password text);

INSERT INTO usertable(username) VALUES
        ('myuser1'),
        ('myuser2'),
        ('myuser3'),
        ('myuser4');


CREATE TABLE usser (
    userid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    username varchar(24) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    role varchar(10),
    enabled boolean DEFAULT true
  );



  -- afegim un usuari de prova
CREATE EXTENSION IF NOT EXISTS pgcrypto;
INSERT INTO usser (username, password) VALUES ('user', crypt('pass', gen_salt('bf')));




CREATE TABLE IF NOT EXISTS file (
        fileid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
        contenttype text,
        data bytea);


INSERT INTO file(contenttype) VALUES
    ('image/png'),
    ('txt'),
    ('txt');
