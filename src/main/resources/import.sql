insert into continent (id, name) values (1, 'Europa');

INSERT INTO COUNTRY (ID, NAME, continents_id) VALUES (1, 'Hiszpania',1);
INSERT INTO COUNTRY (ID, NAME, continents_id) VALUES (2, 'Grecja', 1);
INSERT INTO COUNTRY (ID, NAME, continents_id) VALUES (3, 'Polska',1);
INSERT INTO COUNTRY (ID, NAME, continents_id) VALUES (4, 'Turcja', 1);

--INSERT INTO continent_countries (continent_id, COUNTRIES_ID) VALUES (1,1);
--INSERT INTO continent_countries (continent_id, COUNTRIES_ID) VALUES (1,2);
--INSERT INTO continent_countries (continent_id, COUNTRIES_ID) VALUES (1,3);
--INSERT INTO continent_countries (continent_id, COUNTRIES_ID) VALUES (1,4);


insert into city (id, name, country_id) values (1, 'Malaga', 1);
insert into city (id, name, country_id) values (2, 'Ateny', 2);
insert into city (id, name, country_id) values (3, 'Warszawa', 3);
insert into city (id, name, country_id) values (4, 'Ankara', 4);



insert into role (id, name) values(1, 'ADMIN');
insert into role (id, name) values(2, 'CUSTOMER');
insert into user (id, username, password) values(1, 'admin', '$2a$10$csIVj5k8CB74npTTstUQuO3ObjmaM6y8cRMxvsKqpHmT3zNQxY/IK');
insert into user_role (user_id, role_id) values(1,1);

insert into continent (id, name) values (2, 'Azja');

insert into country (id, NAME, continents_id) values (5, 'Malediwy',2);
insert into country (id, name, continents_id) values (6, 'Filipiny',2);
insert into country (id, name, continents_id) values (7, 'Armenia',2);
insert into country (id, name, continents_id) values (8, 'Cypr',2);

--INSERT INTO continent_countries (continent_id, COUNTRIES_ID) VALUES (2,5);
--INSERT INTO continent_countries (continent_id, COUNTRIES_ID) VALUES (2,6);
--INSERT INTO continent_countries (continent_id, COUNTRIES_ID) VALUES (2,7);
--INSERT INTO continent_countries (continent_id, COUNTRIES_ID) VALUES (2,8);

insert into city (id, name, country_id) values (5, 'Male', 5);
insert into city (id, name, country_id) values (6, 'Manila', 6);
insert into city (id, name, country_id) values (7, 'Yerevan', 7);
insert into city (id, name, country_id) values (8, 'Larnaka', 8);


insert into continent (id, name) values (3, 'Afryka');

insert into country (id, name, continents_id) values (9, 'Tunezja', 3);
insert into country (id, name, continents_id) values (10, 'Egipt', 3);
insert into country (id, name, continents_id) values (11, 'Maroko', 3);
insert into country (id, name, continents_id) values (12, 'Madagaskar', 3);

--INSERT INTO continent_countries (continent_id, COUNTRIES_ID) VALUES (3,9);
--INSERT INTO continent_countries (continent_id, COUNTRIES_ID) VALUES (3,10);
--INSERT INTO continent_countries (continent_id, COUNTRIES_ID) VALUES (3,11);
--INSERT INTO continent_countries (continent_id, COUNTRIES_ID) VALUES (3,12);

insert into city (id, name, country_id) values (9, 'Tunis', 9);
insert into city (id, name, country_id) values (10, 'Kair', 9);
insert into city (id, name, country_id) values (11, 'Marrakesz', 11);
insert into city (id, name, country_id) values (12, 'Ambanja', 12);


insert into hotel (id, name, standard, description, city_id) values (1, 'Gran Hotel Miramar GL', 5, 'Ten obiekt jest położony 1 minutę spacerem od plaży. Luksusowy obiekt Gran Hotel Miramar GL mieści się w zabytkowym budynku z XX wieku, który jest położony w Maladze, 10 metrów od plaży La Malagueta. Ten nadmorski hotel zapewnia centrum spa w sezonie.', 1);
insert into hotel (id, name, standard, description, city_id) values (2, 'Acropolis Ami Boutique Hotel', 3, 'Ten nowoczesny hotel usytuowany jest zaledwie kilka minut spacerem od Akropolu i Nowego Muzeum Akropolu. Stacja metra Singru-Fix znajduje się 3 minuty spacerem od obiektu. Z hotelowego tarasu na dachu roztacza się wspaniały widok na Partenon.', 2);
insert into hotel (id, name, standard, description, city_id) values (3, 'Fos DownTown Suites', 4, 'Nowoczesny hotel Novotel Warszawa Centrum usytuowany jest w centrum Warszawy, 5 minut spacerem od dworca kolejowego Warszawa Centralna, a z jego okien roztacza się widok na miasto. Goście hotelu mogą rozpocząć dzień od urozmaiconego śniadania.', 3);
insert into hotel (id, name, standard, description, city_id) values (4, 'ibis Ankara Airport Hotel', 3, 'Hotel ibis Ankara Airport usytuowany jest w mieście Ankara, zaledwie 2 km od lotniska w Ankarze. Obiekt oferuje restaurację, bezpłatne WiFi oraz całodobową recepcję.', 4);
insert into hotel (id, name, standard, description, city_id) values (5, 'Samann Grand', 3, 'Ten obiekt jest położony 9 minut spacerem od plaży. Obiekt Samann Grand usytuowany jest w miejscowości Male i oferuje taras oraz widok na miasto. Odległość ważnych miejsc od obiektu: Artificial Beach – 300 m. Do dyspozycji Gości przygotowano... ', 5);
insert into hotel (id, name, standard, description, city_id) values (6, 'Lime Resort Manila', 4, 'Obiekt Lime Resort Manila, usytuowany w miejscowości Manila, oferuje odkryty basen, bezpłatny prywatny parking, centrum fitness oraz ogród. Odległość ważnych miejsc od obiektu: Centrum wystawowe World Trade Centre Metro Manila – 700 m.', 6);
insert into hotel (id, name, standard, description, city_id) values (7, 'Grand Hotel Yerevan - Small Luxury Hotels of the World', 5, 'Ten pięciogwiazdkowy hotel w Yerevan, położony zaledwie 200 metrów od Narodowej Galerii Sztuki i 500 metrów od Teatru Opery, oferuje stylowe spa z wanną z hydromasażem i dostępem do sezonowego odkrytego basenu na dachu, nowo otwartą ormiańską ', 7);
insert into hotel (id, name, standard, description, city_id) values (8, 'Lebay Beach Hotel', 3, 'Hotel Lebay Beach położony jest nad brzegiem wyjątkowej zatoki w Larnace i oferuje elegancki odkryty basen z widokiem na morze oraz restaurację. W 15 minut można dojechać...', 8);
insert into hotel (id, name, standard, description, city_id) values (9, 'Royal Victoria', 4, 'Obiekt Royal Victoria, usytuowany w miejscowości Tunis, oferuje wspólny salon, bezpłatny prywatny parking oraz taras. Odległość ważnych miejsc od obiektu: Victory Square – 0 m. Do dyspozycji Gości przygotowano takie udogodnienia, jak bankomat...', 9);
insert into hotel (id, name, standard, description, city_id) values (10, 'Le Meridien Cairo Airport', 5, 'Hotel Le Meridien Cairo Airport połączony jest kładką dla pieszych z Terminalem 3 portu lotniczego Kair. Udostępnia on Gościom odkryty basen z podgrzewaną wodą oraz centrum fitness. Na terenie całego hotelu mogą oni też bezpłatnie korzystać z WiFi.', 10);
insert into hotel (id, name, standard, description, city_id) values (11, 'Riad Omri', 5, 'Obiekt Riad Omri, położony w centrum miejscowości Marrakesz, oferuje odkryty basen, bar, a także taras. Odległość ważnych miejsc od obiektu: Muzeum Yves Saint Laurenta – 2,1 km. Do dyspozycji Gości przygotowano takie udogodnienia, jak...', 11);
insert into hotel (id, name, standard, description, city_id) values (12, 'Remo e Berenice', 3, 'Obiekt Remo e Berenice położony jest w miejscowości Nosy Komba i oferuje ogród, zaplecze do uprawiania sportów wodnych, a także restaurację. Dla Gości zapewniono takie udogodnienia, jak całodobowa recepcja. Personel służy...', 12);

insert into airport (id, name, city_id) values (1, 'Malaga Airport or Costa del Sol Airport',1);
insert into airport (id, name, city_id) values (2, 'Athens International Airport',2);
insert into airport (id, name, city_id) values (3, 'Lotnisko Chopina w Warszawie',3);
insert into airport (id, name, city_id) values (4, 'Ankara Esenboğa Airport',4);
insert into airport (id, name, city_id) values (5, 'Male Airport Guide – Velana International Airport',5);
insert into airport (id, name, city_id) values (6, 'Ninoy Aquino International Airport',6);
insert into airport (id, name, city_id) values (7, 'Zvartnots International Airport',7);
insert into airport (id, name, city_id) values (8, 'Larnaca International Airport',8);
insert into airport (id, name, city_id) values (9, 'Tunis–Carthage International Airport',9);
insert into airport (id, name, city_id) values (10, 'Cairo International Airport',10);
insert into airport (id, name, city_id) values (11, 'Menara International Airport',11);
insert into airport (id, name, city_id) values (12, 'Ivato Airport',12);

--insert into city_hotels (city_id, hotels_id) values (1,1);
--insert into city_hotels (city_id, hotels_id) values (2,2);
--insert into city_hotels (city_id, hotels_id) values (3,3);
--insert into city_hotels (city_id, hotels_id) values (4,4);
--insert into city_hotels (city_id, hotels_id) values (5,5);
--insert into city_hotels (city_id, hotels_id) values (6,6);
--insert into city_hotels (city_id, hotels_id) values (7,7);
--insert into city_hotels (city_id, hotels_id) values (8,8);
--insert into city_hotels (city_id, hotels_id) values (9,9);
--insert into city_hotels (city_id, hotels_id) values (10,10);
--insert into city_hotels (city_id, hotels_id) values (11,11);
--insert into city_hotels (city_id, hotels_id) values (12,12);

--insert into COUNTRY_CITIES (country_id, cities_id) values (1, 1);
--insert into COUNTRY_CITIES (country_id, cities_id) values (2, 2);
--insert into COUNTRY_CITIES (country_id, cities_id) values (3, 3);
--insert into COUNTRY_CITIES (country_id, cities_id) values (4, 4);
--insert into COUNTRY_CITIES (country_id, cities_id) values (5, 5);
--insert into COUNTRY_CITIES (country_id, cities_id) values (6, 6);
--insert into COUNTRY_CITIES (country_id, cities_id) values (7, 7);
--insert into COUNTRY_CITIES (country_id, cities_id) values (8, 8);
--insert into COUNTRY_CITIES (country_id, cities_id) values (9, 9);
--insert into COUNTRY_CITIES (country_id, cities_id) values (10, 10);
--insert into COUNTRY_CITIES (country_id, cities_id) values (11, 11);
--insert into COUNTRY_CITIES (country_id, cities_id) values (12, 12);


--insert into tour (origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values (3, 3, 1, 1, 1, '2022-06-14', '2022-06-21', 7, 3500, 3000, 0, 10, 10);
--insert into tour ( origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values ( 3, 3, 1, 1, 1, '2022-06-14', '2022-06-21', 7, 3500, 3000, 0, 10, 10);


insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (1, 1, 2, 2, 2, '2022-06-14', '2022-06-21', 7, 3500, 2800, 0, 10, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (1, 1, 3, 3, 3, '2022-06-15', '2022-06-22', 7, 3600, 2900, 0, 20, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (1, 1, 4, 4, 4, '2022-06-16', '2022-06-23', 7, 3400, 3000, 0, 30, 37);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (1, 1, 5, 5, 5, '2022-06-17', '2022-06-24', 7, 4200, 3100, 1, 40, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (1, 1, 6, 6, 6, '2022-06-18', '2022-06-25', 7, 3800, 3200, 0, 11, 36);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (1, 1, 7, 7, 7, '2022-06-19', '2022-06-26', 7, 4300, 3100, 0, 12, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (1, 1, 8, 8, 8, '2022-06-20', '2022-06-27', 7, 4000, 3500, 0, 13, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (1, 1, 9, 9, 9, '2022-06-21', '2022-06-28', 7, 4200, 3500, 1, 14, 36);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (1, 1, 10, 10, 10, '2022-06-22', '2022-06-29', 7, 3600, 3200, 0, 15, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (1, 1, 11, 11, 11, '2022-06-23', '2022-06-30', 7, 3500, 3100, 0, 16, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (1, 1, 12, 12, 12, '2022-06-24', '2022-07-08', 14, 6000, 5000, 0, 17, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (2, 2, 1, 1, 1, '2022-06-25', '2022-07-09', 14, 6500, 4000, 0, 20, 18);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (2, 2, 3, 3, 3, '2022-06-26', '2022-07-10', 14, 6300, 4700, 1, 11, 19);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (2, 2, 4, 4, 4, '2022-06-27', '2022-07-11', 14, 6200, 3100, 0, 21, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (2, 2, 5, 5, 5, '2022-06-28', '2022-07-12', 14, 6100, 3500, 0, 19, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (2, 2, 6, 6, 6, '2022-06-29', '2022-07-13', 14, 7000, 3800, 0, 50, 54);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (2, 2, 7, 7, 7, '2022-06-30', '2022-07-14', 14, 7200, 3900, 0, 27, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (2, 2, 8, 8, 8, '2022-07-01', '2022-07-08', 7, 3500, 3200, 1, 96, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (2, 2, 9, 9, 9, '2022-07-02', '2022-07-09', 7, 3600, 3500, 0, 23, 45);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (2, 2, 10, 10, 10, '2022-07-03', '2022-07-10', 7, 3300, 3100, 0, 28, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (2, 2, 11, 11, 11, '2022-07-04', '2022-07-11', 7, 3100, 3000, 0, 10, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (2, 2, 12, 12, 12, '2022-07-05', '2022-07-12', 7, 3600, 3200, 0, 19, 43);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (3, 3, 1, 1, 1, '2022-07-06', '2022-07-13', 7, 3900, 3000, 0, 27, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (3, 3, 2, 2, 2, '2022-07-07', '2022-07-14', 7, 3200, 3100, 0, 73, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (3, 3, 4, 4, 4, '2022-07-08', '2022-07-15', 7, 3800, 3500, 0, 45, 74);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (3, 3, 5, 5, 5, '2022-07-09', '2022-07-16', 7, 3100, 3000, 1, 67, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (3, 3, 6, 6, 6, '2022-07-10', '2022-07-17', 7, 3300, 2800, 0, 98, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (3, 3, 7, 7, 7, '2022-07-11', '2022-07-18', 7, 3600, 3400, 0, 76, 54);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (3, 3, 8, 8, 8, '2022-07-12', '2022-07-19', 7, 3500, 3200, 0, 55, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (3, 3, 9, 9, 9, '2022-07-13', '2022-07-20', 7, 3200, 2900, 0, 43, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (3, 3, 10, 10, 10, '2022-07-14', '2022-07-21', 7, 3400, 3300, 0, 31, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (3, 3, 11, 11, 11, '2022-07-15', '2022-07-22', 7, 3500, 3200, 0, 10, 26);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (3, 3, 12, 12, 12, '2022-07-16', '2022-07-23', 7, 3800, 3600, 0, 27, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (4, 4, 1, 1, 1, '2022-07-17', '2022-07-24', 7, 3100, 2500, 0, 93, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (4, 4, 2, 2, 2, '2022-07-18', '2022-07-25', 7, 3200, 2700, 0, 43, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (4, 4, 3, 3, 3, '2022-07-19', '2022-07-26', 7, 3300, 2500, 0, 46, 6);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (4, 4, 5, 5, 5, '2022-07-20', '2022-07-27', 7, 3400, 3000, 1, 67, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (4, 4, 6, 6, 6, '2022-07-21', '2022-07-28', 7, 3500, 3100, 0, 65, 52);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (4, 4, 7, 7, 7, '2022-07-22', '2022-07-29', 7, 3600, 3400, 0, 44, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (4, 4, 8, 8, 8, '2022-07-23', '2022-07-30', 7, 3700, 3600, 0, 32, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (4, 4, 9, 9, 9, '2022-07-24', '2022-07-31', 7, 3800, 3500, 0, 18, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (4, 4, 10, 10, 10, '2022-07-25', '2022-08-08', 14, 4500, 3700, 0, 23, 27);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (4, 4, 11, 11, 11, '2022-07-26', '2022-08-09', 14, 9000, 5000, 0, 34, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (4, 4, 12, 12, 12, '2022-07-27', '2022-08-10', 14, 7000, 6000, 0, 35, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (5, 5, 1, 1, 1, '2022-07-28', '2022-08-11', 14, 7500, 6800, 0, 45, 47);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (5, 5, 2, 2, 2, '2022-07-29', '2022-08-12', 14, 6500, 4000, 1, 67, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (5, 5, 3, 3, 3, '2022-07-30', '2022-08-13', 14, 6000, 3800, 0, 78, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (5, 5, 4, 4, 4, '2022-07-31', '2022-08-14', 14, 4800, 3800, 0, 89, 52);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (5, 5, 6, 6, 6, '2022-08-01', '2022-08-15', 14, 5000, 4000, 0, 56, 27);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (5, 5, 7, 7, 7, '2022-08-02', '2022-08-16', 14, 5700, 5000, 0, 45, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (5, 5, 8, 8, 8, '2022-08-03', '2022-08-17', 14, 5800, 3700, 0, 45, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (5, 5, 9, 9, 9, '2022-08-04', '2022-08-18', 14, 5900, 4200, 0, 23, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (5, 5, 10, 10, 10, '2022-08-05', '2022-08-19', 14, 6100, 3000, 0, 41, 36);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (5, 5, 11, 11, 11, '2022-08-06', '2022-08-20', 14, 6100, 3000, 0, 51, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (5, 5, 12, 12, 12, '2022-08-07', '2022-08-21', 14, 5900, 3000, 0, 66, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (6, 6, 1, 1, 1, '2022-08-08', '2022-08-22', 14, 5800, 3000, 1, 63, 37);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (6, 6, 2, 2, 2, '2022-08-09', '2022-08-23', 14, 5700, 3000, 0, 84, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (6, 6, 3, 3, 3, '2022-08-10', '2022-08-24', 14, 5600, 3000, 0, 73, 28);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (6, 6, 4, 4, 4, '2022-08-11', '2022-08-25', 14, 5500, 3000, 0, 53, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (6, 6, 5, 5, 5, '2022-08-12', '2022-08-26', 14, 5400, 3000, 0, 55, 27);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (6, 6, 7, 7, 7, '2022-08-13', '2022-08-27', 14, 4900, 3000, 0, 41, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (6, 6, 8, 8, 8, '2022-08-14', '2022-08-28', 14, 6100, 3000, 0, 52, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (6, 6, 9, 9, 9, '2022-08-15', '2022-08-29', 14, 6200, 3000, 0, 35, 37);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (6, 6, 10, 10, 10, '2022-08-16', '2022-08-30', 14, 6300, 3000, 0, 44, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (6, 6, 11, 11, 11, '2022-08-17', '2022-08-31', 14, 6400, 3000, 0, 34, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (6, 6, 12, 12, 12, '2022-08-18', '2022-08-25', 7, 3500, 3000, 0, 45, 58);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (7, 7, 1, 1, 1, '2022-08-19', '2022-08-26', 7, 3100, 3000, 0, 67, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (7, 7, 2, 2, 2, '2022-08-20', '2022-08-27', 7, 3200, 3000, 1, 78, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (7, 7, 3, 3, 3, '2022-08-21', '2022-08-28', 7, 3300, 3000, 0, 89, 36);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (7, 7, 4, 4, 4, '2022-08-22', '2022-08-29', 7, 3400, 3000, 0, 54, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (7, 7, 5, 5, 5, '2022-08-23', '2022-08-30', 7, 3500, 3000, 0, 42, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (7, 7, 6, 6, 6, '2022-08-24', '2022-08-31', 7, 3600, 3000, 0, 74, 35);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (7, 7, 8, 8, 8, '2022-08-25', '2022-09-01', 7, 3700, 3000, 0, 37, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (7, 7, 9, 9, 9, '2022-08-26', '2022-09-02', 7, 3800, 3000, 0, 21, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (7, 7, 10, 10, 10, '2022-08-27', '2022-09-03', 7, 3900, 3000, 0, 78, 27);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (7, 7, 11, 11, 11, '2022-08-28', '2022-09-04', 7, 3100, 3000, 1, 41, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (7, 7, 12, 12, 12, '2022-08-29', '2022-09-05', 7, 3200, 3000, 0, 72, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (8, 8, 1, 1, 1, '2022-08-30', '2022-09-06', 7, 4100, 3000, 0, 79, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (8, 8, 2, 2, 2, '2022-08-31', '2022-09-07', 7, 4200, 3000, 0, 29, 27);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (8, 8, 3, 3, 3, '2022-09-01', '2022-09-08', 7, 4300, 3000, 0, 34, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (8, 8, 4, 4, 4, '2022-09-02', '2022-09-09', 7, 4400, 3000, 0, 94, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (8, 8, 5, 5, 5, '2022-09-03', '2022-09-10', 7, 4500, 3000, 0, 37, 52);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (8, 8, 6, 6, 6, '2022-09-04', '2022-09-11', 7, 4600, 3000, 0, 39, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (8, 8, 7, 7, 7, '2022-09-05', '2022-09-12', 7, 4700, 3000, 1, 41, 42);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (8, 8, 9, 9, 9, '2022-09-06', '2022-09-13', 7, 4800, 3000, 0, 10, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (8, 8, 10, 10, 10, '2022-09-07', '2022-09-14', 7, 4700, 3000, 0, 46, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (8, 8, 11, 11, 11, '2022-09-08', '2022-09-15', 7, 4600, 3000, 0, 10, 37);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (8, 8, 12, 12, 12, '2022-09-09', '2022-09-16', 7, 4500, 3000, 0, 83, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (9, 9, 1, 1, 1, '2022-09-10', '2022-09-17', 7, 4400, 3000, 0, 36, 26);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (9, 9, 2, 2, 2, '2022-09-11', '2022-09-18', 7, 4300, 3000, 0, 42, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (9, 9, 3, 3, 3, '2022-09-12', '2022-09-19', 7, 4200, 3000, 0, 17, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (9, 9, 4, 4, 4, '2022-09-13', '2022-09-20', 7, 4100, 3000, 0, 54, 27);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (9, 9, 5, 5, 5, '2022-09-14', '2022-09-21', 7, 4000, 3000, 1, 94, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (9, 9, 6, 6, 6, '2022-09-15', '2022-09-22', 7, 3900, 3000, 0, 45, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (9, 9, 7, 7, 7, '2022-09-16', '2022-09-23', 7, 3800, 3000, 0, 34, 16);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (9, 9, 8, 8, 8, '2022-09-17', '2022-09-24', 7, 3700, 3000, 0, 57, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (9, 9, 10, 10, 10, '2022-09-18', '2022-09-25', 7, 3600, 3000, 0, 91, 27);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (9, 9, 11, 11, 11, '2022-09-19', '2022-09-26', 7, 3500, 3000, 0, 24, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (9, 9, 12, 12, 12, '2022-09-20', '2022-09-27', 7, 3400, 3000, 0, 140, 27);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (10, 10, 1, 1, 1, '2022-09-21', '2022-09-28', 7, 3300, 3000, 0, 10, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (10, 10, 2, 2, 2, '2022-09-22', '2022-09-29', 7, 3200, 3000, 0, 63, 47);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (10, 10, 3, 3, 3, '2022-09-23', '2022-09-30', 7, 3100, 3000, 0, 28, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (10, 10, 4, 4, 4, '2022-09-24', '2022-10-08', 14, 5500, 3000, 0, 57, 40);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (10, 10, 5, 5, 5, '2022-09-25', '2022-10-09', 14, 6500, 3000, 1, 32, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (10, 10, 6, 6, 6, '2022-09-26', '2022-10-10', 14, 7500, 3000, 0, 87, 38);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (10, 10, 7, 7, 7, '2022-09-27', '2022-10-11', 14, 7600, 3000, 0, 63, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (10, 10, 8, 8, 8, '2022-09-28', '2022-10-12', 14, 7500, 3000, 0, 58, 40);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (10, 10, 9, 9, 9, '2022-09-29', '2022-10-13', 14, 7400, 3900, 0, 26, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (10, 10, 11, 11, 11, '2022-09-30', '2022-10-14', 14, 7300, 4700, 0, 65, 39);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (10, 10, 12, 12, 12, '2022-10-01', '2022-10-15', 14, 7200, 4900, 0, 43, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (11, 11, 1, 1, 1, '2022-10-02', '2022-10-16', 14, 7100, 5000, 0, 47, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (11, 11, 2, 2, 2, '2022-10-03', '2022-10-17', 14, 7000, 5500, 0, 160, 36);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (11, 11, 3, 3, 3, '2022-10-04', '2022-10-18', 14, 6900, 4900, 0, 70, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (11, 11, 4, 4, 4, '2022-10-05', '2022-10-19', 14, 6800, 5200, 0, 20, 37);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (11, 11, 5, 5, 5, '2022-10-06', '2022-10-20', 14, 6700, 5300, 0, 30, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (11, 11, 6, 6, 6, '2022-10-07', '2022-10-21', 14, 6600, 5200, 0, 40, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (11, 11, 7, 7, 7, '2022-10-08', '2022-10-22', 14, 6500, 4900, 1, 50, 28);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (11, 11, 8, 8, 8, '2022-10-09', '2022-10-23', 14, 6400, 4800, 0, 60, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (11, 11, 9, 9, 9, '2022-10-10', '2022-10-24', 14, 6300, 4700, 0, 70, 18);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (11, 11, 10, 10, 10, '2022-10-11', '2022-10-25', 14, 6200, 4600, 0, 76, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (11, 11, 12, 12, 12, '2022-10-12', '2022-10-26', 14, 6100, 4500, 0, 75, 15);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (12, 12, 1, 1, 1, '2022-10-13', '2022-10-27', 14, 6000, 4400, 0, 73, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (12, 12, 2, 2, 2, '2022-10-14', '2022-10-28', 14, 5900, 4300, 0, 69, 31);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (12, 12, 3, 3, 3, '2022-10-15', '2022-10-29', 14, 5800, 4200, 0, 67, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (12, 12, 4, 4, 4, '2022-10-16', '2022-10-30', 14, 5700, 4100, 0, 64, 25);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (12, 12, 5, 5, 5, '2022-10-17', '2022-10-31', 14, 5600, 4000, 0, 47, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (12, 12, 6, 6, 6, '2022-10-18', '2022-10-25', 7, 3500, 3000, 0, 53, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (12, 12, 7, 7, 7, '2022-10-19', '2022-10-26', 7, 3400, 2900, 0, 43, 23);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (12, 12, 8, 8, 8, '2022-10-20', '2022-10-27', 7, 3300, 2800, 0, 10, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (12, 12, 9, 9, 9, '2022-10-21', '2022-10-28', 7, 3200, 2700, 1, 38, 10);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (12, 12, 10, 10, 10, '2022-10-22', '2022-10-29', 7, 3100, 2600, 0, 76, 34);
insert into tour(origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats)values (12, 12, 11, 11, 11, '2022-10-23', '2022-10-30', 7, 3000, 2500, 0, 54, 10);

insert into customer (id, email, name, surname) values(1, 'jan@wp.pl', 'Jan', 'Kowalski');
insert into BOUGHT_TOUR (id, adult_amount, child_amount, price, customer_id, tour_id) values (1, 2, 1, '9800', 1, 1);
--insert into CUSTOMER_BOUGHT_TOURS (customer_id, bought_tours_id) values (1 ,1);