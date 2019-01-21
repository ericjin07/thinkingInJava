package com.eric.typeinfo;

import java.nio.file.OpenOption;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/21/2019 5:13 PM
 */
public interface Robot {
    String model();
    String name();
    List<Operation> operations();

    class Test{
        public static void test(Robot robot) {
            if (robot instanceof Null)
                System.out.println("[Null Robot]");
            System.out.println("Robot Name: " + robot.name());
            System.out.println("Robot Model: " + robot.model());
            for (Operation operation : robot.operations()) {
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
