package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest
{

    @Test
    void addItem()
    {
        //Given...
        //ToDoList expected with task (Clean, 07/24/2021)
        //ToDoList result empty

        //When...
        //result calls addItem(Clean, 07/24/2021)

        //Then...
        //Assert result == expected
    }

    @Test
    void removeItem()
    {
        //Given...
        //ToDoList expected that is empty
        //ToDoList result that has one task

        //When...
        //result calls removeItem(taskToRemove)

        //Then...
        //Assert result == expected

    }

    @Test
    void displayList()
    {
        //Given...
        //ToDoList expected with only undone tasks
        //ToDoList result with same undone tasks but one complete task
        //mode 2

        //When...
        //result calls displayList(mode)
        //Save resulting newList

        //Then...
        //Assert newList == expected
    }
}