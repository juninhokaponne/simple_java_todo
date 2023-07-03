public class Task {
    private String name;
    private boolean completed;
    private boolean pending;

    public Task(String name) {
        this.name = name;
        this.completed = false;
        this.pending = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
