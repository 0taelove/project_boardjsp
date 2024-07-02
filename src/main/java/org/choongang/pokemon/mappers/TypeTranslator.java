package org.choongang.pokemon.mappers;

import java.util.HashMap;
import java.util.Map;

public class TypeTranslator {
    private static final Map<String, String> typeMap = new HashMap<>();

    static {
        typeMap.put("normal", "노말");
        typeMap.put("fighting", "격투");
        typeMap.put("flying", "비행");
        typeMap.put("poison", "독");
        typeMap.put("ground", "땅");
        typeMap.put("rock", "바위");
        typeMap.put("bug", "벌레");
        typeMap.put("ghost", "고스트");
        typeMap.put("steel", "강철");
        typeMap.put("fire", "불");
        typeMap.put("water", "물");
        typeMap.put("grass", "풀");
        typeMap.put("electric", "전기");
        typeMap.put("psychic", "에스퍼");
        typeMap.put("ice", "얼음");
        typeMap.put("dragon", "드래곤");
        typeMap.put("dark", "악");
        typeMap.put("fairy", "페어리");
        typeMap.put("stellar", "스텔라");
    }

    public static String translate(String type) {
        return typeMap.getOrDefault(type, type); // 매핑이 없으면 원래 문자열 반환
    }
}

