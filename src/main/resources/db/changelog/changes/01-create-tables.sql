
CREATE SEQUENCE words_id_seq AS INTEGER START WITH 1;
CREATE SEQUENCE word_relations_id_seq AS INTEGER START WITH 1;

CREATE TABLE words
(
    id int,
    word text,
    constraint pk_words primary key(id)
);

CREATE TABLE word_relations
(
    id int,
    word_id integer,
    relation_type VARCHAR(50),
    relation_word text NOT NULL,
    CONSTRAINT pk_word_relations primary key(id),
    CONSTRAINT fk_word_relations_word FOREIGN KEY (word_id)
      REFERENCES public.words(id)
);
