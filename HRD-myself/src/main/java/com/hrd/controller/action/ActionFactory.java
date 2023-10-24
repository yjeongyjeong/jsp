package com.hrd.controller.action;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
	};

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);

		if (command.equals("member_list")) {
			action = new MemberListAction();
		} else if (command.equals("member_join_form")) { 
			action = new MemberJoinFormAction();
		} else if ( command.equals("member_join") ) { 
			action = new MemberJoinAction();
		} else if (command.equals("member_update_form")) {
			action = new MemberUpdateFormAction();
		} else if (command.equals("member_update")) {
			action = new MemberUpdateAction();
		} else if ( command.equals("member_total" )) {
			action = new MemberTotalAction();
		}
		return action;
	}
}
