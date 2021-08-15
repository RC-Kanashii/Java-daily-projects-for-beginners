package my.demo;

/*
 * @author rc_kanashii
 * 2021-08-15  17:44
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 点菜的主程序
 */
public class DishApp {
    // 提前准备一些菜品，展示给用户，同时用户可以点菜
    // 定义集合，表示小饭店拥有的菜品  泛型
    static List<Dish> dishList = new ArrayList<>();

    // 用户已点的菜品集合
    static List<Dish> personDishes = new ArrayList<>();

    public static void main(String[] args) {
        // 初始化菜品
        initDish();

        // 写死循环
        while (true) {
            // 给用户展示主菜单
            showMenu();

            int num = 0;
            // 创建扫描器对象，获取到控制台输入的内容
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
            }

            // 判断用户输入的数字
            switch (num) {
                // 展示饭店菜单
                case 1 -> {
                    while (true) {
                        showDishMenu();

                        // 获取用户输入信息
                        int id = scanner.nextInt();
                        if (id == 0) {
                            break;
                        }
                        // 从饭店的集合中获取到菜品的对象  1  2  3  4  5
                        // 集合的索引  0  1  2  3  4
                        Dish dish = dishList.get(id - 1);
                        System.out.println("# 您点了：" + dish.name);
                        personDishes.add(dish);
                    }
                }
                // 展示用户已经点的菜品
                case 2 -> showPersonDish();
                // 买单
                case 3 -> {
                    buy();
                    scanner.close();
                    return;
                }
                default -> System.out.println("# 输入编号有误！");
            }
        }
    }

    /**
     * 初始化菜品
     */
    private static void initDish() {
        dishList.add(new Dish(1, "香辣肉丝", 29.0));
        dishList.add(new Dish(2, "炖王八", 59.0));
        dishList.add(new Dish(3, "家常凉菜", 21.0));
        dishList.add(new Dish(4, "地三鲜", 24.0));
        dishList.add(new Dish(5, "油焖大虾", 55.0));
    }

    /**
     * 展示主菜单
     */
    private static void showMenu() {
        System.out.println("-----主菜单-----");
        System.out.println("菜单\t\t\t 1");
        System.out.println("已点菜品\t\t 2");
        System.out.println("买单\t\t\t 3");
        System.out.println("---------------");
        System.out.println("# 请选择服务：");
    }

    /**
     * 展示饭店菜单
     */
    private static void showDishMenu() {
        System.out.println("-------菜单-------");
        for (Dish dish : dishList) {
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }
        System.out.println("-----------------");
        System.out.println("# 输入序号点菜，按0返回上一级");

    }

    /**
     * 展示用户已经点的菜品
     */
    private static void showPersonDish() {
        System.out.println("-----已点菜品-----");
        for (Dish dish : dishList) {
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }
        System.out.println("-----------------");
    }

    /**
     * 买单
     */
    private static void buy() {
        System.out.println("-----正在结算-----");
        // 定义总金额
        double total = 0;
        // 遍历已点菜品
        for (Dish dish : personDishes) {
            total += dish.price;
        }
        System.out.println("您共消费：" + total + "元");
        System.out.println("-----------------");
    }
}
