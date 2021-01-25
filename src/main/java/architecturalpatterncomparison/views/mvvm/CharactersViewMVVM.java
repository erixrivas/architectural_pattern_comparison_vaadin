package architecturalpatterncomparison.views.mvvm;

import architecturalpatterncomparison.model.entities.Character;
import architecturalpatterncomparison.views.main.MainView;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.stream.Collectors;

@Route(value = "CharactersViewMvvM", layout = MainView.class)
@PageTitle("Hello World")
//@CssImport("./styles/views/helloworld/hello-world-view.css")
public class CharactersViewMVVM extends VerticalLayout {


    TextField characterFilter = new TextField("Filter By Name");
    Grid<Character> grid = new Grid<>();

    Div characterDetail = new Div();
    TextField name= new TextField("name");
    TextField status= new TextField("Status");
    TextField species=new TextField("species");
    TextField type=new TextField("type");
    TextField gender= new TextField("gender");
    Image image = new Image();

    Binder<Character> binder = new Binder<Character>();
    CharactersViewModel charactersViewModel= new CharactersViewModel();
    public CharactersViewMVVM(){
        super();
        configGrid();
        drawCharacterDetail();
        initBinder();
        add(characterFilter,grid,characterDetail);
        charactersViewModel=new CharactersViewModel();

        characterFilter.addValueChangeListener(e->charactersViewModel.onFilterTextChange(e,this));
        grid.addSelectionListener(e->charactersViewModel.showCharacterDetail(e,this));
        grid.setItems(charactersViewModel.getCharacters());
        setHeightFull();
    }

    private void drawCharacterDetail() {
        characterDetail.add(image,name,status,species,type,gender);
        characterDetail.setVisible(false);
    }
    private void initBinder(){
        binder.forField(name).bind(Character::getName,null);
        binder.forField(status).bind(Character::getStatus,null);
        binder.forField(species).bind(Character::getSpecies,null);
        binder.forField(type).bind(Character::getType,null);
        binder.forField(gender).bind(Character::getGender,null);

    }

    public void setCharacterToBinder(Character character){
        if (character!=null){
            image.setSrc(character.getImage());
            binder.setBean(character);
        }

    }

    private void configGrid() {
        grid.addComponentColumn(element ->{ Image image = new Image(element.getImage(), "alt text");
            image.setHeight("100px");
            return  image;}).setHeader("Photo");
        grid.addColumn(Character::getName).setHeader("Name");
        grid.addColumn(Character::getLocation).setHeader("Location");
        grid.addColumn(Character::getSpecies).setHeader("Species");
      //  grid.setPageSize(10);
        grid.setMultiSort(true);
       // grid.setHeightByRows(true);
       // grid.setHeightFull();
    }

    public TextField getCharacterFilter() {
        return characterFilter;
    }

    public void setCharacterFilter(TextField characterFilter) {
        this.characterFilter = characterFilter;
    }

     public Grid<Character> getGrid() {
        return grid;
    }

    public void setGrid(Grid<Character> grid) {
        this.grid = grid;
    }

    public Div getCharacterDetail() {
        return characterDetail;
    }










}