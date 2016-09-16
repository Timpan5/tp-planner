package System;

import java.io.Serializable;
import java.util.LinkedList;

import CalendarObject.Assignment;
import CalendarObject.Event;
import CalendarObject.Meeting;
import CalendarObject.Project;
import CalendarObject.Task;

/**
 * Created by Tim on 12/29/2015.
 */
public class CalendarBase implements Serializable{

    private LinkedList<Assignment> cAssignment = new LinkedList<Assignment>();
    private LinkedList<Event> cEvent = new LinkedList<Event>();
    private LinkedList<Meeting> cMeeting = new LinkedList<Meeting>();
    private LinkedList<Project> cProject = new LinkedList<Project>();
    private LinkedList<Task> cTask = new LinkedList<Task>();

    private LinkedList<String> category = new LinkedList<String>();

    public LinkedList<Assignment> getCalenderAssignment() {
        return this.cAssignment;
    }

    public LinkedList<Event> getCalendarExercise() {
        return this.cEvent;
    }

    public LinkedList<Meeting> getCalendarMeeting() {
        return this.cMeeting;
    }

    public LinkedList<Project> getCalendarProject() {
        return this.cProject;
    }

    public LinkedList<Task> getcTask() {return this.cTask;}

    public LinkedList<String> getCategory(){
        return this.category;
    }

    public void addProject(Project p){
        this.cProject.add(p);
    }

    public void addMeeting(Meeting m){
        this.cMeeting.add(m);
    }

    public void addEvent(Event e){
        this.cEvent.add(e);
    }

    public void addAssignment(Assignment a){
        this.cAssignment.add(a);
    }

    public void addTask(Task t) { this.cTask.add(t);}

    public void addCourses(String c) {
        this.category.add(c);
    }

    public void deleteCategory(String c) {
        for (int i=0; i<this.category.size(); i++) {
            if (this.category.get(i).equals(c)) {
                this.category.remove(i);
                return;
            }
        }
    }

    public boolean categoryExists(String name) {
        for (int i=0; i<this.category.size(); i++) {
            if (this.category.get(i).equals(name))
                return true;
        }
        return false;
    }

    public void deleteEvent(Event e) {
        cEvent.remove(e);
        cTask.remove((Task) e);
    }

}
