package com.example.demo.model;


import com.example.demo.jsonReader.Json;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArrayPowerElement {

    private static final List<PowerElement> ListPower = new ArrayList<>(); // Final - кароче это константа тип реализацию менять нельзя (не можешь ничего писать вместо new Array)

    public void add(PowerElement ElementPower){
        System.out.println(Json.JsonPut(ElementPower));
        ListPower.add(ElementPower);
        Json.JsonPut(ElementPower);
    }

//    public void delete(int ElementPower){
//        PowerElement Element = find(ElementPower);
//        ListPower.remove(Element);
//    }

//    public PowerElement find(int ElementID){
//        for (PowerElement ElementPower: ListPower){
//            if(ElementPower.getID()){
//                return  ElementPower;
//            }
//        }
//        return null;
//    }

    public JSONArray findAll(){
        System.out.println(Json.JsonRead());
        return Json.JsonRead();
    }
}
