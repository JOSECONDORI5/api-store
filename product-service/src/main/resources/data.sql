INSERT INTO categories (name)
VALUES ('shoes');
INSERT INTO categories (name)
VALUES ('books');
INSERT INTO categories (name)
VALUES ('electronics');

INSERT INTO products (name, description, stock, price, status, create_at, category_id)
VALUES ('under armour Men ''s Micro G Assert – 7',
        'under armour Men ''Lightweight mesh upper delivers complete breathability . Durable leather overlays for stability ',
        4, 12.5, 'CREATED', '2018-09-05', 1);


INSERT INTO products (name, description, stock, price, status, create_at, category_id)
VALUES ('Spring Boot in Action',
        'under armour Men '' Craig Walls is a software developer at Pivotal and is the author of Spring in Action', 12,
        40.06, 'CREATED', '2018-09-05', 1);

INSERT INTO products (name, description, stock, price, status, create_at, category_id)
VALUES ('Spring Boot in Action',
        'under armour Men '' Craig Walls is a software developer at Pivotal and is the author of Spring in Action', 12,
        40.06, 'CREATED', '2018-09-05', 2);