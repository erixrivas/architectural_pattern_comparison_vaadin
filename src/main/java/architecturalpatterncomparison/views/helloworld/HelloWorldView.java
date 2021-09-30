package architecturalpatterncomparison.views.helloworld;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import architecturalpatterncomparison.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Hello World")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class HelloWorldView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;
    //private HelloWorld helloWorld;

    public HelloWorldView() {
        setId("hello-world-view");
        name = new TextField("Your name");
        sayHello = new Button("Say hello");

    //    helloWorld= new HelloWorld();

      //  String text=helloWorld.getContent().getText();
  /*      helloWorld.getContent().setText("OtherText");
        String text2=helloWorld.getContent().getText();
*/


        sayHello.addThemeVariants();
        add(name, sayHello);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });

    }

}
