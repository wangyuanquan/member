package com.rechenggit.core.domainservice.mongodbrepository;

import com.rechenggit.core.dal.mongodbobject.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    @Query(value="{'name':{'$ne':null}}")
   // @Query(value="{'_id':{'$ne':null}}",fields="{'name':1}")
    public Page<Customer> findByNameNotNull( Pageable pageable);
    @Query(value="{'name':?0}",fields="{'name':1}")
    // @Query(value="{'_id':{'$ne':null}}",fields="{'name':1}")
    public Page<Customer> findByNameEqual(String name, Pageable pageable);

    @Query(value="{'name':?0}",fields="{'name':1}")
    // @Query(value="{'_id':{'$ne':null}}",fields="{'name':1}")
    public Page<Customer> findByNameLike(String name, Pageable pageable);

}
