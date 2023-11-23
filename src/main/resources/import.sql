-- CREATE TABLE charity_donation;

USE charity_donation;

INSERT INTO charity_donation.users (id, active, email, password, role) VALUES (1, true, 'admin@admin.pl', '{bcrypt}$2a$10$SLAaXDkeBfdthpaaDpH8xeu2DVTXAmCNHDQo0JMhpAOYJKPsOVuV2', 'ROLE_ADMIN');
INSERT INTO charity_donation.users (id, active, email, password, role) VALUES (2, true, 'user@user.pl', '{bcrypt}$2a$10$HkwP7cLBqRn4NbloyNiUi.Z7fbb3Nb1WFevthdyG5lv51l2n/YxD.', 'ROLE_USER');

INSERT INTO charity_donation.institution (id, description, name) VALUES (1, 'Cel i misja: Pomoc dzieciom z ubogich rodzin.', 'Fundacja "Dbam o Zdrowie"');
INSERT INTO charity_donation.institution (id, description, name) VALUES (2, 'Cel i misja: Pomoc wybudzaniu dzieci ze śpiączki.', 'Fundacja "A kogo"');
INSERT INTO charity_donation.institution (id, description, name) VALUES (3, 'Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej.', 'Fundacja “Dla dzieci"');
INSERT INTO charity_donation.institution (id, description, name) VALUES (4, 'Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania', 'Fundacja “Bez domu”');

INSERT INTO charity_donation.category (id, name) VALUES (1, 'RTV');
INSERT INTO charity_donation.category (id, name) VALUES (2, 'Ubrania');
INSERT INTO charity_donation.category (id, name) VALUES (3, 'Inne');

INSERT INTO charity_donation.donation (id, city, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id) VALUES (1, 'B-B', 'ASAP', '2023-11-09', '22:20:13', 1, 'KJ1', '43-300', 1);
INSERT INTO charity_donation.donation (id, city, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id) VALUES (2, 'B-B', 'ASAP', '2023-11-10', '22:20:13', 3, 'KJ2', '43-300', 2);

INSERT INTO charity_donation.donation_category (donation_id, category_id) VALUES (1, 1);
INSERT INTO charity_donation.donation_category (donation_id, category_id) VALUES (1, 2);
INSERT INTO charity_donation.donation_category (donation_id, category_id) VALUES (2, 1);
INSERT INTO charity_donation.donation_category (donation_id, category_id) VALUES (2, 2);
