package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ProductDao productDao;

    @Test
    @Transactional
    public void testInvoiceDaoSave() {
        //Given
        Product laptop = new Product("Laptop");
        Product mouse =  new Product("Mouse");
        productDao.save(laptop);
        productDao.save(mouse);

        Item item1 = new Item(laptop, new BigDecimal(3500.00), 2);
        Item item2 = new Item(mouse, new BigDecimal(150.00), 5);

        Invoice invoice = new Invoice("FV/2026/01");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        assertNotEquals(0,invoiceId);
        assertEquals(2,invoiceDao.findById(invoiceId).get().getItems().size());

        //CleanUp
        invoiceDao.delete(invoice);
        productDao.delete(laptop);
        productDao.delete(mouse);
    }
}
