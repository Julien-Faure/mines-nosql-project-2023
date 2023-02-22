CREATE SEQUENCE users_user_id_seq START WITH 1;
CREATE SEQUENCE products_product_id_seq START WITH 1;
CREATE SEQUENCE purchases_purchase_id_seq START WITH 1;

CREATE TABLE Users
(
    user_id  INTEGER PRIMARY KEY DEFAULT nextval('users_user_id_seq'),
    name     VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255)
);

CREATE INDEX user_id_idx ON Users (user_id);

CREATE TABLE Followers
(
    follower_id INTEGER,
    followed_id INTEGER,
    UNIQUE (follower_id, followed_id),
    FOREIGN KEY (follower_id) REFERENCES Users (user_id),
    FOREIGN KEY (followed_id) REFERENCES Users (user_id)
);

CREATE TABLE Products
(
    product_id  INTEGER PRIMARY KEY DEFAULT nextval('products_product_id_seq'),
    name        VARCHAR(255),
    description TEXT,
    price       NUMERIC(10, 2)
);

CREATE TABLE Purchases
(
    purchase_id   INTEGER PRIMARY KEY DEFAULT nextval('purchases_purchase_id_seq'),
    user_id       INTEGER,
    product_id    INTEGER,
    quantity      INTEGER,
    purchase_date DATE,
    FOREIGN KEY (user_id) REFERENCES Users (user_id),
    FOREIGN KEY (product_id) REFERENCES Products (product_id)
);
