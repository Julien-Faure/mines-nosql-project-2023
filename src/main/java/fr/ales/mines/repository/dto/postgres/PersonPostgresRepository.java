package fr.ales.mines.repository.dto.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonPostgresRepository extends JpaRepository<PersonPostgresDto, Integer> {
    @Query(value = """
WITH RECURSIVE circle(follower_id, depth) AS (
  SELECT Followers.followed_id, 1
  FROM Users
  JOIN Followers ON Users.user_id = Followers.follower_id
  WHERE Users.name = :username
  UNION ALL
  SELECT Followers.followed_id, circle.depth + 1
  FROM circle
  JOIN Followers ON circle.follower_id = Followers.follower_id
  WHERE circle.depth < :num_follows
)
SELECT Products.name AS product, SUM(Purchases.quantity) AS total_quantity, COUNT(Purchases.*) AS num_purchases
FROM circle
JOIN Purchases ON circle.follower_id = Purchases.user_id
JOIN Products ON Purchases.product_id = Products.product_id
GROUP BY Products.product_id, Products.name
ORDER BY total_quantity DESC
""", nativeQuery = true)
    String[][] executeRequest11(@Param("username") String username, @Param("num_follows") int depth);

    @Query(value = """
WITH RECURSIVE circle(follower_id, depth) AS (
  SELECT Followed.followed_id, 1
  FROM Users
  JOIN Followers Followed ON Users.user_id = Followed.follower_id
  WHERE Users.name = :username
  UNION ALL
  SELECT Followed.followed_id, circle.depth + 1
  FROM circle
  JOIN Followers Followed ON circle.follower_id = Followed.follower_id
  WHERE circle.depth < :num_follows
)
SELECT COUNT(DISTINCT Products.product_id) AS num_products, SUM(Purchases.quantity) AS total_quantity, COUNT(*) AS num_purchases
FROM circle
JOIN Purchases ON circle.follower_id = Purchases.user_id
JOIN Products ON Purchases.product_id = Products.product_id;
""", nativeQuery = true)
    String[][] executeRequest12(@Param("username") String username, @Param("num_follows") int depth);


    @Query(value = """
WITH RECURSIVE circle(follower_id, depth) AS (
  SELECT Followers.followed_id, 1
  FROM Users
  JOIN Followers ON Users.user_id = Followers.follower_id
  WHERE Users.name = :username
  UNION ALL
  SELECT Followers.followed_id, circle.depth + 1
  FROM circle
  JOIN Followers ON circle.follower_id = Followers.follower_id
  WHERE circle.depth < :num_follows
)
SELECT SUM(Purchases.quantity) AS total_quantity, COUNT(*) AS num_purchases
FROM circle
JOIN Purchases ON circle.follower_id = Purchases.user_id
JOIN Products ON Purchases.product_id = Products.product_id
WHERE Products.name = :product_name
""", nativeQuery = true)
    String[][] executeRequest2(@Param("username") String username,
                               @Param("num_follows") int depth,
                               @Param("product_name") String productName);

    @Query(value = """
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
""", nativeQuery = true)
    String[][] executeRequest3();
}
