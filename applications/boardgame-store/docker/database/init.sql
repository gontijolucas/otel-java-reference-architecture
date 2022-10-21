-- Catalog
CREATE SCHEMA IF NOT EXISTS catalog AUTHORIZATION bgstore;
CREATE TABLE catalog.category
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name            VARCHAR(255) NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE catalog.product(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name            VARCHAR(255) NOT NULL,
    description     TEXT NOT NULL,
    sku             VARCHAR(50) NOT NULL,
    editor          VARCHAR(255),
    player_number   INT NOT NULL,
    play_time       INT NOT NULL,
    price           NUMERIC(10,2),
    category_id     BIGINT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES catalog.category(id),
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE catalog.product_img
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    url             VARCHAR(255) NOT NULL,
    product_id      BIGINT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES catalog.product(id),
    CONSTRAINT pk_product_img PRIMARY KEY (ID)
);


-- Cart
CREATE SCHEMA IF NOT EXISTS cart AUTHORIZATION bgstore;

-- Order
CREATE SCHEMA IF NOT EXISTS orders AUTHORIZATION bgstore;

-- Authentication
CREATE SCHEMA IF NOT EXISTS authentication AUTHORIZATION bgstore;

-- Users
CREATE SCHEMA IF NOT EXISTS users AUTHORIZATION bgstore;
CREATE TABLE users.user
(
    id                   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    username             VARCHAR(255),
    password             VARCHAR(255),
    first_name           VARCHAR(255),
    middle_name          VARCHAR(255),
    last_name            VARCHAR(255),
    email                VARCHAR(255),
    mobile_phone         VARCHAR(255),
    thumbnail_id         VARCHAR(255),
    photo_id             VARCHAR(255),
    birth_date           DATE,
    need_change_password BOOLEAN,
    CONSTRAINT pk_user PRIMARY KEY (id)
);


-- Shipping
CREATE SCHEMA IF NOT EXISTS shipping AUTHORIZATION bgstore;

-- Payment
CREATE SCHEMA IF NOT EXISTS payment AUTHORIZATION bgstore;


