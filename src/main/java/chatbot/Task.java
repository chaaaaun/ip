package chatbot;

import chatbot.exceptions.AlreadyMarkedException;
import chatbot.exceptions.AlreadyUnmarkedException;

import java.io.Serializable;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String description;
    private boolean done;

    public Task(String desc) {
        this.description = desc;
        this.done = false;
    }

    @Override
    public String toString() {
        return (done ? "[X] " : "[ ] ") + description;
    }

    public void mark() throws AlreadyMarkedException {
        if (this.done) throw new AlreadyMarkedException();
        this.done = true;
    }

    public void unmark() throws AlreadyUnmarkedException {
        if (!this.done) throw new AlreadyUnmarkedException();
        this.done = false;
    }
}
