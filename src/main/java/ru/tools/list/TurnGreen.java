package ru.tools.list;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;

/**
 * Created by Admin on 6/9/2017.
 */
public class TurnGreen implements ClickListener {
    private static final long serialVersionUID = 1L;

    private final Label item;

    public TurnGreen (Label item) {
        this.item=item;
    }

    public void buttonClick(Button.ClickEvent turnGreen) {

        item.addStyleName("done");
        Notification.show("Задание выполнено!");
    }
}
