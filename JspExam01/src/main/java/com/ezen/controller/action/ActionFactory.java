package com.ezen.controller.action;

import com.ezen.controller.ShopServlet;

public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() { };
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("action factory에 들어온 command 출력 : " + command);
		
		if( command.equals( "shop_list" ) ) {
			action = new ShopListAction();
		} else if ( command.equals( "shop_input_form" )) {
			action = new ShopInputFormAction();
		} else if ( command.equals( "shop_input" )) {
		action = new ShopInputAction();
		}
		return action;
	}
}
