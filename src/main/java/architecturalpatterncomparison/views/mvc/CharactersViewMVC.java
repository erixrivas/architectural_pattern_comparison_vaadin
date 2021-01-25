package architecturalpatterncomparison.views.mvc;

import architecturalpatterncomparison.model.entities.Character;
import architecturalpatterncomparison.views.main.MainView;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "CharactersViewMVC", layout = MainView.class)
@PageTitle("Hello World")
//@CssImport("./styles/views/helloworld/hello-world-view.css")
public class CharactersViewMVC extends VerticalLayout {

    TextField characterFilter = new TextField("Filter By Name");
    Grid<Character> grid = new Grid<>();
    Div characterDetail = new Div();
     TextField name= new TextField("name");
     TextField status= new TextField("Status");
     TextField species=new TextField("species");
     TextField type=new TextField("type");
     TextField gender= new TextField("gender");
     Image image = new Image();
    public CharactersViewMVC(){
        super();
        configGrid();
        drawCharacterDetail();
        add(characterFilter,grid,characterDetail);
        new CharactersController(this);
        setHeightFull();
    }

    private void drawCharacterDetail() {
        characterDetail.add(image,name,status,species,type,gender);
        characterDetail.setVisible(false);
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
      //  grid.setHeightByRows(true);
      //  grid.setHeightFull();

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

    public void setCharacterDetail(Div characterDetail) {
        this.characterDetail = characterDetail;
    }


    public TextField getName() {
        return name;
    }

    public void setName(TextField name) {
        this.name = name;
    }

    public TextField getStatus() {
        return status;
    }

    public void setStatus(TextField status) {
        this.status = status;
    }

    public TextField getSpecies() {
        return species;
    }

    public void setSpecies(TextField species) {
        this.species = species;
    }

    public TextField getType() {
        return type;
    }

    public void setType(TextField type) {
        this.type = type;
    }

    public TextField getGender() {
        return gender;
    }

    public void setGender(TextField gender) {
        this.gender = gender;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
