package com.dt.param.controller;

import android.os.Handler;

import com.dt.bean.Message;

public class Controller {

	private static final String SERVER_IP   = "127.0.0.1";
	private static final int    SERVER_PORT = 9192;
	
	public Controller(){
		init();
	}
	
	public void init(){
		
	}
	
	/**
	 * ��ʼ��������
	 */
	public void loadConfig(){
		
	}
	
	/**
	 * ������̨����
	 */
	public void startServices(){
		
	}
	
	/**
	 * ������Ϣ�Ķ���ӿڣ����з�������������Ϣ���ɸýӿڷ������÷�������һ���̴߳������Ϣ���ҽ�������Ϣ
	 * ��������Ϣע���handler����handler����������Ϣ��
	 * @param msg
	 * @param handler
	 */
	public void sendMessage(Message msg, Handler handler){
		new Thread(new MsgSender(msg,handler)).start();
	}
	
	private class MsgSender implements Runnable{

		private Message msg;
		private Handler handler;
		
		public MsgSender(Message msg, Handler handler){
			this.msg = msg;
			this.handler = handler;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
