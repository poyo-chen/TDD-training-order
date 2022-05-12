DROP TABLE IF EXISTS Commodities;

CREATE TABLE Commodities(

    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(48),
    description VARCHAR(48),
    qty INT,
    price INT,
    PRIMARY KEY (id)
);

INSERT INTO commodities(`name`, `description`, `qty`, `price`) VALUES ('椅子', '椅子', 1, 100);
INSERT INTO commodities(`name`, `description`, `qty`, `price`) VALUES ('桌子', '桌子', 2, 50);

-- *********
DROP TABLE IF EXISTS Orders;

CREATE TABLE Orders(

    id BIGINT NOT NULL AUTO_INCREMENT,
    amount INT,
    status VARCHAR(10),

    PRIMARY KEY (id)
);



