package ru.tools.list;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;

import static com.vaadin.ui.Notification.Type.TRAY_NOTIFICATION;

/**
 * Created by Admin on 6/14/2017.
 */
public class ListSecond extends FormLayout {
    private static final long serialVersionUID = 1L;

    private FormLayout form = new FormLayout();

    Task task = new Task("");
    BeanItem<Task> item = new BeanItem<Task>(task);

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

    private FieldGroup taskBinder = new FieldGroup(item);

    private Field<?> taskField = taskBinder.buildAndBind("Введите новое задание:","taskText");
    private Field<?> taskType = taskBinder.buildAndBind(null, "taskCategory");
    private Button addButton = new Button("Добавить");


    public ListSecond() {
        setMargin(true);
        //addComponent(form);

        //form.addComponent(taskBinder.buildAndBind("Введите новое задание:","taskText"));
        //form.addComponent(taskBinder.buildAndBind(null, "taskCategory"));
        taskField.setWidth(20, Sizeable.Unit.PERCENTAGE);
        FormLayout form = new FormLayout(taskField, taskType, new HorizontalLayout(addButton));
        addComponent(form);

        //TextField tasksField = new TextField(item.getItemProperty("taskText"));

        /*taskField.addTextChangeListener(new FieldEvents.TextChangeListener(){
            public void textChange (FieldEvents.TextChangeEvent event) {
                event.getText();
            }
        });



        taskType.addBlurListener(new FieldEvents.BlurListener() {
            public void blur(FieldEvents.BlurEvent blurEvent) {
                blurEvent.getComponent();
            }
        });*/





        /*addButton.addClickListener(new AbstractCommitDiscardClickListener("commit") {
            protected void execute() {
                try {
                    taskBinder.commit();
                } catch (FieldGroup.CommitException e) {
                    throw new RuntimeException(e);
                }
            }
        });*/

    }

}
