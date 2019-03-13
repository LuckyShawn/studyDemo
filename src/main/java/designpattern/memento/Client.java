package designpattern.memento;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/3/13 0013
 */
public class Client {
    public static void main(String[] args){

        CareTaker careTaker = new CareTaker();

        Emp emp = new Emp("shawn",20,1000);
        System.out.println("第一次打印："+emp.toString());
        careTaker.setEmpMemento(emp.menento()); //备忘一次
        careTaker.setStack(emp.menento());  //在栈中备忘一次
        emp.setName("jack");
        emp.setAge(30);
        emp.setSalary(10);
        System.out.println("第二次打印："+emp.toString());
        careTaker.setStack(emp.menento());  //在栈中备忘两次

        //emp.recovery(careTaker.getEmpMemento());//恢复到备忘录对象保存的状态
        System.out.println("第三次打印："+emp.toString());

        emp.setName("stack");
        emp.setSalary(50);
        emp.setAge(1);
        careTaker.setStack(emp.menento());  //在栈中备忘三次
        System.out.println("====================利用栈模拟撤销");
        emp.recoveryStack(careTaker.getStack());
        System.out.println(emp.toString());
        emp.recoveryStack(careTaker.getStack());
        System.out.println(emp.toString());
        emp.recoveryStack(careTaker.getStack());
        System.out.println(emp.toString());



    }
}
