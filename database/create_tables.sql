USE "java-simple-webshop";

CREATE TABLE category 
(
    category_id SERIAL          PRIMARY KEY,
    "name"      VARCHAR(50)     NOT NULL
);

CREATE TABLE product
(
    product_id      SERIAL          PRIMARY KEY,
    "name"          VARCHAR(50)     NOT NULL,
    "image"         VARCHAR(200)    NOT NULL,
    "description"   VARCHAR(500)   NOT NULL,
    price           NUMERIC(8,2)    NOT NULL,
    category_id     INTEGER         NOT NULL,
    CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(category_id)
);

CREATE TABLE payment_method
(
    payment_method_id   SERIAL          PRIMARY KEY,
    "name"              VARCHAR(50)     NOT NULL
);

CREATE TABLE country
(
    country_id  SERIAL          PRIMARY KEY,
    "name"      VARCHAR(50)     NOT NULL
);

CREATE TABLE "address"
(
    address_id      SERIAL          PRIMARY KEY,
    street          VARCHAR(100)    NOT NULL,
    city            VARCHAR(50)     NOT NULL,
    postal_code     VARCHAR(5)      NOT NULL,
    country_id      INTEGER         NOT NULL,
    CONSTRAINT fk_address_country_id FOREIGN KEY (country_id) REFERENCES country(country_id)
);

CREATE TABLE person
(
    person_id   SERIAL          PRIMARY KEY,
    first_name  VARCHAR(50)     NOT NULL,
    last_name   VARCHAR(50)     NOT NULL,
    birth       TIMESTAMP       NOT NULL,
    address_id  INTEGER         NOT NULL,
    CONSTRAINT fk_person_address_id FOREIGN KEY (address_id) REFERENCES "address"(address_id)
);

CREATE TABLE user_type
(
    user_type_id    SERIAL          PRIMARY KEY,
    "name"          VARCHAR(50)     NOT NULL
);

CREATE TABLE "user"
(
    "user_id"       SERIAL          PRIMARY KEY,
    email           VARCHAR(100)    NOT NULL,
    "password"      VARCHAR(256)    NOT NULL,
    user_type_id    INTEGER         NOT NULL,
    CONSTRAINT fk_user_user_type_id FOREIGN KEY (user_type_id) REFERENCES "user_type"(user_type_id)
);

CREATE TABLE bill
(
    bill_id             SERIAL          PRIMARY KEY,
    "date"              TIMESTAMP       NOT NULL,
    price               NUMERIC(8,2)    NOT NULL,
    note                VARCHAR(500),
    "user_id"           INTEGER         NOT NULL,
    payment_method_id   INTEGER         NOT NULL,
    CONSTRAINT fk_bill_payment_user_id FOREIGN KEY ("user_id") REFERENCES "user"("user_id"),
    CONSTRAINT fk_bill_payment_method_id FOREIGN KEY (payment_method_id) REFERENCES payment_method(payment_method_id)
);

CREATE TABLE article
(
    article_id  SERIAL          PRIMARY KEY,
    "count"     INTEGER         NOT NULL,
    price       NUMERIC(8,2)    NOT NULL,
    bill_id     INTEGER         NOT NULL,
    CONSTRAINT fk_article_bill_id FOREIGN KEY (bill_id) REFERENCES bill(bill_id)
);

CREATE TABLE user_log
(
    user_log_id     SERIAL          PRIMARY KEY,
    ip_address      VARCHAR(15)     NOT NULL,
    "time"          TIMESTAMP       NOT NULL,
    "user_id"       INTEGER         NOT NULL,
    CONSTRAINT fk_user_log_user_id FOREIGN KEY ("user_id") REFERENCES "user"("user_id")
);