package com.myWorkFlow.component;

import java.util.List;

import com.myWorkFlow.base.FlowContext;
import com.myWorkFlow.base.CmpTypeEnum;
import com.myWorkFlow.event.FlowCmpRegEvent;
import com.myWorkFlow.util.ApplicationContextHolder;

public abstract class FlowComponent {
	
	//组件属于的类型
	private CmpTypeEnum typeEnum;
	
	//组件对应的Key值
	private List<String> keyList;
	
	//次序，用于当同一类型找到多个组件时
	private int index;
	
	//超类初始化方法，用于spring的监听机制，在OSGI不需要
	public void init(){
		FlowCmpRegEvent event = new FlowCmpRegEvent(this);
		ApplicationContextHolder.getApplicationContext().publishEvent(event);
	}
	
	public abstract boolean excuteWithContext(FlowContext context);
	
	public boolean isBuild(FlowContext context){
		//是否装配
		return true;
	}
	
	public void rollbackWithContext(FlowContext context){
		//如果有就子类复写。没有就不复写
	}

	public CmpTypeEnum getTypeEnum() {
		return typeEnum;
	}

	public void setTypeEnum(CmpTypeEnum typeEnum) {
		this.typeEnum = typeEnum;
	}

	public List<String> getKeyList() {
		return keyList;
	}

	public void setKeyList(List<String> keyList) {
		this.keyList = keyList;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
