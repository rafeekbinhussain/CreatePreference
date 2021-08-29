package com.tbpay.preference.service.serviceimpl;

import com.tbpay.preference.configreader.FeatureToggle;
import com.tbpay.preference.exception.ResourceNotFoundException;
import com.tbpay.preference.model.PreferenceDto;
import com.tbpay.preference.repository.PreferenceRepository;
import com.tbpay.preference.repository.daomodels.Preference;
import com.tbpay.preference.service.PreferenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;


/*
 *  Service to create or update user request to DB
 *
 * */
@Service
@Slf4j
public class PreferenceServiceImpl implements PreferenceService {

    @Autowired
    private PreferenceRepository preferenceRepository;

    @Autowired
    private FeatureToggle featureToggle;


    /*
     * Method Create or update user marketing preference in DB
     *
     * @Parameter PreferenceDto
     * @return preference
     * */
    @Override
    public Preference createOrUpdatePreferences(PreferenceDto preferenceDto) {
        log.debug("createOrUpdatePreferences findByUserId: {}", PreferenceServiceImpl.class);
        try {
            Preference preference = preferenceRepository.findByUserId(preferenceDto.getUserId());
            if (Objects.nonNull(preference)) {
                log.debug("User Exist Updating preferences in DB {}", PreferenceServiceImpl.class);
                return preferenceRepository.save(mapPreferenceDtoToPreferenceDao(preferenceDto, preference));
            } else {
                log.debug("User not Exist Creating Preference in DB {}", PreferenceServiceImpl.class);
                return preferenceRepository.save(mapPreferenceDtoToPreferenceDao(preferenceDto, Preference.builder()
                        .userId(preferenceDto.getUserId())
                        .build()));
            }
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to Create or Update User due to", exc);
        }
    }

    private Preference mapPreferenceDtoToPreferenceDao(PreferenceDto preferenceDto, Preference preference) {
        log.debug("Mapping Dto to Dao model in mapPreferenceDtoToPreferenceDao() : {}", PreferenceServiceImpl.class);
        if (Objects.nonNull(preferenceDto.getSmsPreference())) {
            preference.setSmsPreference(preferenceDto.getSmsPreference());
        } else {
            preference.setSmsPreference(featureToggle.getUser().getMarketing().getPreferences());
        }
        if (Objects.nonNull(preferenceDto.getEmailPreference())) {
            preference.setEmailPreference(preferenceDto.getEmailPreference());

        } else {
            preference.setEmailPreference(featureToggle.getUser().getMarketing().getPreferences());
        }

        if (Objects.nonNull(preferenceDto.getPostPreference())) {
            preference.setPostPreference(preferenceDto.getPostPreference());

        } else {
            preference.setPostPreference(featureToggle.getUser().getMarketing().getPreferences());
        }

        log.debug("Mapped Dto to Dao model in mapPreferenceDtoToPreferenceDao() successfully: {}", PreferenceServiceImpl.class);
        return preference;
    }
}
