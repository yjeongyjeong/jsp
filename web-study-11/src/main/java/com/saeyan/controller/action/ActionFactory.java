package com.saeyan.controller.action;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance; //싱글톤패턴
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("board_list")) {
			action = new BoardListAction();
			
		} else if(command.equals("board_write-form")) {
			action = new BoardWriteFormAction();
			
		} else if( command.equals("board_write") ) {
			action = new BoardWriteAction();
		} else if( command.equals("board_view") ) {
			action = new BoardViewFormAction();
		} else if( command.equals("board_check_pass_form") ) {
			action = new BoardCheckPassFormAction();
		} else if( command.equals("board_check_pass") ) {
			action = new BoardCheckPassAction();
		} else if( command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		}
		
		
		return action;
	}
}
