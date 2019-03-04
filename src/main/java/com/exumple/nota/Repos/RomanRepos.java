package com.exumple.nota.Repos;

import com.exumple.nota.domain.Roman;
import org.springframework.data.repository.CrudRepository;

// Репозиторий для работы с базой данных, наследуется от CRUD(create, read, update, delete) репозитория Spring boot
public interface RomanRepos extends CrudRepository<Roman, Integer> {
}
