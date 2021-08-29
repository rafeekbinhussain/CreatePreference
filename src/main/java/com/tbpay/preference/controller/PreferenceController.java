package com.tbpay.preference.controller;


import com.tbpay.preference.model.PreferenceDto;
import com.tbpay.preference.repository.daomodels.Preference;
import com.tbpay.preference.service.PreferenceService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/*
 * Controller to handle user preference request
 *
 * */
@RestController
@Slf4j
public class PreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @PutMapping("/preferences")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Create or Update User preferences in BackEnd.")
    public Preference registerUserInterest(@RequestBody @Valid PreferenceDto preferenceDto) {
        log.info("CreateOrUpdate User : {}", PreferenceController.class);
        return preferenceService.createOrUpdatePreferences(preferenceDto);
    }

}