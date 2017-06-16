package ru.tools.list;

import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickListener;

/**
 * Created by Admin on 6/9/2017.
 */
public class DeleteTask extends VerticalLayout implements ClickListener {
    private static final long serialVersionUID = 1L;
    private final HorizontalLayout taskLine;

    public DeleteTask(HorizontalLayout taskLine) {
        this.taskLine = taskLine;
    }

    public void buttonClick(Button.ClickEvent deleteEvent) {
        deleteLine(this.taskLine);
        removeComponent(taskLine);
        addComponent(new Label("congrats!"));
        Notification.show("Задание удалено");
    }

    public void deleteLine(HorizontalLayout line) {
        removeComponent(line);
    }
}
