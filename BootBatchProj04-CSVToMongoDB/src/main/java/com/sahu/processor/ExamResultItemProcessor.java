package com.sahu.processor;

import org.springframework.batch.item.ItemProcessor;

import com.sahu.document.ExamResult;

public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult> {

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		if (item.getPercentage()>=90)
			return item;
		return null;
	}

}
