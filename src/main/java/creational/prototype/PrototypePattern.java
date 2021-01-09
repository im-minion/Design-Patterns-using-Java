/*
 * Creational design patterns provide solution to instantiate a object in the best possible way for specific situations.
 */
package creational.prototype;

import java.util.ArrayList;
import java.util.List;

/*
 * The prototype pattern is used when the Object creation is a costly affair and requires a lot of time and resources
 * and you have a similar object already existing.
 * This pattern provides a mechanism to copy the original object to a new object and then modify it according to our needs.
 * This pattern uses java cloning to copy the object.
 * The existing object acts as a prototype and contains the state of the object.
 * The newly copied object may change same properties only if required. This approach saves costly resources and time, especially when the object creation is a heavy process.
 * */
public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employees emps = new Employees();
        emps.loadData();

        //Use the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        System.out.println(empsNew.getEmpList().toString());
        System.out.println(empsNew1.getEmpList().toString());
    }
}

class Employees implements Cloneable {

    private final List<String> empList;

    public Employees() {
        empList = new ArrayList<String>();
    }

    public Employees(List<String> list) {
        this.empList = list;
    }

    public void loadData() {
        //read all employees from database and put into the list
        empList.add("One");
        empList.add("Two");
        empList.add("Three");
        empList.add("Four");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<String>(this.getEmpList());
        return new Employees(temp);
    }

}