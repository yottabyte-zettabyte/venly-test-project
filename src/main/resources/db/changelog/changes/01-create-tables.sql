
create table x_relations
(
    id VARCHAR(50),
    name VARCHAR(50) NOT NULL,
    constraint pk_x_relations primary key(id)
);

CREATE TABLE words
(
    id serial,
    word text,
    constraint pk_words primary key(id)
);

CREATE TABLE word_relations
(
    id serial,
    word_id integer,
    relation_id VARCHAR(50),
    relation_word text NOT NULL,
    CONSTRAINT pk_word_relations primary key(id),
    CONSTRAINT fk_word_relations_word FOREIGN KEY (word_id)
      REFERENCES public.words(id),
    CONSTRAINT fk_word_relations_xrelation FOREIGN KEY (relation_id)
      REFERENCES public.x_relations(id)
);
