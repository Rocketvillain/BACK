package com.rocket.healingpets.etc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonManipulation {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\80409\\Desktop\\JDH\\꾸러기로켓단\\Project\\Back\\src\\main\\resources\\강남구_동물병원.json";

        // JsonManipulation 클래스의 인스턴스 생성
        JsonManipulation jsonManipulation = new JsonManipulation();

        // 폐업인 객체들 삭제처리
//        jsonManipulation.deleteObjectByValue(filePath);

        // 원하는 수만큼 병원 삭제
//        jsonManipulation.deleteObjects(filePath,10);

        // 병원 api에서 가져온 json 정보에서 병원 엔티티에 담아줄 내용 sql문 자동생성
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonObject = new JSONObject(content);

        JSONArray dataArray = jsonObject.getJSONArray("DATA");

        StringBuilder sqlBuilder = new StringBuilder();

        int count = 1;
        String imgPath = "images/hospital";

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject item = dataArray.getJSONObject(i);
            String name = item.getString("bplcnm");
            String owner_name = "병원장" + count;
            String owner_image = imgPath + "/owner/" + count + ".png";
            String info = "저희 " + name + "을 방문해주셔서 감사합니다!";
            String info_image = imgPath + "/info/" + count + ".png";
            String address = item.getString("sitewhladdr");

            String formattedCount = String.format("%02d", count);
            String business_no = "124-45-109" + formattedCount;

            String siteTel = item.getString("sitetel"); // 혹시 몰라 담아놓기만 함.

            sqlBuilder.append(String.format("INSERT INTO hospital (name, owner_name, owner_image, info, info_image, address, business_no, created_date, last_modified_date) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);\n", name, owner_name, owner_image, info, info_image, address, business_no));
            count++;
        }

        System.out.println(sqlBuilder.toString());
    }

    // 원하는 수만큼 객체 삭제
    private void deleteObjects(String filePath, int deleteNumbers) {

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);

            JSONArray dataArray = jsonObject.getJSONArray("DATA");

            int deletedCount = 0;

            for (int i = dataArray.length() - 1; i > 0; i--) {
                dataArray.remove(i);
                deletedCount++;
                if (deletedCount >= deleteNumbers) {
                    break;
                }
            }

            System.out.println("현재 병원 수 = " + dataArray.length());

            Files.write(Paths.get(filePath), jsonObject.toString(4).getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // 폐업인 객체들 삭제처리
    public void deleteObjectByValue(String filePath) {

        try {
            // 1. JSON 파일 읽기
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);

            // 2. "data" 배열 가져오기 (가정: 최상위 객체에 "data"라는 배열이 있음)
            JSONArray dataArray = jsonObject.getJSONArray("DATA");

            // 3. "폐업"인 항목 삭제
            for (int i = dataArray.length() - 1; i >= 0; i--) {
                JSONObject item = dataArray.getJSONObject(i);
                if (item.getString("dtlstatenm").equals("폐업")) {
                    dataArray.remove(i);
                }
            }

            System.out.println("병원 수 : " +dataArray.length());

            // 4. JSON 파일 저장
            Files.write(Paths.get(filePath), jsonObject.toString(4).getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }
}
