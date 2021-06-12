package architecturalpatterncomparison.views.helloworld;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("hello-world")
@NpmPackage(value = "@polymer/paper-input", version = "3.0.2")
@JsModule("./src/hello-world.js")
public class HelloWorld extends PolymerTemplate<BindingModel>  {
    @Id("content")
    private Div content;

    public Div getContent() {
        return content;
    }

    public void setContent(Div content) {
        this.content = content;
    }

    public HelloWorld() {
        setId("template");
        String algo =content.getText();




    }
}


interface BindingModel extends TemplateModel {
    void setHostProperty(String propertyValue);
    String getHostProperty();
}

