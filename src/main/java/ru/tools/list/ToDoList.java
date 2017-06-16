package ru.tools.list;

import com.vaadin.annotations.Title;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.ComboBox.*;

import java.util.Arrays;
import java.util.List;

import static com.vaadin.ui.Notification.Type.TRAY_NOTIFICATION;
import static ru.tools.list.Task.TaskCategory.OTHER;

/**
 * Created by Admin on 6/9/2017.
 */
@Title("Список дел")
public class ToDoList extends VerticalLayout {
    private static final long serialVersionUID = 1L;

    List<Task.TaskCategory> categories = Arrays.asList(Task.TaskCategory.WORK, Task.TaskCategory.HOME, Task.TaskCategory.SHOPPING, Task.TaskCategory.OTHER);

    private TextField taskField = new TextField("Введите новое задание:");
    private ComboBox taskType = new ComboBox("Тип задания", categories);

    private Button addButton = new Button("Добавить новое");
    private VerticalLayout tasks = new VerticalLayout();

    private FormLayout formLayout = new FormLayout(taskField, taskType);

    public ToDoList() {

        setMargin(true);
        taskField.setWidth(20, Sizeable.Unit.PERCENTAGE);

        addComponent(tasks);

        addComponent(taskField);
        taskField.addTextChangeListener(new FieldEvents.TextChangeListener(){
            public void textChange (FieldEvents.TextChangeEvent event) {
                event.getText();
            }
        });

        addComponent(taskType);
        taskType.addBlurListener(new FieldEvents.BlurListener() {
            public void blur(FieldEvents.BlurEvent blurEvent) {
                blurEvent.getComponent();
            }
        });

        addComponent(addButton);
        addButton.addClickListener(new AddBehavior(taskField, taskType, tasks));

        /*Task task = new Task("");
        BeanItem<Task> item = new BeanItem<Task>(task);
        //TextField tasksField = new TextField(item.getItemProperty("taskText"));

        final FieldGroup taskBinder = new FieldGroup(item);
        Field<?> tasksField = taskBinder.buildAndBind("Введите новое задание:","taskText");
        Field<?> tasksType = taskBinder.buildAndBind(null, "taskCategory");
        Button addingButton = new Button("Добавить");


        abstract class AbstractCommitDiscardClickListener implements Button.ClickListener {
            private final String operation;

            public AbstractCommitDiscardClickListener(String operation) {
                this.operation = operation;
            }

            public void buttonClick(Button.ClickEvent event) {
                Notification.show("Before " + operation + ": "
                                + taskBinder.getItemDataSource().toString(),
                        TRAY_NOTIFICATION);
                execute();
                Notification.show("After " + operation + ": "
                                + taskBinder.getItemDataSource().toString(),
                        TRAY_NOTIFICATION);
            }

            protected abstract void execute();
        }

        addingButton.addClickListener(new AbstractCommitDiscardClickListener("commit") {
            protected void execute() {
                try {
                    taskBinder.commit();
                } catch (CommitException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        FormLayout form = new FormLayout(tasksField, tasksType, new HorizontalLayout(addingButton));
        addComponent(form);*/
    }

    //Property<String> task = new ObjectProperty<String>("");

}
