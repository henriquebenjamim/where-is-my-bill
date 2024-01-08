CREATE TABLE Orders (
    id                  UUID                    PRIMARY KEY NOT NULL,
    customer            VARCHAR(100)                        NOT NULL,
    restaurant_table    INT                                 NOT NULL,
    serving_staff       VARCHAR(100)                        NOT NULL,
    created_at          TEXT                                NOT NULL,
    status              TEXT
);