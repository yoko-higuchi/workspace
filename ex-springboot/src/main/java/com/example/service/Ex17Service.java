package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Service;

import com.example.domain.*;

@Service
public class Ex17Service {
	public Ex17Domain save (Ex17Domain ex17Domain) {
		return ex17Domain;
	}
}
