package com.company;

import java.util.Scanner;

abstract class AbsNode{
    AbsNode lastOne;
    protected int val;

    public AbsNode getLastOne() {
        return lastOne;
    }

    public void setLastOne(AbsNode lastOne) {
        this.lastOne = lastOne;
    }

    public abstract int getVal() throws Exception;
    public abstract void setVal(int _val);

}

class RealNode extends AbsNode{

    @Override
    public int getVal(){
        return val;
    }

    @Override
    public void setVal(int _val){
        val = _val;
    }
}

class ZeroNode extends AbsNode{

    @Override
    public int getVal() throws Exception {
        throw new Exception("You are shavka!");
    }

    @Override
    public void setVal(int _val){
    }
}

class Stack{
    private AbsNode curNode;
    public Stack(){
        curNode = new ZeroNode();
    }

    public void push(int i){
        RealNode realNode = new RealNode();
        realNode.setVal(i);
        realNode.setLastOne(curNode);
        curNode = realNode;
    }

    public int pop() throws Exception{
        int val = curNode.getVal();
        curNode = curNode.getLastOne();
        return val;
    }
}


public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while (!(str.equals("e"))){
            str = scanner.next();
            if(str.equals("a")){
            System.out.println("Vvedite chislo i mi ego sohranim");
            stack.push(scanner.nextInt());
        }
        if(str.equals("b")) {
            try {
                System.out.println("Vashe chiso " + stack.pop());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                str = "e";
            }
        }
        }
    }
}
