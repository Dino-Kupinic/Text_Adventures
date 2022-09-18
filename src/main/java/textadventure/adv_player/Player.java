package textadventure.adv_player;

public class Player {
    private String name;
    private String origin;
    private String role;
    private String starterWeapon;
    private int age;

    public Player() {
        this.name = "?";
        this.age = 18;
        this.origin = "?";
        this.role = "?";
        this.starterWeapon = "?";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStarterWeapon() {
        return starterWeapon;
    }

    public void setStarterWeapon(String starterWeapon) {
        this.starterWeapon = starterWeapon;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
