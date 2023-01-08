package ca.sheridancollege.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.model.Result;


@Repository
public interface ResultRepository extends CrudRepository <Result,Long> {

	

}
