toc.dat                                                                                             0000600 0004000 0002000 00000005447 14073455635 0014465 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP       9    #    
            y            restful-api    12.3    12.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         	           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false         
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                    1262    152355    restful-api    DATABASE     �   CREATE DATABASE "restful-api" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_Indonesia.1252' LC_CTYPE = 'English_Indonesia.1252';
    DROP DATABASE "restful-api";
                postgres    false                     2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false                    0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3         �            1259    152364    api_keys    TABLE     I   CREATE TABLE public.api_keys (
    id character varying(255) NOT NULL
);
    DROP TABLE public.api_keys;
       public         heap    postgres    false    3         �            1259    152356    products    TABLE     �   CREATE TABLE public.products (
    id character varying(255) NOT NULL,
    created_date timestamp without time zone,
    name character varying(255),
    price bigint,
    quantity integer,
    updated_date timestamp without time zone
);
    DROP TABLE public.products;
       public         heap    postgres    false    3                   0    152364    api_keys 
   TABLE DATA           &   COPY public.api_keys (id) FROM stdin;
    public          postgres    false    203       2821.dat           0    152356    products 
   TABLE DATA           Y   COPY public.products (id, created_date, name, price, quantity, updated_date) FROM stdin;
    public          postgres    false    202       2820.dat �
           2606    152368    api_keys api_keys_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.api_keys
    ADD CONSTRAINT api_keys_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.api_keys DROP CONSTRAINT api_keys_pkey;
       public            postgres    false    203         �
           2606    152363    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            postgres    false    202                                                                                                                                                                                                                                 2821.dat                                                                                            0000600 0004000 0002000 00000000014 14073455635 0014255 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        SECRET
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    2820.dat                                                                                            0000600 0004000 0002000 00000001145 14073455635 0014262 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        A0001	2021-07-10 21:35:07.275	Macbook	30000000	10	\N
A0004	2021-07-11 13:32:02.826	Laptop Hp	10009900	10	\N
A0005	2021-07-11 13:32:12.373	Laptop Dell	10009900	10	\N
A0006	2021-07-11 13:32:20.454	Laptop Samsung	10009900	10	\N
A0007	2021-07-11 13:32:30.584	Laptop Toshiba	10009900	10	\N
A0008	2021-07-11 13:32:43.871	Laptop Fujitsu	10009900	10	\N
A0009	2021-07-11 13:33:09.36	Laptop Macbook Pro	10009900	10	\N
A0010	2021-07-11 13:33:22.348	Laptop Lenovo	10009900	10	\N
A0011	2021-07-11 13:33:48.629	Laptop Redmi	10009900	10	\N
A0002	2021-07-11 13:31:39.475	Laptop Acer bos acer	20000	89	2021-07-11 16:28:11.09
\.


                                                                                                                                                                                                                                                                                                                                                                                                                           restore.sql                                                                                         0000600 0004000 0002000 00000005732 14073455635 0015407 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "restful-api";
--
-- Name: restful-api; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "restful-api" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_Indonesia.1252' LC_CTYPE = 'English_Indonesia.1252';


ALTER DATABASE "restful-api" OWNER TO postgres;

\connect -reuse-previous=on "dbname='restful-api'"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: api_keys; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.api_keys (
    id character varying(255) NOT NULL
);


ALTER TABLE public.api_keys OWNER TO postgres;

--
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id character varying(255) NOT NULL,
    created_date timestamp without time zone,
    name character varying(255),
    price bigint,
    quantity integer,
    updated_date timestamp without time zone
);


ALTER TABLE public.products OWNER TO postgres;

--
-- Data for Name: api_keys; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.api_keys (id) FROM stdin;
\.
COPY public.api_keys (id) FROM '$$PATH$$/2821.dat';

--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products (id, created_date, name, price, quantity, updated_date) FROM stdin;
\.
COPY public.products (id, created_date, name, price, quantity, updated_date) FROM '$$PATH$$/2820.dat';

--
-- Name: api_keys api_keys_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.api_keys
    ADD CONSTRAINT api_keys_pkey PRIMARY KEY (id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      