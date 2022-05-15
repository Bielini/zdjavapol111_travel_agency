insert into continent (id, name) values (1, 'Europa');

INSERT INTO COUNTRY (ID, NAME) VALUES (1, 'Hiszpania');
INSERT INTO COUNTRY (ID, NAME) VALUES (2, 'Grecja');
INSERT INTO COUNTRY (ID, NAME) VALUES (3, 'Polska');
INSERT INTO COUNTRY (ID, NAME) VALUES (4, 'Turcja');

INSERT INTO CONTINENT_COUNTRIES (CONTINENT_ID, COUNTRIES_ID) VALUES (1,1);
INSERT INTO CONTINENT_COUNTRIES (CONTINENT_ID, COUNTRIES_ID) VALUES (1,2);
INSERT INTO CONTINENT_COUNTRIES (CONTINENT_ID, COUNTRIES_ID) VALUES (1,3);
INSERT INTO CONTINENT_COUNTRIES (CONTINENT_ID, COUNTRIES_ID) VALUES (1,4);

insert into city (id, name, country_id) values (1, 'Malaga', 1);
insert into city (id, name, country_id) values (2, 'Ateny', 2);
insert into city (id, name, country_id) values (3, 'Warszawa', 3);
insert into city (id, name, country_id) values (4, 'Ankara', 4);

insert into tour(origin_city_id, destination_city_id, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values (3, 1, 7, 3500, 3000, 0, 2, 2);
insert into tour(origin_city_id, destination_city_id, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values (3, 2, 14, 4200, 3000, 1, 2, 0);
insert into tour(origin_city_id, destination_city_id, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values (3, 4, 7, 5000, 3500, 0, 2, 1);
insert into tour(origin_city_id, destination_city_id, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values (3, 1, 7, 3500, 3000, 0, 2, 2);
insert into tour(origin_city_id, destination_city_id, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values (3, 2, 14, 4200, 3000, 1, 2, 0);
insert into tour(origin_city_id, destination_city_id, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values (3, 2, 14, 4200, 3000, 1, 2, 0);
insert into tour(origin_city_id, destination_city_id, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values (3, 4, 7, 5000, 3500, 0, 2, 1);


--insert into continent (id, name) values (2, 'Azja')
--insert into continent (id, name) values (3, 'Afryka')
--
--insert into country (id, name, continent_id) values (5, 'Malediwy', 2)
--insert into country (id, name, continent_id) values (6, 'Filipiny', 2)
--insert into country (id, name, continent_id) values (7, 'Armenia', 2)
--insert into country (id, name, continent_id) values (8, 'Cypr', 2)
--
--insert into country (id, name, continent_id) values (9, 'Tunezja', 3)
--insert into country (id, name, continent_id) values (10, 'Egipt', 3)
--insert into country (id, name, continent_id) values (11, 'Maroko', 3)
--insert into country (id, name, continent_id) values (12, 'Madagaskar', 3)
--
--insert into hotel (id, name, standard, description, city_id) values
--
--insert into airport (id, name, city_id) values


