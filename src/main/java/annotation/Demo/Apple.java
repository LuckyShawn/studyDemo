package annotation.Demo;

/**
 * @author Shawn
 * @title: Apple
 * @projectName studyDemo
 * @description: TODO
 * @date 2021/1/26
 */
@FruitProvider(id = 011,name = "shawn",address = "china")
public class Apple {
    private int appleID;
    private String appleProvidername;
    private String appleprovideraddress;

    public int getAppleID() {
        return appleID;
    }

    public void setAppleID(int appleID) {
        this.appleID = appleID;
    }

    public String getAppleProvidername() {
        return appleProvidername;
    }

    public void setAppleProvidername(String appleProvidername) {
        this.appleProvidername = appleProvidername;
    }

    public String getAppleprovideraddress() {
        return appleprovideraddress;
    }

    public void setAppleprovideraddress(String appleprovideraddress) {
        this.appleprovideraddress = appleprovideraddress;
    }
}
