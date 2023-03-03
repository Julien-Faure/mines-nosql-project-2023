-- Insert sample users
INSERT INTO Users (name, email, password) VALUES
                                              ('Alice', 'alice@example.com', 'password123'),
                                              ('Bob', 'bob@example.com', 'password456'),
                                              ('Charlie', 'charlie@example.com', 'password789'),
                                              ('Dave', 'dave@example.com', 'password012');

-- Insert sample followers
INSERT INTO Followers (follower_id, followed_id) VALUES
                                                     (1, 2),
                                                     (1, 3),
                                                     (2, 1),
                                                     (3, 1),
                                                     (4, 1),
                                                     (4, 2),
                                                     (4, 3);

-- Insert sample products
INSERT INTO Products (name, description, price) VALUES
                                                    ('Product A', 'This is product A', 10.99),
                                                    ('Product B', 'This is product B', 5.99),
                                                    ('Product C', 'This is product C', 15.99);

-- Insert sample purchases
INSERT INTO Purchases (user_id, product_id, quantity, purchase_date) VALUES
                                                                         (1, 1, 2, '2022-02-01'),
                                                                         (1, 2, 1, '2022-02-02'),
                                                                         (2, 1, 1, '2022-02-03'),
                                                                         (2, 2, 3, '2022-02-04'),
                                                                         (3, 3, 1, '2022-02-05'),
                                                                         (4, 1, 2, '2022-02-06'),
                                                                         (4, 2, 1, '2022-02-07'),
                                                                         (4, 3, 4, '2022-02-08');
