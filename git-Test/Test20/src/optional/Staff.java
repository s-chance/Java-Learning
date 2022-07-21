package optional;

public class Staff {
    private String name;

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Staff() {
    }

    public Staff(String name) {
        this.name = name;
    }
}
