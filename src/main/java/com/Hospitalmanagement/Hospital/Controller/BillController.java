package com.Hospitalmanagement.Hospital.Controller;

import com.Hospitalmanagement.Hospital.Service.BillService;
import com.Hospitalmanagement.Hospital.modles.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/Bill")
public class BillController {
    @Autowired
    private BillService billService;
    @GetMapping
    public List<Bill> getAll(){
        System.out.println("Fetching the data");
        return billService.getAll();
    }
    @PostMapping
    public Bill createBill(@RequestBody Bill bill){
        System.out.println("Create Bill");
        return billService.createBill(bill);
    }
    @GetMapping("/{id}")
    public Bill createBill(@PathVariable Long id){
        System.out.println("Fetching id by ID");
        return billService.getBillByid(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id){
     billService.DeleteBillByid(id);
    }
    @PutMapping("/{id}")
    public Bill updateBill(@PathVariable Long id, @RequestBody Bill updatedBill) {
        return billService.updateBillById(id, updatedBill);  // Calling the service to update the bill
    }

}


