package ru.tools.list;

import com.vaadin.data.Property;
import com.vaadin.data.util.PropertysetItem;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 6/14/2017.
 */

public class Task extends PropertysetItem implements Property  {
    private String taskText;
    enum TaskCategory {
        WORK,
        HOME,
        SHOPPING,
        OTHER
    };
    //List<TaskCategory> categories = Arrays.asList(TaskCategory.WORK, TaskCategory.HOME, TaskCategory.SHOPPING, TaskCategory.OTHER);
    private TaskCategory taskCategory;
    boolean readOnly = false;
    boolean taskDone = false;


    Task (String taskText, TaskCategory taskCategory) {
        this.taskText = taskText;
        this.taskCategory = taskCategory;
    }

    Task (String taskText) {
        this.taskText = taskText;
        this.taskCategory = TaskCategory.OTHER;
    }

    public Class<?> getType() {
        return String.class;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean newStatus) {
        readOnly = newStatus;
    }

    public void setTaskDone(boolean newStatus) {
        taskDone = newStatus;
    }

    public String getValue() {
        return taskText;
    }


    public void setValue(Object newValue)
            throws ReadOnlyException {
        if (readOnly)
            throw new ReadOnlyException();

        // Already the same type as the internal representation
        if (newValue instanceof String)
            taskText = (String) newValue;
    }

}
