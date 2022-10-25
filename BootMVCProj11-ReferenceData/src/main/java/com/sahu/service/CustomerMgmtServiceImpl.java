package com.sahu.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.repository.IHumanActivitiesRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	
	@Autowired
	private IHumanActivitiesRepo humanActivitiesRepo;;

	@Override
	public Set<String> getAllCountries() {
		Locale[] locales = Locale.getAvailableLocales();
		Set<String> countriesSet = new TreeSet<>();
		for (Locale locale : locales)
			countriesSet.add(locale.getDisplayCountry());

		return countriesSet;
	}

	@Override
	public Set<String> getAllLanguages() {
		Locale[] locales = Locale.getAvailableLocales();
		Set<String> languagesSet = new TreeSet<>();
		for (Locale locale : locales)
			languagesSet.add(locale.getDisplayLanguage());

		return languagesSet;
	}

	@Override
	public Set<String> getAllHobbies() {
		return humanActivitiesRepo.getAllHobbies();
	}

}
