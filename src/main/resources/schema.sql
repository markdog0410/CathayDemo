DROP TABLE IF EXISTS currencies;

CREATE TABLE currencies
(
    code        VARCHAR(10) PRIMARY KEY,
    description VARCHAR(500),
    rate        VARCHAR(500),
    rate_float  DOUBLE,
    symbol      VARCHAR(500),
    update_time DATETIME DEFAULT current_timestamp
);

INSERT INTO currencies (code, description, rate, rate_float, symbol)
VALUES ('ETH', 'digital coin', '4000.0', 4000.0, '$');