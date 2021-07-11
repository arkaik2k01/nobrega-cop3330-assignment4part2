package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class ToDoController
{
    @FXML private ListView myListView;

    // ObservableList is a List
    protected ObservableList<String> list;

    //GUI vars
    @FXML private TextField taskDescription;

    @FXML private DatePicker dateSetter;

    @FXML private CheckBox doneButton;


    @FXML
    public void newTask(MouseEvent mouseEvent)
    {
        //Get current description from app
            //If task with desc exists, add 1 to check
            //If null, return and do not create
        //Get selected date from app
            //If task with date exists, add 1 check
            //If null, return and do not create
        //If check is 2
            //return
        //addItem(desc, date)
        //Update viewer
    }

    @FXML
    public void filterComplete(MouseEvent mouseEvent)
    {
        //Send mode 1 to displayList
        //Update viewer
    }

    @FXML
    public void filterUncompleted(MouseEvent mouseEvent)
    {
        //Send mode 2 to displayList
        //Update viewer
    }

    @FXML
    public void showAll(MouseEvent mouseEvent)
    {
        //Send mode 0 to displayList
        //Update viewer
    }

    @FXML
    public void importList(ActionEvent actionEvent)
    {
        //Open dialog box
        //Get user location for list import
        //Read first line as list title and create newList

        //Assuming (task description,date) format....

        //While EOF
            //Read strings by line
            //Separate into two string by comma
            //Create Task with date and desc
            //Add task to newList
        //Update viewer
    }

    @FXML
    public void exportList(ActionEvent actionEvent)
    {
        //Create file variable that will be stored in resources
        //Open file writer
        //Get list

        //For loop through toDoList
            //toString() current element
            //Print string to file
        //close file writer
    }
}
