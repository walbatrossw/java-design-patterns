package ex03;

public class Person {

    private Phone homePhone;
    private Phone officePhone;

    public void setHomePhone(Phone homePhone) {
        this.homePhone = homePhone;
    }

    public void setOfficePhone(Phone officePhone) {
        this.officePhone = officePhone;
    }

    public Phone getHomePhone() {
        return homePhone;
    }

    public Phone getOfficePhone() {
        return officePhone;
    }
}
