package practice.p04_petercoad_inheritance_rules;

// 사람 클래스
public class Person {

    private Role role;  // 역할 속성

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void doIt() {
        role.doIt();
    }
}
