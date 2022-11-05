package model;

public class Employee {
    private String id;
    private String name;
    private String address;
    private String age;
    private String contact;
    private String salary;

    public Employee() {
    }

    public Employee(String id, String name, String address, String age, String contact, String salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.contact = contact;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                ", contact='" + contact + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
