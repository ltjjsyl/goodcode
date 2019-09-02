package cn.chuxiao.annotations.example2;

@DBTable(name = "MEMBER")
public class Member {
    static int memberCount;
    @SQLString(30)
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30,
            constraints = @Constraints(primaryKey = true))
    String reference;

    public String getReference() {
        return reference;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return reference;
    }

    public Integer getAge() {
        return age;
    }
}