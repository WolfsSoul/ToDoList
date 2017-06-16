package ru.tools.list;

import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import ru.tools.list.Task;

import java.util.Arrays;
import java.util.List;


/**
 * Created by Admin on 6/15/2017.
 */
public class MyForm extends FormLayout {

    List<Task.TaskCategory> categories = Arrays.asList(Task.TaskCategory.WORK, Task.TaskCategory.HOME, Task.TaskCategory.SHOPPING, Task.TaskCategory.OTHER);

    @PropertyId("taskText")
    TextField taskField = new TextField("Введите новое задание:");
    @PropertyId("taskCategory")
    ComboBox taskType = new ComboBox("Тип задания", categories);

    public MyForm(){
        setSpacing(true);
        setMargin(true);
        taskField.setWidth(20, Sizeable.Unit.PERCENTAGE);

        //taskType.setItemCaption();

        addComponent(taskField);
        addComponent(taskType);
    }
}
