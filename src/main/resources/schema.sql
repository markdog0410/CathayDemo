DROP TABLE IF EXISTS currencies;

CREATE TABLE currencies
(
    code        VARCHAR(10) PRIMARY KEY,
    description VARCHAR(500),
    rate        VARCHAR(500),
    rate_float  FLOAT NOT NULL,
    symbol      VARCHAR(500)
);

INSERT INTO currencies (code, description, rate, rate_float, symbol)
VALUES ('ETH', 'digital coin', '4000.0', 4000.0, '$');