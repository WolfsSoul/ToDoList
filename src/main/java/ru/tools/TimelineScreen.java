package ru.tools;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.*;
import ru.tools.list.Example;
import ru.tools.list.ToDoList;
import ru.tools.presenter.LogoutBehavior;
import ru.tools.list.ListSecond;

import java.security.Principal;
import java.util.Date;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;
import static com.vaadin.ui.Alignment.MIDDLE_RIGHT;

/**
 * Created by Admin on 6/9/2017.
 */
@Title("Добрпо пожаловать!")
public class TimelineScreen extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public TimelineScreen() {

		setMargin(true);

		Label label = new Label(VaadinSession.getCurrent()
				.getAttribute(Principal.class).getName());

		PopupDateField dateField = new PopupDateField();
		dateField.setValue(new Date());
		dateField.setResolution(Resolution.MINUTE);

		/*final Button toTasks = new Button("Список дел", new Button.ClickListener() {
			public void buttonClick(Button.ClickEvent e) {
				UI.getCurrent().setContent(new ToDoList());
			}
		});*/

		Button button = new Button("Logout");
		Button lolButton = new Button("Список дел 2");

		button.addClickListener(new LogoutBehavior());

		HorizontalLayout menuBar = new HorizontalLayout(label, dateField, button);

		menuBar.setWidth(100, PERCENTAGE);
		menuBar.setComponentAlignment(button, MIDDLE_RIGHT);

		addComponent(menuBar);

		final Button list = new Button("Список дел");
		//final Button listSecond = new Button("Список 2");
		HorizontalLayout stuff = new HorizontalLayout(list, lolButton);
		addComponent(stuff);
		stuff.setMargin(true);
		stuff.setSpacing(true);

		list.addClickListener(new Button.ClickListener() {
			public void buttonClick(Button.ClickEvent clickEvent) {
				UI.getCurrent().setContent(new ToDoList());
			}
		});
		/*listSecond.addClickListener(new Button.ClickListener() {
			public void buttonClick(Button.ClickEvent clickEvent) {
				UI.getCurrent().setContent(new ListSecond());
			}
		});*/
		lolButton.addClickListener(new Button.ClickListener() {
			public void buttonClick(Button.ClickEvent clickEvent) {
				UI.getCurrent().setContent(new Example());
			}
		});

	};

}
