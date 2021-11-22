CREATE TABLE IF NOT EXISTS anime (
    animeid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    text text,
    description text,
    type text,
    year int,
    image text);


INSERT INTO anime(description, year, type, image) VALUES
    ('text1','anime1',2020, 'type1','anime1.jpg'),
    ('text2','anime2', 2021,'type2','anime2.jpg'),
    ('text3','anime3',2021,'type3','anime3.jpg'),
    ('text4','anime4',2020,'type4','anime4.jpg');
