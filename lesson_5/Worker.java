package ru.mylife.worker;

public class Worker {

    private String fio;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Worker(){
        this.fio = "unknown";
        this.position = "unknown";
        this.email = "unknown";
        this.phone = "unknown";
        this.salary = 0;
        this.age = 0;
    }

    public Worker(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getFio() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printWorker(){
        System.out.print("ФИО:\t" + getFio() + "\n" +
                        "Должность:\t" + getPosition() + "\n" +
                        "email:\t" + getEmail() + "\n" +
                        "Телефон:\t" + getPhone() + "\n" +
                        "З\\п:\t" + getSalary() + "\n" +
                        "Возраст:\t" + getAge() + "\n\n");
    }
}
