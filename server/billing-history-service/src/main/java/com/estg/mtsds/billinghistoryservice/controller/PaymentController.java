package com.estg.mtsds.billinghistoryservice.controller;

import com.estg.mtsds.billinghistoryservice.entity.PaymentInfo;
import com.estg.mtsds.billinghistoryservice.service.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentHistoric")
public class PaymentController {

    @Autowired
    private PaymentInfoService paymentInfoService;

    @GetMapping("/listAll")
    public List<PaymentInfo> listAllHistoric() {
        return paymentInfoService.listPayments();
    }

    @CrossOrigin
    @GetMapping("/list/{movieId}")
    public List<PaymentInfo> getMoviesPayments(@PathVariable("movieId") String movieId) {
        List<PaymentInfo> list = this.paymentInfoService.listPayments();
        List<PaymentInfo> moviesListPayments = null;

        for (PaymentInfo paymentInfo : list) {
            if (paymentInfo.getMovieId().equals(movieId)) {
                moviesListPayments.add(paymentInfo);
            }
        }

        return moviesListPayments;
    }
}