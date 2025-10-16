package com.TechsmartEducationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TechsmartEducationSystem.model.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Long> { }