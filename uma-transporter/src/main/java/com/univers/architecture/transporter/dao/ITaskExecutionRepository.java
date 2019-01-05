/**
 * 
 */
package com.univers.architecture.transporter.dao;


import com.univers.architecture.transporter.model.TaskExecution;
import com.univers.architecture.transporter.model.TaskExecutionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sabir
 *
 */
@Repository
public interface ITaskExecutionRepository extends PagingAndSortingRepository<TaskExecution, String> {

     Page<TaskExecution> findByStatusContains(String key, Pageable pages);
    Page<TaskExecution> findByMessageContaining(String key, Pageable pages);
    Page<TaskExecution> findByTaskConfigNameContaining(String key, Pageable pages);
    Page<TaskExecution> findByTransportedFilesContaining(String key, Pageable pages);
    Page<TaskExecution> findByIdContaining(String key, Pageable pages);
    Page<TaskExecution> findByCreationDateContaining(String key, Pageable pages);

}
