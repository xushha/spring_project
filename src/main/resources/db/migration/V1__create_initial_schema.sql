CREATE TABLE city (
    city_id VARCHAR(255) PRIMARY KEY,
    display_name TEXT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_profile (
     user_profile_id VARCHAR(255) PRIMARY KEY,
     first_name TEXT NOT NULL,
     last_name TEXT NOT NULL,
     username TEXT NOT NULL UNIQUE,
     password TEXT NOT NULL,
     created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE flight (
     flight_id VARCHAR(255) PRIMARY KEY,
     departure_city_id VARCHAR(255) NOT NULL,
     arrival_city_id VARCHAR(255) NOT NULL,
     departure_time TIMESTAMPTZ NOT NULL,
     arrival_time TIMESTAMPTZ NOT NULL,
     flight_number TEXT NOT NULL UNIQUE,
     price TEXT NOT NULL,
     created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,

     CONSTRAINT fk_flight_departure_city
        FOREIGN KEY (departure_city_id) REFERENCES city(city_id),

     CONSTRAINT fk_flight_arrival_city
        FOREIGN KEY (arrival_city_id) REFERENCES city(city_id)
);

CREATE TABLE ticket (
    ticket_id VARCHAR(255) PRIMARY KEY,
    flight_id VARCHAR(255) NOT NULL,
    user_profile_id VARCHAR(255) NOT NULL,
    pnr TEXT NOT NULL UNIQUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_ticket_flight
       FOREIGN KEY (flight_id) REFERENCES flight(flight_id),

    CONSTRAINT fk_ticket_user_profile
       FOREIGN KEY (user_profile_id) REFERENCES user_profile(user_profile_id)
);