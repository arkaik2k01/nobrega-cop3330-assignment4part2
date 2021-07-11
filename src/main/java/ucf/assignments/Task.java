package ucf.assignments;

import java.util.Date;

public class Task
{
    Date date;
    String description;
    Boolean check;

    public Task(Date date, String description)
    {
        this.date = date;
        this.description = description;
        this.check = false;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Boolean getCheck()
    {
        return check;
    }

    public void setCheck(Boolean check)
    {
        this.check = check;
    }

    public String toString()
    {
        return description + ", due " + date.toString() + ((check) ? (". Done\n"):(". Not done\n"));
    }
}
