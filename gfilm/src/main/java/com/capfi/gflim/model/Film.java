package com.capfi.gflim.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Film {
	private String primaryTitle;
	private String originalTitle;
	private int startYear;
}
