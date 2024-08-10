package com.microservice.Phone.service.impl;

import com.microservice.Phone.clients.ImageClient;
import com.microservice.Phone.dto.ModelDto;
import com.microservice.Phone.mapper.PhoneMapper;
import com.microservice.Phone.model.Brand;
import com.microservice.Phone.model.Model;
import com.microservice.Phone.repository.BrandRepository;
import com.microservice.Phone.repository.ModelRepository;
import com.microservice.Phone.service.inter.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final ImageClient imageClient;

    @Override
    public List<ModelDto> getAllModelByBrandId(Long brandId) {
        if (modelRepository.existsByBrandId(brandId)) {
            List<Model> models = modelRepository.findByBrandId(brandId);
            return models.stream().map(PhoneMapper::mapToModelDto).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public List<ModelDto> getAllModel() {
        List<Model> models = modelRepository.findAll();
        return models.stream().map(PhoneMapper::mapToModelDto).collect(Collectors.toList());
    }

    @Override
    public ModelDto getModelById(Long modelId) {
        Model model = modelRepository.findById(modelId).orElse(null);
        if (model!=null)
            return PhoneMapper.mapToModelDto(model);
        return null;
    }

    @Override
    public boolean createModel(Long brandId, ModelDto modelDto) {
        if (brandRepository.existsById(brandId)) {
            Model model = PhoneMapper.maptoModel(modelDto);
            Brand brand = brandRepository.findById(brandId).orElse(null);
            model.setBrand(brand);
            modelRepository.save(model);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateModel(Long modelId, ModelDto updatedModelDto) {
        Model model = modelRepository.findById(modelId).orElse(null);
        if (model!=null){
            Model updatedModel = PhoneMapper.maptoModel(updatedModelDto);
            updatedModel.setBrand(model.getBrand());
            updatedModel.setId(model.getId());
            modelRepository.save(updatedModel);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteModel(Long modelId) {
        if (modelRepository.existsById(modelId)){
            imageClient.delete(modelId);
            modelRepository.deleteById(modelId);
            return true;
        }
        return false;
    }
}
