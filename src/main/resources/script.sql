USE db_jdbclaba4;

INSERT INTO solar_station(country,type_station,capacity) VALUES
                                                             ('UA','multi',100),
                                                             ('UK','solar',87),
                                                             ('DE','biggest',69),
                                                             ('AUS','multi',23),
                                                             ('USA','solar',67),
                                                             ('UK','solar',33),
                                                             ('DE','biggest',12),
                                                             ('AUS','multi',99),
                                                             ('UK','solar',11),
                                                             ('KA','biggest',78);

INSERT INTO electricity_price(price,solar_station_id) VALUES
                                                             (1000, 1),
                                                             ( 39933, 2),
                                                             ( 32322, 7),
                                                             ( 9999, 3),
                                                             ( 9222, 8),
                                                             ( 1111, 9),
                                                             ( 2233, 10),
                                                             ( 1111, 6),
                                                             ( 7843, 4),
                                                             ( 9113, 5);

INSERT INTO battary_charge(type_of_charge,solar_station_id) VALUES
                                                                   ( 'USB-C', 1),
                                                                   ( 'LIGHTNING', 2),
                                                                   ( 'MICRO-USB', 2),
                                                                   ( 'LIGHTNING', 3),
                                                                   ( 'USB-C', 1),
                                                                   ( 'MICRO-USB', 3),
                                                                   ( 'LIGHTNING-Ka', 5),
                                                                   ( 'HDMI', 2),
                                                                   ( 'MICRO-USB', 4),
                                                                   ( 'LIGHTNING', 5);

INSERT INTO owner_s(name,surname) VALUES
                                         ('harry','potter'),
                                         ('charly','jeremy'),
                                         ('marsel','pillow'),
                                         ('memet','DZIGAEV'),
                                         ('witsel','axel');

INSERT INTO amount_of_station(amount,owner_s_id) VALUES
                                                     (2,3),(3,5),(1,4),(3,1),(1,2);

INSERT INTO sold_energy(amount_of_sold_energy,solar_station_id) VALUES
                                                                    (1211,10),
                                                                    (8902, 1),
                                                                    (99191,8),
                                                                    (1111,2),
                                                                    (4242,7),
                                                                    (2123,3),
                                                                    (8909,6),
                                                                    (3211,4),
                                                                    (3910,9),
                                                                    (8932,5);

INSERT INTO instalation_date(ins_date,solar_station_id) VALUES
                                                            ('2007-08-20',2),
                                                            ('2009-10-01',1),
                                                            ('2001-04-15',10),
                                                            ('2021-08-11',9),
                                                            ('1999-12-30',3),
                                                            ('2003-12-30',7),
                                                            ('2004-01-21',6),
                                                            ('2005-02-22',8),
                                                            ('2006-03-23',5),
                                                            ('2007-04-24',4);

INSERT INTO panel(amount_of_panel,solar_station_id) VALUES
                                                        (123,10),
                                                        (98, 1),
                                                        (432,8),
                                                        (233,2),
                                                        (783,7),
                                                        (142,3),
                                                        (98,6),
                                                        (89,4),
                                                        (422,9),
                                                        (152,5);

INSERT INTO panel_angels(id,tilt,panel_id) VALUES
                                               (1, 180, 1),
                                               (2, 89, 2),
                                               (3, 13, 7),
                                               (4, 78, 3),
                                               (5, 11, 8),
                                               (6, 99, 9),
                                               (7, 43, 10),
                                               (8, 56, 6),
                                               (9, 71, 4),
                                               (10, 140, 5);