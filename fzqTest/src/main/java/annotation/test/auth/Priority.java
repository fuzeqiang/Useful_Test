package annotation.test.auth;

/**
 * Created by Administrator on 2016/7/15 0015.
 */
public enum Priority {
    ADMIN("admin", 0),
    MANAGER("manager", 1),
    USER("user", 2),
    GUEST("guest", 3);

    private String name;
    private  int index;

    public static String getPriorityName(int index) {
        for (Priority priority : Priority.values()) {
            if (priority.getIndex() == index) {
                return priority.getName();
            }
        }
        return null;
    }

    public static int getPriorityIndex(String name) {
        for (Priority priority : Priority.values()) {
            if (priority.getName().equals(name)) {
                return priority.getIndex();
            }
        }
        return -1;
    }

    private Priority (String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
