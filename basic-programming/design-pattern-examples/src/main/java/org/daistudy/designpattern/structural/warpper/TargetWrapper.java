package org.daistudy.designpattern.structural.warpper;

public abstract class TargetWrapper extends Target{

    private Target target;

    public TargetWrapper(Target target){
        this.target = target;
    }

    public void operate(){
        this.target.operate();
    }

}
