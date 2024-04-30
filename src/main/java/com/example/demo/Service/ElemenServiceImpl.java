package com.example.demo.Service;

import com.example.demo.jsonReader.Json;
import com.example.demo.model.PowerElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ElemenServiceImpl {

    @Async
    public List<PowerElement> readAll() {
        JSONArray jsonArray = Json.JsonRead();
        return convertJSONArrayToPowerElementList(jsonArray);
    }

    private List<PowerElement> convertJSONArrayToPowerElementList(JSONArray jsonArray) {
        List<PowerElement> powerElements = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            PowerElement powerElement = new PowerElement(
                    jsonObject.getString("brand"),
                    jsonObject.getString("substanceAnode"),
                    jsonObject.getString("substanceCatode"),
                    jsonObject.getInt("capacity"),
                    jsonObject.getInt("voltage"),
                    jsonObject.getInt("id")
            );
            powerElements.add(powerElement);
        }
        return powerElements;
    }

    public List<PowerElement> getById(int id) {
        JSONArray jsonArray = Json.getById(id);
        return convertJSONArrayToPowerElementList(jsonArray);
    }

    public String addPowerElement(PowerElement powerElement) {
        return Json.JsonPut(powerElement);
    }

    public org.json.simple.JSONObject getStatitic(){
        return Json.getStatisticVoltage();
    }
}
