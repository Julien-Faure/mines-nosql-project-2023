-- Requete 2 - Params : $username = nom de l'utilisateur,
--                      $num_follows = Nombre de cercle de follower sur lesquels faire la recherche
--                      $product_name = Nom du produit
WITH RECURSIVE circle(follower_id, depth) AS (
  SELECT Followers.followed_id, 1
  FROM Users
  JOIN Followers ON Users.user_id = Followers.follower_id
  WHERE Users.name = $username
  UNION ALL
  SELECT Followers.followed_id, circle.depth + 1
  FROM circle
  JOIN Followers ON circle.follower_id = Followers.follower_id
  WHERE circle.depth < $num_follows
)
SELECT SUM(Purchases.quantity) AS total_quantity, COUNT(*) AS num_purchases
FROM circle
JOIN Purchases ON circle.follower_id = Purchases.user_id
JOIN Products ON Purchases.product_id = Products.product_id
WHERE Products.name = $product_name;
