
package com.sudeep.springbootreactjsredux.repository;
import com.sudeep.springbootreactjsredux.model.Backlog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {

    Backlog findByProjectIdentifier(String upperCase);
}