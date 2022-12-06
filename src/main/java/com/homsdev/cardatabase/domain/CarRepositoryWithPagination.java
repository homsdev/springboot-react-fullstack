package com.homsdev.cardatabase.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepositoryWithPagination extends PagingAndSortingRepository<Car,Long> {
}
