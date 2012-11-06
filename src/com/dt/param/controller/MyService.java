package com.dt.param.controller;

import com.dt.bean.Message;
import com.dt.param.R;
import com.dt.param.view.activity.MsgCenterActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service{
	
	private NotificationManager nm;
	private Handler handler;
	private int     notification_id = 0;
	
	public static final String MESSAGE_LOGIN = "login"; /// Broadcast flag for login action
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate(){
		super.onCreate();
		nm = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
	}
	
	@Override
	public void onStart(Intent intent, int startID){
		super.onStart(intent, startID);
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
	}
	
	/**
	 * ��ʼ�����������������
	 */
	public void startHeartBeat(){
		
	}
	
	/**
	 * 
	 * @param msg
	 */
	public void sendMessage(Message msg){
		new Thread(new MessageSender(msg)).start();
	}
	
	/**
	 * ��״̬������µ�֪ͨ
	 * @param icon
	 * @param tickerText
	 * @param when
	 * @param intentFlags
	 * @param title
	 * @param msg
	 * @param target
	 */
	private void newNotification(int icon, CharSequence tickerText, long when, int intentFlags, CharSequence title, CharSequence msg, Class target){
		Notification notification = new Notification(icon, tickerText,when);
		notification.flags|=Notification.FLAG_AUTO_CANCEL; //�Զ���ֹ
		notification.defaults |= Notification.DEFAULT_SOUND; //Ĭ������
		Intent intent = new Intent(this, target);
		intent.setFlags(intentFlags);
		PendingIntent pending = PendingIntent.getActivity(this, 0, intent, 0);
		notification.setLatestEventInfo(this, title, msg, pending);
		nm.notify(notification_id ++, notification);
	}
	
	/**
	 * �����������������Ϣ��Runnable�����õ��ķ�����Ϣ��Ϊ�㲥��������Ӧ����ϢԴ��
	 * @author HP
	 *
	 */
	private class MessageSender implements Runnable{
		
		private Message msg;
		
		public MessageSender(Message msg){
			this.msg = msg;
		}
		
		@Override
		public void run(){
			Intent intent = new Intent(msg.broadCastFlag);
			MyService.this.sendBroadcast(intent);
		}
	}
	
}