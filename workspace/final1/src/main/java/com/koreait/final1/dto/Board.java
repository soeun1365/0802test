package com.koreait.final1.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Board {
	private long bidx;
	private String bwriter;
	private String btitle;
	private String bcontent;
	private Date bdate;
}
