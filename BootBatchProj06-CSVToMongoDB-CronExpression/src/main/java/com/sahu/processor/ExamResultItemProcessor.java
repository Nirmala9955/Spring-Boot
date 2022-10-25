package com.sahu.processor;

import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;

import com.sahu.document.OExamResult;
import com.sahu.model.IExamResult;

public class ExamResultItemProcessor implements ItemProcessor<IExamResult, OExamResult> {

	@Override
	public OExamResult process(IExamResult item) throws Exception {
		if (item.getPercentage()>=59) {
			OExamResult result = new OExamResult();
			result.setId(item.getId());
			result.setDob(LocalDate.parse(item.getDob()));
			result.setPercentage(item.getPercentage());
			result.setSemester(item.getSemester());
			return result;
		}	
		return null;
	}

}
