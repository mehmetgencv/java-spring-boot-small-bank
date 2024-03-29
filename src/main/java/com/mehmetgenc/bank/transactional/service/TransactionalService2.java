package com.mehmetgenc.bank.transactional.service;


import com.mehmetgenc.bank.entity.Customer;
import com.mehmetgenc.bank.service.entityservice.CustomerEntityService;
import com.mehmetgenc.bank.transactional.util.TransactionalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class TransactionalService2 {

  private final CustomerEntityService customerEntityService;

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void saveRN() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts9-2");

    customerEntityService.save(customer);

    System.out.println("end");
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void saveRN(int i) {

    Customer customer = TransactionalUtil.getDummyCustomer("ts10-" + i);

    customerEntityService.save(customer);

    if (i == 7) {
      throw new RuntimeException("error");
    }

    System.out.println("end ->" + i);
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public void save(int i) {

    Customer customer = TransactionalUtil.getDummyCustomer("ts10-" + i);

    customerEntityService.save(customer);

    if (i == 7) {
      throw new RuntimeException("error");
    }

    System.out.println("end ->" + i);
  }

  @Transactional(propagation = Propagation.MANDATORY)
  public void saveMandatory() {

    Customer customer = TransactionalUtil.getDummyCustomer("ts12-M");

    customerEntityService.save(customer);

    System.out.println("end");
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public void saveSupports() {
    Customer customer = TransactionalUtil.getDummyCustomer("ts12-M");

    customerEntityService.save(customer);

    System.out.println("end");
  }

  @Transactional(propagation = Propagation.NESTED)
  public void saveNested() {
    Customer customer = TransactionalUtil.getDummyCustomer("ts16-M");

    customerEntityService.save(customer);

    System.out.println("end");
  }
}
