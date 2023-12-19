-- INSERT INTO level (id, monthly_cost, allocation_reduction, maximum_time, level_type)
-- VALUES (1, 10, 10, 10, 'BRONZE'),
--        (2, 10, 10, 10, 'SILVER'),
--        (3, 10, 10, 10, 'GOLD');

-- INSERT INTO admin (id, email, password)
-- VALUES (1, 'admin@parkshark.com', '$2a$12$r3fLIlWCAzvA6qgIqf.60uDPFn00QwpS6ba28LNvSXBYF0eHbVDAW');

INSERT INTO level (monthly_cost, allocation_reduction, maximum_time, level_type)
VALUES (10, 10, 10, 'BRONZE'),
       (10, 10, 10, 'SILVER'),
       (10, 10, 10, 'GOLD');

INSERT INTO admin (EMAIL, PASSWORD)
VALUES ('admin@parkshark.com', '$2a$12$r3fLIlWCAzvA6qgIqf.60uDPFn00QwpS6ba28LNvSXBYF0eHbVDAW'),
       ('admin2@example.com', 'adminwachtwoord2'),
       ('admin3@example.com', 'adminwachtwoord3'),
       ('admin4@example.com', 'adminwachtwoord4'),
       ('admin5@example.com', 'adminwachtwoord5'),
       ('admin6@example.com', 'adminwachtwoord6');

INSERT INTO address (STREET_NAME, STREET_NUMBER, POSTAL_CODE)
VALUES ('Hoofdstraat', '123', '12345'),
       ('Eikenlaan', '456', '67890'),
       ('Esdoornlaan', '789', '54321'),
       ('Cederlaan', '101', '98765'),
       ('Dennenstraat', '202', '23456'),
       ('Berkweg', '303', '87654');

INSERT INTO division (NAME, ORIGINAL_NAME, DIRECTOR, DIVISION_ID)
VALUES ('Verkoop', 'Verkoopafdeling', 'Jan Janssen', NULL),
       ('Marketing', 'Marketingafdeling', 'Johanna de Vries', NULL),
       ('Techniek', 'Technische Dienst', 'Pieter Pietersen', NULL),
       ('Financiën', 'Financiële Afdeling', 'Alice Bruin', NULL),
       ('HR', 'Personeelszaken', 'Charlie Groen', NULL),
       ('IT', 'Informatietechnologie', 'Eva Wit', NULL);

INSERT INTO member (EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, ADDRESS_ID, LICENSE_PLATE, LEVEL_ID, REGISTRATION_DATE)
VALUES ('gebruiker1@example.com', 'gebruikerswachtwoord1', 'Jan', 'Janssen', 1, 'ABC123', 1, '2023-01-15'),
       ('gebruiker2@example.com', 'gebruikerswachtwoord2', 'Johanna', 'de Vries', 2, 'XYZ789', 2, '2023-02-20'),
       ('gebruiker3@example.com', 'gebruikerswachtwoord3', 'Pieter', 'Pietersen', 3, 'DEF456', 1, '2023-03-10'),
       ('gebruiker4@example.com', 'gebruikerswachtwoord4', 'Alice', 'Bruin', 4, 'GHI789', 2, '2023-04-05'),
       ('gebruiker5@example.com', 'gebruikerswachtwoord5', 'Charlie', 'Groen', 5, 'JKL012', 1, '2023-05-15'),
       ('gebruiker6@example.com', 'gebruikerswachtwoord6', 'Eva', 'Wit', 6, 'MNO345', 1, '2023-06-20');

INSERT INTO contact (FIRST_NAME, LAST_NAME, MOBILE_NUMBER, PHONE_NUMBER, EMAIL, ADDRESS_ID)
VALUES ('Contactpersoon1', 'Persoon1', '123-456-7890', '987-654-3210', 'contactpersoon1@example.com', 1),
       ('Contactpersoon2', 'Persoon2', '111-222-3333', '444-555-6666', 'contactpersoon2@example.com', 2),
       ('Contactpersoon3', 'Persoon3', '555-777-8888', '999-000-1111', 'contactpersoon3@example.com', 3),
       ('Contactpersoon4', 'Persoon4', '777-999-1111', '222-333-4444', 'contactpersoon4@example.com', 4),
       ('Contactpersoon5', 'Persoon5', '888-111-2222', '333-444-5555', 'contactpersoon5@example.com', 5),
       ('Contactpersoon6', 'Persoon6', '666-444-3333', '111-000-9999', 'contactpersoon6@example.com', 6);

INSERT INTO parking_lot (NAME, CATEGORY, MAX_CAPACITY, DIVISION_ID, ADDRESS_ID, CONTACT_ID)
VALUES ('Parkeerplaats A', 0, 100, 1, 1, 1),
       ('Parkeerplaats B', 1, 50, 2, 2, 2),
       ('Parkeerplaats C', 1, 75, 3, 3, 3),
       ('Parkeerplaats D', 0, 120, 4, 4, 4),
       ('Parkeerplaats E', 1, 60, 5, 5, 5),
       ('Parkeerplaats F', 1, 90, 6, 6, 6);

INSERT INTO allocation (PARKING_LOT_ID, MEMBER_ID, LICENSE_PLATE, STATUS, START_TIME, STOP_TIME)
VALUES (1, 1, 'ABC123', 'Actief', '2023-03-01 08:00:00', NULL),
       (2, 2, 'XYZ789', 'Inactief', '2023-03-01 10:30:00', '2023-03-01 18:00:00'),
       (3, 3, 'DEF456', 'Actief', '2023-03-01 09:15:00', NULL),
       (4, 4, 'GHI789', 'Inactief', '2023-03-01 12:45:00', '2023-03-01 17:30:00'),
       (5, 5, 'JKL012', 'Actief', '2023-03-01 07:30:00', NULL),
       (6, 6, 'MNO345', 'Actief', '2023-03-01 11:00:00', NULL);