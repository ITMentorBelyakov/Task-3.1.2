INSERT INTO user_schema.roles (name)
VALUES ('ROLE_USER')
ON CONFLICT (name) DO NOTHING;

INSERT INTO user_schema.roles (name)
VALUES ('ROLE_ADMIN')
ON CONFLICT (name) DO NOTHING;

INSERT INTO user_schema.users (username, password, first_name, second_name, email, age)
VALUES ('admin',  '$2a$10$f71U.zSl3RM4o0fiDL.CousQ.xO2CJL.RcUufK2NBn7z46y9UNU1i', 'Admin', 'User', 'admin@example.com', 30)
ON CONFLICT (username) DO NOTHING;

INSERT INTO user_schema.user_roles (user_id, role_id)
SELECT u.id, r.id
FROM user_schema.users u, user_schema.roles r
WHERE u.username = 'admin' AND r.name = 'ROLE_ADMIN'
ON CONFLICT (user_id, role_id) DO NOTHING;

INSERT INTO user_schema.user_roles (user_id, role_id)
SELECT u.id, r.id
FROM user_schema.users u, user_schema.roles r
WHERE u.username = 'admin' AND r.name = 'ROLE_USER'
ON CONFLICT (user_id, role_id) DO NOTHING;

INSERT INTO user_schema.users (username, password, first_name, second_name, email, age)
VALUES ('user',  '$2a$10$f71U.zSl3RM4o0fiDL.CousQ.xO2CJL.RcUufK2NBn7z46y9UNU1i', 'Regular', 'User', 'user@example.com', 25)
ON CONFLICT (username) DO NOTHING;

INSERT INTO user_schema.user_roles (user_id, role_id)
SELECT u.id, r.id
FROM user_schema.users u, user_schema.roles r
WHERE u.username = 'user' AND r.name = 'ROLE_USER'
ON CONFLICT (user_id, role_id) DO NOTHING;