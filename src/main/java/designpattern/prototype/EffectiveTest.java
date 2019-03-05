package designpattern.prototype;



import java.sql.Date;

/**
 * @Description //轻量级的对象可以使用new，其他对象可以使用clone。
 * clone():
 * 1.拷贝对象返回的是一个新的对象，而不是一个对象的引用地址；
 * 2.拷贝对象已经包含原来对象的信息，而不是对象的初始信息，即每次拷贝动作不是针对一个全新对象的创建。
 * 3.执行clone操作的时候，不会调用构造函数
 * @Author shawn
 * @create 2019/3/5 0005
 */
public class EffectiveTest {
    public static void main(String[] args) throws Exception {
        newCreate(100000);
        cloneCreate(100000);
    }

    /**
     * new方式创建对象
     * @param size
     */
    public static void newCreate(int size){
        long start = System.currentTimeMillis();
        for (int i = 0; i < size ; i++) {
            new Person("aaaaaaaaaaaaaaaaaaaaaaaaaaa","1111",123123);
        }
        long end = System.currentTimeMillis();
        System.out.println("new耗时："+(end - start));
    }

    /**
     * 克隆的方式创建对象
     * @param size
     * @throws CloneNotSupportedException
     */
    public static void cloneCreate(int size) throws CloneNotSupportedException {
        long start = System.currentTimeMillis();
        Person person = new Person("aaaaaaaaaaaaaaaaaaaaaaaaaaa","1111",123123);
        for (int i = 0; i < size ; i++) {
            person.clone();
        }
        long end = System.currentTimeMillis();
        System.out.println("clone耗时："+(end - start));
    }
}


class Person implements Cloneable{
    public Person(String name, String age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 999; i++) {
            stringBuilder.append("aaa");
        }
    }

    public Person() {
    }

    private String name;
    private String age;
    private int id;
    private boolean checked;
    private String text;
    private boolean leaf;
    private String cls;
    private String functionLevel;
    private String href;
    private String qtip;
    private String hrefTarget;
    private Long empno;
    private String ename;
    private String job;
    private Long mgr;
    private double sal;
    private double comm;
    private Long invoiceId;
    private String type;
    private String invoiceType;
    private Date invoiceGlDate;
    private String termsName;
    private String paymentMethod;
    private String currencyCode;
    private String rateType;
    private Date rateDate;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getFunctionLevel() {
        return functionLevel;
    }

    public void setFunctionLevel(String functionLevel) {
        this.functionLevel = functionLevel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getQtip() {
        return qtip;
    }

    public void setQtip(String qtip) {
        this.qtip = qtip;
    }

    public String getHrefTarget() {
        return hrefTarget;
    }

    public void setHrefTarget(String hrefTarget) {
        this.hrefTarget = hrefTarget;
    }

    public Long getEmpno() {
        return empno;
    }

    public void setEmpno(Long empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getMgr() {
        return mgr;
    }

    public void setMgr(Long mgr) {
        this.mgr = mgr;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Date getInvoiceGlDate() {
        return invoiceGlDate;
    }

    public void setInvoiceGlDate(Date invoiceGlDate) {
        this.invoiceGlDate = invoiceGlDate;
    }

    public String getTermsName() {
        return termsName;
    }

    public void setTermsName(String termsName) {
        this.termsName = termsName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public Date getRateDate() {
        return rateDate;
    }

    public void setRateDate(Date rateDate) {
        this.rateDate = rateDate;
    }
}