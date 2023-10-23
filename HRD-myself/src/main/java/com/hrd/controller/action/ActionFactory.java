package com.hrd.controller.action;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {};
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if( command.equals("member_list") ) {
			action = new MemberListAction();
		}
		
		return action;
		
	}
}
