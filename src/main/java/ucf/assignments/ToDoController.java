package ucf.assignments;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.time.LocalDate;
import java.util.function.Predicate;

public class ToDoController
{
    @FXML private ListView<Task> taskList;

    // ObservableList var and methods
    private final ObservableList<Task> tasks = FXCollections.observableArrayList();
    private final FilteredList<Task> filterTask = new FilteredList<>(tasks);

    public void initialize() {
        taskList.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    taskDescription.setText(newValue.getDescription());
                    dateSetter.setValue(newValue.getDate());
                    doneButton.setSelected(newValue.getCheck());
                }
        );
}

    //GUI vars
    @FXML private TextField taskDescription;

    @FXML private DatePicker dateSetter;

    @FXML private CheckBox doneButton;


    @FXML
    public void newTask(MouseEvent mouseEvent)
    {
        //Get current description from app
        int checker = 0;
        String taskDesc = taskDescription.getText();

        //If null, return and do not create
        if(taskDesc.isEmpty())
            return;
        //Get selected date from app
        LocalDate taskDate = dateSetter.getValue();
        //If null, return and do not create
        if(taskDate.toString().isEmpty())
            return;

        Task newTask = new Task(taskDate, taskDesc);
        //addItem(desc, date)
        tasks.add(newTask);
        taskList.setItems(tasks);
    }

    @FXML
    public void updateButtonPressed(ActionEvent actionEvent)
    {
        Task current = taskList.getSelectionModel().getSelectedItem();
        current.setDescription(taskDescription.getText());
        current.setDate(dateSetter.getValue());
        current.setCheck(doneButton.isSelected());
        taskList.refresh();
    }

    @FXML
    public void removeTask(ActionEvent actionEvent)
    {
        Task toRemove = taskList.getSelectionModel().getSelectedItem();
        tasks.remove(toRemove);
    }

    @FXML
    public void clearList(ActionEvent actionEvent)
    {
        taskList.getItems().clear();
    }

    @FXML
    public void filterComplete(MouseEvent mouseEvent)
    {
        taskList.setItems(filterTask);
        Predicate<Task> isDone = i -> i.getCheck();
        filterTask.setPredicate(isDone);
    }

    @FXML
    public void filterUncompleted(MouseEvent mouseEvent)
    {
        taskList.setItems(filterTask);
        Predicate<Task> isUndone = i -> !i.getCheck();
        filterTask.setPredicate(isUndone);
    }

    @FXML
    public void showAll(MouseEvent mouseEvent)
    {
        filterTask.setPredicate(null);
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
