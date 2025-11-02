INSERT INTO roles (code)
VALUES ('ADMIN'),
       ('USER'),
       ('MODERATOR'),
       ('GUEST'),
       ('STREAMER');


INSERT INTO modules (name)
VALUES ('Authentication Module'),
       ('Streaming Module'),
       ('Chat Moderation Module'),
       ('User Profile Module'),
       ('Payment & Subscription Module');

INSERT INTO role_permission (roles_id, permission, service_code, module_code)
SELECT

    (
        SELECT r.id
        FROM roles r
        ORDER BY random()
        LIMIT 1
    ),
    jsonb_build_object(
        'create', (random() > 0.5),
        'read',   true,
        'update', (random() > 0.5),
        'delete', (random() > 0.5)
    ) AS permission,
    'LIVE' AS service_code,
    (
        SELECT m.id
        FROM modules m
        ORDER BY random()
        LIMIT 1
    ) AS module_code
FROM roles r;