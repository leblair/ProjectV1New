CREATE TABLE IF NOT EXISTS anime (
    animeid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    title text,
    description text,
    type text,
    year int,
    image text);

INSERT INTO anime(title,description, type, year, image) VALUES
    ('text1','anime1','type1', 2020,'anime1.jpg'),
    ('text2','anime2', 'type2',2021,'anime2.jpg'),
    ('text3','anime3','type3',2019,'anime3.jpg'),
    ('text4','anime4','type4',2018,'anime4.jpg');

CREATE TABLE IF NOT EXISTS author(
    authorid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name text,
    imageurl text,
);

CREATE TABLE IF NOT EXISTS genre(
    genreid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    label text,
    imageurl text
);
INSERT INTO genre(label,imageurl) VALUES
    ('Genre1', 'imagen1'),
    ('Genre2', 'imagen2');


INSERT INTO author(name,imageurl) VALUES
    ('Author1', 'imagen1'),
    ('Author2', 'imagen2');

CREATE TABLE anime_genre(
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    genreid uuid REFERENCES genre(genreid) ON DELETE CASCADE,
    PRIMARY KEY (animeid,genreid)
);

INSERT INTO anime_genre VALUES
    ((SELECT animeid FROM anime WHERE title='text1'),(SELECT genreid FROM genre WHERE label='Genre1')),
    ((SELECT animeid FROM anime WHERE title='text2'),(SELECT genreid FROM genre WHERE label='Genre2'));


CREATE TABLE anime_author(
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    authorid uuid REFERENCES author(authorid) ON DELETE CASCADE,
    PRIMARY KEY (animeid,authorid)
);

INSERT INTO anime_author VALUES
    ((SELECT animeid FROM anime WHERE title='text1'),(SELECT authorid FROM author WHERE name='Author1')),
    ((SELECT animeid FROM anime WHERE title='text2'),(SELECT authorid FROM author WHERE name='Author2'));




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

CREATE TABLE favorite{
    userid uuid REFERENCES usser(userid) ON DELETE CASCADE,
    animeid uuid REFERENCES anime(animeid) ON DELETE CASCADE,
    PRIMARY KEY (userid,animeid);
}

INSERT INTO favorite VALUES
    ((select userid from usser where username='user'),(select animeid from anime where title='text1'));