package com.meminator.imageModule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meminator.imageModule.models.ImageType;

@Repository
public interface ImageTypeRepository extends JpaRepository<ImageType, Long>{
}