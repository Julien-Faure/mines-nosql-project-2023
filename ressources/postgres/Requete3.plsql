// Requete 3 - Params : product_id = id du produit,
//                      $num_follows = Nombre de cercle de follower sur lesquels faire la recherche
WITH RECURSIVE product_followers_recursive(product_id, follower_id, followed_id, level) AS (
  SELECT pu.product_id, f.follower_id, f.followed_id, 0
  FROM purchases pu
  JOIN followers f ON f.follower_id = pu.user_id
  WHERE pu.product_id = 1
  UNION
  SELECT pfr.product_id, f.follower_id, f.followed_id, pfr.level + 1
  FROM followers f
  JOIN product_followers_recursive pfr ON pfr.follower_id = f.followed_id
  WHERE pfr.level < 3
)
SELECT pfr.level, COUNT(DISTINCT pu.user_id) AS num_people
FROM product_followers_recursive pfr
LEFT JOIN purchases pu ON pu.user_id = pfr.follower_id AND pu.product_id = pfr.product_id
GROUP BY pfr.level
ORDER BY pfr.level ASC;

