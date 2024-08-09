package com.microservice.Phone.service.inter;

import com.microservice.Phone.dto.ModelDto;

import java.util.List;

public interface ModelService {
    List<ModelDto> getAllModelByBrandId(Long brandId);
    List<ModelDto> getAllModel();
    ModelDto getModelById(Long modelId);
    boolean createModel(Long brandId, ModelDto modelDto);
    boolean updateModel(Long modelId, ModelDto modelDto);
    boolean deleteModel(Long modelId);

}
