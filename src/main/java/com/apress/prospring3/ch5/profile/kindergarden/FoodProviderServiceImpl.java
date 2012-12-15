package com.apress.prospring3.ch5.profile.kindergarden;

import com.apress.prospring3.ch5.profile.FoodProviderService;
import com.apress.prospring3.ch5.profile.Food;
import java.util.List;
import java.util.ArrayList;

public class FoodProviderServiceImpl implements FoodProviderService {
	@Override
	public List<Food> provideLunchSet() {
		List<Food> lunchSet = new ArrayList<Food>();
		lunchSet.add(new Food("Milk"));
		lunchSet.add(new Food("Biscuits"));
		
		return lunchSet;
	}
}
