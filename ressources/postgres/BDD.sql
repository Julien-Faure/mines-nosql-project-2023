CREATE TABLE Users
(
    user_id  INTEGER PRIMARY KEY,
    name     VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255)
);
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
    product_id  INTEGER PRIMARY KEY,
    name        VARCHAR(255),
    description TEXT,
    price       NUMERIC(10, 2)
);
CREATE TABLE Purchases
(
    purchase_id   INTEGER PRIMARY KEY,
    user_id       INTEGER,
    product_id    INTEGER,
    quantity      INTEGER,
    purchase_date DATE,
    FOREIGN KEY (user_id) REFERENCES Users (user_id),
    FOREIGN KEY (product_id) REFERENCES Products (product_id)
);
