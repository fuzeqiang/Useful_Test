package annotation.test.auth;

/**
 * Created by fuzeqiang(100918) on 2016/7/15 0015.
 */
public class User {
    private long id;
    private String name;
    private Priority priority;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
