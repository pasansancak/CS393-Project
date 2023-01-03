INSERT INTO cars (barcode_number, license_plate_number, passenger_capacity, brand, model, mileage, transmission_type, daily_price, type, status)
VALUES ('123456789', 'XYZ123', 4, 'Toyota', 'Camry', 10000, 'AUTOMATIC', 50.00, 'STANDARD', 'AVAILABLE');

INSERT INTO members (name, address, email, phone, driving_license_number)
VALUES ('John Smith', '123 Main St', 'john.smith@example.com', '123-456-7890', '12345678');

INSERT INTO locations (code, name, address)
VALUES (1, 'Istanbul Airport', 'Istanbul, Turkey');

INSERT INTO reservations (car_id, creation_date, pick_up_date, drop_off_date, pick_up_location_code, drop_off_location_code, return_date, status, member_id)
VALUES (1, '2022-01-01 10:00:00', '2022-01-01 12:00:00', '2022-01-03 12:00:00', 1, 1, '2022-01-03 14:00:00', 'ACTIVE', 1);

INSERT INTO equipments (name, price)
VALUES ('Snow Tyres', 50.00);

INSERT INTO services (name,price)
VALUES ('Additional Driver', 25.00);

INSERT INTO services (name, price)
VALUES ('Extra Pick-Up', 25.00);