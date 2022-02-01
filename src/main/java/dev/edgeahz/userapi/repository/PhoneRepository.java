package dev.edgeahz.userapi.repository;

import dev.edgeahz.userapi.domain.entity.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {
    Optional<Phone> findByNumber(String number);
}
