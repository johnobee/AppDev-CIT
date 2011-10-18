package ie.cit.cloud.appdev.model;

/**
 * Domain object representing a Todo item.
 * 
 * @author igor.mihalik
 */
public class Todo {

    private String text;

    private boolean done;
    
    public Todo() {
	// empty constructor to enable instantiation via reflection API
    }

    public Todo(String text) {
	this.text = text;
	done = false;
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public boolean isDone() {
	return done;
    }

    public void setDone(boolean done) {
	this.done = done;
    }

}