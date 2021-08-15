package my.demo;

/*
 * @author rc_kanashii
 * 2021-08-15  17:02
 */


/**
 * 菜品类
 * 提供有参数的构造方法
 */
public class Dish {
    int id;
    String name;
    double price;


    /**
     * @param id    编号
     * @param name  菜名
     * @param price 价格
     */
    // 生成构造方法快捷键 alt+insert
    public Dish(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
