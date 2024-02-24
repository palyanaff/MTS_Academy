package ru.mts.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import ru.mts.service.CreateServiceImpl;

@Component
public class AnimalTypeBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CreateServiceImpl) {
            CreateServiceImpl animalService = (CreateServiceImpl) bean;
            //animalService.setAnimalType(animalService.defineAnimalType());
        }
        return bean;
    }
}
