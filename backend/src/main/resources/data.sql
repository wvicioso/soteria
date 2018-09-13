INSERT IGNORE INTO School VALUES (1, '199 Chambers Street', '40.7188', '74.0115', 'BMCC');
INSERT IGNORE INTO School VALUES (2, '160 Convent Ave', '40.8200', '73.9493', 'City College');
INSERT IGNORE INTO School VALUES (3, '55 Lexington Ave', '40.7405', '73.9832', 'Baruch College');
--
--INSERT IGNORE INTO User VALUES (1, 'Zoozoo', 'Satya', 'Gupta', 'https://www.sideshowtoy.com/assets/products/400310-iron-man-mark-iii/lg/marvel-iron-man-mark-3-life-size-figure-400310-08.jpg', 's@gmail.com', 2);
--INSERT IGNORE INTO User VALUES (2, 'Wells', 'Wellington', 'Gupta', 'https://upload.wikimedia.org/wikipedia/en/5/59/Hulk_%28comics_character%29.png', 'w@gmail.com', 3);
--INSERT IGNORE INTO User VALUES (3, 'Harry', 'Haris', 'Nadeem', 'https://media.forbiddenplanet.com/products/138842.jpg', 'h@gmail.com', 2);
--INSERT IGNORE INTO User VALUES (4, 'NewDude', 'New', 'Dude', 'https://assets.catawiki.nl/assets/2017/10/10/3/8/e/38e9cfc5-ebc4-4796-81d4-fc61fe672fb6.jpg', 'nedu@gmail.com', 1);

INSERT IGNORE INTO Station VALUES ('1', '13', '13', '23rd and Lex');
INSERT IGNORE INTO Station VALUES ('2', '12', '12', 'Chambers Street');
INSERT IGNORE INTO Station VALUES ('3', '11', '11', '14th Street Union Square');
INSERT IGNORE INTO Station VALUES ('4', '10', '10', 'Jackson Heights');

INSERT IGNORE INTO Trip  VALUES ('1', '08-08-18', '2', '1');
INSERT IGNORE INTO Trip  VALUES ('2', '08-08-18', '3', '1');
INSERT IGNORE INTO Trip  VALUES ('3', '08-09-18', '4', '2');
INSERT IGNORE INTO Trip  VALUES ('4', '08-10-18', '3', '4');

--INSERT IGNORE INTO  Trip_User  VALUES ('1', '2');
--INSERT IGNORE INTO  Trip_User  VALUES ('1', '3');
--INSERT IGNORE INTO  Trip_User  VALUES ('1', '4');
--INSERT IGNORE INTO  Trip_User  VALUES ('2', '1');
--INSERT IGNORE INTO  Trip_User  VALUES ('2', '3');
--INSERT IGNORE INTO  Trip_User  VALUES ('3', '1');
--INSERT IGNORE INTO  Trip_User  VALUES ('3', '2');
--INSERT IGNORE INTO  Trip_User  VALUES ('4', '4');
--INSERT IGNORE INTO  Trip_User  VALUES ('4', '1');

INSERT INTO School_Station VALUES ('1', '2');
INSERT INTO School_Station VALUES ('3', '1');
INSERT INTO School_Station VALUES ('2', '3');
INSERT INTO School_Station VALUES ('2', '4');