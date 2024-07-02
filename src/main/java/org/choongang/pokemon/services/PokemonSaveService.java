package org.choongang.pokemon.services;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Service;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.entities.api.Pokemon;
import org.choongang.pokemon.mappers.PokemonMapper;
import org.choongang.pokemon.mappers.TypeTranslator;

@Service
@RequiredArgsConstructor
public class PokemonSaveService {
    private final PokemonMapper mapper;

    public boolean save(Pokemon data) {
        String primaryTypeName = data.getPrimaryTypeName();
        String translatedTypeName = TypeTranslator.translate(primaryTypeName);

        PokemonDetail detail = PokemonDetail.builder()
                .seq(data.getId())
                .name(data.getName())
                .nameKr(data.getNameKr())
                .types(translatedTypeName) // 번역된 타입을 저장
                .weight(data.getWeight())
                .height(data.getHeight())
                .baseExperience(data.getBase_experience())
                .frontImage(data.getSprites().getOther().getOfficial_artwork().getFront_default())
                .backImage(data.getSprites().getBack_default())
                .rawData(data.getRawData())
                .description(data.getDescription())
                .build();
        int result = mapper.register(detail);

        return result > 0;
    }
}
