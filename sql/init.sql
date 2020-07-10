INSERT INTO "user"
    ( user_id, username, password, email, phone_number,
    cat_user_status, status, tx_id, tx_username, tx_host,
    tx_date)
VALUES
    (  nextval('user_user_id_seq') , 'mgomez', '12345678', 'mgomez@gmail.com', '70655567',
        'ACTIVE', 1, 1, 'root', '127.0.0.1',
        now()
    );


INSERT INTO "user"
( user_id, username, password, email, phone_number,
  cat_user_status, status, tx_id, tx_username, tx_host,
  tx_date)
VALUES
(  nextval('user_user_id_seq') , 'jperez', '6b9ffd71631dd64e1231ef41e138cd29b933c687073c1f72a66571998d9bd2a3', 'jperez@gmail.com', '70655570',
   'ACTIVE', 1, 1, 'root', '127.0.0.1',
   now()
);

INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('PAGE_USER_MANAGEMENT', 'Gestión de usuarios', 1, 1, 'admin', 'localhost', now());

INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('PAGE_PRODUCT_MANAGEMENT', 'Gestión de productos', 1, 1, 'admin', 'localhost', now());

INSERT INTO feature (feature_code, feature_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('BUTTON_DELETE_USER', 'Botón para eliminar un usuario', 1, 1, 'admin', 'localhost', now());

INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('ADMIN', 1,  1, 'admin', 'localhost', now());

INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('WAREHOUSE_SUPERVISOR', 1,  1, 'admin', 'localhost', now());

INSERT INTO role ( role_name, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('WAREHOUSE_EMPLOYEE', 1,  1, 'admin', 'localhost', now());

-- ADMIN role
INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1, 1, 1,  1, 'admin', 'localhost', now());

INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1, 3, 1,  1, 'admin', 'localhost', now());

-- WAREHOUSE_SUPERVISOR
INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 1, 1,  1, 'admin', 'localhost', now());

INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 2, 1,  1, 'admin', 'localhost', now());

-- WAREHOUSE_EMPLOYY
INSERT INTO role_feature ( role_id, feature_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (3, 2, 1,  1, 'admin', 'localhost', now());

-- CONFIGURACIÍN DE USUARIOS

INSERT INTO user_role ( user_id, role_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 2, 1,  1, 'admin', 'localhost', now());

INSERT INTO user_role ( user_id, role_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (2, 1, 1,  1, 'admin', 'localhost', now());



-- INSERT DE PROVIDER

INSERT INTO provider (provider_name, cat_country, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('Proveedor 1','Chile',1, 1, 'admin', 'localhost', now());

-- INSERT DE WAREHOUSE

INSERT INTO warehouse (warehouse_name, warehouse_address, latitude, longitude, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('Almacen 1','Obrajes calle 10',-16.526716, -68.106790,1, 1, 'admin', 'localhost', now());

-- INSERT DE PERSONA/CLIENTE

INSERT INTO person(first_name, first_surname, document_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('Miguel','Vilca','5972726 L.P.',1,1, 'admin', 'localhost', now());
INSERT INTO customer(user_id, person_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1,1,1,1, 'admin', 'localhost', now());

INSERT INTO person(first_name, first_surname, document_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('Andres','Morales','7865329 L.P.',1,1, 'admin', 'localhost', now());
INSERT INTO "user"(username, password, email, phone_number, cat_user_status, status, tx_id, tx_username, tx_host, tx_date)
VALUES  ('amorales', '12300', 'amorales@gmail.com', '12459385','ACTIVE', 1, 1, 'root', '127.0.0.1',now());
INSERT INTO customer(user_id, person_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (3,2,1,1, 'admin', 'localhost', now());

INSERT INTO person(first_name, first_surname, document_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES ('Vania','Vera','1298635 L.P.',1,1, 'admin', 'localhost', now());
INSERT INTO "user"(username, password, email, phone_number, cat_user_status, status, tx_id, tx_username, tx_host, tx_date)
VALUES  ('vvera', '1999', 'vvera@gmail.com', '78754896','ACTIVE', 1, 1, 'root', '127.0.0.1',now());
INSERT INTO customer(user_id, person_id, status, tx_id, tx_username, tx_host, tx_date)
VALUES (4,3,1,1, 'admin', 'localhost', now());

------------------- INSERT DE ORDENES

-- users: 1= mvilca, 2=jperez, 3=amorales, 4=vvera

-- status: 0=eliminado,1=pagado,2=preparado,3=despachado,4=entregado

-- pagadas
INSERT INTO "order"(provider_id, warehouse_id, user_id, date, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1,1,1,'2020-05-10',1,1, 'admin', 'localhost', now());

INSERT INTO "order"(provider_id, warehouse_id, user_id, date, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1,1,2,'2020-05-11',1,1, 'admin', 'localhost', now());

INSERT INTO "order"(provider_id, warehouse_id, user_id, date, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1,1,3,'2020-05-01',1,1, 'admin', 'localhost', now());

-- preparadas
INSERT INTO "order"(provider_id, warehouse_id, user_id, date, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1,1,1,'2020-05-10',2,1, 'admin', 'localhost', now());

INSERT INTO "order"(provider_id, warehouse_id, user_id, date, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1,1,3,'2020-04-15',2,1, 'admin', 'localhost', now());

INSERT INTO "order"(provider_id, warehouse_id, user_id, date, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1,1,4,'2020-04-09',2,1, 'admin', 'localhost', now());

-- despachadas
INSERT INTO "order"(provider_id, warehouse_id, user_id, date, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1,1,1,'2020-05-10',3,1, 'admin', 'localhost', now());

INSERT INTO "order"(provider_id, warehouse_id, user_id, date, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1,1,4,'2020-04-05',3,1, 'admin', 'localhost', now());
-- entregadas
INSERT INTO "order"(provider_id, warehouse_id, user_id, date, status, tx_id, tx_username, tx_host, tx_date)
VALUES (1,1,1,'2020-05-10',4,1, 'admin', 'localhost', now());



SELECT o.order_id, DATE(o.date), CONCAT(p.first_name,' ',p.first_surname) as customer, o.date_courier_rec, o.date_cust_rec
FROM "order" as o, "user" as u, customer as  c, person as p
WHERE o.user_id = u.user_id
  AND u.user_id = c.user_id
  AND c.person_id = p.person_id
  AND o.status = 4;



SELECT o.order_id, o.date, p.first_name, p.first_surname, o.date_courier_rec, o.date_cust_rec
FROM "order" as o, "user" as u, customer as  c, person as p
WHERE o.user_id = u.user_id
                AND u.user_id = c.user_id
                AND c.person_id = p.person_id
                AND o.status = 4;


SELECT * FROM "order";