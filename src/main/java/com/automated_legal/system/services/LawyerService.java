package com.automated_legal.system.services;

import com.automated_legal.system.models.LawyerResponse;

import java.util.List;

public interface LawyerService {

    List<LawyerResponse> findLawyers(String keyword);

}
