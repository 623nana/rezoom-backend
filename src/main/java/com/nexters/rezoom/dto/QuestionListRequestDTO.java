package com.nexters.rezoom.dto;

import com.nexters.rezoom.domain.Question;
import lombok.Data;

import java.util.List;

@Data
public class QuestionListRequestDTO {
	private int resumeId;
	private List<Question> questions;
}
