use villaindb;

/* ======================================   유저 더미 데이터 ====================================== */
INSERT INTO user (user_id, user_role, name, email, phone,hos_id,pwd,user_state,created_date,last_modified_date) VALUES
                                                              ('admin01','ROLE_ADMIN','관리자01','admin01@gmail.com','070-1111-1111',null,'$2a$10$hRzf2HYBzRKiWK1A3XVglOOko6tF3hoJy9Eob9YLf','activated','2019-02-12','2024-09-11'), /*qwer1234!*/
                                                              ('admin02','ROLE_ADMIN','관리자02','admin02@gmail.com','070-2222-2222',null,'$2a$10$hRzf2HYBzRKiWK1A3XVglOOko6tF3hoJy9Eob9YLf','activated','2019-04-12','2024-09-11'),
                                                              ('admin03','ROLE_ADMIN','관리자03','admin03@gmail.com','070-3333-3333',null,'$2a$10$hRzf2HYBzRKiWK1A3XVglOOko6tF3hoJy9Eob9YLf','activated','2019-08-12','2024-09-11'),
                                                              ('hospital01','ROLE_HOSPITAL','병원관리자01','hospital01@gmail','02-1111-1111',1,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-01-12','2024-09-11'),/* 1q2w3e4r! */
                                                              ('hospital02','ROLE_HOSPITAL','병원관리자02','hospital02@gmail','02-1111-2222',2,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-02-12','2024-09-11'),
                                                              ('hospital03','ROLE_HOSPITAL','병원관리자03','hospital03@gmail','02-1111-3333',3,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-03-12','2024-09-11'),
                                                              ('hospital04','ROLE_HOSPITAL','병원관리자04','hospital04@gmail','02-1111-4444',4,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-04-12','2024-09-11'),
                                                              ('hospital05','ROLE_HOSPITAL','병원관리자05','hospital05@gmail','02-1111-5555',5,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-05-12','2024-09-11'),
                                                              ('hospital06','ROLE_HOSPITAL','병원관리자06','hospital06@gmail','02-1111-6666',6,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-05-12','2024-09-11'),
                                                              ('hospital07','ROLE_HOSPITAL','병원관리자07','hospital07@gmail','02-1111-7777',7,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-05-12','2024-09-11'),
                                                              ('hospital08','ROLE_HOSPITAL','병원관리자08','hospital08@gmail','02-1111-8888',8,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-05-12','2024-09-11'),
                                                              ('hospital09','ROLE_HOSPITAL','병원관리자09','hospital09@gmail','02-1111-9999',9,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-06-12','2024-09-11'),
                                                              ('hospital10','ROLE_HOSPITAL','병원관리자10','hospital09@gmail','02-2222-0000',10,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-06-12','2024-09-11'),
                                                              ('hospital11','ROLE_HOSPITAL','병원관리자11','hospital11@gmail','02-2222-1111',11,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-06-12','2024-09-11'),
                                                              ('hospital12','ROLE_HOSPITAL','병원관리자12','hospital12@gmail','02-2222-2222',12,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-06-12','2024-09-11'),
                                                              ('hospital13','ROLE_HOSPITAL','병원관리자13','hospital13@gmail','02-2222-3333',13,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-07-12','2024-09-11'),
                                                              ('hospital14','ROLE_HOSPITAL','병원관리자14','hospital14@gmail','02-2222-4444',14,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-07-12','2024-09-11'),
                                                              ('hospital15','ROLE_HOSPITAL','병원관리자15','hospital15@gmail','02-2222-5555',15,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-07-12','2024-09-11'),
                                                              ('hospital16','ROLE_HOSPITAL','병원관리자16','hospital16@gmail','02-2222-6666',16,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-08-12','2024-09-11'),
                                                              ('hospital17','ROLE_HOSPITAL','병원관리자17','hospital17@gmail','02-2222-7777',17,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-08-12','2024-09-11'),
                                                              ('hospital18','ROLE_HOSPITAL','병원관리자18','hospital18@gmail','02-2222-8888',18,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-08-12','2024-09-11'),
                                                              ('hospital19','ROLE_HOSPITAL','병원관리자19','hospital19@gmail','02-2222-9999',19,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-09-12','2024-09-11'),
                                                              ('hospital20','ROLE_HOSPITAL','병원관리자20','hospital20@gmail','02-3333-0000',20,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-07-12','2024-09-11'),
                                                              ('hospital21','ROLE_HOSPITAL','병원관리자21','hospital21@gmail','02-3333-1111',21,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2020-09-12','2024-09-11'),
                                                              ('hospital22','ROLE_HOSPITAL','병원관리자22','hospital22@gmail','02-3333-2222',22,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2021-09-12','2024-09-11'),
                                                              ('hospital23','ROLE_HOSPITAL','병원관리자23','hospital23@gmail','02-3333-3333',23,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2021-10-12','2024-09-11'),
                                                              ('hospital24','ROLE_HOSPITAL','병원관리자24','hospital24@gmail','02-3333-4444',24,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2021-10-12','2024-09-11'),
                                                              ('hospital25','ROLE_HOSPITAL','병원관리자25','hospital25@gmail','02-3333-5555',25,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2021-10-12','2024-09-11'),
                                                              ('hospital26','ROLE_HOSPITAL','병원관리자26','hospital26@gmail','02-3333-6666',26,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2021-11-12','2024-09-11'),
                                                              ('hospital27','ROLE_HOSPITAL','병원관리자27','hospital27@gmail','02-3333-7777',27,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2021-11-12','2024-09-11'),
                                                              ('hospital28','ROLE_HOSPITAL','병원관리자28','hospital28@gmail','02-3333-8888',28,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2021-11-12','2024-09-11'),
                                                              ('hospital29','ROLE_HOSPITAL','병원관리자29','hospital29@gmail','02-3333-9999',29,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2021-12-12','2024-09-11'),
                                                              ('hospital30','ROLE_HOSPITAL','병원관리자30','hospital30@gmail','02-4444-0000',30,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2021-12-12','2024-09-11'),
                                                              ('hospital31','ROLE_HOSPITAL','병원관리자31','hospital31@gmail','02-4444-1111',31,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-11-12','2024-09-11'),
                                                              ('hospital32','ROLE_HOSPITAL','병원관리자32','hospital32@gmail','02-4444-2222',32,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-10-12','2024-09-11'),
                                                              ('hospital33','ROLE_HOSPITAL','병원관리자33','hospital33@gmail','02-4444-3333',33,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-10-12','2024-09-11'),
                                                              ('hospital34','ROLE_HOSPITAL','병원관리자34','hospital34@gmail','02-4444-4444',34,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-11-12','2024-09-11'),
                                                              ('hospital35','ROLE_HOSPITAL','병원관리자35','hospital35@gmail','02-4444-5555',35,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-07-12','2024-09-11'),
                                                              ('hospital36','ROLE_HOSPITAL','병원관리자36','hospital36@gmail','02-4444-6666',36,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-08-12','2024-09-11'),
                                                              ('hospital37','ROLE_HOSPITAL','병원관리자37','hospital37@gmail','02-4444-7777',37,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-07-12','2024-09-11'),
                                                              ('hospital38','ROLE_HOSPITAL','병원관리자38','hospital38@gmail','02-4444-8888',38,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-09-12','2024-09-11'),
                                                              ('hospital39','ROLE_HOSPITAL','병원관리자39','hospital39@gmail','02-4444-9999',39,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-10-12','2024-09-11'),
                                                              ('hospital40','ROLE_HOSPITAL','병원관리자40','hospital40@gmail','02-5555-0000',40,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-11-12','2024-09-11'),
                                                              ('hospital41','ROLE_HOSPITAL','병원관리자41','hospital41@gmail','02-5555-1111',41,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-11-12','2024-09-11'),
                                                              ('hospital42','ROLE_HOSPITAL','병원관리자42','hospital42@gmail','02-5555-2222',42,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-10-12','2024-09-11'),
                                                              ('hospital43','ROLE_HOSPITAL','병원관리자43','hospital43@gmail','02-5555-3333',43,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-07-12','2024-09-11'),
                                                              ('hospital44','ROLE_HOSPITAL','병원관리자44','hospital44@gmail','02-5555-4444',44,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-08-12','2024-09-11'),
                                                              ('hospital45','ROLE_HOSPITAL','병원관리자45','hospital45@gmail','02-5555-5555',45,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-09-12','2024-09-11'),
                                                              ('hospital46','ROLE_HOSPITAL','병원관리자46','hospital46@gmail','02-5555-6666',46,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-09-12','2024-09-11'),
                                                              ('hospital47','ROLE_HOSPITAL','병원관리자47','hospital47@gmail','02-5555-7777',47,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-10-12','2024-09-11'),
                                                              ('hospital48','ROLE_HOSPITAL','병원관리자48','hospital48@gmail','02-5555-8888',48,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-11-12','2024-09-11'),
                                                              ('hospital49','ROLE_HOSPITAL','병원관리자49','hospital49@gmail','02-5555-9999',49,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-11-12','2024-09-11'),
                                                              ('hospital50','ROLE_HOSPITAL','병원관리자50','hospital50@gmail','02-6666-0000',50,'$2a$10$QXuk3EDI8V2nYq5rDhMzDu0lWrPd37k/AP.DYxYUjuIutsGQlnKie','activated','2022-12-12','2024-09-11'),
                                                              ('user01','ROLE_USER','사용자01','user01@gmail.com','010-0000-1111',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-01','2024-09-11'), /* user1234! */
                                                              ('user02','ROLE_USER','사용자02','user02@gmail.com','010-0000-2222',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-02','2024-09-11'),
                                                              ('user03','ROLE_USER','사용자03','user03@gmail.com','010-0000-3333',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-02','2024-09-11'),
                                                              ('user04','ROLE_USER','사용자04','user04@gmail.com','010-0000-4444',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-02','2024-09-11'),
                                                              ('user05','ROLE_USER','사용자05','user05@gmail.com','010-0000-5555',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-02','2024-09-11'),
                                                              ('user06','ROLE_USER','사용자06','user06@gmail.com','010-0000-6666',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-03','2024-09-11'),
                                                              ('user07','ROLE_USER','사용자07','user07@gmail.com','010-0000-7777',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-03','2024-09-11'),
                                                              ('user08','ROLE_USER','사용자08','user08@gmail.com','010-0000-8888',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-03','2024-09-11'),
                                                              ('user09','ROLE_USER','사용자09','user09@gmail.com','010-0000-9999',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-03','2024-09-11'),
                                                              ('user10','ROLE_USER','사용자10','user10@gmail.com','010-0010-0000',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-04','2024-09-11'),
                                                              ('user11','ROLE_USER','사용자11','user11@gmail.com','010-1111-1111',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-04','2024-09-11'),
                                                              ('user12','ROLE_USER','사용자12','user12@gmail.com','010-1111-2222',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-04','2024-09-11'),
                                                              ('user13','ROLE_USER','사용자13','user13@gmail.com','010-1111-3333',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-04','2024-09-11'),
                                                              ('user14','ROLE_USER','사용자14','user14@gmail.com','010-1111-4444',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user15','ROLE_USER','사용자15','user15@gmail.com','010-1111-5555',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user16','ROLE_USER','사용자16','user16@gmail.com','010-1111-6666',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user17','ROLE_USER','사용자17','user17@gmail.com','010-1111-7777',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user18','ROLE_USER','사용자18','user18@gmail.com','010-1111-8888',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user19','ROLE_USER','사용자19','user19@gmail.com','010-1111-9999',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user20','ROLE_USER','사용자20','user20@gmail.com','010-2222-0000',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user21','ROLE_USER','사용자21','user21@gmail.com','010-3333-1111',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user22','ROLE_USER','사용자22','user22@gmail.com','010-3333-2222',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user23','ROLE_USER','사용자23','user23@gmail.com','010-3333-3333',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user24','ROLE_USER','사용자24','user24@gmail.com','010-3333-4444',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user25','ROLE_USER','사용자25','user25@gmail.com','010-3333-5555',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user26','ROLE_USER','사용자26','user26@gmail.com','010-3333-6666',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user27','ROLE_USER','사용자27','user27@gmail.com','010-3333-7777',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user28','ROLE_USER','사용자28','user28@gmail.com','010-3333-8888',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user29','ROLE_USER','사용자29','user29@gmail.com','010-3333-9999',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-01-05','2024-09-11'),
                                                              ('user30','ROLE_USER','사용자30','user30@gmail.com','010-3333-0000',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-03-01','2024-09-11'),
                                                              ('user31','ROLE_USER','사용자31','user31@gmail.com','010-3333-1111',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-03-01','2024-09-11'),
                                                              ('user32','ROLE_USER','사용자32','user32@gmail.com','010-3333-2222',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-03-01','2024-09-11'),
                                                              ('user33','ROLE_USER','사용자33','user33@gmail.com','010-3333-3333',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-03-01','2024-09-11'),
                                                              ('user34','ROLE_USER','사용자34','user34@gmail.com','010-3333-4444',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-03-01','2024-09-11'),
                                                              ('user35','ROLE_USER','사용자35','user35@gmail.com','010-3333-5555',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-03-01','2024-09-11'),
                                                              ('user36','ROLE_USER','사용자36','user36@gmail.com','010-3333-6666',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-03-01','2024-09-11'),
                                                              ('user37','ROLE_USER','사용자37','user37@gmail.com','010-3333-7777',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-03-01','2024-09-11'),
                                                              ('user38','ROLE_USER','사용자38','user38@gmail.com','010-3333-8888',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-03-01','2024-09-11'),
                                                              ('user39','ROLE_USER','사용자39','user39@gmail.com','010-3333-9999',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-03-01','2024-09-11'),
                                                              ('user40','ROLE_USER','사용자40','user40@gmail.com','010-4444-0000',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-03-01','2024-09-11'),
                                                              ('user41','ROLE_USER','사용자41','user41@gmail.com','010-4444-1111',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-03-01','2024-09-11'),
                                                              ('user42','ROLE_USER','사용자42','user42@gmail.com','010-4444-2222',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-05-01','2024-09-11'),
                                                              ('user43','ROLE_USER','사용자43','user43@gmail.com','010-4444-3333',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-05-01','2024-09-11'),
                                                              ('user44','ROLE_USER','사용자44','user44@gmail.com','010-4444-4444',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-05-01','2024-09-11'),
                                                              ('user45','ROLE_USER','사용자45','user45@gmail.com','010-4444-5555',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-05-01','2024-09-11'),
                                                              ('user46','ROLE_USER','사용자46','user46@gmail.com','010-4444-6666',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-05-01','2024-09-11'),
                                                              ('user47','ROLE_USER','사용자47','user47@gmail.com','010-4444-7777',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-05-01','2024-09-11'),
                                                              ('user48','ROLE_USER','사용자48','user48@gmail.com','010-4444-8888',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-05-01','2024-09-11'),
                                                              ('user49','ROLE_USER','사용자49','user49@gmail.com','010-4444-9999',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-05-01','2024-09-11'),
                                                              ('user50','ROLE_USER','사용자50','user50@gmail.com','010-5555-0000',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-05-01','2024-09-11'),
                                                              ('user51','ROLE_USER','사용자51','user51@gmail.com','010-5555-1111',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-09-01','2024-09-11'),
                                                              ('user52','ROLE_USER','사용자52','user52@gmail.com','010-5555-2222',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-09-01','2024-09-11'),
                                                              ('user53','ROLE_USER','사용자53','user53@gmail.com','010-5555-3333',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-09-01','2024-09-11'),
                                                              ('user54','ROLE_USER','사용자54','user54@gmail.com','010-5555-4444',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-09-01','2024-09-11'),
                                                              ('user55','ROLE_USER','사용자55','user55@gmail.com','010-5555-5555',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-09-01','2024-09-11'),
                                                              ('user56','ROLE_USER','사용자56','user56@gmail.com','010-5555-6666',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-09-01','2024-09-11'),
                                                              ('user57','ROLE_USER','사용자57','user57@gmail.com','010-5555-7777',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-09-01','2024-09-11'),
                                                              ('user58','ROLE_USER','사용자58','user58@gmail.com','010-5555-8888',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-09-01','2024-09-11'),
                                                              ('user59','ROLE_USER','사용자59','user59@gmail.com','010-5555-9999',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-09-01','2024-09-11'),
                                                              ('user60','ROLE_USER','사용자60','user60@gmail.com','010-6666-0000',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-09-01','2024-09-11'),
                                                              ('user61','ROLE_USER','사용자61','user61@gmail.com','010-6666-1111',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-09-01','2024-09-11'),
                                                              ('user62','ROLE_USER','사용자62','user62@gmail.com','010-6666-2222',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-10-01','2024-09-11'),
                                                              ('user63','ROLE_USER','사용자63','user63@gmail.com','010-6666-3333',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-10-01','2024-09-11'),
                                                              ('user64','ROLE_USER','사용자64','user64@gmail.com','010-6666-4444',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-10-01','2024-09-11'),
                                                              ('user65','ROLE_USER','사용자65','user65@gmail.com','010-6666-5555',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-10-01','2024-09-11'),
                                                              ('user66','ROLE_USER','사용자66','user66@gmail.com','010-6666-6666',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-10-01','2024-09-11'),
                                                              ('user67','ROLE_USER','사용자67','user67@gmail.com','010-6666-7777',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-10-01','2024-09-11'),
                                                              ('user68','ROLE_USER','사용자68','user68@gmail.com','010-6666-8888',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-10-01','2024-09-11'),
                                                              ('user69','ROLE_USER','사용자69','user69@gmail.com','010-6666-9999',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-10-01','2024-09-11'),
                                                              ('user70','ROLE_USER','사용자70','user70@gmail.com','010-7777-0000',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-10-01','2024-09-11'),
                                                              ('user71','ROLE_USER','사용자71','user71@gmail.com','010-7777-1111',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-10-01','2024-09-11'),
                                                              ('user72','ROLE_USER','사용자72','user72@gmail.com','010-7777-2222',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-10-01','2024-09-11'),
                                                              ('user73','ROLE_USER','사용자73','user73@gmail.com','010-7777-3333',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2020-10-01','2024-09-11'),
                                                              ('user74','ROLE_USER','사용자74','user74@gmail.com','010-7777-4444',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-04-01','2024-09-11'),
                                                              ('user75','ROLE_USER','사용자75','user75@gmail.com','010-7777-5555',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-04-01','2024-09-11'),
                                                              ('user76','ROLE_USER','사용자76','user76@gmail.com','010-7777-6666',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-04-01','2024-09-11'),
                                                              ('user77','ROLE_USER','사용자77','user77@gmail.com','010-7777-7777',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-04-01','2024-09-11'),
                                                              ('user78','ROLE_USER','사용자78','user78@gmail.com','010-7777-8888',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-04-01','2024-09-11'),
                                                              ('user79','ROLE_USER','사용자79','user79@gmail.com','010-7777-9999',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-04-01','2024-09-11'),
                                                              ('user80','ROLE_USER','사용자80','user80@gmail.com','010-8888-0000',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-04-01','2024-09-11'),
                                                              ('user81','ROLE_USER','사용자81','user81@gmail.com','010-8888-1111',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-04-01','2024-09-11'),
                                                              ('user82','ROLE_USER','사용자82','user82@gmail.com','010-8888-2222',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-04-01','2024-09-11'),
                                                              ('user83','ROLE_USER','사용자83','user83@gmail.com','010-8888-3333',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-04-01','2024-09-11'),
                                                              ('user84','ROLE_USER','사용자84','user84@gmail.com','010-8888-4444',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-04-01','2024-09-11'),
                                                              ('user85','ROLE_USER','사용자85','user85@gmail.com','010-8888-5555',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-04-01','2024-09-11'),
                                                              ('user86','ROLE_USER','사용자86','user86@gmail.com','010-8888-6666',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-07-01','2024-09-11'),
                                                              ('user87','ROLE_USER','사용자87','user87@gmail.com','010-8888-7777',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-07-01','2024-09-11'),
                                                              ('user88','ROLE_USER','사용자88','user88@gmail.com','010-8888-8888',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-07-01','2024-09-11'),
                                                              ('user89','ROLE_USER','사용자89','user89@gmail.com','010-8888-9999',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-07-01','2024-09-11'),
                                                              ('user90','ROLE_USER','사용자90','user90@gmail.com','010-9999-0000',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-07-01','2024-09-11'),
                                                              ('user91','ROLE_USER','사용자91','user91@gmail.com','010-9999-1111',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-07-01','2024-09-11'),
                                                              ('user92','ROLE_USER','사용자92','user92@gmail.com','010-9999-2222',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2021-07-01','2024-09-11'),
                                                              ('user93','ROLE_USER','사용자93','user93@gmail.com','010-9999-3333',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2022-01-01','2024-09-11'),
                                                              ('user94','ROLE_USER','사용자94','user94@gmail.com','010-9999-4444',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2022-01-01','2024-09-11'),
                                                              ('user95','ROLE_USER','사용자95','user95@gmail.com','010-9999-5555',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2022-01-01','2024-09-11'),
                                                              ('user96','ROLE_USER','사용자96','user96@gmail.com','010-9999-6666',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2022-01-01','2024-09-11'),
                                                              ('user97','ROLE_USER','사용자97','user97@gmail.com','010-9999-7777',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2022-01-01','2024-09-11'),
                                                              ('user98','ROLE_USER','사용자98','user98@gmail.com','010-9999-8888',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2022-01-01','2024-09-11'),
                                                              ('user99','ROLE_USER','사용자99','user99@gmail.com','010-9999-9999',NULL,'$2a$10$RZ4jY7rGKY4ICjIVbyp/xeBzndr9S3Ed0gfMyJiBU1jjrz1QWrDTS','activated','2022-01-01','2024-09-11');

/* ======================================   펫  더미 데이터 ====================================== */
INSERT INTO pet (user_id, pet_name, gender, weight, age, species, kind, image) VALUES
                                                                                   -- user01부터 user10까지의 펫
                                                                                   ('user01', '바비', '여', '3.5', 2, '강아지', '말티즈',NULL),
                                                                                   ('user01', '코코', '남', '5.0', 4, '강아지', '보더콜리',NULL),
                                                                                   ('user01', '밍키', '여', '2.8', 1, '고양이', '먼치킨',NULL),

                                                                                   ('user02', '키키', '남', '2.2', 1, '기타', '토끼',NULL),
                                                                                   ('user02', '루루', '여', '4.0', 3, '강아지', '푸들',NULL),
                                                                                   ('user02', '초코', '남', '6.5', 5, '강아지', '시츄',NULL),

                                                                                   ('user03', '도리', '여', '1.0', 2, '기타', '앵무새',NULL),
                                                                                   ('user03', '미미', '여', '7.2', 6, '강아지', '골든 리트리버',NULL),
                                                                                   ('user03', '하늘', '여', '3.1', 2, '고양이', '스코티시폴드',NULL),

                                                                                   ('user04', '보리', '남', '5.8', 4, '강아지', '비글',NULL),
                                                                                   ('user04', '모모', '여', '3.6', 2, '고양이', '러시안블루',NULL),
                                                                                   ('user04', '카카', '남', '1.2', 3, '기타', '카멜레온',NULL),

                                                                                   ('user05', '푸푸', '남', '8.1', 7, '강아지', '시베리안 허스키',NULL),
                                                                                   ('user05', '토토', '남', '2.9', 1, '강아지', '치와와',NULL),
                                                                                   ('user05', '마루', '여', '4.3', 3, '강아지', '사모예드',NULL),

                                                                                   -- user06부터 user15까지의 펫
                                                                                   ('user06', '루나', '여', '1.0', 2, '기타', '앵무새',NULL),
                                                                                   ('user06', '구름', '여', '6.7', 5, '강아지', '래브라도 리트리버',NULL),
                                                                                   ('user06', '리리', '남', '0.3', 1, '기타', '햄스터',NULL),

                                                                                   ('user07', '산들', '남', '7.3', 4, '고양이', '페르시안',NULL),
                                                                                   ('user07', '큐티', '남', '0.7', 3, '기타', '카멜레온',NULL),

                                                                                   ('user08', '봄', '여', '3.2', 2, '고양이', '아메리칸숏헤어',NULL),
                                                                                   ('user08', '포포', '여', '0.6', 2, '기타', '햄스터',NULL),

                                                                                   ('user09', '치즈', '남', '4.0', 2, '고양이', '러시안블루',NULL),
                                                                                   ('user09', '버터', '여', '3.8', 3, '고양이', '먼치킨',NULL),

                                                                                   ('user10', '토리', '여', '5.0', 2, '강아지', '푸들',NULL),

                                                                                   -- user11부터 user19까지의 펫
                                                                                   ('user11', '쫑이', '남', '6.5', 5, '강아지', '포메라니안',NULL),
                                                                                   ('user11', '뽀미', '여', '4.5', 3, '강아지', '말티즈',NULL),

                                                                                   ('user12', '바둑이', '남', '7.1', 4, '강아지', '비글',NULL),
                                                                                   ('user12', '냥이', '여', '2.5', 1, '고양이', '페르시안',NULL),

                                                                                   ('user13', '달이', '남', '3.6', 2, '강아지', '시베리안 허스키',NULL),
                                                                                   ('user13', '별이', '여', '2.8', 3, '강아지', '치와와',NULL),

                                                                                   ('user14', '해피', '여', '3.2', 2, '강아지', '말티즈',NULL),
                                                                                   ('user14', '럭키', '남', '4.7', 5, '강아지', '시츄',NULL),

                                                                                   ('user15', '하늘', '여', '5.4', 4, '고양이', '러시안블루',NULL),
                                                                                   ('user15', '구름', '남', '2.8', 1, '기타', '토끼',NULL),

                                                                                   -- user19부터 user29까지의 펫
                                                                                   ('user19', '푸푸', '남', '7.4', 3, '강아지', '시베리안 허스키',NULL),
                                                                                   ('user19', '토토', '여', '4.2', 2, '고양이', '페르시안',NULL),
                                                                                   ('user19', '까미', '남', '1.5', 1, '기타', '카멜레온',NULL),

                                                                                   ('user20', '별이', '여', '3.2', 2, '강아지', '포메라니안',NULL),

                                                                                   ('user21', '로로', '남', '5.1', 3, '강아지', '래브라도 리트리버',NULL),
                                                                                   ('user21', '모모', '여', '3.3', 1, '고양이', '먼치킨',NULL),

                                                                                   ('user22', '쫑이', '남', '4.7', 2, '강아지', '비숑프리제',NULL),
                                                                                   ('user22', '초코', '여', '6.1', 4, '강아지', '시츄',NULL),
                                                                                   ('user22', '말랑이', '남', '2.9', 1, '기타', '토끼',NULL),

                                                                                   -- user30부터 user100까지
                                                                                   ('user23', '파랑이', '남', '6.5', 4, '기타', '앵무새',NULL),
                                                                                   ('user23', '아리', '여', '3.7', 2, '강아지', '골든 리트리버',NULL),

                                                                                   ('user24', '보리', '남', '5.8', 3, '강아지', '비글',NULL),
                                                                                   ('user24', '냥이', '여', '3.1', 2, '고양이', '러시안블루',NULL),

                                                                                   ('user25', '모카', '남', '4.5', 2, '강아지', '시츄',NULL),

                                                                                   -- 계속해서 user100까지
                                                                                   ('user98', '쿠키', '남', '4.1', 2, '강아지', '포메라니안',NULL),
                                                                                   ('user98', '또리', '여', '3.2', 1, '기타', '햄스터',NULL);


/* ======================================   병원 더미 데이터 ====================================== */
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('청담동물병원', '병원장1', 'images/hospital/owner/1.png', '저희 청담동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/1.png', '서울특별시 강남구 논현동 95-16번지 논현빌딩 ', '124-45-10901', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('자연동물병원', '병원장2', 'images/hospital/owner/2.png', '저희 자연동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/2.png', '서울특별시 강남구 개포동 1211번지 ', '124-45-10902', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('강남25동물병원', '병원장3', 'images/hospital/owner/3.png', '저희 강남25동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/3.png', '서울특별시 강남구 논현동 90-6 로이빌딩', '124-45-10903', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('주주동물종합병원', '병원장4', 'images/hospital/owner/4.png', '저희 주주동물종합병원을 방문해주셔서 감사합니다!', 'images/hospital/info/4.png', '서울특별시 강남구 대치동 898-8 1층', '124-45-10904', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('서경석동물병원', '병원장5', 'images/hospital/owner/5.png', '저희 서경석동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/5.png', '서울특별시 강남구 일원동 684 남경빌딩 1층', '124-45-10905', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('우리집동물병원', '병원장6', 'images/hospital/owner/6.png', '저희 우리집동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/6.png', '서울특별시 강남구 도곡동 180-31번지 1층 ', '124-45-10906', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('퍼피즌동물병원', '병원장7', 'images/hospital/owner/7.png', '저희 퍼피즌동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/7.png', '서울특별시 강남구 삼성동 34-3 키스톤빌딩 ', '124-45-10907', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('논현동물병원', '병원장8', 'images/hospital/owner/8.png', '저희 논현동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/8.png', '서울특별시 강남구 논현동 181-8 1층', '124-45-10908', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('고려종합동물병원', '병원장9', 'images/hospital/owner/9.png', '저희 고려종합동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/9.png', '서울특별시 강남구 도곡동 527-3번지 도곡렉슬아파트 상가동 109호', '124-45-10909', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('펫프랜즈', '병원장10', 'images/hospital/owner/10.png', '저희 펫프랜즈을 방문해주셔서 감사합니다!', 'images/hospital/info/10.png', '서울특별시 강남구 대치동 500번지 우성(아)상가101호 ', '124-45-10910', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('예은동물의료센터', '병원장11', 'images/hospital/owner/11.png', '저희 예은동물의료센터을 방문해주셔서 감사합니다!', 'images/hospital/info/11.png', '서울특별시 강남구 논현동 87-4', '124-45-10911', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('개포동물병원', '병원장12', 'images/hospital/owner/12.png', '저희 개포동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/12.png', '서울특별시 강남구 개포동 186-17번지 개포종합상가 1층 ', '124-45-10912', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('그레이스 고양이 병원', '병원장13', 'images/hospital/owner/13.png', '저희 그레이스 고양이 병원을 방문해주셔서 감사합니다!', 'images/hospital/info/13.png', '서울특별시 강남구 청담동 88-37 아시아청담부띠끄', '124-45-10913', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('충현동물병원', '병원장14', 'images/hospital/owner/14.png', '저희 충현동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/14.png', '서울특별시 강남구 논현동 191-12 1~4층', '124-45-10914', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('한 동물병원', '병원장15', 'images/hospital/owner/15.png', '저희 한 동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/15.png', '서울특별시 강남구 개포동 1187-1번지 ', '124-45-10915', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('일마레 동물 메디컬 센터', '병원장16', 'images/hospital/owner/16.png', '저희 일마레 동물 메디컬 센터을 방문해주셔서 감사합니다!', 'images/hospital/info/16.png', '서울특별시 강남구 청담동 132-19 정화빌딩 ', '124-45-10916', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('닥터펫동물의료센터', '병원장17', 'images/hospital/owner/17.png', '저희 닥터펫동물의료센터을 방문해주셔서 감사합니다!', 'images/hospital/info/17.png', '서울특별시 강남구 삼성동 35-3 1층', '124-45-10917', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('강남동물병원', '병원장18', 'images/hospital/owner/18.png', '저희 강남동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/18.png', '서울특별시 강남구 논현동 234-26 상하빌딩 1층', '124-45-10918', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('중앙동물메디컬센터', '병원장19', 'images/hospital/owner/19.png', '저희 중앙동물메디컬센터을 방문해주셔서 감사합니다!', 'images/hospital/info/19.png', '서울특별시 강남구 삼성동 90-8 스타빌딩', '124-45-10919', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('스마트동물병원', '병원장20', 'images/hospital/owner/20.png', '저희 스마트동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/20.png', '서울특별시 강남구 개포동 189 개포자이 스퀘어상가 208호', '124-45-10920', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('위너스 동물병원', '병원장21', 'images/hospital/owner/21.png', '저희 위너스 동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/21.png', '서울특별시 강남구 역삼동 732-26번지 ', '124-45-10921', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('마이펫동물의료센터', '병원장22', 'images/hospital/owner/22.png', '저희 마이펫동물의료센터을 방문해주셔서 감사합니다!', 'images/hospital/info/22.png', '서울특별시 강남구 삼성동 119-3', '124-45-10922', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('츄츄 동물병원', '병원장23', 'images/hospital/owner/23.png', '저희 츄츄 동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/23.png', '서울특별시 강남구 역삼동 834-66', '124-45-10923', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('와이즈24시 동물병원', '병원장24', 'images/hospital/owner/24.png', '저희 와이즈24시 동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/24.png', '서울특별시 강남구 논현동 123-5', '124-45-10924', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('백산동물병원', '병원장25', 'images/hospital/owner/25.png', '저희 백산동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/25.png', '서울특별시 강남구 역삼동 725-15 2층', '124-45-10925', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('래이동물의료센터', '병원장26', 'images/hospital/owner/26.png', '저희 래이동물의료센터을 방문해주셔서 감사합니다!', 'images/hospital/info/26.png', '서울특별시 강남구 대치동 649 1층', '124-45-10926', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('24시 청담우리 동물병원', '병원장27', 'images/hospital/owner/27.png', '저희 24시 청담우리 동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/27.png', '서울특별시 강남구 삼성동 70-6', '124-45-10927', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('이안동물의학센터(청담점)', '병원장28', 'images/hospital/owner/28.png', '저희 이안동물의학센터(청담점)을 방문해주셔서 감사합니다!', 'images/hospital/info/28.png', '서울특별시 강남구 청담동 86 5층', '124-45-10928', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('아이윌24시동물병원', '병원장29', 'images/hospital/owner/29.png', '저희 아이윌24시동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/29.png', '서울특별시 강남구 청담동 47 노블레스타워', '124-45-10929', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('수정동물병원', '병원장30', 'images/hospital/owner/30.png', '저희 수정동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/30.png', '서울특별시 강남구 일원동 719번지 푸른마을아파트 상가동 102호', '124-45-10930', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('이비치 동물치과병원', '병원장31', 'images/hospital/owner/31.png', '저희 이비치 동물치과병원을 방문해주셔서 감사합니다!', 'images/hospital/info/31.png', '서울특별시 강남구 청담동 1-18번지 2층 ', '124-45-10931', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('마더스동물병원', '병원장32', 'images/hospital/owner/32.png', '저희 마더스동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/32.png', '서울특별시 강남구 세곡동 581 강남리더스프라자 202-1호', '124-45-10932', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('도곡종합동물병원', '병원장33', 'images/hospital/owner/33.png', '저희 도곡종합동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/33.png', '서울특별시 강남구 역삼동 761-18번지 ', '124-45-10933', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('치료멍멍동물병원', '병원장34', 'images/hospital/owner/34.png', '저희 치료멍멍동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/34.png', '서울특별시 강남구 신사동 637-14', '124-45-10934', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('가로수동물병원', '병원장35', 'images/hospital/owner/35.png', '저희 가로수동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/35.png', '서울특별시 강남구 신사동 549-1 1층', '124-45-10935', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('드림동물병원', '병원장36', 'images/hospital/owner/36.png', '저희 드림동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/36.png', '서울특별시 강남구 역삼동 771 101호,102호', '124-45-10936', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('힐스타동물병원', '병원장37', 'images/hospital/owner/37.png', '저희 힐스타동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/37.png', '서울특별시 강남구 자곡동 658-105 강남힐스테이트에코', '124-45-10937', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('강남다온동물병원', '병원장38', 'images/hospital/owner/38.png', '저희 강남다온동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/38.png', '서울특별시 강남구 도곡동 545-6 1층,2층', '124-45-10938', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('압구정웰동물병원', '병원장39', 'images/hospital/owner/39.png', '저희 압구정웰동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/39.png', '서울특별시 강남구 신사동 528-3번지 덕산빌딩 203호 ', '124-45-10939', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('선릉동물병원', '병원장40', 'images/hospital/owner/40.png', '저희 선릉동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/40.png', '서울특별시 강남구 역삼동 694-11 연안이씨빌딩 1층 ', '124-45-10940', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('굿모닝동물병원', '병원장41', 'images/hospital/owner/41.png', '저희 굿모닝동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/41.png', '서울특별시 강남구 청담동 44-15번지 ', '124-45-10941', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('개포별빛동물병원', '병원장42', 'images/hospital/owner/42.png', '저희 개포별빛동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/42.png', '서울특별시 강남구 개포동 1229-11번지 동성빌딩1층 ', '124-45-10942', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('청담눈초롱안과동물병원', '병원장43', 'images/hospital/owner/43.png', '저희 청담눈초롱안과동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/43.png', '서울특별시 강남구 청담동 125-12 4층', '124-45-10943', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('서울동물심장병원', '병원장44', 'images/hospital/owner/44.png', '저희 서울동물심장병원을 방문해주셔서 감사합니다!', 'images/hospital/info/44.png', '서울특별시 강남구 역삼동 689-2 PRODIGY TOWER', '124-45-10944', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('압구정동물의료센터', '병원장45', 'images/hospital/owner/45.png', '저희 압구정동물의료센터을 방문해주셔서 감사합니다!', 'images/hospital/info/45.png', '서울특별시 강남구 신사동 617 성수빌딩', '124-45-10945', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('24시 스마트동물병원(신사본원)', '병원장46', 'images/hospital/owner/46.png', '저희 24시 스마트동물병원(신사본원)을 방문해주셔서 감사합니다!', 'images/hospital/info/46.png', '서울특별시 강남구 신사동 587-13 1층 지하1층', '124-45-10946', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('압구정메이트동물병원', '병원장47', 'images/hospital/owner/47.png', '저희 압구정메이트동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/47.png', '서울특별시 강남구 신사동 660-7번지 1층,2층 ', '124-45-10947', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('튼튼동물병원', '병원장48', 'images/hospital/owner/48.png', '저희 튼튼동물병원을 방문해주셔서 감사합니다!', 'images/hospital/info/48.png', '서울특별시 강남구 압구정동 426번지 현대아파트 상가 1동 201호', '124-45-10948', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('미르동물의료센터', '병원장49', 'images/hospital/owner/49.png', '저희 미르동물의료센터을 방문해주셔서 감사합니다!', 'images/hospital/info/49.png', '서울특별시 강남구 개포동 168-11', '124-45-10949', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('삼성펫클리닉', '병원장50', 'images/hospital/owner/50.png', '저희 삼성펫클리닉을 방문해주셔서 감사합니다!', 'images/hospital/info/50.png', '서울특별시 강남구 삼성동 163 에스빌딩', '124-45-10950', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);




# 진료 유형
INSERT INTO clinic_type (hos_id, clinic_name) VALUES
                                                  (1, '진료'),
                                                  (1, '수술'),
                                                  (1, '미용'),
                                                  (2, '진료'),
                                                  (2, '미용'),
                                                  (3, '진료'),
                                                  (4, '진료'),
                                                  (4, '수술'),
                                                  (4, '미용'),
                                                  (5, '미용'),
                                                  (6, '진료'),
                                                  (6, '수술'),
                                                  (6, '미용'),
                                                  (7, '진료'),
                                                  (7, '미용'),
                                                  (8, '진료'),
                                                  (9, '진료'),
                                                  (9, '수술'),
                                                  (9, '미용'),
                                                  (10, '미용'),
                                                  (11, '진료'),
                                                  (11, '미용'),
                                                  (12, '진료'),
                                                  (12, '미용'),
                                                  (13, '진료'),
                                                  (13, '수술'),
                                                  (14, '수술'),
                                                  (14, '미용'),
                                                  (15, '수술'),
                                                  (15, '미용'),
                                                  (16, '진료'),
                                                  (17, '진료'),
                                                  (17, '수술'),
                                                  (17, '미용'),
                                                  (18, '진료'),
                                                  (19, '진료'),
                                                  (19, '수술'),
                                                  (20, '진료'),
                                                  (20, '수술'),
                                                  (21, '수술'),
                                                  (21, '미용'),
                                                  (22, '미용'),
                                                  (23, '진료'),
                                                  (24, '진료'),
                                                  (24, '수술'),
                                                  (24, '미용'),
                                                  (25, '미용'),
                                                  (26, '진료'),
                                                  (26, '수술'),
                                                  (27, '수술'),
                                                  (27, '미용'),
                                                  (28, '진료'),
                                                  (29, '진료'),
                                                  (30, '진료'),
                                                  (30, '수술'),
                                                  (31, '진료'),
                                                  (31, '수술'),
                                                  (31, '미용'),
                                                  (32, '진료'),
                                                  (32, '수술'),
                                                  (33, '진료'),
                                                  (33, '수술'),
                                                  (33, '미용'),
                                                  (34, '진료'),
                                                  (34, '미용'),
                                                  (35, '진료'),
                                                  (36, '수술'),
                                                  (36, '미용'),
                                                  (37, '진료'),
                                                  (37, '수술'),
                                                  (38, '진료'),
                                                  (38, '미용'),
                                                  (39, '수술'),
                                                  (40, '진료'),
                                                  (40, '수술'),
                                                  (41, '수술'),
                                                  (41, '미용'),
                                                  (42, '진료'),
                                                  (43, '진료'),
                                                  (43, '미용'),
                                                  (44, '수술'),
                                                  (44, '미용'),
                                                  (45, '미용'),
                                                  (46, '미용'),
                                                  (47, '수술'),
                                                  (48, '진료'),
                                                  (48, '미용'),
                                                  (49, '진료'),
                                                  (49, '미용'),
                                                  (50, '진료'),
                                                  (50, '미용');

/* ======================================   예약 더미 데이터 ====================================== */
INSERT INTO reservation ( type_id,created_date,hos_id,last_modified_date,reservation_time,description,specific_description,state,user_id,pet_id) values
                                                                                                                                                     (1, '2024-07-01', 1, '2024-07-01', '2024-07-01 10:00:00','Description 1', 'Specific Description 1', 'activated', 'user01',1),
                                                                                                                                                     (1, '2024-07-02', 1, '2024-07-02', '2024-07-02 11:00:00','Description 1', 'Specific Description 1', 'activated', 'user02',4),
                                                                                                                                                     (1, '2024-07-03', 1, '2024-07-03', '2024-07-03 13:00:00','Description 1', 'Specific Description 1', 'activated', 'user03',7),
                                                                                                                                                     (1, '2024-07-04', 1, '2024-07-04', '2024-07-04 14:00:00','Description 1', 'Specific Description 1', 'activated', 'user04',10),
                                                                                                                                                     (1, '2024-07-05', 1, '2024-07-05', '2024-07-05 15:00:00','Description 1', 'Specific Description 1', 'activated', 'user05',13),
                                                                                                                                                     (1, '2024-07-06', 1, '2024-07-06', '2024-07-06 16:00:00','Description 1', 'Specific Description 1', 'activated', 'user06',16),
                                                                                                                                                     (1, '2024-07-07', 1, '2024-07-07', '2024-07-07 17:00:00','Description 1', 'Specific Description 1', 'activated', 'user07',19),
                                                                                                                                                     (1, '2024-07-08', 1, '2024-07-08', '2024-07-08 18:00:00','Description 1', 'Specific Description 1', 'activated', 'user08',22),
                                                                                                                                                     (1, '2024-07-09', 1, '2024-07-09', '2024-07-09 10:00:00','Description 1', 'Specific Description 1', 'activated', 'user09',23),
                                                                                                                                                     (1, '2024-07-15', 1, '2024-07-15', '2024-07-15 11:15:00','Description 1', 'Specific Description 1', 'activated', 'user10',25),
                                                                                                                                                     (1, '2024-07-17', 1, '2024-07-17', '2024-07-17 13:00:00','Description 1', 'Specific Description 1', 'activated', 'user11',27),
                                                                                                                                                     (1, '2024-07-19', 1, '2024-07-19', '2024-07-19 14:00:00','Description 1', 'Specific Description 1', 'activated', 'user12',29),
                                                                                                                                                     (1, '2024-07-24', 1, '2024-07-24', '2024-07-24 15:00:00','Description 1', 'Specific Description 1', 'activated', 'user13',31),
                                                                                                                                                     (1, '2024-07-26', 1, '2024-07-26', '2024-07-26 16:00:00','Description 1', 'Specific Description 1', 'activated', 'user14',33),
                                                                                                                                                     (1, '2024-07-28', 1, '2024-07-28', '2024-07-28 17:00:00','Description 1', 'Specific Description 1', 'activated', 'user15',34),
                                                                                                                                                     (1, '2024-07-30', 1, '2024-07-30', '2024-07-30 18:00:00','Description 1', 'Specific Description 1', 'activated', 'user19',36),
                                                                                                                                                     (1, '2024-08-02', 1, '2024-08-02', '2024-08-02 10:00:00','Description 1', 'Specific Description 1', 'activated', 'user20',39),
                                                                                                                                                     (1, '2024-08-04', 1, '2024-08-04', '2024-08-04 11:00:00','Description 1', 'Specific Description 1', 'activated', 'user21',40),
                                                                                                                                                     (1, '2024-08-07', 1, '2024-08-07', '2024-08-07 13:00:00','Description 1', 'Specific Description 1', 'activated', 'user22',42),
                                                                                                                                                     (1, '2024-08-11', 1, '2024-08-11', '2024-08-11 14:00:00','Description 1', 'Specific Description 1', 'activated', 'user23',45),
                                                                                                                                                     (1, '2024-08-13', 1, '2024-08-13', '2024-08-13 15:00:00','Description 1', 'Specific Description 1', 'activated', 'user24',47),
                                                                                                                                                     (1, '2024-08-15', 1, '2024-08-15', '2024-08-15 16:00:00','Description 1', 'Specific Description 1', 'activated', 'user25',49),
                                                                                                                                                     (1, '2024-08-17', 1, '2024-08-17', '2024-08-17 17:00:00','Description 1', 'Specific Description 1', 'activated', 'user98',50),
                                                                                                                                                     (1, '2024-08-18', 1, '2024-08-18', '2024-08-18 18:00:00','Description 1', 'Specific Description 1', 'activated', 'user01',2),
                                                                                                                                                     (1, '2024-08-19', 1, '2024-08-19', '2024-08-19 10:00:00','Description 1', 'Specific Description 1', 'activated', 'user02',5),
                                                                                                                                                     (1, '2024-08-25', 1, '2024-08-25', '2024-08-25 11:00:00','Description 1', 'Specific Description 1', 'activated', 'user03',9),
                                                                                                                                                     (2, '2024-07-01', 1, '2024-07-01', '2024-07-01 10:00:00','Description 1', 'Specific Description 1', 'activated', 'user01',1),
                                                                                                                                                     (2, '2024-07-02', 1, '2024-07-02', '2024-07-02 11:00:00','Description 1', 'Specific Description 1', 'activated', 'user02',4),
                                                                                                                                                     (2, '2024-07-03', 1, '2024-07-03', '2024-07-03 13:00:00','Description 1', 'Specific Description 1', 'activated', 'user03',7),
                                                                                                                                                     (2, '2024-07-04', 1, '2024-07-04', '2024-07-04 14:00:00','Description 1', 'Specific Description 1', 'activated', 'user04',10),
                                                                                                                                                     (2, '2024-07-05', 1, '2024-07-05', '2024-07-05 15:00:00','Description 1', 'Specific Description 1', 'activated', 'user05',13),
                                                                                                                                                     (2, '2024-07-06', 1, '2024-07-06', '2024-07-06 16:00:00','Description 1', 'Specific Description 1', 'activated', 'user06',16),
                                                                                                                                                     (2, '2024-07-07', 1, '2024-07-07', '2024-07-07 17:00:00','Description 1', 'Specific Description 1', 'activated', 'user07',19),
                                                                                                                                                     (2, '2024-07-08', 1, '2024-07-08', '2024-07-08 18:00:00','Description 1', 'Specific Description 1', 'activated', 'user08',22),
                                                                                                                                                     (2, '2024-07-09', 1, '2024-07-09', '2024-07-09 10:00:00','Description 1', 'Specific Description 1', 'activated', 'user09',23),
                                                                                                                                                     (2, '2024-07-15', 1, '2024-07-15', '2024-07-15 11:15:00','Description 1', 'Specific Description 1', 'activated', 'user10',25),
                                                                                                                                                     (2, '2024-07-17', 1, '2024-07-17', '2024-07-17 13:00:00','Description 1', 'Specific Description 1', 'activated', 'user11',27),
                                                                                                                                                     (2, '2024-07-19', 1, '2024-07-19', '2024-07-19 14:00:00','Description 1', 'Specific Description 1', 'activated', 'user12',29),
                                                                                                                                                     (2, '2024-07-24', 1, '2024-07-24', '2024-07-24 15:00:00','Description 1', 'Specific Description 1', 'activated', 'user13',31),
                                                                                                                                                     (2, '2024-07-26', 1, '2024-07-26', '2024-07-26 16:00:00','Description 1', 'Specific Description 1', 'activated', 'user14',33),
                                                                                                                                                     (2, '2024-07-28', 1, '2024-07-28', '2024-07-28 17:00:00','Description 1', 'Specific Description 1', 'activated', 'user15',34),
                                                                                                                                                     (2, '2024-07-30', 1, '2024-07-30', '2024-07-30 18:00:00','Description 1', 'Specific Description 1', 'activated', 'user19',36),
                                                                                                                                                     (2, '2024-08-02', 1, '2024-08-02', '2024-08-02 10:00:00','Description 1', 'Specific Description 1', 'activated', 'user20',39),
                                                                                                                                                     (2, '2024-08-04', 1, '2024-08-04', '2024-08-04 11:00:00','Description 1', 'Specific Description 1', 'activated', 'user21',40),
                                                                                                                                                     (2, '2024-08-07', 1, '2024-08-07', '2024-08-07 13:00:00','Description 1', 'Specific Description 1', 'activated', 'user22',42),
                                                                                                                                                     (2, '2024-08-11', 1, '2024-08-11', '2024-08-11 14:00:00','Description 1', 'Specific Description 1', 'activated', 'user23',45),
                                                                                                                                                     (2, '2024-08-13', 1, '2024-08-13', '2024-08-13 15:00:00','Description 1', 'Specific Description 1', 'activated', 'user24',47),
                                                                                                                                                     (2, '2024-08-15', 1, '2024-08-15', '2024-08-15 16:00:00','Description 1', 'Specific Description 1', 'activated', 'user25',49),
                                                                                                                                                     (2, '2024-08-17', 1, '2024-08-17', '2024-08-17 17:00:00','Description 1', 'Specific Description 1', 'activated', 'user98',50),
                                                                                                                                                     (2, '2024-08-18', 1, '2024-08-18', '2024-08-18 18:00:00','Description 1', 'Specific Description 1', 'activated', 'user01',2),
                                                                                                                                                     (2, '2024-08-19', 1, '2024-08-19', '2024-08-19 10:00:00','Description 1', 'Specific Description 1', 'activated', 'user02',5),
                                                                                                                                                     (2, '2024-08-25', 1, '2024-08-25', '2024-08-25 11:00:00','Description 1', 'Specific Description 1', 'activated', 'user03',9),
                                                                                                                                                     (3, '2024-07-01', 1, '2024-07-01', '2024-07-01 10:00:00','Description 1', 'Specific Description 1', 'activated', 'user01',1),
                                                                                                                                                     (3, '2024-07-02', 1, '2024-07-02', '2024-07-02 11:00:00','Description 1', 'Specific Description 1', 'activated', 'user02',4),
                                                                                                                                                     (3, '2024-07-03', 1, '2024-07-03', '2024-07-03 13:00:00','Description 1', 'Specific Description 1', 'activated', 'user03',7),
                                                                                                                                                     (3, '2024-07-04', 1, '2024-07-04', '2024-07-04 14:00:00','Description 1', 'Specific Description 1', 'activated', 'user04',10),
                                                                                                                                                     (3, '2024-07-05', 1, '2024-07-05', '2024-07-05 15:00:00','Description 1', 'Specific Description 1', 'activated', 'user05',13),
                                                                                                                                                     (3, '2024-07-06', 1, '2024-07-06', '2024-07-06 16:00:00','Description 1', 'Specific Description 1', 'activated', 'user06',16),
                                                                                                                                                     (3, '2024-07-07', 1, '2024-07-07', '2024-07-07 17:00:00','Description 1', 'Specific Description 1', 'activated', 'user07',19),
                                                                                                                                                     (3, '2024-07-08', 1, '2024-07-08', '2024-07-08 18:00:00','Description 1', 'Specific Description 1', 'activated', 'user08',22),
                                                                                                                                                     (3, '2024-07-09', 1, '2024-07-09', '2024-07-09 10:00:00','Description 1', 'Specific Description 1', 'activated', 'user09',23),
                                                                                                                                                     (3, '2024-07-15', 1, '2024-07-15', '2024-07-15 11:15:00','Description 1', 'Specific Description 1', 'activated', 'user10',25),
                                                                                                                                                     (3, '2024-07-17', 1, '2024-07-17', '2024-07-17 13:00:00','Description 1', 'Specific Description 1', 'activated', 'user11',27),
                                                                                                                                                     (3, '2024-07-19', 1, '2024-07-19', '2024-07-19 14:00:00','Description 1', 'Specific Description 1', 'activated', 'user12',29),
                                                                                                                                                     (3, '2024-07-24', 1, '2024-07-24', '2024-07-24 15:00:00','Description 1', 'Specific Description 1', 'activated', 'user13',31),
                                                                                                                                                     (3, '2024-07-26', 1, '2024-07-26', '2024-07-26 16:00:00','Description 1', 'Specific Description 1', 'activated', 'user14',33),
                                                                                                                                                     (3, '2024-07-28', 1, '2024-07-28', '2024-07-28 17:00:00','Description 1', 'Specific Description 1', 'activated', 'user15',34),
                                                                                                                                                     (3, '2024-07-30', 1, '2024-07-30', '2024-07-30 18:00:00','Description 1', 'Specific Description 1', 'activated', 'user19',36),
                                                                                                                                                     (3, '2024-08-02', 1, '2024-08-02', '2024-08-02 10:00:00','Description 1', 'Specific Description 1', 'activated', 'user20',39),
                                                                                                                                                     (3, '2024-08-04', 1, '2024-08-04', '2024-08-04 11:00:00','Description 1', 'Specific Description 1', 'activated', 'user21',40),
                                                                                                                                                     (3, '2024-08-07', 1, '2024-08-07', '2024-08-07 13:00:00','Description 1', 'Specific Description 1', 'activated', 'user22',42),
                                                                                                                                                     (3, '2024-08-11', 1, '2024-08-11', '2024-08-11 14:00:00','Description 1', 'Specific Description 1', 'activated', 'user23',45),
                                                                                                                                                     (3, '2024-08-13', 1, '2024-08-13', '2024-08-13 15:00:00','Description 1', 'Specific Description 1', 'activated', 'user24',47),
                                                                                                                                                     (3, '2024-08-15', 1, '2024-08-15', '2024-08-15 16:00:00','Description 1', 'Specific Description 1', 'activated', 'user25',49),
                                                                                                                                                     (3, '2024-08-17', 1, '2024-08-17', '2024-08-17 17:00:00','Description 1', 'Specific Description 1', 'activated', 'user98',50),
                                                                                                                                                     (3, '2024-08-18', 1, '2024-08-18', '2024-08-18 18:00:00','Description 1', 'Specific Description 1', 'activated', 'user01',2),
                                                                                                                                                     (3, '2024-08-19', 1, '2024-08-19', '2024-08-19 10:00:00','Description 1', 'Specific Description 1', 'activated', 'user02',5),
                                                                                                                                                     (3, '2024-08-25', 1, '2024-08-25', '2024-08-25 11:00:00','Description 1', 'Specific Description 1', 'activated', 'user03',9);











# /* 리뷰 더미 데이터 */
# INSERT INTO review (reservation_id, content, report_state, created_date, last_modified_date)
# VALUES
#     (1, '친절하고 자세한 설명 덕분에 안심하고 진료를 받을 수 있었습니다.', NULL, '2024-09-14', NULL),
#     (2, '말티즈 진료를 받았는데, 전문적이고 깔끔한 처치였습니다.', NULL, '2024-09-14', NULL),
#     (3, '대기 시간이 길었지만 친절한 서비스에 만족했습니다.', NULL, '2024-09-14', NULL),
#     (4, '수술 전후 과정이 매우 체계적이었고 안심할 수 있었습니다.', NULL, '2024-09-14', NULL),
#     (5, '콜리의 수술이 성공적으로 끝나서 다행입니다. 감사합니다.', NULL, '2024-09-14', '2024-09-16'),
#     (6, '수술 후에도 지속적으로 관리해 주셔서 안심했습니다.', NULL, '2024-09-14', NULL),
#     (7, '파브로프 미용을 아주 깔끔하게 해주셨습니다. 다음에도 이용하겠습니다.', NULL, '2024-09-14', NULL),
#     (8, '직원분들이 매우 친절하시고, 미용 결과도 마음에 듭니다.', NULL, '2024-09-14', NULL),
#     (9, '너무 불친절하고 대기 시간이 말도 안 될 정도로 길었습니다. 다시는 안 갑니다.', '대기', '2024-09-14', NULL),
#     (10, '처음 방문했지만 매우 만족스러운 진료였습니다. 병원을 추천합니다.', NULL, '2024-09-14', NULL),
#     (11, '우리 도베르만이 큰 수술을 받았지만 빠르게 회복 중입니다.', NULL, '2024-09-14', NULL),
#     (12, '정말 감사합니다. 세심한 수술과 회복 관리를 해 주셔서 믿음이 갑니다.', NULL, '2024-09-14', '2024-09-16'),
#     (13, '시츄 미용을 받았는데 결과가 매우 만족스럽습니다.', NULL, '2024-09-14', NULL),
#     (14, '병원 환경이 너무 더럽고 비위생적이었습니다. 다시는 안 갈 겁니다.', '승인', '2024-09-14', '2024-09-16'),
#     (15, '고양이 진료를 받았는데, 세심한 케어 덕분에 안심하고 진료를 마쳤습니다.', NULL, '2024-09-14', NULL),
#     (16, '미용사가 실수를 해서 강아지 털을 너무 많이 잘랐어요. 어떻게 책임질 건가요?', '승인', '2024-09-14', '2024-09-16'),
#     (17, '아비시니안 고양이 수술이 무사히 끝나서 다행입니다.', NULL, '2024-09-14', '2024-09-15'),
#     (18, '수술 전후 관리가 정말 체계적이었습니다. 감사합니다.', NULL, '2024-09-14', NULL),
#     (19, '친절하고 꼼꼼한 진료에 매우 만족했습니다. 고양이도 안심했습니다.', NULL, '2024-09-14', NULL),
#     (20, '진료 과정에서의 세심한 배려가 돋보였습니다.', NULL, '2024-09-14', NULL),
#     (21, '진료 비용이 너무 비쌌고, 그에 비해 서비스는 형편없었습니다.', '취소', '2024-09-14', NULL),
#     (22, '고양이 수술 후 회복 과정도 매우 신경 써주셨습니다.', NULL, '2024-09-14', NULL),
#     (23, '페르시안 고양이 미용 결과가 아주 좋습니다. 다음에도 방문할 예정입니다.', NULL, '2024-09-14', NULL),
#     (24, '진료를 받으면서 느낀 건 병원 전반적으로 직원 태도가 엉망이라는 점입니다.', '취소', '2024-09-14', '2024-09-15'),
#     (25, '고양이 진료를 받았는데, 세심한 설명에 감사드립니다.', NULL, '2024-09-14', NULL),
#     (26, '고양이 건강 검진 결과를 상세히 설명해 주셔서 이해하기 쉬웠습니다.', NULL, '2024-09-14', NULL),
#     (27, '랙돌 고양이 수술이 무사히 끝났습니다. 감사합니다.', NULL, '2024-09-14', NULL),
#     (28, '의사 선생님이 대충 진료하는 것 같았습니다. 고양이가 아픈데 전혀 도움 안 됐어요.', '대기', '2024-09-14', NULL),
#     (29, '렉돌 고양이 정기 검진을 받았는데, 신속하고 정확한 진단이었습니다.', NULL, '2024-09-14', NULL),
#     (30, '직원이 반말로 응대해서 기분이 매우 나빴습니다.', '대기', '2024-09-14', NULL);


# 병원 일정 더미 데이터
ALTER TABLE schedule MODIFY COLUMN is_okay BOOLEAN NOT NULL DEFAULT TRUE;

CALL InsertHospitalSchedules1();