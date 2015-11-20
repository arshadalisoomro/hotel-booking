INSERT INTO category (id, name)
VALUES 
(1, 'Luxury'),
(2, 'Apartment Hotel'),
(3, 'Motel'),
(4, 'Bed and Breakfast'),
(5, 'Resort');

INSERT INTO room_type (id, description, occupancy)
VALUES
(1, 'Single', 1),
(2, 'Double', 2),
(3, 'Studio', 2),
(4, 'Presidential Suite', 6);

INSERT INTO authority (id, role)
VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_COMMENT_MODERATOR'),
(3, 'ROLE_HOTEL_MANAGER'),
(4, 'ROLE_ADMIN');

INSERT INTO `user`(id, email, name, password, username, authority_id)
VALUES
(1, 'pedro@email.com','Pedro Carvalho', 'pass', 'pedro', 4),
(2, 'manuel@email.com','Manuel Bastos', 'pass', 'manuel', 2),
(3, 'tiago@email.com','Tiago Pereira', 'pass', 'tiago', 1),
(4, 'rui@email.com','Rui Abreu', 'pass', 'rui', 3),
(5, 'luis@email.com','Luis Piedade', 'pass', 'luis', 3);

insert into `user` (id, email, name, password, username, authority_id) values (6, 'dhill0@bloglines.com', 'Deborah Hill', 'UKtpJgDr', 'dhill0', 1);
insert into `user` (id, email, name, password, username, authority_id) values (7, 'sbradley1@microsoft.com', 'Sandra Bradley', 'tSOTgV', 'sbradley1', 3);
insert into `user` (id, email, name, password, username, authority_id) values (8, 'jmurray2@gizmodo.com', 'John Murray', 'Rnjon0', 'jmurray2', 1);
insert into `user` (id, email, name, password, username, authority_id) values (9, 'ahoward3@ox.ac.uk', 'Aaron Howard', 'ScFVd7p42Yn', 'ahoward3', 1);
insert into `user` (id, email, name, password, username, authority_id) values (10, 'kflores4@parallels.com', 'Kathryn Flores', 'ztTx2Oa4', 'kflores4', 3);
insert into `user` (id, email, name, password, username, authority_id) values (11, 'dpeters5@ucoz.ru', 'Diana Peters', 'MKySNw', 'dpeters5', 1);
insert into `user` (id, email, name, password, username, authority_id) values (12, 'blynch6@tinypic.com', 'Brenda Lynch', 'Kp1ID5o69k', 'blynch6', 1);
insert into `user` (id, email, name, password, username, authority_id) values (13, 'mandrews7@dmoz.org', 'Michael Andrews', 'ZXnMzMytUWaV', 'mandrews7', 1);
insert into `user` (id, email, name, password, username, authority_id) values (14, 'mfranklin8@cbc.ca', 'Matthew Franklin', 'c72DCVcD', 'mfranklin8', 1);
insert into `user` (id, email, name, password, username, authority_id) values (15, 'ajackson9@adobe.com', 'Amy Jackson', 'LxIhudJ', 'ajackson9', 1);

INSERT INTO hotel (id, address, name, rating, category_id, manager_id, status)
VALUES
(1, 'Rua Castilho 149, Lisbon','Intercontinental', 5, 1, 4, true),
(2, 'Av. D. Joao II, Lisbon','Tryp', 4, 2, 4, true),
(3, 'Rua da Madalena 96, Lisbon','Holiday Inn', 2, 3, 5, true),
(4, 'Avenida dos Combatentes, Lisbon', 'Marriott', 5, 5, 5, false);

insert into room (id, floor, room_number, hotel_id, type_id, price) values (1, 1, '101', 1, 1, 50);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (2, 1, '102', 1, 2, 75);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (3, 1, '103', 1, 3, 100);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (4, 1, '104', 1, 4, 200);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (5, 1, '105', 1, 1, 50);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (6, 2, '201', 1, 2, 75);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (7, 2, '202', 1, 3, 100);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (8, 2, '203', 1, 4, 200);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (9, 2, '204', 1, 1, 50);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (10, 2, '205', 1, 2, 75);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (11, 1, '101', 2, 1, 50);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (12, 1, '102', 2, 2, 75);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (13, 1, '103', 2, 3, 100);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (14, 1, '104', 2, 4, 200);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (15, 1, '105', 2, 1, 50);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (16, 2, '201', 2, 2, 75);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (17, 2, '202', 2, 3, 100);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (18, 2, '203', 2, 4, 200);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (19, 2, '204', 2, 1, 50);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (20, 2, '205', 2, 2, 75);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (21, 1, '101', 3, 1, 50);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (22, 1, '102', 3, 2, 75);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (23, 1, '103', 3, 3, 100);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (24, 1, '104', 3, 4, 200);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (25, 1, '105', 3, 1, 50);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (26, 2, '201', 3, 2, 75);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (27, 2, '202', 3, 3, 100);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (28, 2, '203', 3, 4, 200);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (29, 2, '204', 3, 1, 50);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (30, 2, '205', 3, 2, 75);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (31, 1, '101', 4, 1, 50);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (32, 1, '102', 4, 2, 75);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (33, 1, '103', 4, 3, 100);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (34, 1, '104', 4, 4, 200);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (35, 1, '105', 4, 1, 50);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (36, 2, '201', 4, 2, 75);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (37, 2, '202', 4, 3, 100);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (38, 2, '203', 4, 4, 200);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (39, 2, '204', 4, 1, 50);
insert into room (id, floor, room_number, hotel_id, type_id, price) values (40, 2, '205', 4, 2, 75);

INSERT INTO comment (id, `date`, status, text, hotel_id, user_id, is_answer)
VALUES
(1, '2013-08-30 19:05:00',TRUE,'The best thing about this hotel were the owners. They were lovely friendly people. Giovanni asked us what he could cook for us. In no time we had a delicious pasta all amatriciana and a mixed meat dish. It was very nice.', 1, 3, false),
(2, '2015-10-18 15:10:00',TRUE,'Really helpful staff, studio room was perfect.', 1, 6, false),
(3, '2015-10-20 16:43:00',FALSE,'We loved the nice quiet location, the wonderful hospitality of the proprietor and superbly attentive staff. Breakfast always well presented and varied. Beautiful apartment with excellent facilities!', 1, 3, false),
(4, '2015-09-30 20:12:00',TRUE,'The location of the Hotel is great. Its only a view kms from the Airport, there is the great shopping centre Vasco da Gama in front of the hotel and the Metro station is next door as well.', 2, 3, false),
(5, '2015-09-30 17:55:00',TRUE,'Shower head moves all over the place. Boiler is noisy even though its in an outside cupboard its still next to the bed. Be good if the wall could be insulated.', 3, 8, false),
(6, '2015-09-30 17:55:00',TRUE,'Friendly and helpful staff. Great pool. Not in the city centre of Lisbon but close to the undergound station.', 4, 9, false);

insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (7, '2015-04-25 07:51:47', false, 'In congue. Etiam justo. Etiam pretium iaculis justo.', 4, 11, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (8, '2015-07-26 20:32:02', false, 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', 2, 12, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (9, '2015-09-15 04:37:56', false, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', 2, 13, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (10, '2015-01-13 01:51:10', true, 'Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.', 4, 14, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (11, '2015-06-28 12:12:37', true, 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', 1, 15, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (12, '2015-07-01 06:38:51', true, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', 1, 6, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (13, '2015-10-19 20:57:42', true, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', 1, 3, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (14, '2014-12-01 11:35:37', true, 'In congue. Etiam justo. Etiam pretium iaculis justo.', 3, 8, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (15, '2015-05-25 01:04:13', false, 'Sed ante. Vivamus tortor. Duis mattis egestas metus.', 1, 9, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (16, '2015-08-09 12:02:23', true, 'Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', 2, 3, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (17, '2015-01-02 00:28:37', true, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 2, 14, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (18, '2015-10-21 19:00:14', true, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', 4, 12, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (19, '2015-09-19 21:49:18', false, 'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 3, 11, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (20, '2015-02-06 11:01:13', false, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 1, 3, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (21, '2015-05-21 14:39:19', true, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', 4, 3, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (22, '2015-09-05 14:28:02', false, 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', 2, 6, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (23, '2015-08-30 18:38:37', true, 'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.', 1, 13, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (24, '2015-02-05 08:57:59', false, 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 1, 12, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (25, '2015-02-15 05:51:24', true, 'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.', 1, 8, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (26, '2015-01-11 09:44:24', false, 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', 2, 9, false);

INSERT INTO image (id, insertion_date, hotel_id, path)
VALUES
(1, '2015-10-22 15:00:00', 1, 'intercontinental.jpg'),
(2, '2015-10-22 15:00:00', 1, 'intercontinental2.jpg'),
(3, '2015-10-22 15:00:00', 1, 'intercontinental3.jpg'),
(4, '2015-10-22 15:00:00', 2, 'tryp.jpg'),
(5, '2015-10-22 15:00:00', 2, 'tryp2.jpg'),
(6, '2015-10-22 15:00:00', 3, 'inn.jpg'),
(7, '2015-10-22 15:00:00', 3, 'inn2.jpg'),
(8, '2015-10-22 15:00:00', 4, 'marriott.jpg'),
(9, '2015-10-22 15:00:00', 4, 'marriott2.jpg');

insert into booking (id, begin_date, end_date, state, user_id) values (1, '2015-12-03 12:00:00', '2015-12-05 12:00:00', TRUE, 15);
insert into booking (id, begin_date, end_date, state, user_id) values (2, '2015-12-04 12:00:00', '2015-12-07 12:00:00', TRUE, 9);
insert into booking (id, begin_date, end_date, state, user_id) values (3, '2015-11-29 14:00:00', '2015-12-02 11:00:00', TRUE, 3);
insert into booking (id, begin_date, end_date, state, user_id) values (4, '2015-11-27 02:16:13', '2015-11-29 05:30:55', false, 3);
insert into booking (id, begin_date, end_date, state, user_id) values (5, '2015-12-05 16:53:12', '2015-12-07 14:04:27', false, 6);
insert into booking (id, begin_date, end_date, state, user_id) values (6, '2015-12-21 15:43:32', '2015-12-23 21:49:40', false, 8);
insert into booking (id, begin_date, end_date, state, user_id) values (7, '2015-11-23 20:22:39', '2014-11-24 16:22:16', true, 9);
insert into booking (id, begin_date, end_date, state, user_id) values (8, '2015-12-01 08:12:25', '2015-12-03 05:40:48', true, 11);
insert into booking (id, begin_date, end_date, state, user_id) values (9, '2015-12-23 08:48:20', '2015-12-25 10:16:14', false, 4);
insert into booking (id, begin_date, end_date, state, user_id) values (10, '2015-11-27 01:27:44', '2015-11-28 05:31:19', false, 3);
insert into booking (id, begin_date, end_date, state, user_id) values (11, '2015-12-05 09:44:00', '2014-12-09 00:10:38', true, 12);
insert into booking (id, begin_date, end_date, state, user_id) values (12, '2015-11-30 21:35:09', '2015-12-04 10:18:16', true, 13);
insert into booking (id, begin_date, end_date, state, user_id) values (13, '2015-11-28 20:26:30', '2015-12-01 05:10:56', true, 14);

insert into booking_rooms (bookings_id, rooms_id) values (1, 1);
insert into booking_rooms (bookings_id, rooms_id) values (2, 2);
insert into booking_rooms (bookings_id, rooms_id) values (3, 5);
insert into booking_rooms (bookings_id, rooms_id) values (4, 7);
insert into booking_rooms (bookings_id, rooms_id) values (5, 12);
insert into booking_rooms (bookings_id, rooms_id) values (6, 13);
insert into booking_rooms (bookings_id, rooms_id) values (7, 18);
insert into booking_rooms (bookings_id, rooms_id) values (8, 19);
insert into booking_rooms (bookings_id, rooms_id) values (9, 25);
insert into booking_rooms (bookings_id, rooms_id) values (10, 26);
insert into booking_rooms (bookings_id, rooms_id) values (11, 27);
insert into booking_rooms (bookings_id, rooms_id) values (12, 31);
insert into booking_rooms (bookings_id, rooms_id) values (13, 33);
insert into booking_rooms (bookings_id, rooms_id) values (4, 9);
insert into booking_rooms (bookings_id, rooms_id) values (5, 15);
insert into booking_rooms (bookings_id, rooms_id) values (6, 11);