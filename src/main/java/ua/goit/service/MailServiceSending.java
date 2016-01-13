package ua.goit.service;

public interface MailServiceSending {
    public void send(String subject, String text, String fromEmail, String toEmail);
}
