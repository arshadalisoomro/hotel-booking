INSERT INTO category (id, name)
VALUES 
(1, 'Luxury'),
(2, 'Apartment Hotel'),
(3, 'Motel'),
(4, 'Bed and Breakfast'),
(5, 'Resort');

INSERT INTO room_type (id, description)
VALUES
(1, 'Single'),
(2, 'Double'),
(3, 'Presidential Suite');

INSERT INTO `user`(id, email, name, password, username)
VALUES
(1, 'pedro@email.com','Pedro', 'password', 'pedro'),
(2, 'manuel@email.com','Manuel', 'password', 'manuel'),
(3, 'tiago@email.com','Tiago', 'password', 'tiago');

INSERT INTO hotel (id, address, name, rating, category_id)
VALUES
(1, 'Rua Castilho 149','Intercontinental', 4, 1),
(2, 'Av. D. Joao II, Lisboa','Tryp', 3, 2),
(3, 'Rua da Madalena 96, Lisbon','Holiday Inn', 5, 3),
(4, 'Avenida dos Combatentes, Lisbon', 'Marriott', 2, 4);

INSERT INTO room (id, floor, room_number, hotel_id, type_id)
VALUES
(1,2, '209',1,1),
(2,3, '310',3,1),
(3,2, '249',2,2);

INSERT INTO comment (comment_id, `date`, status, text, hotel_id, user_id)
VALUES
(1, '2013-08-30 19:05:00',TRUE,'The best thing about this hotel were the owners. They were lovely friendly people. Giovanni asked us what he could cook for us. In no time we had a delicious pasta all amatriciana and a mixed meat dish. It was very nice.', 1,1);
