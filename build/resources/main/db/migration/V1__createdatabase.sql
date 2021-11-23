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
