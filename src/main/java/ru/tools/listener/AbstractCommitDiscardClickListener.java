package ru.tools.listener;

import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import ru.tools.list.ToDoList.*;

import static com.vaadin.ui.Notification.Type.TRAY_NOTIFICATION;

/**
 * Created by Admin on 6/14/2017.
 */
abstract class AbstractCommitDiscardClickListener implements Button.ClickListener {
    private final String operation;

    public AbstractCommitDiscardClickListener(String operation) {
        this.operation = operation;
    }

    /*public void buttonClick(Button.ClickEvent event) {
        Notification.show("Before " + operation + ": "
                        + taskBinder.getItemDataSource().toString(),
                TRAY_NOTIFICATION);
        execute();
        Notification.show("After " + operation + ": "
                        + taskBinder.getItemDataSource().toString(),
                TRAY_NOTIFICATION);
    }

    protected abstract void execute();*/
}
