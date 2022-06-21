DROP TABLE IF EXISTS Products CASCADE;
DROP TABLE IF EXISTS ProductCategories CASCADE;
DROP TABLE IF EXISTS Suppliers CASCADE;
DROP TABLE IF EXISTS Users CASCADE;
DROP TABLE IF EXISTS Carts CASCADE;



CREATE TABLE Products(
                         id          SERIAL PRIMARY KEY  NOT NULL,
                         name        VARCHAR(100)        NOT NULL,
                         price       DECIMAL             NOT NULL,
                         currency    VARCHAR(5)          NOT NULL,
                         description VARCHAR(200)        NOT NULL,
                         categoryID  INTEGER             NOT NULL,
                         supplierID  INTEGER             NOT NULL,
                         imageRoute  VARCHAR(100)        NOT NULL
);

CREATE TABLE ProductCategories(
                                  id          SERIAL PRIMARY KEY  NOT NULL,
                                  name        VARCHAR(50)         NOT NULL,
                                  department  VARCHAR(50)         NOT NULL,
                                  description VARCHAR(200)        NOT NULL
);

CREATE TABLE Suppliers(
                          id          SERIAL PRIMARY KEY  NOT NULL,
                          name        VARCHAR(50)         NOT NULL,
                          description VARCHAR(200)        NOT NULL
);

CREATE TABLE Users(
                      id          SERIAL PRIMARY KEY  NOT NULL,
                      name        VARCHAR(50)         NOT NULL,
                      email       VARCHAR(200)        NOT NULL,
                      password    VARCHAR(200)        NOT NULL
);

CREATE TABLE Carts(
                      id          INTEGER  NOT NULL,
                      date        TIMESTAMP WITHOUT TIME ZONE,
                      userID      INTEGER             ,
                      items       TEXT
);


INSERT INTO Suppliers(name, description) VALUES
('Chair Factory Co.', 'Coolest chairs on the planet.'),
('Eco Chairs Limited', 'Environment friendly chairs.'),
('Yellow Chairs Company', 'Only yellow chairs.');


INSERT INTO ProductCategories(name, department, description) VALUES
('Metal chairs', 'MetalDepartment', 'A chair made of metal. Usually can support heavy people. Easy to clean. Minimalist design.'),
('Wooden chairs', 'WoodDepartment', 'A chair made of wood. Max for 100 kg weight. Clean with caution. Modern design.'),
('Other type of chairs', 'OtherDepartment', 'A chair made of plastic or other fabric. Clean carefully. Various design.'),
('All of the available chairs', 'AllDepartment', 'All of the chairs');


INSERT INTO Products(name, price, currency, description, categoryID, supplierID, imageRoute)  VALUES
('Organic Metal 300', 302.9, 'USD', 'Stackable chair without armrests, made using natural materials and artisanal processes.', 1, 1, 'chair_1.jpeg'),
('Cosy Yellow Miix', 461.6, 'USD', 'The shearling-style fabric is the ideal way to add warmth, style and contemporary chic to your space.', 3, 3, 'chair_2.jpeg'),
('The blue zone', 299.9, 'USD', 'Upholstered in shearling-style fabric', 3, 2, 'chair_3.jpeg'),
('Yellow Metal Classic 66', 869.3, 'USD', 'The shearling-style fabric is the ideal way to add warmth, style and contemporary chic to your space.', 1, 3, 'chair_4.jpeg'),
('Straight Lines 700', 179.3, 'USD', 'Metal structure with matt black painted finish.', 1, 1, 'chair_5.jpeg'),

('The Ring', 89.8, 'USD', 'Metal, cooool hanging chair. Safety and style combined.', 1, 2, 'chair_6.jpeg'),
('Hanging Chill New', 1999.5, 'USD', 'Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.', 1, 1, 'chair_7.jpeg'),
('Black Lines 2 pieces', 3566, 'USD', 'Metal structure with matt black painted finish.', 1, 2, 'chair_8.jpeg'),
('Support my Back', 299.9, 'USD', 'The shearling-style fabric is the ideal way to add warmth, style and contemporary chic to your space.', 2, 2, 'chair_9.jpeg'),
('Floating Feeling', 4248, 'USD', 'The frame is made from solid acacia wood with natural finish, offering unique tones and grain patterns in every piece', 2, 1, 'chair_10.jpeg'),

('Number Five 55555', 479.3, 'USD', 'Cares design: with an internal wooden structure made with zero-emission adhesives to keep the planet free from pollution', 2, 1, 'chair_11.jpeg'),
('Wooden Chair is my Name', 12.8, 'USD', 'The wood sourced is from sustainably-managed forests, where felling is controlled to protect the environment.', 2, 2, 'chair_12.jpeg'),
('Curvy Dream 2022', 1999.5, 'USD', 'Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.', 2, 1, 'chair_13.jpeg'),
('Tha Oval Set', 3566, 'USD', 'The frame is made from solid acacia wood with natural finish, offering unique tones and grain patterns in every piece', 2, 2, 'chair_14.jpeg'),
('Yellow Slices Beta', 299.9, 'USD', 'Very Yellow, very sliced up design. Unique, best beta version.', 3, 3, 'chair_15.jpeg'),

('The ventilator', 4248, 'USD', 'Special plastic material, sourced from the moon. Slicer ventilator design.', 3, 3, 'chair_16.jpeg'),
('Sit with Me', 479.3, 'USD', 'Special chair for two. Made out of organic wood.', 3, 1, 'chair_17.jpeg'),
('Coffee Chair', 7022.8, 'USD', 'For coffee lovers.', 3, 2, 'chair_18.jpeg'),
('Black to Basics', 4248, 'USD', 'Stackable chair with armrests, made using natural materials and artisanal processes.', 3, 2, 'chair_19.jpeg'),
('Butterfly 888', 761.2, 'USD', 'Upholstered in shearling-style fabric', 3, 3, 'chair_20.jpeg'),

('The Desert Cactus', 854.8, 'USD', 'I guess nobody is reading these descriptions.', 3, 3, 'chair_21.jpeg'),
('Metal Bar Chair 24', 1258, 'USD', 'Im not feeling very creative today chair.', 1, 1, 'chair_22.jpeg'),
('Yellow Wooden Rocking Chair', 89.8, 'USD', 'Cares design: with an internal wooden structure made with zero-emission adhesives to keep the planet free from pollution', 2, 3, 'chair_23.jpeg');