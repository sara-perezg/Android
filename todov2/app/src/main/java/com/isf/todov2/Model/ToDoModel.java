package com.isf.todov2.Model;

public class ToDoModel {

    private int id, status; //ddbb id, status check 1 or uncheck 0
    private String task; // actual text of the task

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
