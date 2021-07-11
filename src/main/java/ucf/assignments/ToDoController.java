package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.function.Predicate;

public class ToDoController
{
    @FXML private ListView<Task> taskList;
    // ListView utilities
    private final ObservableList<Task> tasks = FXCollections.observableArrayList();
    private final FilteredList<Task> filterTask = new FilteredList<>(tasks);
    // FileChooser
    FileChooser fileChooser = new FileChooser();


    public void initialize() {
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt"));
        fileChooser.setInitialDirectory(new File("./src/main/resources/ucf/assignments"));

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
    public void newTask(ActionEvent actionEvent)
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
        taskList.setItems(tasks);
        taskList.getItems().clear();
    }

    @FXML
    public void filterComplete(ActionEvent actionEvent)
    {
        Predicate<Task> isDone = i -> i.getCheck();
        filterTask.setPredicate(isDone);
        taskList.setItems(filterTask);
    }

    @FXML
    public void filterUncompleted(ActionEvent actionEvent)
    {
        Predicate<Task> isUndone = i -> !i.getCheck();
        filterTask.setPredicate(isUndone);
        taskList.setItems(filterTask);
    }

    @FXML
    public void showAll(ActionEvent actionEvent)
    {
        filterTask.setPredicate(null);
    }

    @FXML
    public void importList(ActionEvent actionEvent)
    {
        //Open dialog box
        //Get user location for list import
        File toReadFile = fileChooser.showOpenDialog(new Stage());

        try {
            //Clear current list
            clearList(null);
            Scanner in = new Scanner(toReadFile);
            //While EOF
            while(in.hasNextLine()) {
                //Read strings by line
                String input = in.nextLine();

                //Separate into two string by comma
                //Assuming (task description,ISO local date) format....
                String[] separated = separateInputByComma(input);

                //Create Task with date and desc
                Task newTask = new Task(LocalDate.parse(separated[1]), separated[0]);

                //Add task to newList
                tasks.add(newTask);
            }
            taskList.setItems(tasks);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String[] separateInputByComma(String input)
    {
        String[] separatedInput = new String[2];
        separatedInput[0] = input.substring(0, input.indexOf(","));
        separatedInput[1] = input.substring(input.indexOf(",")+1);
        return separatedInput;
    }

    @FXML
    public void exportList(ActionEvent actionEvent)
    {
        //Open file writer
        //Get list

        //For loop through toDoList
            //toString() current element
            //Print string to file
        //close file writer
    }
}
