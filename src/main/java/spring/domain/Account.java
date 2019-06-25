/*
 * @Project: springTest_maven
 * @Package spring.service.domain
 * @author: zzc
 * @date Date: 2019年06月24日 上午7:42
 * @version V1.0
 */

package spring.domain;

public class Account {
    private int id;
    private double money;
    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                ", user_id=" + user_id +
                '}';
    }
}
