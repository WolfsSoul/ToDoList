package ru.tools;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

@Theme("mytheme")
public class MyUI extends UI {
	private static final long serialVersionUID = 1L;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new LoginScreen());
/*
        AbstractSplitPanel mainPanel = new HorizontalSplitPanel();
        mainPanel.setFirstComponent(new LoginScreen());
        mainPanel.setSecondComponent(new TimelineScreen());
        mainPanel.setSplitPosition(20);

        setContent(mainPanel);
*/
/*
        final VerticalLayout mainLayout = new VerticalLayout();
        final TextField name = new TextField();
        name.setCaption("Имя:");
        Button button = new Button("Нажми меня");
        button.addClickListener( e -> {
            mainLayout.addComponent(new Label("Спасибо, " + name.getValue()
                    + ", ништяк!"));
        });
        mainLayout.addComponents(name, button);
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);
*/

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
