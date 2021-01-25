package architecturalpatterncomparison.views.mvp;

import architecturalpatterncomparison.model.entities.Character;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.SelectionEvent;

import java.util.List;

public interface CharactersContrac {
    interface View{
        TextField getCharacterFilter();
        Grid<Character> getGrid();
        void setCharacterToBinder(Character character);
        Div getCharacterDetail();
    }

    interface Presenter{
        void onFilterTextChange(AbstractField.ComponentValueChangeEvent<TextField, String> e);
        void setGridItems();
        void  setFilter();
        void  setGridSelectionListener();

    }
    interface Model {
        List<Character> getCharacters();
    }
}
