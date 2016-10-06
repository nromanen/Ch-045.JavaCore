package PeopleCart;

/**
 * Created by evil on 02.10.16.
 */

class ManCart {
    private String name, address;
    private int age;
    ManCart(){}
    ManCart(String name, String address, int age){
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
    public String printCart(){
        return "Name is " + name + " age: " + age + " address: " + address;
    }
}

