package architecturalpatterncomparison.views.mvp;

import architecturalpatterncomparison.model.entities.Character;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.SelectionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CharactersPresenter  implements  CharactersContrac.Presenter{
    private CharactersModel charactersModel = new CharactersModel();
    private CharactersContrac.View view;
    private List<Character> characterList = new ArrayList<>();

    public CharactersPresenter(CharactersContrac.View view) {
        this.view = view;
        characterList=charactersModel.getCharacters();


    }

    public void setGridItems(){
        view.getGrid().setItems(characterList);
    }

    public void setFilter() {
        view.getCharacterFilter().addValueChangeListener(e->this.onFilterTextChange(e));

    }

    @Override
    public void setGridSelectionListener() {
        view.getGrid().addSelectionListener(e->showCharacterDetail(e))  ;
    }


    @Override
    public void onFilterTextChange(AbstractField.ComponentValueChangeEvent<TextField, String> e) {
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



    public void showCharacterDetail(SelectionEvent<Grid<Character>, Character> e) {
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
