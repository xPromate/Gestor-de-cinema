package pt.ipp.estg.registerservice.repositories;

import pt.ipp.estg.registerservice.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
