CREATE TABLE IF NOT EXISTS anime (
    animeid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    description text,
    year int,
    type text,
    image text);


INSERT INTO anime(description, year, type, image) VALUES
    ('anime1',2020, 'type1','anime1.jpg'),
    ('anime2', 2021,'type2','anime2.jpg'),
    ('anime3',2021,'type3','anime3.jpg'),
    ('anime4',2020,'type4','anime4.jpg');
