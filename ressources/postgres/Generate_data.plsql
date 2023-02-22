DECLARE
    num_users INTEGER := 10000;
    num_products INTEGER := 1000;
    num_followers INTEGER := 20;
    num_purchases INTEGER := 5;
BEGIN
    INSERT INTO Users(user_id, name, email, password)
    SELECT u.user_id, 'User' || u.user_id, 'user' || u.user_id || '@example.com', 'password'
    FROM generate_series(1, num_users) AS u(user_id)
    ON CONFLICT (user_id) DO NOTHING;

    INSERT INTO Products(product_id, name, description, price)
    SELECT p.product_id, 'product' || p.product_id, 'This is product' || p.product_id, CAST((random() * 99.99 + 1) AS numeric(10,2))
    FROM generate_series(1, num_products) AS p(product_id)
    ON CONFLICT (product_id) DO NOTHING;

    INSERT INTO Followers(follower_id, followed_id)
    SELECT DISTINCT u1.user_id, u2.user_id
    FROM Users u1
    CROSS JOIN LATERAL (SELECT u2.user_id FROM Users u2 WHERE u2.user_id <> u1.user_id ORDER BY random() LIMIT num_followers) AS u2
    ON CONFLICT (follower_id, followed_id) DO NOTHING;

    INSERT INTO Purchases(user_id, product_id, quantity, purchase_date)
    SELECT u.user_id, p.product_id, floor(random() * 5 + 1), NOW() - (random() * 365 || ' days')::INTERVAL
    FROM Users u
    JOIN LATERAL (SELECT product_id FROM Products ORDER BY random() LIMIT num_purchases) AS p(product_id) ON true
    ON CONFLICT DO NOTHING;
END;
