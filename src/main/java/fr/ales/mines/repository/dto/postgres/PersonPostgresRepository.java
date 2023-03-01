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
}
