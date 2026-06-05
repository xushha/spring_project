INSERT INTO roles (id, name)
VALUES
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');

INSERT INTO users (id, email, name, username, password)
VALUES
    (1, 'admin@gmail.com', 'Admin User', 'admin', '$2a$10$2s.598/VLNB SdLyyQRr6w.OVJ7Q2mE.uDk.yp/sNji51p9daaSzAq'),
    (2, 'user@gmail.com', 'Simple User', 'user', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy');

INSERT INTO users_roles (user_id, role_id)
VALUES
    (1, 1),
    (2, 2);

