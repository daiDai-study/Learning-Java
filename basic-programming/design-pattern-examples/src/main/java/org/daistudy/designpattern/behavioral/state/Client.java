package org.daistudy.designpattern.behavioral.state;

class StateHolder{
    public final static State RED = new RedState();
    public final static State BLUE = new BlueState();
    public final static State YELLOW = new YellowState();

    private State state;

    public void setState(State state){
        this.state = state;
        this.state.setStateHolder(this);
    }

    public void show(){
        this.state.show();
    }

    public void changeState(){
        this.state.changeState();
    }
}

abstract class State{
    protected StateHolder stateHolder;

    public void setStateHolder(StateHolder stateHolder){
        this.stateHolder = stateHolder;
    }

    public abstract void show();

    public abstract void changeState();
}

class RedState extends State{
    public void show(){
        System.out.println("红灯停");
    }

    public void changeState(){
        this.stateHolder.setState(StateHolder.BLUE);
    }
}


class BlueState extends State{
    public void show(){
        System.out.println("绿灯行");
    }

    public void changeState(){
        this.stateHolder.setState(StateHolder.YELLOW);
    }
}

class YellowState extends State{
    public void show(){
        System.out.println("黄灯等一等");
    }

    public void changeState(){
        this.stateHolder.setState(StateHolder.RED);
    }
}

public class Client {
    public static void main(String[] args) {
        //定义环境角色
        StateHolder holder = new StateHolder();
        //初始化状态
        holder.setState(holder.RED);
        for(int i = 0; i < 10; i++){
            holder.show();
            holder.changeState();
        }
    }
}
