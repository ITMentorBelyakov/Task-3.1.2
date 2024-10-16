CREATE SCHEMA IF NOT EXISTS user_schema;

CREATE TABLE IF NOT EXISTS user_schema.roles (
                                                 id SERIAL PRIMARY KEY,
                                                 name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS user_schema.users (
                                                 id SERIAL PRIMARY KEY,
                                                 username VARCHAR(50) UNIQUE NOT NULL,
                                                 password VARCHAR(100) NOT NULL,
                                                 first_name VARCHAR(50),
                                                 second_name VARCHAR(50),
                                                 email VARCHAR(100),
                                                 age INT
);

CREATE TABLE IF NOT EXISTS user_schema.user_roles (
                                                      user_id INT REFERENCES user_schema.users(id),
                                                      role_id INT REFERENCES user_schema.roles(id),
                                                      PRIMARY KEY (user_id, role_id)
);