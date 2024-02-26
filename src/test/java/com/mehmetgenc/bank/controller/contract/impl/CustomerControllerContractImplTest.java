package com.mehmetgenc.bank.controller.contract.impl;

import com.mehmetgenc.bank.dto.CustomerDto;
import com.mehmetgenc.bank.entity.Customer;
import com.mehmetgenc.bank.errormessage.CustomerErrorMessage;
import com.mehmetgenc.bank.general.N11BusinessException;
import com.mehmetgenc.bank.request.CustomerUpdatePasswordRequest;
import com.mehmetgenc.bank.request.CustomerUpdateRequest;
import com.mehmetgenc.bank.service.entityservice.CustomerEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerContractImplTest {

    @Mock
    private CustomerEntityService customerEntityService;

    @InjectMocks
    private CustomerControllerContractImpl customerControllerContractImpl;

    @Captor
    private ArgumentCaptor<Customer> customerArgumentCaptor;

    @Test
    void shouldGetAllCustomers() {
        // given

        Customer customer1 = new Customer();
        customer1.setName("name1");
        customer1.setSurname("surname1");
        Customer customer2 = new Customer();
        customer2.setName("name2");
        customer2.setSurname("surname2");
        Customer customer3 = new Customer();
        customer3.setName("name3");
        customer3.setSurname("surname3");
        Customer customer4 = new Customer();
        customer4.setName("name4");
        customer4.setSurname("surname4");
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);

        //when

        Mockito.when(customerEntityService.findAll()).thenReturn(customers);
        List<CustomerDto> results = customerControllerContractImpl.getAllCustomers();

        // then

        assertEquals(customers.size(), results.size());
        for (int i = 0; i < results.size(); i++) {
            CustomerDto result = results.get(i);
            Customer customer = customers.get(i);

            assertEquals(customer.getName(), result.name());
            assertEquals(customer.getSurname(), result.surname());
        }

    }

    @Test
    void shouldGetCustomerById() {
        //given
        Long id = 15L;
        String name = "Mehmet";
        String surname = "Genc";

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setSurname(surname);

        //when

        Mockito.when(customerEntityService.findByIdWithControl(Mockito.anyLong())).thenReturn(customer);
        // Another usage
        // Mockito.when(customerEntityService.findByIdWithControl(id)).thenReturn(customer);

        CustomerDto result = customerControllerContractImpl.getCustomerById(id);

        // then

        assertEquals(id, result.id());
        assertEquals(name, result.name());
        assertEquals(surname, result.surname());

    }

    @Test
    void shouldUpdateCustomer() {
        // given
        CustomerUpdateRequest request = new CustomerUpdateRequest(
                15L,
                "Mehmet",
                "Genc",
                LocalDate.of(1996, 1, 1),
                "554",
                "a.mail");

        Long id = 15L;
        String name = "Mehmet";
        String surname = "Gencxxx";

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setSurname(surname);


        // when
        Mockito.when(customerEntityService.findByIdWithControl(id)).thenReturn(customer);
        CustomerDto result = customerControllerContractImpl.updateCustomer(request);


        // then
        InOrder inOrder = Mockito.inOrder(customerEntityService);
        inOrder.verify(customerEntityService).findByIdWithControl(request.id());
        inOrder.verify(customerEntityService).save(customer);
        inOrder.verifyNoMoreInteractions();

        assertEquals(id, result.id());
        assertEquals(request.name(), result.name());
        assertEquals(request.surname(), result.surname());
        assertEquals(request.birthDate(), result.birthDate());
        assertEquals(request.phoneNumber(), result.phoneNumber());
        assertEquals(request.email(), result.email());

    }

    @Test
    void shouldUpdateCustomerPassword() {

        // given
        Long id = 1L;
        String oldPass = "old";
        String newPass = "new";
        String newPass2 = "new";

        CustomerUpdatePasswordRequest request = new CustomerUpdatePasswordRequest(
                oldPass,
                newPass,
                newPass2
        );

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("name");
        customer.setSurname("surname");
        customer.setPassword(oldPass);

        // when

        Mockito.when(customerEntityService.findByIdWithControl(id)).thenReturn(customer);
        CustomerDto result = customerControllerContractImpl.updateCustomerPassword(id, request);

        // then

        InOrder inOrder = Mockito.inOrder(customerEntityService);
        inOrder.verify(customerEntityService).findByIdWithControl(id);
        inOrder.verify(customerEntityService).save(customerArgumentCaptor.capture());
        inOrder.verifyNoMoreInteractions();

        Customer customerArgumentCaptorValue = customerArgumentCaptor.getValue();
        assertEquals(newPass, customerArgumentCaptorValue.getPassword());
        assertEquals(id, result.id());

    }

    @Test
    void shouldNotUpdateCustomerPasswordWhenOldPassIsWrong() {
        // given
        Long id = 1L;

        CustomerUpdatePasswordRequest request = Mockito.mock(CustomerUpdatePasswordRequest.class);

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("name");
        customer.setSurname("surname");
        customer.setPassword("oldX");

        // when

        Mockito.when(customerEntityService.findByIdWithControl(id)).thenReturn(customer);

        N11BusinessException n11BusinessException = assertThrows(N11BusinessException.class,
                () -> customerControllerContractImpl.updateCustomerPassword(id, request));

        assertEquals(CustomerErrorMessage.INVALID_OLD_PASSWORD, n11BusinessException.getBaseErrorMessage());


        // then

        InOrder inOrder = Mockito.inOrder(customerEntityService);
        inOrder.verify(customerEntityService).findByIdWithControl(id);
        inOrder.verifyNoMoreInteractions();


    }
    @Test
    void shouldNotUpdateCustomerPasswordWhenNewPasswordsAreDifferent() {
        // given
        Long id = 1L;
        String oldPass = "old";
        String newPass = "new";
        String newPass2 = "newX";

        CustomerUpdatePasswordRequest request = Mockito.mock(CustomerUpdatePasswordRequest.class);
        Mockito.when(request.oldPass()).thenReturn(oldPass);
        Mockito.when(request.newPass()).thenReturn(newPass);
        Mockito.when(request.newPass2()).thenReturn(newPass2);


        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("name");
        customer.setSurname("surname");
        customer.setPassword(oldPass);

        // when

        Mockito.when(customerEntityService.findByIdWithControl(id)).thenReturn(customer);

        N11BusinessException n11BusinessException = assertThrows(N11BusinessException.class,
                () -> customerControllerContractImpl.updateCustomerPassword(id, request));

        assertEquals(CustomerErrorMessage.NEW_PASSWORDS_DID_NOT_MATCH, n11BusinessException.getBaseErrorMessage());


        // then

        InOrder inOrder = Mockito.inOrder(customerEntityService);
        inOrder.verify(customerEntityService).findByIdWithControl(id);
        inOrder.verifyNoMoreInteractions();


    }
}