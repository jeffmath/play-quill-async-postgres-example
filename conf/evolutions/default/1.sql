# Users schema

# --- !Ups
CREATE TABLE "Users" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    "isActive" BOOLEAN NOT NULL
);

# --- !Downs
DROP TABLE "Users";