insert into continent (id, name) values (1, 'Europa');

INSERT INTO COUNTRY (ID, NAME,continents_id) VALUES (1, 'Hiszpania',1);
INSERT INTO COUNTRY (ID, NAME,continents_id) VALUES (2, 'Grecja',1);
INSERT INTO COUNTRY (ID, NAME,continents_id) VALUES (3, 'Polska',1);
INSERT INTO COUNTRY (ID, NAME,continents_id) VALUES (4, 'Turcja',1);

insert into city (id, name, country_id) values (1, 'Malaga', 1);
insert into city (id, name, country_id) values (2, 'Ateny', 2);
insert into city (id, name, country_id) values (3, 'Warszawa', 3);
insert into city (id, name, country_id) values (4, 'Ankara', 4);


insert into role (id, name) values(1, 'ADMIN');
insert into role (id, name) values(2, 'CUSTOMER');

insert into user (id, username, password) values(1, 'admin', '$2a$10$csIVj5k8CB74npTTstUQuO3ObjmaM6y8cRMxvsKqpHmT3zNQxY/IK');

insert into user_role (user_id, role_id) values(1,1);

insert into continent (id, name) values (2, 'Azja');
--
insert into country (id, name,continents_id) values (5, 'Malediwy',2);
insert into country (id, name,continents_id) values (6, 'Filipiny',2);
insert into country (id, name,continents_id) values (7, 'Armenia',2);
insert into country (id, name,continents_id) values (8, 'Cypr',2);


insert into city (id, name, country_id) values (5, 'Male', 5);
insert into city (id, name, country_id) values (6, 'Manila', 5);
insert into city (id, name, country_id) values (7, 'Yerevan', 7);
insert into city (id, name, country_id) values (8, 'Larnaka', 8);


insert into continent (id, name) values (3, 'Afryka');

insert into country (id, name,continents_id) values (9, 'Tunezja',3);
insert into country (id, name,continents_id) values (10, 'Egipt',3);
insert into country (id, name,continents_id) values (11, 'Maroko',3);
insert into country (id, name,continents_id) values (12, 'Madagaskar',3);



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

insert into tour ( origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values ( 3, 3, 1, 1, 1, '2022-06-14', '2022-06-21', 7, 3500, 3000, 0, 10, 10);
insert into tour ( origin_city_id, origin_airport_id, destination_city_id, destination_airport_id, destination_hotel_id, start_date, end_date, duration_time, adult_price, minor_price, promotion, adult_seats, minor_seats) values ( 3, 3, 1, 1, 1, '2022-06-14', '2022-06-21', 7, 3500, 3000, 0, 10, 10);


--insert into role (id, name) values(1, 'ADMIN');
--insert into role (id, name) values(2, 'USER');
--
--insert into user (id, username, password) values(1, 'admin', '$2a$10$csIVj5k8CB74npTTstUQuO3ObjmaM6y8cRMxvsKqpHmT3zNQxY/IK');
--
--insert into user_role (user_id, role_id) values(1,1);



