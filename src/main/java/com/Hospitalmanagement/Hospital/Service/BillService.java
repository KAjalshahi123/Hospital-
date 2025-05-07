package com.Hospitalmanagement.Hospital.Service;

import com.Hospitalmanagement.Hospital.Repository.BillRepository;
import com.Hospitalmanagement.Hospital.modles.Bill;
import com.Hospitalmanagement.Hospital.modles.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);
@Autowired
      private BillRepository billRepository;
    public List<Bill> getAll() {
        try {
            logger.info("Fetching all bills from service layer");
           // return null; // Replace with actual logic
          return   billRepository.findAll();

        } catch (Exception e) {
            logger.error("An error occurred while fetching all bills: {}", e.getMessage(), e);
            return null;
        }
    }

    public Bill getBillByid(Long id) {
        try {
           // return null; // Replace with actual logic
            Optional<Bill>bill = billRepository.findById(id);
            return bill.orElse(null);
        } catch (Exception e) {
            logger.error("An error occurred while fetching bill by ID: {}", e.getMessage(), e);
            return null;
        }
    }

    public Bill createBill(Bill bill) {
        try {
           // return null; // Replace with actual logic
            billRepository.save(bill);
            return bill;
        } catch (Exception e) {
            logger.error("An error occurred while creating a bill: {}", e.getMessage(), e);
            return null;
        }
    }

    public void DeleteBillByid(Long id) {
        try {
            // Add delete logic here
            billRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("An error occurred while deleting bill by ID: {}", e.getMessage(), e);
        }
    }

    public Bill updateBillById(Long id, Bill updateBill) {
        try {
            Optional<Bill> existingBill = billRepository.findById(id);
            if (existingBill.isPresent()) {
                Bill b = existingBill.get();

                // Update relevant fields with the values from updateBill
                b.setAmount(updateBill.getAmount());
                b.setStatus(updateBill.getStatus());
                b.setPaymentMode(updateBill.getPaymentMode());
                b.setInsuranceProvider(updateBill.getInsuranceProvider());
                b.setDiscount(updateBill.getDiscount());
                b.setTax(updateBill.getTax());
                b.setTotalAmount(updateBill.getTotalAmount());
                b.setPaid(updateBill.isPaid());
                b.setNotes(updateBill.getNotes());
                b.setBillingDate(updateBill.getBillingDate());

                // Save the updated bill to the repository
                billRepository.save(b);
            } else {
                logger.error("Bill with id {} not found", id);
            }
        } catch (Exception e) {
            logger.error("An error occurred while updating bill by ID {}: {}", id, e.getMessage(), e);
        }
        return null;
    }


}
