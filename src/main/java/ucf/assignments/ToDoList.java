package ucf.assignments;

import java.util.ArrayList;
import java.util.Date;

public class ToDoList
{
    ArrayList<Task> list;
    String title;

    public ToDoList(String title)
    {
        this.title = title;
    }

    public void addTask(String desc, Date date)
    {
        //Create task with given desc and date
        //Add date to list
    }

    public void removeTask(Task toRemove)
    {
        //If list contains task
            //Delete item from to do list
    }

    public ArrayList<Task> displayList(int mode)
    {
        //If mode 0
            //Send full todolist
        //If mode 1
            //Copy toDoList
            //If item is not completed
                //Remove from list
            //return new toDoList
        //If mode 2
            //Copy toDoList
            //If item is completed
                //Remove from list
            //return new toDoList
        //return error
        return null;
    }
}
