DROP TABLE IF EXISTS user_billing CASCADE;

CREATE TABLE user_billing
(
    user_id      INTEGER,
    first_name   VARCHAR(100),
    last_name    VARCHAR(100),
    country      VARCHAR(100),
    city         VARCHAR(100),
    street       VARCHAR(200),
    house_number INTEGER,
    zip_code     INTEGER

);

ALTER TABLE ONLY user_billing
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id);
