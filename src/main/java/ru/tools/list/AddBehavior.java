package ru.tools.list;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.data.util.converter.StringToEnumConverter;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickListener;


/**
 * Created by Admin on 6/9/2017.
 */
public class AddBehavior extends VerticalLayout implements ClickListener {
    private static final long serialVersionUID = 1L;

    private final TextField taskField;
    private final ComboBox taskType;
    private final VerticalLayout tasks;

    public AddBehavior(TextField taskField, ComboBox taskType, VerticalLayout tasks) {
        this.taskField = taskField;
        this.taskType = taskType;
        this.tasks = tasks;
    }

    public void buttonClick(Button.ClickEvent addNew) {

        String task = taskField.getValue();
        String taskCategory = taskType.getValue().toString();
        //StringToEnumConverter stringToEnumConverter = new StringToEnumConverter();
        //stringToEnumConverter.convertToModel("", stringToEnumConverter.getModelType());
        //StringToEnumConverter.stringToEnum("", )
        //String taskCategory = StringToEnumConverter(x.toString(), Task.TaskCategory.class);

        Task taskItem = new Task(task, Task.TaskCategory.valueOf(taskCategory));

        final Label item = new Label(task);
        final Label itemType = new Label(taskCategory);
        final Button done = new Button();
        done.setIcon(new ThemeResource("images/tick.png"));
        done.addStyleName("borderless");
        Button delete = new Button();
        delete.setIcon(new ThemeResource("images/cross.png"));
        delete.addStyleName("borderless");

        final HorizontalLayout taskLine = new HorizontalLayout(item, itemType, done, delete);
        taskLine.setWidth(80, Sizeable.Unit.PERCENTAGE);
        taskLine.setComponentAlignment(done, Alignment.MIDDLE_RIGHT);
        taskLine.setComponentAlignment(delete, Alignment.MIDDLE_RIGHT);
        done.setDisableOnClick(true);

        tasks.addComponent(taskLine);
        taskField.setValue("");

        done.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent green) {
                item.setStyleName("done");
                done.setIcon(null);
                //taskLine.removeComponent(done);
                Notification.show("Задание выполнено!");
            }
        });

        delete.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent remove) {
                tasks.removeComponent(taskLine);
                Notification.show("Задание удалено");
            }
        });

        Notification.show("Новое задание добавлено");
    }

}
