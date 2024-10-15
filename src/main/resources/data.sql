-- Добавление ролей
INSERT INTO user_schema.roles (name)
VALUES ('ROLE_USER')
ON CONFLICT (name) DO NOTHING;

INSERT INTO user_schema.roles (name)
VALUES ('ROLE_ADMIN')
ON CONFLICT (name) DO NOTHING;

-- Добавление пользователя admin с незашифрованным паролем
INSERT INTO user_schema.users (username, password, first_name, second_name, email, age)
VALUES ('admin', 'password', 'Admin', 'User', 'admin@example.com', 30)
ON CONFLICT (username) DO NOTHING;

-- Связывание пользователя admin с ролями
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

-- Добавление пользователя user с незашифрованным паролем
INSERT INTO user_schema.users (username, password, first_name, second_name, email, age)
VALUES ('user', 'password', 'Regular', 'User', 'user@example.com', 25)
ON CONFLICT (username) DO NOTHING;

-- Связывание пользователя user с ролью USER
INSERT INTO user_schema.user_roles (user_id, role_id)
SELECT u.id, r.id
FROM user_schema.users u, user_schema.roles r
WHERE u.username = 'user' AND r.name = 'ROLE_USER'
ON CONFLICT (user_id, role_id) DO NOTHING;