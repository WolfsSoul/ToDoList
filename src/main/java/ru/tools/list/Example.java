package ru.tools.list;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.ui.*;

import static com.vaadin.ui.Notification.Type.TRAY_NOTIFICATION;

/**
 * Created by Admin on
 */
public class Example extends FormLayout {

    // Have an item
    //PropertysetItem item = new PropertysetItem();
    Task task = new Task("");
    BeanItem<Task> item = new BeanItem<Task>(task);
    FieldGroup taskBinder = new FieldGroup(item);
    private Button addButton = new Button("Добавить");
    private VerticalLayout tasks = new VerticalLayout();

    abstract class AbstractCommitDiscardClickListener implements Button.ClickListener {
        private final String operation;

        public AbstractCommitDiscardClickListener(String operation) {
            this.operation = operation;
        }

        public void buttonClick(Button.ClickEvent event) {
            /*Notification.show("Before " + operation + ": "
                            + taskBinder.getItemDataSource().toString(),
                    TRAY_NOTIFICATION);*/
            execute();
            /*Notification.show("After " + operation + ": "
                            + taskBinder.getItemDataSource().toString(),
                    TRAY_NOTIFICATION);*/
        }

        protected abstract void execute();
    }

    public Example() {
        // Create one
        final MyForm form = new MyForm();

        item.addItemProperty("taskText", new ObjectProperty<String>(""));
        item.addItemProperty("taskCategory", new ObjectProperty<Task.TaskCategory>(Task.TaskCategory.OTHER));


        taskBinder.setBuffered(true);
        taskBinder.bindMemberFields(form);

        addComponent(tasks);
        addComponent(form);
        addComponent(addButton);

        addButton.addClickListener(new AddBehavior(form.taskField, form.taskType, tasks));
        addButton.addClickListener(new AbstractCommitDiscardClickListener("commit") {
            protected void execute() {
                try {
                    taskBinder.commit();
                    //Notification.show("Новое задание добавлено!");
                } catch (FieldGroup.CommitException e) {
                    Notification.show("Ошибка");
                    throw new RuntimeException(e);
                }
            }
        });

    }

}
