create table roles
(
    id   varchar(100) not null
        primary key,
    code varchar(20)
);

create table modules
(
    id   uuid not null
        primary key default uuid_generate_v4(),
    name varchar(100)
);

create table role_permission
(
    id           uuid not null
        primary key default uuid_generate_v4(),
    roles_id     uuid
        references roles,
    permission   jsonb,
    service_code varchar(20),
    module_code  uuid
        constraint modules_fk
            references modules
);


