package com.example.demo.jsonReader;

import com.example.demo.model.PowerElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class Json  {
    public static String JsonPut(PowerElement powerElement) {
        try {
            JSONTokener tokener = new JSONTokener(new FileReader("data.json"));
            JSONArray jsonArray;
            if (tokener.more()) {
                jsonArray = new JSONArray(tokener);
            } else {
                jsonArray = new JSONArray();
            }

            String IndexNewObject = jsonArray.getJSONObject(jsonArray.length() - 1).optString("id");
            System.out.println(Integer.parseInt(IndexNewObject));
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", Integer.parseInt(IndexNewObject) +1 );
            jsonObject.put("brand", powerElement.getBrand());
            jsonObject.put("substanceAnode", powerElement.getSubstanceAnode());
            jsonObject.put("substanceCatode", powerElement.getSubstanceCatode());
            jsonObject.put("capacity", powerElement.getCapacity());
            jsonObject.put("voltage", powerElement.getVoltage());

            jsonArray.put(jsonObject);

            try (FileWriter file = new FileWriter("data.json")) {
                file.write(jsonArray.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Файл обновлен";
    }

    public static JSONArray JsonRead() {
        try {
            JSONTokener tokener = new JSONTokener(new FileReader("data.json"));
            JSONArray jsonArray;
            if (tokener.more()) {
                jsonArray = new JSONArray(tokener);
            } else {
                jsonArray = new JSONArray();
            }

            return jsonArray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONArray getById(int id) {
        try {
            JSONTokener tokener = new JSONTokener(new FileReader("data.json"));
            JSONArray jsonArray;
            if (tokener.more()) {
                jsonArray = new JSONArray(tokener);
            } else {
                jsonArray = new JSONArray();
            }
            JSONArray resultArray = new JSONArray();
            for(int i=0; i < jsonArray.length(); i++) {
                org.json.JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject.optString("id").equals( Integer.toString(id))) {
                    resultArray.put(jsonObject);
                    return resultArray;
            }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONObject getStatisticVoltage(){
        JSONObject object = new JSONObject();
        int sumVoltage = 0;
        int maxVoltage = 0;
        try {
            JSONTokener tokener = new JSONTokener(new FileReader("data.json"));
            JSONArray jsonArray;
            if (tokener.more()) {
                jsonArray = new JSONArray(tokener);
            } else {
                jsonArray = new JSONArray();
            }
            for(int i=0; i < jsonArray.length(); i++) {
                org.json.JSONObject jsonObject = jsonArray.getJSONObject(i);
                int currentVoltage = jsonObject.getInt("voltage");
                if(currentVoltage > maxVoltage) {
                    maxVoltage = currentVoltage;
                }
                sumVoltage = sumVoltage + jsonObject.getInt("voltage");
                object.put("maxVoltage", maxVoltage);
                object.put("overallVoltage",sumVoltage);
            }
            object.put("averageVoltage", sumVoltage / jsonArray.length());

            return object;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
