use villaindb;


DROP TABLE IF EXISTS `User` CASCADE;

CREATE TABLE `user`
(
    `user_id` VARCHAR(50) NOT NULL COMMENT '사용자 아이디',
    `hos_id` INTEGER COMMENT '병원 고유번호',
    `pwd` VARCHAR(255)NOT NULL COMMENT '비밀번호',
    `user_role` VARCHAR(255) NOT NULL COMMENT '유저 권한',
    `name`  VARCHAR(255) NOT NULL COMMENT '유저 이름',
    `email` VARCHAR(255) NOT NULL COMMENT '이메일',
    `phone` VARCHAR(255) NOT NULL COMMENT '전화번호',
    `userState`
    `create_date` DATETIME COMMENT '생성일',
    `last_modified_date` DATETIME  COMMENT '최근 수정일',
    PRIMARY KEY ( `user_id` )
) COMMENT = '유저관리';

UPDATE villaindb.user
SET hos_id = NULL
WHERE hos_id = '';


INSERT INTO user (user_id, user_role, name, email, phone,hos_id,pwd,user_state,created_date,last_modified_date) VALUES
                                                              ('admin01','ROLE_ADMIN','관리자01','admin01@gmail.com','070-1111-1111',null,'qwer1234','activated','2019-02-12','2024-09-11'),
                                                              ('admin02','ROLE_ADMIN','관리자02','admin02@gmail.com','070-2222-2222',null,'qwer1234','activated','2019-04-12','2024-09-11'),
                                                              ('admin03','ROLE_ADMIN','관리자03','admin03@gmail.com','070-3333-3333',null,'qwer1234','activated','2019-08-12','2024-09-11'),
                                                              ('hospital01','ROLE_HOSPITAL','병원관리자01','hospital01@gmail','02-1111-1111',1,'1q2w3e4r!','activated','2020-01-12','2024-09-11'),
                                                              ('hospital02','ROLE_HOSPITAL','병원관리자02','hospital02@gmail','02-1111-2222',2,'1q2w3e4r!','activated','2020-02-12','2024-09-11'),
                                                              ('hospital03','ROLE_HOSPITAL','병원관리자03','hospital03@gmail','02-1111-3333',3,'1q2w3e4r!','activated','2020-03-12','2024-09-11'),
                                                              ('hospital04','ROLE_HOSPITAL','병원관리자04','hospital04@gmail','02-1111-4444',4,'1q2w3e4r!','activated','2020-04-12','2024-09-11'),
                                                              ('hospital05','ROLE_HOSPITAL','병원관리자05','hospital05@gmail','02-1111-5555',5,'1q2w3e4r!','activated','2020-05-12','2024-09-11'),
                                                              ('hospital06','ROLE_HOSPITAL','병원관리자06','hospital06@gmail','02-1111-6666',6,'1q2w3e4r!','activated','2020-05-12','2024-09-11'),
                                                              ('hospital07','ROLE_HOSPITAL','병원관리자07','hospital07@gmail','02-1111-7777',7,'1q2w3e4r!','activated','2020-05-12','2024-09-11'),
                                                              ('hospital08','ROLE_HOSPITAL','병원관리자08','hospital08@gmail','02-1111-8888',8,'1q2w3e4r!','activated','2020-05-12','2024-09-11'),
                                                              ('hospital09','ROLE_HOSPITAL','병원관리자09','hospital09@gmail','02-1111-9999',9,'1q2w3e4r!','activated','2020-06-12','2024-09-11'),
                                                              ('hospital10','ROLE_HOSPITAL','병원관리자10','hospital09@gmail','02-2222-0000',10,'1q2w3e4r!','activated','2020-06-12','2024-09-11'),
                                                              ('hospital11','ROLE_HOSPITAL','병원관리자11','hospital11@gmail','02-2222-1111',11,'1q2w3e4r!','activated','2020-06-12','2024-09-11'),
                                                              ('hospital12','ROLE_HOSPITAL','병원관리자12','hospital12@gmail','02-2222-2222',12,'1q2w3e4r!','activated','2020-06-12','2024-09-11'),
                                                              ('hospital13','ROLE_HOSPITAL','병원관리자13','hospital13@gmail','02-2222-3333',13,'1q2w3e4r!','activated','2020-07-12','2024-09-11'),
                                                              ('hospital14','ROLE_HOSPITAL','병원관리자14','hospital14@gmail','02-2222-4444',14,'1q2w3e4r!','activated','2020-07-12','2024-09-11'),
                                                              ('hospital15','ROLE_HOSPITAL','병원관리자15','hospital15@gmail','02-2222-5555',15,'1q2w3e4r!','activated','2020-07-12','2024-09-11'),
                                                              ('hospital16','ROLE_HOSPITAL','병원관리자16','hospital16@gmail','02-2222-6666',16,'1q2w3e4r!','activated','2020-08-12','2024-09-11'),
                                                              ('hospital17','ROLE_HOSPITAL','병원관리자17','hospital17@gmail','02-2222-7777',17,'1q2w3e4r!','activated','2020-08-12','2024-09-11'),
                                                              ('hospital18','ROLE_HOSPITAL','병원관리자18','hospital18@gmail','02-2222-8888',18,'1q2w3e4r!','activated','2020-08-12','2024-09-11'),
                                                              ('hospital19','ROLE_HOSPITAL','병원관리자19','hospital19@gmail','02-2222-9999',19,'1q2w3e4r!','activated','2020-09-12','2024-09-11'),
                                                              ('hospital20','ROLE_HOSPITAL','병원관리자20','hospital20@gmail','02-3333-0000',20,'1q2w3e4r!','activated','2020-07-12','2024-09-11'),
                                                              ('hospital21','ROLE_HOSPITAL','병원관리자21','hospital21@gmail','02-3333-1111',21,'1q2w3e4r!','activated','2020-09-12','2024-09-11'),
                                                              ('hospital22','ROLE_HOSPITAL','병원관리자22','hospital22@gmail','02-3333-2222',22,'1q2w3e4r!','activated','2021-09-12','2024-09-11'),
                                                              ('hospital23','ROLE_HOSPITAL','병원관리자23','hospital23@gmail','02-3333-3333',23,'1q2w3e4r!','activated','2021-10-12','2024-09-11'),
                                                              ('hospital24','ROLE_HOSPITAL','병원관리자24','hospital24@gmail','02-3333-4444',24,'1q2w3e4r!','activated','2021-10-12','2024-09-11'),
                                                              ('hospital25','ROLE_HOSPITAL','병원관리자25','hospital25@gmail','02-3333-5555',25,'1q2w3e4r!','activated','2021-10-12','2024-09-11'),
                                                              ('hospital26','ROLE_HOSPITAL','병원관리자26','hospital26@gmail','02-3333-6666',26,'1q2w3e4r!','activated','2021-11-12','2024-09-11'),
                                                              ('hospital27','ROLE_HOSPITAL','병원관리자27','hospital27@gmail','02-3333-7777',27,'1q2w3e4r!','activated','2021-11-12','2024-09-11'),
                                                              ('hospital28','ROLE_HOSPITAL','병원관리자28','hospital28@gmail','02-3333-8888',28,'1q2w3e4r!','activated','2021-11-12','2024-09-11'),
                                                              ('hospital29','ROLE_HOSPITAL','병원관리자29','hospital29@gmail','02-3333-9999',29,'1q2w3e4r!','activated','2021-12-12','2024-09-11'),
                                                              ('hospital30','ROLE_HOSPITAL','병원관리자30','hospital30@gmail','02-4444-0000',30,'1q2w3e4r!','activated','2021-12-12','2024-09-11'),
                                                              ('hospital31','ROLE_HOSPITAL','병원관리자31','hospital31@gmail','02-4444-1111',31,'1q2w3e4r!','activated','2022-11-12','2024-09-11'),
                                                              ('hospital32','ROLE_HOSPITAL','병원관리자32','hospital32@gmail','02-4444-2222',32,'1q2w3e4r!','activated','2022-10-12','2024-09-11'),
                                                              ('hospital33','ROLE_HOSPITAL','병원관리자33','hospital33@gmail','02-4444-3333',33,'1q2w3e4r!','activated','2022-10-12','2024-09-11'),
                                                              ('hospital34','ROLE_HOSPITAL','병원관리자34','hospital34@gmail','02-4444-4444',34,'1q2w3e4r!','activated','2022-11-12','2024-09-11'),
                                                              ('hospital35','ROLE_HOSPITAL','병원관리자35','hospital35@gmail','02-4444-5555',35,'1q2w3e4r!','activated','2022-07-12','2024-09-11'),
                                                              ('hospital36','ROLE_HOSPITAL','병원관리자36','hospital36@gmail','02-4444-6666',36,'1q2w3e4r!','activated','2022-08-12','2024-09-11'),
                                                              ('hospital37','ROLE_HOSPITAL','병원관리자37','hospital37@gmail','02-4444-7777',37,'1q2w3e4r!','activated','2022-07-12','2024-09-11'),
                                                              ('hospital38','ROLE_HOSPITAL','병원관리자38','hospital38@gmail','02-4444-8888',38,'1q2w3e4r!','activated','2022-09-12','2024-09-11'),
                                                              ('hospital39','ROLE_HOSPITAL','병원관리자39','hospital39@gmail','02-4444-9999',39,'1q2w3e4r!','activated','2022-10-12','2024-09-11'),
                                                              ('hospital40','ROLE_HOSPITAL','병원관리자40','hospital40@gmail','02-5555-0000',40,'1q2w3e4r!','activated','2022-11-12','2024-09-11'),
                                                              ('hospital41','ROLE_HOSPITAL','병원관리자41','hospital41@gmail','02-5555-1111',41,'1q2w3e4r!','activated','2022-11-12','2024-09-11'),
                                                              ('hospital42','ROLE_HOSPITAL','병원관리자42','hospital42@gmail','02-5555-2222',42,'1q2w3e4r!','activated','2022-10-12','2024-09-11'),
                                                              ('hospital43','ROLE_HOSPITAL','병원관리자43','hospital43@gmail','02-5555-3333',43,'1q2w3e4r!','activated','2022-07-12','2024-09-11'),
                                                              ('hospital44','ROLE_HOSPITAL','병원관리자44','hospital44@gmail','02-5555-4444',44,'1q2w3e4r!','activated','2022-08-12','2024-09-11'),
                                                              ('hospital45','ROLE_HOSPITAL','병원관리자45','hospital45@gmail','02-5555-5555',45,'1q2w3e4r!','activated','2022-09-12','2024-09-11'),
                                                              ('hospital46','ROLE_HOSPITAL','병원관리자46','hospital46@gmail','02-5555-6666',46,'1q2w3e4r!','activated','2022-09-12','2024-09-11'),
                                                              ('hospital47','ROLE_HOSPITAL','병원관리자47','hospital47@gmail','02-5555-7777',47,'1q2w3e4r!','activated','2022-10-12','2024-09-11'),
                                                              ('hospital48','ROLE_HOSPITAL','병원관리자48','hospital48@gmail','02-5555-8888',48,'1q2w3e4r!','activated','2022-11-12','2024-09-11'),
                                                              ('hospital49','ROLE_HOSPITAL','병원관리자49','hospital49@gmail','02-5555-9999',49,'1q2w3e4r!','activated','2022-11-12','2024-09-11'),
                                                              ('hospital50','ROLE_HOSPITAL','병원관리자50','hospital50@gmail','02-6666-0000',50,'1q2w3e4r!','activated','2022-12-12','2024-09-11'),
                                                              ('user01','ROLE_USER','사용자01','user01@gmail.com','010-0000-1111',NULL,'user1234','activated','2020-01-01','2024-09-11'),
                                                              ('user02','ROLE_USER','사용자02','user02@gmail.com','010-0000-2222',NULL,'user1234','activated','2020-01-02','2024-09-11'),
                                                              ('user03','ROLE_USER','사용자03','user03@gmail.com','010-0000-3333',NULL,'user1234','activated','2020-01-02','2024-09-11'),
                                                              ('user04','ROLE_USER','사용자04','user04@gmail.com','010-0000-4444',NULL,'user1234','activated','2020-01-02','2024-09-11'),
                                                              ('user05','ROLE_USER','사용자05','user05@gmail.com','010-0000-5555',NULL,'user1234','activated','2020-01-02','2024-09-11'),
                                                              ('user06','ROLE_USER','사용자06','user06@gmail.com','010-0000-6666',NULL,'user1234','activated','2020-01-03','2024-09-11'),
                                                              ('user07','ROLE_USER','사용자07','user07@gmail.com','010-0000-7777',NULL,'user1234','activated','2020-01-03','2024-09-11'),
                                                              ('user08','ROLE_USER','사용자08','user08@gmail.com','010-0000-8888',NULL,'user1234','activated','2020-01-03','2024-09-11'),
                                                              ('user09','ROLE_USER','사용자09','user09@gmail.com','010-0000-9999',NULL,'user1234','activated','2020-01-03','2024-09-11'),
                                                              ('user10','ROLE_USER','사용자10','user10@gmail.com','010-0010-0000',NULL,'user1234','activated','2020-01-04','2024-09-11'),
                                                              ('user11','ROLE_USER','사용자11','user11@gmail.com','010-1111-1111',NULL,'user1234','activated','2020-01-04','2024-09-11'),
                                                              ('user12','ROLE_USER','사용자12','user12@gmail.com','010-1111-2222',NULL,'user1234','activated','2020-01-04','2024-09-11'),
                                                              ('user13','ROLE_USER','사용자13','user13@gmail.com','010-1111-3333',NULL,'user1234','activated','2020-01-04','2024-09-11'),
                                                              ('user14','ROLE_USER','사용자14','user14@gmail.com','010-1111-4444',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user15','ROLE_USER','사용자15','user15@gmail.com','010-1111-5555',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user16','ROLE_USER','사용자16','user16@gmail.com','010-1111-6666',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user17','ROLE_USER','사용자17','user17@gmail.com','010-1111-7777',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user18','ROLE_USER','사용자18','user18@gmail.com','010-1111-8888',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user19','ROLE_USER','사용자19','user19@gmail.com','010-1111-9999',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user20','ROLE_USER','사용자20','user20@gmail.com','010-2222-0000',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user21','ROLE_USER','사용자21','user21@gmail.com','010-3333-1111',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user22','ROLE_USER','사용자22','user22@gmail.com','010-3333-2222',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user23','ROLE_USER','사용자23','user23@gmail.com','010-3333-3333',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user24','ROLE_USER','사용자24','user24@gmail.com','010-3333-4444',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user25','ROLE_USER','사용자25','user25@gmail.com','010-3333-5555',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user26','ROLE_USER','사용자26','user26@gmail.com','010-3333-6666',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user27','ROLE_USER','사용자27','user27@gmail.com','010-3333-7777',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user28','ROLE_USER','사용자28','user28@gmail.com','010-3333-8888',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user29','ROLE_USER','사용자29','user29@gmail.com','010-3333-9999',NULL,'user1234','activated','2020-01-05','2024-09-11'),
                                                              ('user30','ROLE_USER','사용자30','user30@gmail.com','010-3333-0000',NULL,'user1234','activated','2020-03-01','2024-09-11'),
                                                              ('user31','ROLE_USER','사용자31','user31@gmail.com','010-3333-1111',NULL,'user1234','activated','2020-03-01','2024-09-11'),
                                                              ('user32','ROLE_USER','사용자32','user32@gmail.com','010-3333-2222',NULL,'user1234','activated','2020-03-01','2024-09-11'),
                                                              ('user33','ROLE_USER','사용자33','user33@gmail.com','010-3333-3333',NULL,'user1234','activated','2020-03-01','2024-09-11'),
                                                              ('user34','ROLE_USER','사용자34','user34@gmail.com','010-3333-4444',NULL,'user1234','activated','2020-03-01','2024-09-11'),
                                                              ('user35','ROLE_USER','사용자35','user35@gmail.com','010-3333-5555',NULL,'user1234','activated','2020-03-01','2024-09-11'),
                                                              ('user36','ROLE_USER','사용자36','user36@gmail.com','010-3333-6666',NULL,'user1234','activated','2020-03-01','2024-09-11'),
                                                              ('user37','ROLE_USER','사용자37','user37@gmail.com','010-3333-7777',NULL,'user1234','activated','2020-03-01','2024-09-11'),
                                                              ('user38','ROLE_USER','사용자38','user38@gmail.com','010-3333-8888',NULL,'user1234','activated','2020-03-01','2024-09-11'),
                                                              ('user39','ROLE_USER','사용자39','user39@gmail.com','010-3333-9999',NULL,'user1234','activated','2020-03-01','2024-09-11'),
                                                              ('user40','ROLE_USER','사용자40','user40@gmail.com','010-4444-0000',NULL,'user1234','activated','2020-03-01','2024-09-11'),
                                                              ('user41','ROLE_USER','사용자41','user41@gmail.com','010-4444-1111',NULL,'user1234','activated','2020-03-01','2024-09-11'),
                                                              ('user42','ROLE_USER','사용자42','user42@gmail.com','010-4444-2222',NULL,'user1234','activated','2020-05-01','2024-09-11'),
                                                              ('user43','ROLE_USER','사용자43','user43@gmail.com','010-4444-3333',NULL,'user1234','activated','2020-05-01','2024-09-11'),
                                                              ('user44','ROLE_USER','사용자44','user44@gmail.com','010-4444-4444',NULL,'user1234','activated','2020-05-01','2024-09-11'),
                                                              ('user45','ROLE_USER','사용자45','user45@gmail.com','010-4444-5555',NULL,'user1234','activated','2020-05-01','2024-09-11'),
                                                              ('user46','ROLE_USER','사용자46','user46@gmail.com','010-4444-6666',NULL,'user1234','activated','2020-05-01','2024-09-11'),
                                                              ('user47','ROLE_USER','사용자47','user47@gmail.com','010-4444-7777',NULL,'user1234','activated','2020-05-01','2024-09-11'),
                                                              ('user48','ROLE_USER','사용자48','user48@gmail.com','010-4444-8888',NULL,'user1234','activated','2020-05-01','2024-09-11'),
                                                              ('user49','ROLE_USER','사용자49','user49@gmail.com','010-4444-9999',NULL,'user1234','activated','2020-05-01','2024-09-11'),
                                                              ('user50','ROLE_USER','사용자50','user50@gmail.com','010-5555-0000',NULL,'user1234','activated','2020-05-01','2024-09-11'),
                                                              ('user51','ROLE_USER','사용자51','user51@gmail.com','010-5555-1111',NULL,'user1234','activated','2020-09-01','2024-09-11'),
                                                              ('user52','ROLE_USER','사용자52','user52@gmail.com','010-5555-2222',NULL,'user1234','activated','2020-09-01','2024-09-11'),
                                                              ('user53','ROLE_USER','사용자53','user53@gmail.com','010-5555-3333',NULL,'user1234','activated','2020-09-01','2024-09-11'),
                                                              ('user54','ROLE_USER','사용자54','user54@gmail.com','010-5555-4444',NULL,'user1234','activated','2020-09-01','2024-09-11'),
                                                              ('user55','ROLE_USER','사용자55','user55@gmail.com','010-5555-5555',NULL,'user1234','activated','2020-09-01','2024-09-11'),
                                                              ('user56','ROLE_USER','사용자56','user56@gmail.com','010-5555-6666',NULL,'user1234','activated','2020-09-01','2024-09-11'),
                                                              ('user57','ROLE_USER','사용자57','user57@gmail.com','010-5555-7777',NULL,'user1234','activated','2020-09-01','2024-09-11'),
                                                              ('user58','ROLE_USER','사용자58','user58@gmail.com','010-5555-8888',NULL,'user1234','activated','2020-09-01','2024-09-11'),
                                                              ('user59','ROLE_USER','사용자59','user59@gmail.com','010-5555-9999',NULL,'user1234','activated','2020-09-01','2024-09-11'),
                                                              ('user60','ROLE_USER','사용자60','user60@gmail.com','010-6666-0000',NULL,'user1234','activated','2020-09-01','2024-09-11'),
                                                              ('user61','ROLE_USER','사용자61','user61@gmail.com','010-6666-1111',NULL,'user1234','activated','2020-09-01','2024-09-11'),
                                                              ('user62','ROLE_USER','사용자62','user62@gmail.com','010-6666-2222',NULL,'user1234','activated','2020-10-01','2024-09-11'),
                                                              ('user63','ROLE_USER','사용자63','user63@gmail.com','010-6666-3333',NULL,'user1234','activated','2020-10-01','2024-09-11'),
                                                              ('user64','ROLE_USER','사용자64','user64@gmail.com','010-6666-4444',NULL,'user1234','activated','2020-10-01','2024-09-11'),
                                                              ('user65','ROLE_USER','사용자65','user65@gmail.com','010-6666-5555',NULL,'user1234','activated','2020-10-01','2024-09-11'),
                                                              ('user66','ROLE_USER','사용자66','user66@gmail.com','010-6666-6666',NULL,'user1234','activated','2020-10-01','2024-09-11'),
                                                              ('user67','ROLE_USER','사용자67','user67@gmail.com','010-6666-7777',NULL,'user1234','activated','2020-10-01','2024-09-11'),
                                                              ('user68','ROLE_USER','사용자68','user68@gmail.com','010-6666-8888',NULL,'user1234','activated','2020-10-01','2024-09-11'),
                                                              ('user69','ROLE_USER','사용자69','user69@gmail.com','010-6666-9999',NULL,'user1234','activated','2020-10-01','2024-09-11'),
                                                              ('user70','ROLE_USER','사용자70','user70@gmail.com','010-7777-0000',NULL,'user1234','activated','2020-10-01','2024-09-11'),
                                                              ('user71','ROLE_USER','사용자71','user71@gmail.com','010-7777-1111',NULL,'user1234','activated','2020-10-01','2024-09-11'),
                                                              ('user72','ROLE_USER','사용자72','user72@gmail.com','010-7777-2222',NULL,'user1234','activated','2020-10-01','2024-09-11'),
                                                              ('user73','ROLE_USER','사용자73','user73@gmail.com','010-7777-3333',NULL,'user1234','activated','2020-10-01','2024-09-11'),
                                                              ('user74','ROLE_USER','사용자74','user74@gmail.com','010-7777-4444',NULL,'user1234','activated','2021-04-01','2024-09-11'),
                                                              ('user75','ROLE_USER','사용자75','user75@gmail.com','010-7777-5555',NULL,'user1234','activated','2021-04-01','2024-09-11'),
                                                              ('user76','ROLE_USER','사용자76','user76@gmail.com','010-7777-6666',NULL,'user1234','activated','2021-04-01','2024-09-11'),
                                                              ('user77','ROLE_USER','사용자77','user77@gmail.com','010-7777-7777',NULL,'user1234','activated','2021-04-01','2024-09-11'),
                                                              ('user78','ROLE_USER','사용자78','user78@gmail.com','010-7777-8888',NULL,'user1234','activated','2021-04-01','2024-09-11'),
                                                              ('user79','ROLE_USER','사용자79','user79@gmail.com','010-7777-9999',NULL,'user1234','activated','2021-04-01','2024-09-11'),
                                                              ('user80','ROLE_USER','사용자80','user80@gmail.com','010-8888-0000',NULL,'user1234','activated','2021-04-01','2024-09-11'),
                                                              ('user81','ROLE_USER','사용자81','user81@gmail.com','010-8888-1111',NULL,'user1234','activated','2021-04-01','2024-09-11'),
                                                              ('user82','ROLE_USER','사용자82','user82@gmail.com','010-8888-2222',NULL,'user1234','activated','2021-04-01','2024-09-11'),
                                                              ('user83','ROLE_USER','사용자83','user83@gmail.com','010-8888-3333',NULL,'user1234','activated','2021-04-01','2024-09-11'),
                                                              ('user84','ROLE_USER','사용자84','user84@gmail.com','010-8888-4444',NULL,'user1234','activated','2021-04-01','2024-09-11'),
                                                              ('user85','ROLE_USER','사용자85','user85@gmail.com','010-8888-5555',NULL,'user1234','activated','2021-04-01','2024-09-11'),
                                                              ('user86','ROLE_USER','사용자86','user86@gmail.com','010-8888-6666',NULL,'user1234','activated','2021-07-01','2024-09-11'),
                                                              ('user87','ROLE_USER','사용자87','user87@gmail.com','010-8888-7777',NULL,'user1234','activated','2021-07-01','2024-09-11'),
                                                              ('user88','ROLE_USER','사용자88','user88@gmail.com','010-8888-8888',NULL,'user1234','activated','2021-07-01','2024-09-11'),
                                                              ('user89','ROLE_USER','사용자89','user89@gmail.com','010-8888-9999',NULL,'user1234','activated','2021-07-01','2024-09-11'),
                                                              ('user90','ROLE_USER','사용자90','user90@gmail.com','010-9999-0000',NULL,'user1234','activated','2021-07-01','2024-09-11'),
                                                              ('user91','ROLE_USER','사용자91','user91@gmail.com','010-9999-1111',NULL,'user1234','activated','2021-07-01','2024-09-11'),
                                                              ('user92','ROLE_USER','사용자92','user92@gmail.com','010-9999-2222',NULL,'user1234','activated','2021-07-01','2024-09-11'),
                                                              ('user93','ROLE_USER','사용자93','user93@gmail.com','010-9999-3333',NULL,'user1234','activated','2022-01-01','2024-09-11'),
                                                              ('user94','ROLE_USER','사용자94','user94@gmail.com','010-9999-4444',NULL,'user1234','activated','2022-01-01','2024-09-11'),
                                                              ('user95','ROLE_USER','사용자95','user95@gmail.com','010-9999-5555',NULL,'user1234','activated','2022-01-01','2024-09-11'),
                                                              ('user96','ROLE_USER','사용자96','user96@gmail.com','010-9999-6666',NULL,'user1234','activated','2022-01-01','2024-09-11'),
                                                              ('user97','ROLE_USER','사용자97','user97@gmail.com','010-9999-7777',NULL,'user1234','activated','2022-01-01','2024-09-11'),
                                                              ('user98','ROLE_USER','사용자98','user98@gmail.com','010-9999-8888',NULL,'user1234','activated','2022-01-01','2024-09-11'),
                                                              ('user99','ROLE_USER','사용자99','user99@gmail.com','010-9999-9999',NULL,'user1234','activated','2022-01-01','2024-09-11');
