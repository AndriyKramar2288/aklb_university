CREATE DATABASE aklb_universityDatabase;

--\c aklb_universityDatabase;
--
--CREATE TABLE IF NOT EXISTS public."Publication"
--(
--    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
--    title text COLLATE pg_catalog."default",
--    date timestamp without time zone,
--    "contentView" text COLLATE pg_catalog."default",
--    CONSTRAINT "Publication_pkey" PRIMARY KEY (id)
--);