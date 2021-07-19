package model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import DAO.TaskDAO;
import model.users.Users;

public class SendMailLogic {
	public Remind remind; //リマインド通知の情報
	public ScheduledExecutorService service; //リマインド通知を送るスレッド
	public ScheduledFuture<?> sf; //リマインド通知を送るスレッドの戻り値,キャンセルを行うためのインスタンス。
	public static final HashMap<Integer, ScheduledFuture<?>> map_ScheduledFuture = new HashMap<Integer, ScheduledFuture<?>>();
	public static final HashMap<Integer, ScheduledExecutorService> map_ScheduledExecutor = new HashMap<Integer, ScheduledExecutorService>();

	public SendMailLogic(Remind remind) {
		this.remind = remind;
		service = Executors.newSingleThreadScheduledExecutor();
	}

	public void execute() { //リマインド設定を行う

		Runnable task1 = () -> { //リマインド時刻にメールを送信
			try {
				Properties property = new Properties();
				// 各種設定 
				ResourceBundle bundle = ResourceBundle.getBundle("properties.mail");
				//リマインド配信元の情報を取得
				TaskDAO dao = new TaskDAO();
				Task task = dao.findByTaskId(remind.getTaskId());

				GetUsersLogic bo2 = new GetUsersLogic();
				Users users = bo2.execute(remind.getUsrId());

				property.put("mail.smtp.auth", "true");
				property.put("mail.smtp.starttls.enable", "true");
				property.put("mail.smtp.host", bundle.getString("mail.smtp.host"));
				property.put("mail.smtp.port", bundle.getString("mail.smtp.port")
						+ "");
				property.put("mail.smtp.debug", "true");

				Session session = Session.getInstance(property, new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(bundle.getString("mail"), bundle.getString("pass"));
					}
				});

				MimeMessage mimeMessage = new MimeMessage(session);
				InternetAddress toAddress = new InternetAddress(users.getMail()); //送信先
				mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);
				InternetAddress fromAddress = new InternetAddress(bundle.getString("mail")); //送信元
				mimeMessage.setFrom(fromAddress);
				mimeMessage.setSubject(task.getAction(), "ISO-2022-JP"); //タイトル
				mimeMessage.setText(task.getMailText(), "ISO-2022-JP"); //本文
				Transport.send(mimeMessage); //メール送信
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		};
		LocalDateTime now = LocalDateTime.now(); //現在時刻
		LocalTime next = remind.getRemindTime();
		LocalDate date = LocalDate.now();
		LocalDateTime nextRun = LocalDateTime.of(date, next);

		if (now.isAfter(nextRun)) {
			nextRun = nextRun.plusDays(1);
		}
		Duration duration = Duration.between(now, nextRun);
		long initialDelay = duration.getSeconds();

		sf = service.scheduleAtFixedRate(task1,
				initialDelay,
				TimeUnit.DAYS.toSeconds(1),
				TimeUnit.SECONDS); //リマインドを設定

		map_ScheduledFuture.put(remind.getRemindId(), sf); //キャンセルを行う時のための格納
		map_ScheduledExecutor.put(remind.getRemindId(), service);
	}

}
