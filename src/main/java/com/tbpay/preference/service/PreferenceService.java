package com.tbpay.preference.service;


import com.tbpay.preference.model.PreferenceDto;
import com.tbpay.preference.repository.daomodels.Preference;
import org.springframework.stereotype.Service;

@Service
public interface PreferenceService {

    Preference createOrUpdatePreferences(PreferenceDto preferenceDto);
}
