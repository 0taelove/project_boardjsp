package org.choongang.pokemon.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PokemonDetail extends AbstractPokemonDetail {
    private long seq;
    private long num;
    private String name;
    private String nameKr;
    private String types1; // 첫 번째 타입 필드
    private String types2; // 두 번째 타입 필드
    private int weight;
    private int height;
    private int baseExperience;
    private String frontImage;
    private String backImage;
    private String rawData;
    private String description;
}
