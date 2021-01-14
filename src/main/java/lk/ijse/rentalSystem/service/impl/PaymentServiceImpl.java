package lk.ijse.rentalSystem.service.impl;

import lk.ijse.rentalSystem.dto.PaymentDTO;
import lk.ijse.rentalSystem.entity.OrderDetails;
import lk.ijse.rentalSystem.entity.Payment;
import lk.ijse.rentalSystem.repo.OrderDetailsRepository;
import lk.ijse.rentalSystem.repo.PaymentRepository;
import lk.ijse.rentalSystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repo;

    @Autowired
    private OrderDetailsRepository details_repo;


    @Override
    public void savePayment(PaymentDTO dto) {
        if (! repo.existsById(dto.getPayment_id() ) ) {
            updateAndSave(dto);
        }else{
            throw new RuntimeException("This Payment ID is already Exist !");
        }
    }

    @Override
    public void updatePayment(PaymentDTO dto) {
        if ( repo.existsById(dto.getPayment_id())) {
            updateAndSave(dto);
        }else{
            throw new RuntimeException("This Payment ID is Does'nt Exist !");
        }
    }

    @Override
    public void deletePayment(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }else{
            throw new RuntimeException("This Payment ID is Does'nt Exist !");
        }
    }

    @Override
    public PaymentDTO getPayment(String id) {
        if (repo.existsById(id)) {

            Payment payment = repo.getOne(id);

            return new PaymentDTO(
                    payment.getPayment_id(),
                    payment.getPayment_type(),
                    payment.getLoss_damage_fee(),
                    payment.getDeducted_amount(),
                    payment.getReturn_fee(),
                    payment.getNet_fee(),
                    payment.getExtra_fee(),
                    payment.getTotal_fee(),
                    payment.getOv_id().getOv_id()
            );

        }else{
            throw new RuntimeException("This Payment ID is'nt Exist !");
        }
    }

    @Override
    public List<PaymentDTO> getAllPayment() {
        List<Payment> all = repo.findAll();

        List<PaymentDTO> list =new ArrayList<>();
        for (Payment payment: all ) {
            list.add( new PaymentDTO(
                    payment.getPayment_id(),
                    payment.getPayment_type(),
                    payment.getLoss_damage_fee(),
                    payment.getDeducted_amount(),
                    payment.getReturn_fee(),
                    payment.getNet_fee(),
                    payment.getExtra_fee(),
                    payment.getTotal_fee(),
                    payment.getOv_id().getOv_id()
            ));
        }
        return list;
    }

    private void updateAndSave(PaymentDTO dto) {
        if (details_repo.existsById(dto.getOv_id())) {

            OrderDetails one = details_repo.getOne(dto.getOv_id());

            Payment payment = new Payment(
                    dto.getPayment_id(),
                    dto.getPayment_type(),
                    dto.getLoss_damage_fee(),
                    dto.getDeducted_amount(),
                    dto.getReturn_fee(),
                    dto.getNet_fee(),
                    dto.getExtra_fee(),
                    dto.getTotal_fee(),
                    one
            );

            repo.save(payment);
        } else {
            throw new RuntimeException("This OrderDetails ID isn't Exist !");

        }
    }
}
