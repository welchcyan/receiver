DROP TABLE IF EXISTS transaction;
CREATE TABLE transaction
(
  id            BIGINT(20),
  user_id       VARCHAR(20),
  val           BIGINT(20)
);