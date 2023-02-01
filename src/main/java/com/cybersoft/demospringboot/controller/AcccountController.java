package com.cybersoft.demospringboot.controller;

import com.cybersoft.demospringboot.model.AccountModel;
import com.cybersoft.demospringboot.model.StudentModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AcccountController {

    @GetMapping("/{id}/{customerName}") //! định nghĩa tham số dạng pathVariables
    public ResponseEntity<?> index(
            @PathVariable int id,
            @PathVariable("customerName") String customer, //! lấy tham số về và đổi lại tên theo mình muốn
            @RequestParam(required = false, defaultValue = "") String address
    ){
        return new ResponseEntity<>("Hello Resultful API" + id + "- " + customer + "address " + address, HttpStatus.OK);
    }

    /**
     * các type truyền ngầm trong spring
     * 1/ url-encoded:        truyền ngầm ko đính kèm file
     * 2/ form data:  truyền dữ liệu ngầm có đính kèm file
     * 3/ raw body  :  truyền dữ liệu ngầm nhưng dạng JSON
     */
    @PostMapping("/{id}")
    public ResponseEntity<?> insertAccount(
            @PathVariable int id,
            @RequestBody AccountModel accountModel
    ){
//        AccountModel accountModel   = new AccountModel();
//        accountModel.setId(id);
//        accountModel.setCustomerName("Nguyen van A");
//        accountModel.setAge(18);

        return new ResponseEntity<>(accountModel, HttpStatus.OK);
    }
}
