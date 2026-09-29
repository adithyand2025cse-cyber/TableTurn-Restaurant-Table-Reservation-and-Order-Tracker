package com.tableturn.tableturn.service;

import com.tableturn.tableturn.entity.Bill;
import com.tableturn.tableturn.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found with id: " + id));
    }

    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }

    public Bill updateBill(Long id, Bill billDetails) {

        Bill bill = getBillById(id);

        // Update fields according to your Bill entity
        // Example:
        // bill.setTotalAmount(billDetails.getTotalAmount());

        return billRepository.save(bill);
    }

    public void deleteBill(Long id) {
        Bill bill = getBillById(id);
        billRepository.delete(bill);
    }
}