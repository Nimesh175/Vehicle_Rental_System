package lk.ijse.rentalSystem.service;

import lk.ijse.rentalSystem.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    public void savePayment(PaymentDTO dto);
    public void updatePayment(PaymentDTO dto);
    public void deletePayment(String id);
    public PaymentDTO getPayment(String id);
    public List<PaymentDTO> getAllPayment();
}
