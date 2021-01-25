package architecturalpatterncomparison.views.mvc;

import architecturalpatterncomparison.model.api.APIFunctions;
import architecturalpatterncomparison.model.api.CharacterClient;
import architecturalpatterncomparison.model.entities.Character;
import architecturalpatterncomparison.model.entities.CharacterInfoResult;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.SelectionEvent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CharactersController {
    private List<Character> characterList=new CharactersModel().getCharacters();
    private CharactersViewMVC view;


    public CharactersController(CharactersViewMVC view) {
        this.view = view;
        setFilter();

        view.getGrid().setItems(characterList);
        view.getGrid().addSelectionListener(e->showCharacterDetail(e));

    }

    public void showCharacterDetail(SelectionEvent<Grid<Character>, Character> e) {
        if (e.isFromClient()) {
            if (!e.getFirstSelectedItem().isEmpty()) {
                Character character = e.getFirstSelectedItem().get();
                view.getName().setValue(character.getName());
                view.getStatus().setValue(character.getStatus());
                view.getSpecies().setValue(character.getSpecies());
                view.getType().setValue(character.getType());
                view.getGender().setValue(character.getGender());
                view.getImage().setSrc(character.getImage());
                view.getCharacterDetail().setVisible(true);
            }else
            {
                view.getCharacterDetail().setVisible(false);
            }
        }



    }

    private void configGrid() {

    }

    private void setFilter() {
        view.getCharacterFilter().addValueChangeListener(e->this.onFilterTextChange(e));

    }






    private void onFilterTextChange(AbstractField.ComponentValueChangeEvent<TextField, String> e) {
        if (e.getValue().isBlank()){
            view.getGrid().setItems(characterList);
        }
        else
            view.getGrid().setItems(characterList.stream()
                    .filter(character-> character.getName().toUpperCase().contains(e.getValue().toUpperCase()))
                    .collect(Collectors.toList()));



    }


    private Boolean caseInsensitiveContains(String where, String what) {
        if (where != null && what != null)
            return where.toString().toLowerCase().contains(what.toLowerCase());
        else
            return false;
        // return where.toLowerCase().contains(what.toLowerCase());
    }




    private List<Character> getCharacters() {
        // TODO Auto-generated method stub

        CharacterClient characterClient = APIFunctions.buildAPI(CharacterClient.class,"https://rickandmortyapi.com/api/character" );
	/*Character rick = characterClient.findById(1);
	rick.getLocation();*/
        CharacterInfoResult characters = characterClient.findAll();
        System.out.println(characters.getResults().length);

        return  Arrays.asList(characters.getResults() );
    }

}

