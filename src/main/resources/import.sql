insert into continent (id, name) values (1, 'Europa')
insert into continent (id, name) values (2, 'Azja')
insert into continent (id, name) values (3, 'Afryka')


insert into country (id, name, continent_id) values (1, 'Hiszpania', 1)
insert into country (id, name, continent_id) values (2, 'Grecja', 1)
insert into country (id, name, continent_id) values (3, 'Warszawa', 1)
insert into country (id, name, continent_id) values (4, 'Turcja', 1)

insert into country (id, name, continent_id) values (5, 'Malediwy', 2)
insert into country (id, name, continent_id) values (6, 'Filipiny', 2)
insert into country (id, name, continent_id) values (7, 'Armenia', 2)
insert into country (id, name, continent_id) values (8, 'Cypr', 2)

insert into country (id, name, continent_id) values (9, 'Tunezja', 3)
insert into country (id, name, continent_id) values (10, 'Egipt', 3)
insert into country (id, name, continent_id) values (11, 'Maroko', 3)
insert into country (id, name, continent_id) values (12, 'Madagaskar', 3)

insert into city (id, name, contry_id) values (1, '', 1)

insert into hotel (id, name, standard, description, city_id) values

insert into airport (id, name, city_id) values

insert into tour (id, destination_city, origin_city, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values (1, 1, 3, 7, 3500, 3000, 0, 2, 2)
insert into tour (id, destination_city, origin_city, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values (2, 2, 3, 14, 4200, 3000, 1, 2, 0)
insert into tour (id, destination_city, origin_city, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values (3, 4, 3, 7, 5000, 3500, 0, 2, 1)



