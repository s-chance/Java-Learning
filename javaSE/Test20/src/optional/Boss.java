package optional;

public class Boss {
    private Staff staff;

    public Boss(Staff staff) {
        this.staff = staff;
    }

    public Boss() {
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "staff=" + staff +
                '}';
    }
}
