package com.eric.holding;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/17/2018 3:25 PM
 */
public class Ex27_Command {

    public static void consumer(Queue<Command> q) {
        while (q.peek() != null)
            q.remove().operation();
    }

    public static void main(String[] args) {
        List<String> cms = new LinkedList<>();
        cms.add("ls -l");
        cms.add("cd /test");
        cms.add("ll");
        cms.add("ps -ef|grep tomcat_new");
        cms.add("kill -9 4123");
        consumer(CommandQueue.addCommand(cms));
    }
}

class CommandQueue {

    private static Queue<Command> qc = new LinkedList<>();

    public static Queue<Command> addCommand(List<String> commands) {
        Iterator<String> itr = commands.iterator();
        String cm = "";
        while (itr.hasNext())
            qc.offer(new Command(itr.next()));
        return qc;
    }
}

class Command {
    private String command;

    public Command(String command) {
        this.command = command;
    }

    public void operation() {
        System.out.println(command);
    }
}