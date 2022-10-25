package com.sahu.processor;

import org.springframework.batch.item.ItemProcessor;

import com.sahu.model.ExamResult;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult> {

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		if (item.getPercentage()>=75)
			return item;
		return null;
	}

}
