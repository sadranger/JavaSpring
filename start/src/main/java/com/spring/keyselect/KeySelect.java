package com.spring.keyselect;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.component.KeyBoard;
import com.spring.component.Mouse;

public class KeySelect {
	
	@Autowired
	private Mouse mouse;
	@Autowired
	private KeyBoard keyBoard;
	
	
	public Mouse getMouse() {
		return mouse;
	}
	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}
	public KeyBoard getKeyBoard() {
		return keyBoard;
	}
	
	public void setKeyBoard(KeyBoard keyBoard) {
		this.keyBoard = keyBoard;
	}
	
	

}
