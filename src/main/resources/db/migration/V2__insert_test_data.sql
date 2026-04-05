INSERT INTO city (city_id, display_name)
VALUES
('city_1', 'Kyiv'),
('city_2', 'Lviv'),
('city_3', 'Warsaw');

INSERT INTO user_profile (user_profile_id, first_name, last_name, username, password)
VALUES
('user_1', 'Anna', 'Ivanova', 'anna_i', 'pass123'),
('user_2', 'Oleg', 'Petrenko', 'oleg_p', 'pass456');

INSERT INTO flight (flight_id, departure_city_id, arrival_city_id, departure_time, arrival_time, flight_number, price)
VALUES
('flight_1', 'city_1', 'city_2', '2026-04-10 10:00:00+03', '2026-04-10 11:30:00+03', 'PS101', '1500'),
('flight_2', 'city_2', 'city_3', '2026-04-11 09:00:00+03', '2026-04-11 12:00:00+03', 'LO202', '2200');

INSERT INTO ticket (ticket_id, flight_id, user_profile_id, pnr)
VALUES
('ticket_1', 'flight_1', 'user_1', 'PNR001'),
('ticket_2', 'flight_2', 'user_2', 'PNR002');