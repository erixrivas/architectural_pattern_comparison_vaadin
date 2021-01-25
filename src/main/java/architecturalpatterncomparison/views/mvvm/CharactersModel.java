package architecturalpatterncomparison.views.mvvm;


import architecturalpatterncomparison.model.entities.Character;
import architecturalpatterncomparison.model.entities.CharacterInfoResult;
import architecturalpatterncomparison.model.api.APIFunctions;
import architecturalpatterncomparison.model.api.CharacterClient;
import architecturalpatterncomparison.views.mvp.CharactersContrac;

import java.util.Arrays;
import java.util.List;

public class CharactersModel {





    public List<Character> getCharacters() {
        // TODO Auto-generated method stub

        CharacterClient characterClient = APIFunctions.buildAPI(CharacterClient.class,"https://rickandmortyapi.com/api/character" );
	/*Character rick = characterClient.findById(1);
	rick.getLocation();*/
        CharacterInfoResult characters = characterClient.findAll();
        System.out.println(characters.getResults().length);

        return  Arrays.asList(characters.getResults() );
    }

}
