
import javax.persistence.*;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "element")
    private String element;

    @Column(name = "region")
    private String region;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private String age;

    @Column(name = "weapon")
    private String weapon;

    @Column(name = "health")
    private int health;

    @Column(name = "attack")
    private int attack;

    @Column(name = "defense")
    private int defense;

    @Column(name = "critRate")
    private double critRate;

    @Column(name = "critDamage")
    private double critDamage;

    @Column(name = " quality")
    private int quality;

    @Column(name = "elemenDmgBonus")
    private double elemenDmgBonus;

    // Gettery

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getElement() {
        return element;
    }
    public String getRegion() {
        return region;
    }
    public String getGender() {
        return gender;
    }
    public String getAge() {
        return age;
    }
    public String getWeapon() {
        return weapon;
    }
    public int getHealth() {
        return health;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public double getCritRate() {
        return critRate;
    }
    public double getCritDamage() {
        return critDamage;
    }
    public int getQuality() {
        return quality;
    }
    public double getElemenDmgBonus() {
        return elemenDmgBonus;
    }

    //Settery
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setElement(String element) {
        this.element = element;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public void setCritRate(double critRate) {
        this.critRate = critRate;
    }
    public void setCritDamage(double critDamage) {
        this.critDamage = critDamage;
    }
    public void setQuality(int quality) {
        this.quality = quality;
    }
    public void setElemenDmgBonus(double elemenDmgBonus) {
        this.elemenDmgBonus = elemenDmgBonus;
    }
}
