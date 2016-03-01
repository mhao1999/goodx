package com.goodx.message;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.goodx.models.GoodXUser;

@Service
public class GoodXMailService {
	
	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;
	
	@Value("${mail.username}")
	private String fromAddress;
	
	@Value("${mail.subject}")
	private String subject;
	
	@Autowired
	public GoodXMailService(JavaMailSender sender, VelocityEngine velocityEngine) {
		this.mailSender = sender;
		this.velocityEngine = velocityEngine;
	}
	
	public void sendActivationMail(GoodXUser user) {
		this.sendEmail(user);
	}
	
	private void sendEmail(final GoodXUser user) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// TODO Auto-generated method stub
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				message.setTo(user.getEmail());
				message.setFrom(fromAddress);
				message.setSubject(subject);
				message.setSentDate(new Date());
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("user", user);
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, "activation-template.vm", "UTF-8", model);
				message.setText(text, true);
			}
		};
		
		this.mailSender.send(preparator);
	}
}
