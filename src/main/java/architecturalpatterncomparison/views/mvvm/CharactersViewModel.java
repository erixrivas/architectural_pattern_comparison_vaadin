package architecturalpatterncomparison.views.mvvm;

import architecturalpatterncomparison.model.entities.Character;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.SelectionEvent;

import java.util.List;
import java.util.stream.Collectors;

public class CharactersViewModel {
    List<Character> characterList=new CharactersModel().getCharacters();

    public void onFilterTextChange(AbstractField.ComponentValueChangeEvent<TextField, String> e,CharactersViewMVVM view) {
        if (e.getValue().isBlank()){
            view.getGrid().setItems(characterList);
        }
        else
            view.getGrid().setItems(characterList.stream()
                    .filter(character-> character.getName().toUpperCase().contains(e.getValue().toUpperCase()))
                    .collect(Collectors.toList()));



    }



    java.util.List<Character> getCharacters(){
        return characterList;
    }



    public void showCharacterDetail(SelectionEvent<Grid<Character>, Character> e,CharactersViewMVVM view) {
        if (e.isFromClient()) {
            if (!e.getFirstSelectedItem().isEmpty()) {
                view.setCharacterToBinder(e.getFirstSelectedItem().get());
                view.getCharacterDetail().setVisible(true);
            } else {
                view.getCharacterDetail().setVisible(false);
            }
        }
    }

}
