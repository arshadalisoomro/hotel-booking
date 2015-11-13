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
(3, 'Presidential Suite', 6),
(4, 'Studio', 2);

INSERT INTO authority (id, role)
VALUE
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

INSERT INTO hotel (id, address, name, rating, category_id, manager_id, status)
VALUES
(1, 'Rua Castilho 149, Lisbon','Intercontinental', 5, 1, 4, true),
(2, 'Av. D. Joao II, Lisbon','Tryp', 4, 2, 4, true),
(3, 'Rua da Madalena 96, Lisbon','Holiday Inn', 2, 3, 5, true),
(4, 'Avenida dos Combatentes, Lisbon', 'Marriott', 5, 5, 5, false);

INSERT INTO room (id, floor, room_number, hotel_id, type_id, price)
VALUES
(1, 2, '217', 1, 1, 50),
(2, 3, '310', 1, 2, 100),
(3, 5, '507', 1, 3, 150),
(4, 4, '413', 2, 1, 50),
(5, 5, '250', 2, 2, 100),
(6, 1, '111', 3, 2, 100),
(7, 3, '321', 3, 1, 50),
(8, 2, '226', 4, 4, 75),
(9,2,'218',1,1,50);

INSERT INTO comment (id, `date`, status, text, hotel_id, user_id, is_answer)
VALUES
(1, '2013-08-30 19:05:00',TRUE,'The best thing about this hotel were the owners. They were lovely friendly people. Giovanni asked us what he could cook for us. In no time we had a delicious pasta all amatriciana and a mixed meat dish. It was very nice.', 1, 1, false),
(2, '2015-10-18 15:10:00',TRUE,'Really helpful staff, studio room was perfect.', 1, 2, false),
(3, '2015-10-20 16:43:00',FALSE,'We loved the nice quiet location, the wonderful hospitality of the proprietor and superbly attentive staff. Breakfast always well presented and varied. Beautiful apartment with excellent facilities!', 1, 3, false),
(4, '2015-09-30 20:12:00',TRUE,'The location of the Hotel is great. Its only a view kms from the Airport, there is the great shopping centre Vasco da Gama in front of the hotel and the Metro station is next door as well.', 2, 3, false),
(5, '2015-09-30 17:55:00',TRUE,'Shower head moves all over the place. Boiler is noisy even though its in an outside cupboard its still next to the bed. Be good if the wall could be insulated.', 3, 3, false),
(6, '2015-09-30 17:55:00',TRUE,'Friendly and helpful staff. Great pool. Not in the city centre of Lisbon but close to the undergound station.', 4, 1, false);

insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (7, '2015-04-25 07:51:47', false, 'In congue. Etiam justo. Etiam pretium iaculis justo.', 4, 2, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (8, '2015-07-26 20:32:02', false, 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', 2, 1, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (9, '2015-09-15 04:37:56', false, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', 2, 4, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (10, '2015-01-13 01:51:10', true, 'Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.', 4, 1, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (11, '2015-06-28 12:12:37', true, 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', 1, 4, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (12, '2015-07-01 06:38:51', true, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', 1, 4, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (13, '2015-10-19 20:57:42', true, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', 1, 3, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (14, '2014-12-01 11:35:37', true, 'In congue. Etiam justo. Etiam pretium iaculis justo.', 3, 3, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (15, '2015-05-25 01:04:13', false, 'Sed ante. Vivamus tortor. Duis mattis egestas metus.', 1, 1, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (16, '2015-08-09 12:02:23', true, 'Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', 2, 5, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (17, '2015-01-02 00:28:37', true, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 2, 2, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (18, '2015-10-21 19:00:14', true, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', 4, 2, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (19, '2015-09-19 21:49:18', false, 'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', 3, 4, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (20, '2015-02-06 11:01:13', false, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 1, 1, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (21, '2015-05-21 14:39:19', true, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', 4, 3, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (22, '2015-09-05 14:28:02', false, 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', 2, 2, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (23, '2015-08-30 18:38:37', true, 'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.', 1, 1, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (24, '2015-02-05 08:57:59', false, 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 1, 4, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (25, '2015-02-15 05:51:24', true, 'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.', 1, 5, false);
insert into comment (id, `date`, status, text, hotel_id, user_id, is_answer) values (26, '2015-01-11 09:44:24', false, 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', 2, 4, false);

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

INSERT INTO booking (id, begin_date, end_date, state, room_id, user_id)
VALUES
(1, '2015-11-03 14:00:00', '2015-11-05 11:00:00', TRUE, 1, 1),
(2, '2015-11-24 14:00:00', '2015-11-29 11:00:00', TRUE, 4, 1),
(3, '2015-11-29 14:00:00', '2015-12-02 11:00:00', TRUE, 7, 1);

insert into booking (id, begin_date, end_date, state, room_id, user_id) values (4, '2015-10-23 02:16:13', '2015-10-25 05:30:55', false, 1, 2);
insert into booking (id, begin_date, end_date, state, room_id, user_id) values (5, '2015-12-05 16:53:12', '2015-12-07 14:04:27', false, 5, 5);
insert into booking (id, begin_date, end_date, state, room_id, user_id) values (6, '2015-12-21 15:43:32', '2015-12-23 21:49:40', false, 1, 1);
insert into booking (id, begin_date, end_date, state, room_id, user_id) values (7, '2015-11-23 20:22:39', '2014-11-24 16:22:16', true, 4, 2);
insert into booking (id, begin_date, end_date, state, room_id, user_id) values (8, '2015-12-01 08:12:25', '2015-12-03 05:40:48', true, 5, 3);
insert into booking (id, begin_date, end_date, state, room_id, user_id) values (9, '2015-12-23 08:48:20', '2015-12-25 10:16:14', false, 2, 4);
insert into booking (id, begin_date, end_date, state, room_id, user_id) values (10, '2015-11-27 01:27:44', '2015-11-28 05:31:19', false, 8, 3);
insert into booking (id, begin_date, end_date, state, room_id, user_id) values (11, '2015-11-14 09:44:00', '2014-11-17 00:10:38', true, 7, 5);
insert into booking (id, begin_date, end_date, state, room_id, user_id) values (12, '2015-11-30 21:35:09', '2015-12-02 10:18:16', true, 4, 1);
insert into booking (id, begin_date, end_date, state, room_id, user_id) values (13, '2015-11-17 20:26:30', '2015-11-20 05:10:56', true, 8, 5);