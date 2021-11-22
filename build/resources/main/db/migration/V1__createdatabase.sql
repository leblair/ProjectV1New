CREATE TABLE IF NOT EXISTS movie (
    movieid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    title text,
    synopsis text,
    imageurl text);