DELIMITER $$

CREATE PROCEDURE InsertHospitalSchedules()
BEGIN
    DECLARE hos_id INT;
    DECLARE schedule_date DATE;
    DECLARE start_time TIME;
    DECLARE end_time TIME;
    DECLARE clinic_type VARCHAR(10);
    DECLARE i INT DEFAULT 1;

    WHILE i <= 1000 DO
            SET hos_id = (i MOD 50) + 1;  -- hos_id는 1에서 50까지 순환
            SET schedule_date = DATE('2024-09-01') + (i MOD 30);  -- 2024-09-01부터 2024-09-30까지
            SET start_time = ELT(FLOOR(1 + RAND() * 3), '09:00:00', '10:00:00', '11:00:00');
            SET end_time = ELT(FLOOR(1 + RAND() * 4), '17:00:00', '18:00:00', '19:00:00', '20:00:00');
            SET clinic_type = ELT(FLOOR(1 + RAND() * 3), '진료', '수술', '미용');

            INSERT INTO schedule (hos_id, date, start_time, end_time, clinic_name, is_okay)
            VALUES (hos_id, schedule_date, start_time, end_time, clinic_type, TRUE);

            SET i = i + 1;
    END WHILE;
END $$

DELIMITER ;