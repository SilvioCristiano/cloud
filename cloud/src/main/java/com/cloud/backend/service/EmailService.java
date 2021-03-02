package com.cloud.backend.service;


import org.springframework.mail.SimpleMailMessage;

import com.cloud.backend.domain.Cliente;
import com.cloud.backend.domain.Pedido;



public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}