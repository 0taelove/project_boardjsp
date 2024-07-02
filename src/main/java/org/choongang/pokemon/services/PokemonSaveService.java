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
        String secondaryTypeName = data.getSecondaryTypeName();
        String translatedPrimaryTypeName = TypeTranslator.translate(primaryTypeName);
        String translatedSecondaryTypeName = TypeTranslator.translate(secondaryTypeName);

        PokemonDetail detail = PokemonDetail.builder()
                .seq(data.getId())
                .name(data.getName())
                .nameKr(data.getNameKr())
                .types1(translatedPrimaryTypeName) // 첫 번째 번역된 타입 저장
                .types2(translatedSecondaryTypeName) // 두 번째 번역된 타입 저장
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
